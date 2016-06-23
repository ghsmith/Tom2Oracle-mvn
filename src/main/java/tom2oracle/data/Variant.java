package tom2oracle.data;
// Generated Jun 23, 2016 7:20:44 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Variant generated by hbm2java
 */
@Entity
@Table(name="VARIANT"
    ,schema="TOM_20160225"
)
public class Variant  implements java.io.Serializable {


     private BigDecimal variantSaid;
     private String libraryPrep;
     private String sampleName;
     private String pipeline;
     private String geneRefgene;
     private String funcRefgene;
     private String exonicFuncRefgene;
     private BigDecimal altVariantFreq;
     private BigDecimal readDepth;
     private BigDecimal altReadDepth;
     private String chrName;
     private BigDecimal startPos;
     private BigDecimal endPos;
     private String refBase;
     private String altBase;
     private String genedetailRefgene;
     private String aachangeRefgene;
     private String one000g2014sepAll;
     private String snp138;
     private String cosmic70;
     private BigDecimal cosmic70TotalOccurrences;
     private String clinvar20140929;
     private String exac03;
     private String dbnsfp;
     private String dbnsfpInterpro;

    public Variant() {
    }

	
    public Variant(BigDecimal variantSaid, String libraryPrep, String sampleName, String pipeline) {
        this.variantSaid = variantSaid;
        this.libraryPrep = libraryPrep;
        this.sampleName = sampleName;
        this.pipeline = pipeline;
    }
    public Variant(BigDecimal variantSaid, String libraryPrep, String sampleName, String pipeline, String geneRefgene, String funcRefgene, String exonicFuncRefgene, BigDecimal altVariantFreq, BigDecimal readDepth, BigDecimal altReadDepth, String chrName, BigDecimal startPos, BigDecimal endPos, String refBase, String altBase, String genedetailRefgene, String aachangeRefgene, String one000g2014sepAll, String snp138, String cosmic70, BigDecimal cosmic70TotalOccurrences, String clinvar20140929, String exac03, String dbnsfp, String dbnsfpInterpro) {
       this.variantSaid = variantSaid;
       this.libraryPrep = libraryPrep;
       this.sampleName = sampleName;
       this.pipeline = pipeline;
       this.geneRefgene = geneRefgene;
       this.funcRefgene = funcRefgene;
       this.exonicFuncRefgene = exonicFuncRefgene;
       this.altVariantFreq = altVariantFreq;
       this.readDepth = readDepth;
       this.altReadDepth = altReadDepth;
       this.chrName = chrName;
       this.startPos = startPos;
       this.endPos = endPos;
       this.refBase = refBase;
       this.altBase = altBase;
       this.genedetailRefgene = genedetailRefgene;
       this.aachangeRefgene = aachangeRefgene;
       this.one000g2014sepAll = one000g2014sepAll;
       this.snp138 = snp138;
       this.cosmic70 = cosmic70;
       this.cosmic70TotalOccurrences = cosmic70TotalOccurrences;
       this.clinvar20140929 = clinvar20140929;
       this.exac03 = exac03;
       this.dbnsfp = dbnsfp;
       this.dbnsfpInterpro = dbnsfpInterpro;
    }
   
     @Id 

    
    @Column(name="VARIANT_SAID", unique=true, nullable=false, precision=22, scale=0)
    public BigDecimal getVariantSaid() {
        return this.variantSaid;
    }
    
    public void setVariantSaid(BigDecimal variantSaid) {
        this.variantSaid = variantSaid;
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

    
    @Column(name="GENE_REFGENE", length=1000)
    public String getGeneRefgene() {
        return this.geneRefgene;
    }
    
    public void setGeneRefgene(String geneRefgene) {
        this.geneRefgene = geneRefgene;
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

    
    @Column(name="CHR_NAME", length=2000)
    public String getChrName() {
        return this.chrName;
    }
    
    public void setChrName(String chrName) {
        this.chrName = chrName;
    }

    
    @Column(name="START_POS", precision=22, scale=0)
    public BigDecimal getStartPos() {
        return this.startPos;
    }
    
    public void setStartPos(BigDecimal startPos) {
        this.startPos = startPos;
    }

    
    @Column(name="END_POS", precision=22, scale=0)
    public BigDecimal getEndPos() {
        return this.endPos;
    }
    
    public void setEndPos(BigDecimal endPos) {
        this.endPos = endPos;
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

    
    @Column(name="GENEDETAIL_REFGENE", length=2000)
    public String getGenedetailRefgene() {
        return this.genedetailRefgene;
    }
    
    public void setGenedetailRefgene(String genedetailRefgene) {
        this.genedetailRefgene = genedetailRefgene;
    }

    
    @Column(name="AACHANGE_REFGENE", length=2000)
    public String getAachangeRefgene() {
        return this.aachangeRefgene;
    }
    
    public void setAachangeRefgene(String aachangeRefgene) {
        this.aachangeRefgene = aachangeRefgene;
    }

    
    @Column(name="ONE000G2014SEP_ALL", length=2000)
    public String getOne000g2014sepAll() {
        return this.one000g2014sepAll;
    }
    
    public void setOne000g2014sepAll(String one000g2014sepAll) {
        this.one000g2014sepAll = one000g2014sepAll;
    }

    
    @Column(name="SNP138", length=2000)
    public String getSnp138() {
        return this.snp138;
    }
    
    public void setSnp138(String snp138) {
        this.snp138 = snp138;
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

    
    @Column(name="CLINVAR_20140929", length=2000)
    public String getClinvar20140929() {
        return this.clinvar20140929;
    }
    
    public void setClinvar20140929(String clinvar20140929) {
        this.clinvar20140929 = clinvar20140929;
    }

    
    @Column(name="EXAC03", length=2000)
    public String getExac03() {
        return this.exac03;
    }
    
    public void setExac03(String exac03) {
        this.exac03 = exac03;
    }

    
    @Column(name="DBNSFP", length=2000)
    public String getDbnsfp() {
        return this.dbnsfp;
    }
    
    public void setDbnsfp(String dbnsfp) {
        this.dbnsfp = dbnsfp;
    }

    
    @Column(name="DBNSFP_INTERPRO", length=2000)
    public String getDbnsfpInterpro() {
        return this.dbnsfpInterpro;
    }
    
    public void setDbnsfpInterpro(String dbnsfpInterpro) {
        this.dbnsfpInterpro = dbnsfpInterpro;
    }




}


