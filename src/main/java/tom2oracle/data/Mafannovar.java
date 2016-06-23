package tom2oracle.data;
// Generated Jun 23, 2016 7:20:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Mafannovar generated by hbm2java
 */
@Entity
@Table(name="MAFANNOVAR"
    ,schema="TOM_20160225"
)
public class Mafannovar  implements java.io.Serializable {


     private BigDecimal mafannovarSaid;
     private String libraryPrep;
     private String sampleName;
     private String pipeline;
     private String tumorSampleBarcode;
     private String hugoSymbol;
     private String variantClassification;
     private String consequence;
     private String geneRefgene;
     private String geneEnsemble;
     private String funcRefgene;
     private String exonicFuncRefgene;
     private String aachangeRefgene;
     private String chromosome;
     private String chromosomevep;
     private BigDecimal startvep;
     private BigDecimal endvep;
     private BigDecimal startPosition;
     private BigDecimal endPosition;
     private String biotype;
     private String dbsnpRs;
     private String dbnsfp31aInterpro;
     private String metalrPred;
     private BigDecimal metalrScore;
     private String snp138;
     private String hgvsc;
     private String hgvsp;
     private String transcript;
     private String exonNumber;
     private String refseq;
     private String existingVariation;
     private String domains;
     private String clinSig;
     private String pubmed;
     private String refBase;
     private String altBase;
     private String cosmic70;
     private BigDecimal cosmic70TotalOccurrences;
     private BigDecimal exac03;
     private BigDecimal exacAll;
     private BigDecimal exacAfr;
     private BigDecimal exacAmr;
     private BigDecimal exacEas;
     private BigDecimal exacFin;
     private BigDecimal exacNfe;
     private BigDecimal exacOth;
     private BigDecimal exacSas;
     private BigDecimal altVariantFreq;
     private BigDecimal readDepth;
     private BigDecimal altReadDepth;
     private String clinvar20160302sig;
     private String clinvar20160302dbn;
     private String clinvar20160302acc;
     private String clinvar20160302dsdb;
     private String clinvar20160302dsdbid;
     private String sift;
     private BigDecimal siftScore;
     private String polyphen;
     private BigDecimal polyphenScore;
     private String impact;
     private BigDecimal siftScorea;
     private String siftPreda;
     private BigDecimal polyphen2HdivScorea;
     private String polyphen2HdivPreda;
     private String polyphen2HvarPreda;
     private String mutationtasterPred;
     private String mutationassessorPred;
     private BigDecimal caddRaw;
     private BigDecimal caddPhred;
     private String one000g2014sepAll;

