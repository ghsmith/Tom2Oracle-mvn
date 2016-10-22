/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tom2oracle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
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
import tom2oracle.data.Mafannovar;
import tom2oracle.data.Variant;

/**
 *
 * @author slowm
 */
public class MafAnnovarParser {
    
    
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
        String mafFileName;
        Pattern patternMafFileName = Pattern.compile("^([^_]*)_([^_]*)_(.*).maf$");
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
                    mafFileName=matcherTsvFileName.group(1) + "_" + matcherTsvFileName.group(2) + "_" + matcherTsvFileName.group(3) + ".maf";
                    
                    LOGGER.info("...libraryPrep = '" + libraryPrep + "'");
                    LOGGER.info("...sampleName = '" + sampleName + "'");
                    LOGGER.info("...pipeline = '" + pipeline + "'");
                }
                else {
                    throw new Exception("cannot parse '" + tsvFileName + "' as a TSV file name - skipping");
                }
                BufferedReader mafReader;
                try
                {
                mafReader = new BufferedReader(new FileReader(mafFileName));
                }catch (Exception e) 
                {
                        throw new Exception("there is no " + mafFileName + " - skipping");
                        
                 }
                mafReader.readLine();//because first line is junk, it gives the version number, those punks
                ICsvMapReader mapReaderMaf = new CsvMapReader(mafReader, CsvPreference.TAB_PREFERENCE);
                String[] headerMaf = mapReaderMaf.getHeader(true);
                Map<String, String> mafMap;
                
                
                ICsvMapReader mapReader = new CsvMapReader(new FileReader(tsvFileName), CsvPreference.TAB_PREFERENCE);
                
                String[] header = mapReader.getHeader(true);
                Map<String, String> tsvMap;
                while((tsvMap = mapReader.read(header)) != null && (mafMap = mapReaderMaf.read(headerMaf)) != null) {
                    Mafannovar mafannovar = new Mafannovar();
                    mafannovar.setLibraryPrep(libraryPrep);
                    mafannovar.setSampleName(sampleName);
                    mafannovar.setPipeline(pipeline);
                    mafannovar.setTumorSampleBarcode(sampleName);
                    mafannovar.setConsequence(mafMap.get("Consequence"));
                    mafannovar.setHugoSymbol(mafMap.get("Hugo_Symbol"));
                    mafannovar.setVariantClassification(mafMap.get("Variant_Classification"));
                    
                    mafannovar.setVariantType(mafMap.get("Variant_Type"));
                    mafannovar.setReferenceAllele(mafMap.get("Reference_Allele"));
                    mafannovar.setTumorSeqAllele1(mafMap.get("Tumor_Seq_Allele1"));
                    mafannovar.setTumorSeqAllele2(mafMap.get("Tumor_Seq_Allele2"));
                    mafannovar.setMatchNormSeqAllele1(mafMap.get("Match_Norm_Seq_Allele1"));
                    mafannovar.setMatchNormSeqAllele2(mafMap.get("Match_Norm_Seq_Allele2"));
                    
                    
                    
                    mafannovar.setGeneRefgene(tsvMap.get("Gene.refGene"));
                    mafannovar.setFuncRefgene(tsvMap.get("Func.refGene"));
                            
                    mafannovar.setExonicFuncRefgene(tsvMap.get("ExonicFunc.refGene"));
                    try { if(tsvMap.get("Alt Variant Freq") != null) { mafannovar.setAltVariantFreq(new BigDecimal(tsvMap.get("Alt Variant Freq"))); } } catch(Exception e) { }
                    try { if(tsvMap.get("Read Depth") != null) { mafannovar.setReadDepth(new BigDecimal(tsvMap.get("Read Depth"))); } } catch(Exception e) { }
                    try { if(tsvMap.get("Alt Read Depth") != null) { mafannovar.setAltReadDepth(new BigDecimal(tsvMap.get("Alt Read Depth"))); } } catch(Exception e) { }
                    //try { if(mafMap.get("Chromsome") != null) { mafannovar.setChromosome(new BigDecimal(mafMap.get("Chromosome"))); } } catch(Exception e) { }
                    mafannovar.setChromosome(tsvMap.get("Chr"));
                    try { if(tsvMap.get("Start") != null) { mafannovar.setStartPosition(new BigDecimal(tsvMap.get("Start"))); } } catch(Exception e) { }
                    try { if(tsvMap.get("End") != null) { mafannovar.setEndPosition(new BigDecimal(tsvMap.get("End"))); } } catch(Exception e) { }
                    mafannovar.setChromosome(tsvMap.get("Chr"));
                    try { if(tsvMap.get("Start") != null) { mafannovar.setStartPosition(new BigDecimal(tsvMap.get("Start"))); } } catch(Exception e) { }
                    try { if(tsvMap.get("End") != null) { mafannovar.setEndPosition(new BigDecimal(tsvMap.get("End"))); } } catch(Exception e) { }
                    mafannovar.setChromosomevep(mafMap.get("Chromosome"));
                    try { if(mafMap.get("Start_Position") != null) { mafannovar.setStartvep(new BigDecimal(mafMap.get("Start_Position"))); } } catch(Exception e) { }
                    try { if(mafMap.get("End_Position") != null) { mafannovar.setEndvep(new BigDecimal(mafMap.get("End_Position"))); } } catch(Exception e) { }
                    if (!mafannovar.getChromosomevep().equals(mafannovar.getChromosome()) || !mafannovar.getStartPosition().equals(mafannovar.getStartvep()) )
                    {
                        if (!mafannovar.getStartPosition().equals(mafannovar.getStartvep()))
                        {
                            BigDecimal difference;
                            difference = mafannovar.getStartPosition().subtract(mafannovar.getStartvep());
                            if (difference.abs().intValue() > 150)
                            {
                                LOGGER.info("the maf chromosome is" + mafannovar.getChromosomevep());
                                LOGGER.info("the maf start position is" + mafannovar.getStartvep());
                                LOGGER.info("the tsv chromosome is" + mafannovar.getChromosome());
                                LOGGER.info("the tsv start position is" + mafannovar.getStartPosition());
                               throw new Exception("chromosome or postion do not match throwing out + " + tsvFileName);
                            }
                        }else
                        {
                        LOGGER.info("the maf chromosome is" + mafannovar.getChromosomevep());
                        LOGGER.info("the maf start position is" + mafannovar.getStartvep());
                        
                        LOGGER.info("the tsv chromosome is" + mafannovar.getChromosome());
                        LOGGER.info("the tsv start position is" + mafannovar.getStartPosition());
                        throw new Exception("chromosome or postion do not match throwing out + " + tsvFileName);
                        }
                        
                        
                    }
                    mafannovar.setBiotype(mafMap.get("BIOTYPE"));
                    mafannovar.setDbsnpRs(mafMap.get("dbSNP_RS"));
                    mafannovar.setDbsnpValStatus(mafMap.get("dbSNP_Val_Status"));
                    mafannovar.setRefBase(tsvMap.get("Ref"));
                    mafannovar.setAltBase(tsvMap.get("Alt"));
                    
                    //mafannovar.setGenedetailRefgene(tsvMap.get("GeneDetail.refGene"));
                    mafannovar.setAachangeRefgene(tsvMap.get("AAChange.refGene"));
                    mafannovar.setOne000g2014sepAll(tsvMap.get("1000g2014sep_all"));
                    mafannovar.setSnp138(tsvMap.get("snp138"));
                    mafannovar.setCosmic70(tsvMap.get("cosmic70"));
                    if(mafannovar.getCosmic70() != null) {
                        Pattern patternCosmic70 = Pattern.compile("^ID=.*;OCCURENCE=(.*)$");
                        Matcher matcherCosmic70 = patternCosmic70.matcher(mafannovar.getCosmic70());
                        if(matcherCosmic70.find()) {
                            int totalOccurences = 0;
                            for(String occurence:matcherCosmic70.group(1).split(",")) {
                                totalOccurences += Integer.parseInt(occurence.substring(0, occurence.indexOf("(")));
                            }
                            mafannovar.setCosmic70TotalOccurrences(new BigDecimal(totalOccurences));
                        }
                    }
                   mafannovar.setClinvar20160302sig(tsvMap.get("CLINSIG"));
                   mafannovar.setClinvar20160302dbn(tsvMap.get("CLINDBN"));
                   mafannovar.setClinvar20160302acc(tsvMap.get("CLINACC"));
                   mafannovar.setClinvar20160302dsdb(tsvMap.get("CLINDSDB"));
                   mafannovar.setClinvar20160302dsdbid(tsvMap.get("CLINDSDBID"));
                   try { if(tsvMap.get("MetaLR_score") != null) { mafannovar.setMetalrScore(new BigDecimal(tsvMap.get("MetaLR_score"))); } } catch(Exception e) { };
                   mafannovar.setDbnsfp31aInterpro(tsvMap.get("Interpro_domain"));
                   mafannovar.setMetalrPred(tsvMap.get("MetaLR_pred"));
                   try { if(tsvMap.get("ExAC_ALL") != null) { mafannovar.setExacAll(new BigDecimal(tsvMap.get("ExAC_ALL"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("ExAC_AFR") != null) { mafannovar.setExacAfr(new BigDecimal(tsvMap.get("ExAC_AFR"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("ExAC_AMR") != null) { mafannovar.setExacAmr(new BigDecimal(tsvMap.get("ExAC_AMR"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("ExAC_EAS") != null) { mafannovar.setExacEas(new BigDecimal(tsvMap.get("ExAC_EAS"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("ExAC_FIN") != null) { mafannovar.setExacFin(new BigDecimal(tsvMap.get("ExAC_FIN"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("ExAC_NFE") != null) { mafannovar.setExacNfe(new BigDecimal(tsvMap.get("ExAC_NFE"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("ExAC_OTH") != null) { mafannovar.setExacOth(new BigDecimal(tsvMap.get("ExAC_OTH"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("ExAC_SAS") != null) { mafannovar.setExacSas(new BigDecimal(tsvMap.get("ExAC_SAS"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("SIFT_score") != null) { mafannovar.setSiftScorea(new BigDecimal(tsvMap.get("SIFT_score"))); } } catch(Exception e) { };
                   mafannovar.setSiftPreda(tsvMap.get("SIFT_pred"));
                   try { if(tsvMap.get("Polyphen2_HDIV_score") != null) { mafannovar.setPolyphen2HdivScorea(new BigDecimal(tsvMap.get("Polyphen2_HDIV_score"))); } } catch(Exception e) { };
                   mafannovar.setPolyphen2HdivPreda(tsvMap.get("Polyphen2_HDIV_pred"));
                   mafannovar.setPolyphen2HvarPreda(tsvMap.get("Polyphen2_HVAR_pred"));
                   mafannovar.setMutationtasterPred(tsvMap.get("MutationTaster_pred"));
                   mafannovar.setMutationassessorPred(tsvMap.get("MutationAssessor_pred"));
                   try { if(tsvMap.get("CADD_raw") != null) { mafannovar.setCaddRaw(new BigDecimal(tsvMap.get("CADD_raw"))); } } catch(Exception e) { };
                   try { if(tsvMap.get("CADD_phred") != null) { mafannovar.setCaddPhred(new BigDecimal(tsvMap.get("CADD_phred"))); } } catch(Exception e) { };
                   
                    
                    
                    //mafannovar.setExacGmaf(mafMap.get("GMAF"));
                    //mafannovar.setExacAfr(mafMap.get("AFR_MAF"));
                   // mafannovar.setExacAmr(mafMap.get("AMR_MAF"));
                    //mafannovar.setExacEas(mafMap.get("EAS_MAF"));
                   // mafannovar.setExacEur(mafMap.get("EUR_MAF"));
                   // mafannovar.setExacSas(mafMap.get("SAS_MAF"));
                    //mafannovar.setExacAa(mafMap.get("AA_MAF"));
                   // mafannovar.setExacEa(mafMap.get("EA_MAF"));
                    String siftOutput = "^([a-z]+)\\(([0-9_.]+)\\)";
                    //example : tolerated(0.38)  -> breaking into group 1 -> tolerated and group 2 -> 0.38
                    Pattern patternSift = Pattern.compile(siftOutput);
                    
                    try { 
                        if(mafMap.get("SIFT") != null)
                        {
                    Matcher matcherSift = patternSift.matcher(mafMap.get("SIFT"));
                    if(matcherSift.find())
                    {
                        mafannovar.setSift(matcherSift.group(1));
                        mafannovar.setSiftScore(new BigDecimal(matcherSift.group(2)));
                    }
                    }
                    }catch(Exception e) {};
                    try { 
                        if(mafMap.get("PolyPhen") != null)
                        {
                    mafannovar.setPolyphen(mafMap.get("PolyPhen"));
                    Matcher matcherPoly = patternSift.matcher(mafMap.get("PolyPhen"));
                    if(matcherPoly.find())
                    {
                        mafannovar.setPolyphen(matcherPoly.group(1));
                        mafannovar.setPolyphenScore(new BigDecimal(matcherPoly.group(2)));
                    }
                    }
                    }catch(Exception e) {};
                    
                    
                    mafannovar.setImpact(mafMap.get("IMPACT"));
                    mafannovar.setHgvsc(mafMap.get("HGVSc"));
                    mafannovar.setHgvsp(mafMap.get("HGVSp"));
                    mafannovar.setHgvspShort(mafMap.get("HGVSp_Short"));
                    mafannovar.setTranscript(mafMap.get("Transcript_ID"));
                    mafannovar.setExonNumber(mafMap.get("Exon_Number"));
                    try { if(mafMap.get("t_depth") != null) { mafannovar.setTDepth(new BigDecimal(mafMap.get("t_depth"))); } } catch(Exception e) { };
                    try { if(mafMap.get("t_ref_count") != null) { mafannovar.setTRefCount(new BigDecimal(mafMap.get("t_ref_count"))); } } catch(Exception e) { };
                    try { if(mafMap.get("t_alt_count") != null) { mafannovar.setTAltCount(new BigDecimal(mafMap.get("t_alt_count"))); } } catch(Exception e) { };
                    mafannovar.setAllEffects(mafMap.get("all_effects"));
                    mafannovar.setAllele(mafMap.get("Allele"));
                    mafannovar.setGene(mafMap.get("Gene"));
                    mafannovar.setFeatureType(mafMap.get("Feature_type"));
                    mafannovar.setCdnaPosition(mafMap.get("cDNA_position"));
                    mafannovar.setCdsPosition(mafMap.get("CDS_position"));
                    mafannovar.setProteinPosition(mafMap.get("Protein_position"));
                    mafannovar.setAminoAcids(mafMap.get("Amino_acids"));
                    mafannovar.setCodons(mafMap.get("Codons"));
                    mafannovar.setExistingVariation(mafMap.get("Existing_Variation"));
                    try { if(mafMap.get("STRAND") != null) { mafannovar.setStrandcaps(new BigDecimal(mafMap.get("STRAND"))); } } catch(Exception e) { };
                    mafannovar.setSymbol(mafMap.get("SYMBOL"));
                    mafannovar.setSymbolSource(mafMap.get("SYMBOL_SOURCE"));
                    mafannovar.setHgncId(mafMap.get("HGNC_ID"));
                    mafannovar.setCanonical(mafMap.get("CANONICAL"));
                    mafannovar.setCcds(mafMap.get("CCDS"));
                    mafannovar.setEnsp(mafMap.get("ENSP"));
                    mafannovar.setSwissprot(mafMap.get("SWISSPROT"));
                    mafannovar.setTrembl(mafMap.get("TREMBL"));
                    mafannovar.setUniparc(mafMap.get("UNIPARC"));
                    mafannovar.setSiftMaf(mafMap.get("SIFT"));
                    mafannovar.setPolyphenMaf(mafMap.get("PolyPhen"));
                    mafannovar.setExonNumber(mafMap.get("EXON"));
                    mafannovar.setExonNumber(mafMap.get("INTRON"));
                    mafannovar.setDomains(mafMap.get("DOMAINS"));
                    mafannovar.setRefseq(mafMap.get("RefSeq"));
                    mafannovar.setExistingVariation(mafMap.get("Existing_Variation"));
                    mafannovar.setDomains(mafMap.get("DOMAINS"));
                    mafannovar.setPubmed(mafMap.get("PUBMED"));
                    mafannovar.setClinSig(mafMap.get("CLIN_SIG"));
                    //mafannovar.setInterproDomain(tsvMap.get("Interpro_domain"));
                    
                    //mafannovar.setSiftPred(tsvMap.get("SIFT_pred"));
                    //mafannovar.setPolyphen2HdivPred(tsvMap.get("Polyphen2_HDIV_pred"));
                    //mafannovar.setPolyphen2HvarPred(tsvMap.get("Polyphen2_HVAR_pred"));
                    //mafannovar.setLrtPred(tsvMap.get("LRT_pred"));
                    //mafannovar.setMutationtasterPred(tsvMap.get("MutationTaster_pred"));
                    //mafannovar.setMutationassessorPred(tsvMap.get("MutationAssessor_pred"));
                   // try { if(tsvMap.get("CADD_phred") != null) { mafannovar.setCaddPhred(new BigDecimal(tsvMap.get("CADD_phred"))); } } catch(Exception e) { }
                    
                    
                    
                    
                    sess.save(mafannovar);
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
