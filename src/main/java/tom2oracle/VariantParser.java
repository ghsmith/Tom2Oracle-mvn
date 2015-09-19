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
import tom2oracle.data.Variant;

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
public class VariantParser {

    private static final Logger LOGGER = Logger.getLogger(VariantParser.class.getName());

    static Configuration configuration;
    static ServiceRegistry serviceRegistry;
    static SessionFactory sessionFactory;
    static Session sess;

    static {
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Variant.class);
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
                    Variant variant = new Variant();
                    variant.setLibraryPrep(libraryPrep);
                    variant.setSampleName(sampleName);
                    variant.setPipeline(pipeline);
                    variant.setGeneRefgene(tsvMap.get("Gene.refGene"));
                    variant.setFuncRefgene(tsvMap.get("Func.refGene"));
                    variant.setExonicFuncRefgene(tsvMap.get("ExonicFunc.refGene"));
                    try { if(tsvMap.get("Alt Variant Freq") != null) { variant.setAltVariantFreq(new BigDecimal(tsvMap.get("Alt Variant Freq"))); } } catch(Exception e) { }
                    try { if(tsvMap.get("Read Depth") != null) { variant.setReadDepth(new BigDecimal(tsvMap.get("Read Depth"))); } } catch(Exception e) { }
                    try { if(tsvMap.get("Alt Read Depth") != null) { variant.setAltReadDepth(new BigDecimal(tsvMap.get("Alt Read Depth"))); } } catch(Exception e) { }
                    variant.setChrName(tsvMap.get("Chr"));
                    try { if(tsvMap.get("Start") != null) { variant.setStartPos(new BigDecimal(tsvMap.get("Start"))); } } catch(Exception e) { }
                    try { if(tsvMap.get("End") != null) { variant.setEndPos(new BigDecimal(tsvMap.get("End"))); } } catch(Exception e) { }
                    variant.setRefBase(tsvMap.get("Ref"));
                    variant.setAltBase(tsvMap.get("Alt"));
                    variant.setGenedetailRefgene(tsvMap.get("GeneDetail.refGene"));
                    variant.setAachangeRefgene(tsvMap.get("AAChange.refGene"));
                    variant.setOne000g2014sepAll(tsvMap.get("1000g2014sep_all"));
                    variant.setSnp138(tsvMap.get("snp138"));
                    variant.setCosmic70(tsvMap.get("cosmic70"));
                    if(variant.getCosmic70() != null) {
                        Pattern patternCosmic70 = Pattern.compile("^ID=.*;OCCURENCE=(.*)$");
                        Matcher matcherCosmic70 = patternCosmic70.matcher(variant.getCosmic70());
                        if(matcherCosmic70.find()) {
                            int totalOccurences = 0;
                            for(String occurence:matcherCosmic70.group(1).split(",")) {
                                totalOccurences += Integer.parseInt(occurence.substring(0, occurence.indexOf("(")));
                            }
                            variant.setCosmic70TotalOccurrences(new BigDecimal(totalOccurences));
                        }
                    }
                    variant.setClinvar20140929(tsvMap.get("clinvar_20140929"));
                    variant.setExac03(tsvMap.get("exac03"));
                    sess.save(variant);
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