    public Mafannovar() {
    }

	
    public Mafannovar(BigDecimal mafannovarSaid, String libraryPrep, String sampleName, String pipeline) {
        this.mafannovarSaid = mafannovarSaid;
        this.libraryPrep = libraryPrep;
        this.sampleName = sampleName;
        this.pipeline = pipeline;
    }
    public Mafannovar(BigDecimal mafannovarSaid, String libraryPrep, String sampleName, String pipeline, String tumorSampleBarcode, String hugoSymbol, String variantClassification, String consequence, String geneRefgene, String geneEnsemble, String funcRefgene, String exonicFuncRefgene, String aachangeRefgene, String chromosome, String chromosomevep, BigDecimal startvep, BigDecimal endvep, BigDecimal startPosition, BigDecimal endPosition, String biotype, String dbsnpRs, String dbnsfp31aInterpro, String metalrPred, BigDecimal metalrScore, String snp138, String hgvsc, String hgvsp, String transcript, String exonNumber, String refseq, String existingVariation, String domains, String clinSig, String pubmed, String refBase, String altBase, String cosmic70, BigDecimal cosmic70TotalOccurrences, BigDecimal exac03, BigDecimal exacAll, BigDecimal exacAfr, BigDecimal exacAmr, BigDecimal exacEas, BigDecimal exacFin, BigDecimal exacNfe, BigDecimal exacOth, BigDecimal exacSas, BigDecimal altVariantFreq, BigDecimal readDepth, BigDecimal altReadDepth, String clinvar20160302sig, String clinvar20160302dbn, String clinvar20160302acc, String clinvar20160302dsdb, String clinvar20160302dsdbid, String sift, BigDecimal siftScore, String polyphen, BigDecimal polyphenScore, String impact, BigDecimal siftScorea, String siftPreda, BigDecimal polyphen2HdivScorea, String polyphen2HdivPreda, String polyphen2HvarPreda, String mutationtasterPred, String mutationassessorPred, BigDecimal caddRaw, BigDecimal caddPhred, String one000g2014sepAll) {
       this.mafannovarSaid = mafannovarSaid;
       this.libraryPrep = libraryPrep;
       this.sampleName = sampleName;
       this.pipeline = pipeline;
       this.tumorSampleBarcode = tumorSampleBarcode;
       this.hugoSymbol = hugoSymbol;
       this.variantClassification = variantClassification;
       this.consequence = consequence;
       this.geneRefgene = geneRefgene;
       this.geneEnsemble = geneEnsemble;
       this.funcRefgene = funcRefgene;
       this.exonicFuncRefgene = exonicFuncRefgene;
       this.aachangeRefgene = aachangeRefgene;
       this.chromosome = chromosome;
       this.chromosomevep = chromosomevep;
       this.startvep = startvep;
       this.endvep = endvep;
       this.startPosition = startPosition;
       this.endPosition = endPosition;
       this.biotype = biotype;
       this.dbsnpRs = dbsnpRs;
       this.dbnsfp31aInterpro = dbnsfp31aInterpro;
       this.metalrPred = metalrPred;
       this.metalrScore = metalrScore;
       this.snp138 = snp138;
       this.hgvsc = hgvsc;
       this.hgvsp = hgvsp;
       this.transcript = transcript;
       this.exonNumber = exonNumber;
       this.refseq = refseq;
       this.existingVariation = existingVariation;
       this.domains = domains;
       this.clinSig = clinSig;
       this.pubmed = pubmed;
       this.refBase = refBase;
       this.altBase = altBase;
       this.cosmic70 = cosmic70;
       this.cosmic70TotalOccurrences = cosmic70TotalOccurrences;
       this.exac03 = exac03;
       this.exacAll = exacAll;
       this.exacAfr = exacAfr;
       this.exacAmr = exacAmr;
       this.exacEas = exacEas;
       this.exacFin = exacFin;
       this.exacNfe = exacNfe;
       this.exacOth = exacOth;
       this.exacSas = exacSas;
       this.altVariantFreq = altVariantFreq;
       this.readDepth = readDepth;
       this.altReadDepth = altReadDepth;
       this.clinvar20160302sig = clinvar20160302sig;
       this.clinvar20160302dbn = clinvar20160302dbn;
       this.clinvar20160302acc = clinvar20160302acc;
       this.clinvar20160302dsdb = clinvar20160302dsdb;
       this.clinvar20160302dsdbid = clinvar20160302dsdbid;
       this.sift = sift;
       this.siftScore = siftScore;
       this.polyphen = polyphen;
       this.polyphenScore = polyphenScore;
       this.impact = impact;
       this.siftScorea = siftScorea;
       this.siftPreda = siftPreda;
       this.polyphen2HdivScorea = polyphen2HdivScorea;
       this.polyphen2HdivPreda = polyphen2HdivPreda;
       this.polyphen2HvarPreda = polyphen2HvarPreda;
       this.mutationtasterPred = mutationtasterPred;
       this.mutationassessorPred = mutationassessorPred;
       this.caddRaw = caddRaw;
       this.caddPhred = caddPhred;
       this.one000g2014sepAll = one000g2014sepAll;
    }
   
     @Id 

    
    @Column(name="MAFANNOVAR_SAID", unique=true, nullable=false, precision=22, scale=0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "G1")
    @SequenceGenerator(name = "G1", sequenceName = "SAID_SEQ")
     public BigDecimal getMafannovarSaid() {
        return this.mafannovarSaid;
    }
    
    public void setMafannovarSaid(BigDecimal mafannovarSaid) {
        this.mafannovarSaid = mafannovarSaid;
    }

    
    @Column(name="LIBRARY_PREP", nullable=false, length=100)
    public String getLibraryPrep() {
        return this.libraryPrep;
    }
    
    public void setLibraryPrep(String libraryPrep) {
        this.libraryPrep = libraryPrep;
    }

    
    @Column(name="SAMPLE_NAME", nullable=false, length=100)
    public String getSampleName() {
        return this.sampleName;
    }
    
    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    
    @Column(name="PIPELINE", nullable=false, length=100)
    public String getPipeline() {
        return this.pipeline;
    }
    
