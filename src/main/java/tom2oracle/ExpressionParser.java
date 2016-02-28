package tom2oracle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;
import tom2oracle.data.Expression;

/**
 * Note: Oracle JDBC drivers must be available in the Maven repository. Here is
 * one way to get them into the local repository:
 * 
 * mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar -Dfile=C:\Users\ghsmith\Documents\maven_local\ojdbc6.jar -DgeneratePom=true
 *
 * Using 100% NetBeans-generated POJOs with EJB annotations, but must add this
 * to generated ID annotations:
 * 
 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "G1")
 * @SequenceGenerator(name = "G1", sequenceName = "SAID_SEQ")    
 * 
 * @author ghsmith
 */
 
public class ExpressionParser {

    private static final Logger LOGGER = Logger.getLogger(ExpressionParser.class.getName());

    static Configuration configuration;
    static ServiceRegistry serviceRegistry;
    static SessionFactory sessionFactory;
    static Session sess;

    static {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Expression.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        sess = sessionFactory.openSession();
    }

    public static void main(String[] args) throws Exception {
        
        Transaction tx = null;

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String tsvFileName;
        Pattern patternTsvFileName = Pattern.compile("^([^_]*)_([^_]*)_(.*).tsv$");
        while ((tsvFileName = stdIn.readLine()) != null && tsvFileName.length() != 0) {
            try {
                tx = sess.beginTransaction();
                LOGGER.info("processing TSV file '" + tsvFileName + "'");
                Matcher matcherTsvFileName = patternTsvFileName.matcher(tsvFileName);
                String libraryPrep;
                String sampleName;
                String pipeline;
                if(matcherTsvFileName.find()) {
                    libraryPrep = matcherTsvFileName.group(1);
                    sampleName = matcherTsvFileName.group(2);
                    pipeline = matcherTsvFileName.group(3);
                    LOGGER.info("...libraryPrep = '" + libraryPrep + "'");
                    LOGGER.info("...sampleName = '" + sampleName + "'");
                    LOGGER.info("...pipeline = '" + pipeline + "'");
                }
                else {
                    throw new Exception("cannot parse '" + tsvFileName + "' as a TSV file name - skipping");
                }
                ICsvMapReader mapReader = new CsvMapReader(new FileReader(tsvFileName), CsvPreference.TAB_PREFERENCE);
                String[] header = mapReader.getHeader(true);
                Map<String, String> tsvMap;
                while((tsvMap = mapReader.read(header)) != null) {
                    Expression expression = new Expression();
                    expression.setLibraryPrep(libraryPrep);
                    expression.setSampleName(sampleName);
                    expression.setPipeline(pipeline);
                    if(pipeline.toUpperCase().contains("CUFFLINKS")) {
                        expression.setGeneId(tsvMap.get("gene_id"));
                        expression.setGeneName(tsvMap.get("gene_short_name"));
                        try { if(tsvMap.get("FPKM") != null) { expression.setFpkm(new BigDecimal(tsvMap.get("FPKM"))); } } catch(Exception e) { }
                        try { if(tsvMap.get("FPKM_conf_lo") != null) { expression.setFpkmConfLo(new BigDecimal(tsvMap.get("FPKM_conf_lo"))); } } catch(Exception e) { }
                        try { if(tsvMap.get("FPKM_conf_hi") != null) { expression.setFpkmConfHi(new BigDecimal(tsvMap.get("FPKM_conf_hi"))); } } catch(Exception e) { }
                    }
                    else if(pipeline.toUpperCase().contains("KALLISTO")) {
                        expression.setGeneId(tsvMap.get("ENSEMBLE_GENE_ID"));
                        expression.setGeneName(tsvMap.get("GENE_NAME"));
                        try { if(tsvMap.get("ESTIMATED_COUNTS") != null) { expression.setEstimatedCounts(new BigDecimal(tsvMap.get("ESTIMATED_COUNTS"))); } } catch(Exception e) { }
                    }
                    else {
                        throw new Exception("pipeline not recognized - skipping");
                    }
                    sess.save(expression);
                }
                sess.flush();
                tx.commit();
            }
            catch(Exception e) {
                LOGGER.severe(e.getMessage());
                sess.clear();
                if(tx != null && tx.isActive()) {
                    tx.rollback();
                }
                e.printStackTrace();
                //throw(e);
            }

        }
        
        sess.close();
        System.exit(0);
        
    }
    
}
