package tom2oracle.data;
// Generated Feb 29, 2016 4:20:17 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Expression generated by hbm2java
 */
@Entity
@Table(name="EXPRESSION"
    ,schema="TOM_20160225"
)
public class Expression  implements java.io.Serializable {


     private BigDecimal expressionSaid;
     private String libraryPrep;
     private String sampleName;
     private String pipeline;
     private String geneId;
     private String geneName;
     private BigDecimal fpkm;
     private BigDecimal fpkmConfLo;
     private BigDecimal fpkmConfHi;
     private BigDecimal estimatedCounts;
     private BigDecimal tpm;

    public Expression() {
    }

	
    public Expression(BigDecimal expressionSaid, String libraryPrep, String sampleName, String pipeline) {
        this.expressionSaid = expressionSaid;
        this.libraryPrep = libraryPrep;
        this.sampleName = sampleName;
        this.pipeline = pipeline;
    }
    public Expression(BigDecimal expressionSaid, String libraryPrep, String sampleName, String pipeline, String geneId, String geneName, BigDecimal fpkm, BigDecimal fpkmConfLo, BigDecimal fpkmConfHi, BigDecimal estimatedCounts, BigDecimal tpm) {
       this.expressionSaid = expressionSaid;
       this.libraryPrep = libraryPrep;
       this.sampleName = sampleName;
       this.pipeline = pipeline;
       this.geneId = geneId;
       this.geneName = geneName;
       this.fpkm = fpkm;
       this.fpkmConfLo = fpkmConfLo;
       this.fpkmConfHi = fpkmConfHi;
       this.estimatedCounts = estimatedCounts;
       this.tpm = tpm;
    }
   
     @Id 

    
    @Column(name="EXPRESSION_SAID", unique=true, nullable=false, precision=22, scale=0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "G1")
    @SequenceGenerator(name = "G1", sequenceName = "SAID_SEQ")
    public BigDecimal getExpressionSaid() {
        return this.expressionSaid;
    }
    
    public void setExpressionSaid(BigDecimal expressionSaid) {
        this.expressionSaid = expressionSaid;
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

    
    @Column(name="GENE_ID", length=2000)
    public String getGeneId() {
        return this.geneId;
    }
    
    public void setGeneId(String geneId) {
        this.geneId = geneId;
    }

    
    @Column(name="GENE_NAME", length=2000)
    public String getGeneName() {
        return this.geneName;
    }
    
    public void setGeneName(String geneName) {
        this.geneName = geneName;
    }

    
    @Column(name="FPKM", precision=22, scale=0)
    public BigDecimal getFpkm() {
        return this.fpkm;
    }
    
    public void setFpkm(BigDecimal fpkm) {
        this.fpkm = fpkm;
    }

    
    @Column(name="FPKM_CONF_LO", precision=22, scale=0)
    public BigDecimal getFpkmConfLo() {
        return this.fpkmConfLo;
    }
    
    public void setFpkmConfLo(BigDecimal fpkmConfLo) {
        this.fpkmConfLo = fpkmConfLo;
    }

    
    @Column(name="FPKM_CONF_HI", precision=22, scale=0)
    public BigDecimal getFpkmConfHi() {
        return this.fpkmConfHi;
    }
    
    public void setFpkmConfHi(BigDecimal fpkmConfHi) {
        this.fpkmConfHi = fpkmConfHi;
    }

    
    @Column(name="ESTIMATED_COUNTS", precision=22, scale=0)
    public BigDecimal getEstimatedCounts() {
        return this.estimatedCounts;
    }
    
    public void setEstimatedCounts(BigDecimal estimatedCounts) {
        this.estimatedCounts = estimatedCounts;
    }

    
    @Column(name="TPM", precision=22, scale=0)
    public BigDecimal getTpm() {
        return this.tpm;
    }
    
    public void setTpm(BigDecimal tpm) {
        this.tpm = tpm;
    }




}