    public void setPipeline(String pipeline) {
        this.pipeline = pipeline;
    }

    
    @Column(name="TUMOR_SAMPLE_BARCODE", length=2000)
    public String getTumorSampleBarcode() {
        return this.tumorSampleBarcode;
    }
    
    public void setTumorSampleBarcode(String tumorSampleBarcode) {
        this.tumorSampleBarcode = tumorSampleBarcode;
    }

    
    @Column(name="HUGO_SYMBOL", length=2000)
    public String getHugoSymbol() {
        return this.hugoSymbol;
    }
    
    public void setHugoSymbol(String hugoSymbol) {
        this.hugoSymbol = hugoSymbol;
    }

    
    @Column(name="VARIANT_CLASSIFICATION", length=2000)
    public String getVariantClassification() {
        return this.variantClassification;
    }
    
    public void setVariantClassification(String variantClassification) {
        this.variantClassification = variantClassification;
    }

    
    @Column(name="CONSEQUENCE", length=2000)
    public String getConsequence() {
        return this.consequence;
    }
    
    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    
    @Column(name="GENE_REFGENE", length=1000)
    public String getGeneRefgene() {
        return this.geneRefgene;
    }
    
    public void setGeneRefgene(String geneRefgene) {
        this.geneRefgene = geneRefgene;
    }

    
    @Column(name="GENE_ENSEMBLE", length=1000)
    public String getGeneEnsemble() {
        return this.geneEnsemble;
    }
    
    public void setGeneEnsemble(String geneEnsemble) {
        this.geneEnsemble = geneEnsemble;
    }

    
    @Column(name="FUNC_REFGENE", length=1000)
    public String getFuncRefgene() {
        return this.funcRefgene;
    }
    
    public void setFuncRefgene(String funcRefgene) {
        this.funcRefgene = funcRefgene;
    }

    
    @Column(name="EXONIC_FUNC_REFGENE", length=2000)
    public String getExonicFuncRefgene() {
        return this.exonicFuncRefgene;
    }
    
    public void setExonicFuncRefgene(String exonicFuncRefgene) {
        this.exonicFuncRefgene = exonicFuncRefgene;
    }

    
    @Column(name="AACHANGE_REFGENE", length=2000)
    public String getAachangeRefgene() {
        return this.aachangeRefgene;
    }
    
    public void setAachangeRefgene(String aachangeRefgene) {
        this.aachangeRefgene = aachangeRefgene;
    }

    
    @Column(name="CHROMOSOME", length=2000)
    public String getChromosome() {
        return this.chromosome;
    }
    
    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    
    @Column(name="CHROMOSOMEVEP", length=2000)
    public String getChromosomevep() {
        return this.chromosomevep;
    }
    
    public void setChromosomevep(String chromosomevep) {
        this.chromosomevep = chromosomevep;
    }

    
    @Column(name="STARTVEP", precision=22, scale=0)
    public BigDecimal getStartvep() {
        return this.startvep;
    }
    
    public void setStartvep(BigDecimal startvep) {
        this.startvep = startvep;
    }

    
    @Column(name="ENDVEP", precision=22, scale=0)
    public BigDecimal getEndvep() {
        return this.endvep;
    }
    
    public void setEndvep(BigDecimal endvep) {
        this.endvep = endvep;
    }

    
    @Column(name="START_POSITION", precision=22, scale=0)
    public BigDecimal getStartPosition() {
        return this.startPosition;
    }
    
    public void setStartPosition(BigDecimal startPosition) {
        this.startPosition = startPosition;
    }

    
    @Column(name="END_POSITION", precision=22, scale=0)
    public BigDecimal getEndPosition() {
        return this.endPosition;
    }
    
    public void setEndPosition(BigDecimal endPosition) {
        this.endPosition = endPosition;
    }

    
    @Column(name="BIOTYPE", length=2000)
    public String getBiotype() {
        return this.biotype;
    }
    
    public void setBiotype(String biotype) {
        this.biotype = biotype;
    }

    
    @Column(name="DBSNP_RS", length=2000)
    public String getDbsnpRs() {
        return this.dbsnpRs;
    }
    
    public void setDbsnpRs(String dbsnpRs) {
        this.dbsnpRs = dbsnpRs;
    }

    
    @Column(name="DBNSFP31A_INTERPRO", length=2000)
    public String getDbnsfp31aInterpro() {
        return this.dbnsfp31aInterpro;
    }
    
    public void setDbnsfp31aInterpro(String dbnsfp31aInterpro) {
        this.dbnsfp31aInterpro = dbnsfp31aInterpro;
    }

    
    @Column(name="METALR_PRED", length=20)
    public String getMetalrPred() {
        return this.metalrPred;
    }
    
    public void setMetalrPred(String metalrPred) {
        this.metalrPred = metalrPred;
    }

    
    @Column(name="METALR_SCORE", precision=22, scale=0)
    public BigDecimal getMetalrScore() {
        return this.metalrScore;
    }
    
    public void setMetalrScore(BigDecimal metalrScore) {
        this.metalrScore = metalrScore;
    }

    
    @Column(name="SNP138", length=2000)
    public String getSnp138() {
        return this.snp138;
    }
    
    public void setSnp138(String snp138) {
        this.snp138 = snp138;
    }

    
    @Column(name="HGVSC", length=2000)
    public String getHgvsc() {
        return this.hgvsc;
    }
    
    public void setHgvsc(String hgvsc) {
        this.hgvsc = hgvsc;
    }

    
    @Column(name="HGVSP", length=2000)
    public String getHgvsp() {
        return this.hgvsp;
    }
    
    public void setHgvsp(String hgvsp) {
        this.hgvsp = hgvsp;
    }

    
    @Column(name="TRANSCRIPT", length=2000)
    public String getTranscript() {
        return this.transcript;
    }
    
    public void setTranscript(String transcript) {
        this.transcript = transcript;
    }

    
    @Column(name="EXON_NUMBER", length=2000)
    public String getExonNumber() {
        return this.exonNumber;
    }
    
    public void setExonNumber(String exonNumber) {
        this.exonNumber = exonNumber;
    }

    
    @Column(name="REFSEQ", length=2000)
    public String getRefseq() {
        return this.refseq;
    }
    
    public void setRefseq(String refseq) {
        this.refseq = refseq;
    }

    
    @Column(name="EXISTING_VARIATION", length=2000)
    public String getExistingVariation() {
        return this.existingVariation;
    }
    
    public void setExistingVariation(String existingVariation) {
        this.existingVariation = existingVariation;
    }

    
    @Column(name="DOMAINS", length=2000)
    public String getDomains() {
        return this.domains;
    }
    
    public void setDomains(String domains) {
        this.domains = domains;
    }

    
    @Column(name="CLIN_SIG", length=2000)
    public String getClinSig() {
        return this.clinSig;
    }
    
    public void setClinSig(String clinSig) {
        this.clinSig = clinSig;
    }

    
    @Column(name="PUBMED", length=2000)
    public String getPubmed() {
        return this.pubmed;
    }
    
    public void setPubmed(String pubmed) {
        this.pubmed = pubmed;
    }

    
    @Column(name="REF_BASE", length=2000)
    public String getRefBase() {
        return this.refBase;
    }
    
    public void setRefBase(String refBase) {
        this.refBase = refBase;
    }

    
    @Column(name="ALT_BASE", length=2000)
    public String getAltBase() {
        return this.altBase;
    }
    
    public void setAltBase(String altBase) {
        this.altBase = altBase;
    }

    
    @Column(name="COSMIC70", length=2000)
    public String getCosmic70() {
        return this.cosmic70;
    }
    
    public void setCosmic70(String cosmic70) {
        this.cosmic70 = cosmic70;
    }

    
    @Column(name="COSMIC70_TOTAL_OCCURRENCES", precision=22, scale=0)
    public BigDecimal getCosmic70TotalOccurrences() {
        return this.cosmic70TotalOccurrences;
    }
    
    public void setCosmic70TotalOccurrences(BigDecimal cosmic70TotalOccurrences) {
        this.cosmic70TotalOccurrences = cosmic70TotalOccurrences;
    }

    
    @Column(name="EXAC03", precision=22, scale=0)
    public BigDecimal getExac03() {
        return this.exac03;
    }
    
    public void setExac03(BigDecimal exac03) {
        this.exac03 = exac03;
    }

    
    @Column(name="EXAC_ALL", precision=22, scale=0)
    public BigDecimal getExacAll() {
        return this.exacAll;
    }
    
    public void setExacAll(BigDecimal exacAll) {
        this.exacAll = exacAll;
    }

    
    @Column(name="EXAC_AFR", precision=22, scale=0)
    public BigDecimal getExacAfr() {
        return this.exacAfr;
    }
    
    public void setExacAfr(BigDecimal exacAfr) {
        this.exacAfr = exacAfr;
    }

    
    @Column(name="EXAC_AMR", precision=22, scale=0)
    public BigDecimal getExacAmr() {
        return this.exacAmr;
    }
    
    public void setExacAmr(BigDecimal exacAmr) {
        this.exacAmr = exacAmr;
    }

    
    @Column(name="EXAC_EAS", precision=22, scale=0)
    public BigDecimal getExacEas() {
        return this.exacEas;
    }
    
    public void setExacEas(BigDecimal exacEas) {
        this.exacEas = exacEas;
    }

    
    @Column(name="EXAC_FIN", precision=22, scale=0)
    public BigDecimal getExacFin() {
        return this.exacFin;
    }
    
    public void setExacFin(BigDecimal exacFin) {
        this.exacFin = exacFin;
    }

    
    @Column(name="EXAC_NFE", precision=22, scale=0)
    public BigDecimal getExacNfe() {
        return this.exacNfe;
    }
    
    public void setExacNfe(BigDecimal exacNfe) {
        this.exacNfe = exacNfe;
    }

    
    @Column(name="EXAC_OTH", precision=22, scale=0)
    public BigDecimal getExacOth() {
        return this.exacOth;
    }
    
    public void setExacOth(BigDecimal exacOth) {
        this.exacOth = exacOth;
    }

    
    @Column(name="EXAC_SAS", precision=22, scale=0)
    public BigDecimal getExacSas() {
        return this.exacSas;
    }
    
    public void setExacSas(BigDecimal exacSas) {
        this.exacSas = exacSas;
    }

    
    @Column(name="ALT_VARIANT_FREQ", precision=22, scale=0)
    public BigDecimal getAltVariantFreq() {
        return this.altVariantFreq;
    }
    
    public void setAltVariantFreq(BigDecimal altVariantFreq) {
        this.altVariantFreq = altVariantFreq;
    }

    
    @Column(name="READ_DEPTH", precision=22, scale=0)
    public BigDecimal getReadDepth() {
        return this.readDepth;
    }
    
    public void setReadDepth(BigDecimal readDepth) {
        this.readDepth = readDepth;
    }

    
    @Column(name="ALT_READ_DEPTH", precision=22, scale=0)
    public BigDecimal getAltReadDepth() {
        return this.altReadDepth;
    }
    
    public void setAltReadDepth(BigDecimal altReadDepth) {
        this.altReadDepth = altReadDepth;
    }

    
    @Column(name="CLINVAR_20160302SIG", length=2000)
    public String getClinvar20160302sig() {
        return this.clinvar20160302sig;
    }
    
    public void setClinvar20160302sig(String clinvar20160302sig) {
        this.clinvar20160302sig = clinvar20160302sig;
    }

    
    @Column(name="CLINVAR_20160302DBN", length=2000)
    public String getClinvar20160302dbn() {
        return this.clinvar20160302dbn;
    }
    
    public void setClinvar20160302dbn(String clinvar20160302dbn) {
        this.clinvar20160302dbn = clinvar20160302dbn;
    }

    
    @Column(name="CLINVAR_20160302ACC", length=2000)
    public String getClinvar20160302acc() {
        return this.clinvar20160302acc;
    }
    
    public void setClinvar20160302acc(String clinvar20160302acc) {
        this.clinvar20160302acc = clinvar20160302acc;
    }

    
    @Column(name="CLINVAR_20160302DSDB", length=2000)
    public String getClinvar20160302dsdb() {
        return this.clinvar20160302dsdb;
    }
    
    public void setClinvar20160302dsdb(String clinvar20160302dsdb) {
        this.clinvar20160302dsdb = clinvar20160302dsdb;
    }

    
    @Column(name="CLINVAR_20160302DSDBID", length=2000)
    public String getClinvar20160302dsdbid() {
        return this.clinvar20160302dsdbid;
    }
    
    public void setClinvar20160302dsdbid(String clinvar20160302dsdbid) {
        this.clinvar20160302dsdbid = clinvar20160302dsdbid;
    }

    
    @Column(name="SIFT", length=2000)
    public String getSift() {
        return this.sift;
    }
    
    public void setSift(String sift) {
        this.sift = sift;
    }

    
    @Column(name="SIFT_SCORE", precision=22, scale=0)
    public BigDecimal getSiftScore() {
        return this.siftScore;
    }
    
    public void setSiftScore(BigDecimal siftScore) {
        this.siftScore = siftScore;
    }

    
    @Column(name="POLYPHEN", length=2000)
    public String getPolyphen() {
        return this.polyphen;
    }
    
    public void setPolyphen(String polyphen) {
        this.polyphen = polyphen;
    }

    
    @Column(name="POLYPHEN_SCORE", precision=22, scale=0)
    public BigDecimal getPolyphenScore() {
        return this.polyphenScore;
    }
    
    public void setPolyphenScore(BigDecimal polyphenScore) {
        this.polyphenScore = polyphenScore;
    }

    
    @Column(name="IMPACT", length=2000)
    public String getImpact() {
        return this.impact;
    }
    
    public void setImpact(String impact) {
        this.impact = impact;
    }

    
    @Column(name="SIFT_SCOREA", precision=22, scale=0)
    public BigDecimal getSiftScorea() {
        return this.siftScorea;
    }
    
    public void setSiftScorea(BigDecimal siftScorea) {
        this.siftScorea = siftScorea;
    }

    
    @Column(name="SIFT_PREDA", length=2000)
    public String getSiftPreda() {
        return this.siftPreda;
    }
    
    public void setSiftPreda(String siftPreda) {
        this.siftPreda = siftPreda;
    }

    
    @Column(name="POLYPHEN2_HDIV_SCOREA", precision=22, scale=0)
    public BigDecimal getPolyphen2HdivScorea() {
        return this.polyphen2HdivScorea;
    }
    
    public void setPolyphen2HdivScorea(BigDecimal polyphen2HdivScorea) {
        this.polyphen2HdivScorea = polyphen2HdivScorea;
    }

    
    @Column(name="POLYPHEN2_HDIV_PREDA", length=2000)
    public String getPolyphen2HdivPreda() {
        return this.polyphen2HdivPreda;
    }
    
    public void setPolyphen2HdivPreda(String polyphen2HdivPreda) {
        this.polyphen2HdivPreda = polyphen2HdivPreda;
    }

    
    @Column(name="POLYPHEN2_HVAR_PREDA", length=2000)
    public String getPolyphen2HvarPreda() {
        return this.polyphen2HvarPreda;
    }
    
    public void setPolyphen2HvarPreda(String polyphen2HvarPreda) {
        this.polyphen2HvarPreda = polyphen2HvarPreda;
    }

    
    @Column(name="MUTATIONTASTER_PRED", length=2000)
    public String getMutationtasterPred() {
        return this.mutationtasterPred;
    }
    
    public void setMutationtasterPred(String mutationtasterPred) {
        this.mutationtasterPred = mutationtasterPred;
    }

    
    @Column(name="MUTATIONASSESSOR_PRED", length=2000)
    public String getMutationassessorPred() {
        return this.mutationassessorPred;
    }
    
    public void setMutationassessorPred(String mutationassessorPred) {
        this.mutationassessorPred = mutationassessorPred;
    }

    
    @Column(name="CADD_RAW", precision=22, scale=0)
    public BigDecimal getCaddRaw() {
        return this.caddRaw;
    }
    
    public void setCaddRaw(BigDecimal caddRaw) {
        this.caddRaw = caddRaw;
    }

    
    @Column(name="CADD_PHRED", precision=22, scale=0)
    public BigDecimal getCaddPhred() {
        return this.caddPhred;
    }
    
    public void setCaddPhred(BigDecimal caddPhred) {
        this.caddPhred = caddPhred;
    }

    
    @Column(name="ONE000G2014SEP_ALL", length=2000)
    public String getOne000g2014sepAll() {
        return this.one000g2014sepAll;
    }
    
    public void setOne000g2014sepAll(String one000g2014sepAll) {
        this.one000g2014sepAll = one000g2014sepAll;
    }




}


