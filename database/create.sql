create user tom_20150918 identified by taco99Salad;
alter user tom_20150918 default tablespace users temporary tablespace temp quota unlimited on users;
grant create session, create table, create sequence, create view to tom_20150918;

create sequence said_seq start with 10000;

create table fusion
(
  fusion_said number not null,
  library_prep varchar2(100) not null,
  sample_name varchar2(100) not null,
  pipeline varchar2(100) not null,
  fusion_gene1 varchar2(2000),
  fusion_gene2 varchar2(2000),
  junction_reads number,
  spanning_frags number,
  constraint fusion_pk primary key
  (
    fusion_said
  )
);

create table variant
(
  variant_said number not null,
  library_prep varchar2(100) not null,
  sample_name varchar2(100) not null,
  pipeline varchar2(100) not null,
  gene_refgene varchar2(1000),
  func_refgene varchar2(1000),
  exonic_func_refgene varchar2(2000),
  alt_variant_freq number,
  read_depth number,
  alt_read_depth number,
  chr_name varchar2(2000),
  start_pos number,
  end_pos number,
  ref_base varchar2(2000),
  alt_base varchar2(2000),
  genedetail_refgene varchar2(2000),
  aachange_refgene varchar2(2000),
  one000g2014sep_all varchar2(2000),
  snp138 varchar2(2000),
  cosmic70 varchar2(2000),
  cosmic70_total_occurrences number,
  clinvar_20140929 varchar2(2000),
  exac03 varchar2(2000),
  constraint variant_pk primary key
  (
    variant_said
  )
);

create table expression
(
  expression_said number not null,
  library_prep varchar2(100) not null,
  sample_name varchar2(100) not null,
  pipeline varchar2(100) not null,
  gene_refgene varchar2(2000),
  func_refgene varchar2(2000),
  exonic_func_refgene varchar2(2000),
  alt_variant_freq number,
  read_depth number,
  alt_read_depth number,
  chr_name varchar2(2000),
  start_pos number,
  end_pos number,
  ref_base varchar2(2000),
  alt_base varchar2(2000),
  genedetail_refgene varchar2(2000),
  aachange_refgene varchar2(2000),
  one000g2014sep_all varchar2(2000),
  snp138 varchar2(2000),
  cosmic70 varchar2(2000),
  cosmic70_total_occurrences number,
  clinvar_20140929 varchar2(2000),
  exac03 varchar2(2000),
  constraint variant_pk primary key
  (
    variant_said
  )
);

create table gene_aml_mds
(
  gene_name varchar2(10),
  constraint genes_aml_mds_pk primary key
  (
    gene_name
  )
);

insert into gene_aml_mds values ('ABL1');
insert into gene_aml_mds values ('ACSL6');
insert into gene_aml_mds values ('ARHGAP26');
insert into gene_aml_mds values ('ASXL1');
insert into gene_aml_mds values ('BCOR');
insert into gene_aml_mds values ('BCR');
insert into gene_aml_mds values ('CALR');
insert into gene_aml_mds values ('CBFB');
insert into gene_aml_mds values ('CBL');
insert into gene_aml_mds values ('CCDC6');
insert into gene_aml_mds values ('CDKN2A');
insert into gene_aml_mds values ('CEBPA');
insert into gene_aml_mds values ('CHIC2');
insert into gene_aml_mds values ('CNTRL');
insert into gene_aml_mds values ('CREBBP');
insert into gene_aml_mds values ('CSF1R');
insert into gene_aml_mds values ('CSF3R');
insert into gene_aml_mds values ('CUX1');
insert into gene_aml_mds values ('DEK');
insert into gene_aml_mds values ('DNMT3A');
insert into gene_aml_mds values ('EGR1');
insert into gene_aml_mds values ('ETV6');
insert into gene_aml_mds values ('EZH2');
insert into gene_aml_mds values ('FGFR1');
insert into gene_aml_mds values ('FGFR1OP');
insert into gene_aml_mds values ('FIP1L1');
insert into gene_aml_mds values ('FLT3');
insert into gene_aml_mds values ('GATA1');
insert into gene_aml_mds values ('HIP1');
insert into gene_aml_mds values ('HRAS');
insert into gene_aml_mds values ('HOXA11');
insert into gene_aml_mds values ('IDH1');
insert into gene_aml_mds values ('IDH2');
insert into gene_aml_mds values ('JAK2');
insert into gene_aml_mds values ('KDM6A');
insert into gene_aml_mds values ('KIT');
insert into gene_aml_mds values ('KMT2A');
insert into gene_aml_mds values ('KRAS');
insert into gene_aml_mds values ('MDS1');
insert into gene_aml_mds values ('MDS2');
insert into gene_aml_mds values ('MECOM');
insert into gene_aml_mds values ('MKL1');
insert into gene_aml_mds values ('MLLT1');
insert into gene_aml_mds values ('MLLT10');
insert into gene_aml_mds values ('MLLT11');
insert into gene_aml_mds values ('MLLT3');
insert into gene_aml_mds values ('MLLT4');
insert into gene_aml_mds values ('MLLT7');
insert into gene_aml_mds values ('MPL');
insert into gene_aml_mds values ('MSI2');
insert into gene_aml_mds values ('MYBL2');
insert into gene_aml_mds values ('MYC');
insert into gene_aml_mds values ('NF1');
insert into gene_aml_mds values ('NIN');
insert into gene_aml_mds values ('NPM1');
insert into gene_aml_mds values ('NRAS');
insert into gene_aml_mds values ('NSD1');
insert into gene_aml_mds values ('NUP214');
insert into gene_aml_mds values ('NUP98');
insert into gene_aml_mds values ('PCM1');
insert into gene_aml_mds values ('PDE4DIP');
insert into gene_aml_mds values ('PDGFRA');
insert into gene_aml_mds values ('PDGFRB');
insert into gene_aml_mds values ('PER1');
insert into gene_aml_mds values ('PHF6');
insert into gene_aml_mds values ('PICALM');
insert into gene_aml_mds values ('PML');
insert into gene_aml_mds values ('PRDM16');
insert into gene_aml_mds values ('PTEN');
insert into gene_aml_mds values ('PTPN11');
insert into gene_aml_mds values ('PTPRT');
insert into gene_aml_mds values ('RABEP1');
insert into gene_aml_mds values ('RAD21');
insert into gene_aml_mds values ('RARA');
insert into gene_aml_mds values ('RELN');
insert into gene_aml_mds values ('RPL22');
insert into gene_aml_mds values ('RUNX1');
insert into gene_aml_mds values ('RUNX1T1');
insert into gene_aml_mds values ('SBDS');
insert into gene_aml_mds values ('SETBP1');
insert into gene_aml_mds values ('SF3B1');
insert into gene_aml_mds values ('SH2B3');
insert into gene_aml_mds values ('SMC1A');
insert into gene_aml_mds values ('SMC3');
insert into gene_aml_mds values ('SPECC1');
insert into gene_aml_mds values ('SRSF2');
insert into gene_aml_mds values ('STAG1');
insert into gene_aml_mds values ('STAG2');
insert into gene_aml_mds values ('SYK');
insert into gene_aml_mds values ('TES');
insert into gene_aml_mds values ('TET1');
insert into gene_aml_mds values ('TET2');
insert into gene_aml_mds values ('TP53');
insert into gene_aml_mds values ('U2AF1');
insert into gene_aml_mds values ('UTX');
insert into gene_aml_mds values ('WT1');
insert into gene_aml_mds values ('ZMYM2');
insert into gene_aml_mds values ('ZRSR2');

commit;

create table gene_comprehensive_cancer
(
  gene_name varchar2(10),
  constraint genes_comprehensive_cancer_pk primary key
  (
    gene_name
  )
);

insert into gene_comprehensive_cancer values ('GNB1');
insert into gene_comprehensive_cancer values ('TNFRSF14');
insert into gene_comprehensive_cancer values ('PRDM16');
insert into gene_comprehensive_cancer values ('RPL22');
insert into gene_comprehensive_cancer values ('PLEKHG5');
insert into gene_comprehensive_cancer values ('CAMTA1');
insert into gene_comprehensive_cancer values ('SPEN');
insert into gene_comprehensive_cancer values ('SDHB');
insert into gene_comprehensive_cancer values ('PAX7');
insert into gene_comprehensive_cancer values ('MDS2');
insert into gene_comprehensive_cancer values ('ARID1A');
insert into gene_comprehensive_cancer values ('LCK');
insert into gene_comprehensive_cancer values ('SFPQ');
insert into gene_comprehensive_cancer values ('THRAP3');
insert into gene_comprehensive_cancer values ('MYCL1');
insert into gene_comprehensive_cancer values ('MPL');
insert into gene_comprehensive_cancer values ('MUTYH');
insert into gene_comprehensive_cancer values ('TAL1');
insert into gene_comprehensive_cancer values ('STIL');
insert into gene_comprehensive_cancer values ('CDKN2C');
insert into gene_comprehensive_cancer values ('EPS15');
insert into gene_comprehensive_cancer values ('JUN');
insert into gene_comprehensive_cancer values ('JAK1');
insert into gene_comprehensive_cancer values ('FUBP1');
insert into gene_comprehensive_cancer values ('BCL10');
insert into gene_comprehensive_cancer values ('RPL5');
insert into gene_comprehensive_cancer values ('RBM15');
insert into gene_comprehensive_cancer values ('TRIM33');
insert into gene_comprehensive_cancer values ('NRAS');
insert into gene_comprehensive_cancer values ('FAM46C');
insert into gene_comprehensive_cancer values ('NOTCH2');
insert into gene_comprehensive_cancer values ('PDE4DIP');
insert into gene_comprehensive_cancer values ('BCL9');
insert into gene_comprehensive_cancer values ('ARNT');
insert into gene_comprehensive_cancer values ('SETDB1');
insert into gene_comprehensive_cancer values ('MLLT11');
insert into gene_comprehensive_cancer values ('TPM3');
insert into gene_comprehensive_cancer values ('MUC1');
insert into gene_comprehensive_cancer values ('PRCC');
insert into gene_comprehensive_cancer values ('NTRK1');
insert into gene_comprehensive_cancer values ('FCRL4');
insert into gene_comprehensive_cancer values ('SDHC');
insert into gene_comprehensive_cancer values ('FCGR2B');
insert into gene_comprehensive_cancer values ('PBX1');
insert into gene_comprehensive_cancer values ('PMX1');
insert into gene_comprehensive_cancer values ('ABL2');
insert into gene_comprehensive_cancer values ('TPR');
insert into gene_comprehensive_cancer values ('HRPT2');
insert into gene_comprehensive_cancer values ('PTPRC');
insert into gene_comprehensive_cancer values ('MDM4');
insert into gene_comprehensive_cancer values ('ELK4');
insert into gene_comprehensive_cancer values ('SLC45A3');
insert into gene_comprehensive_cancer values ('H3F3A');
insert into gene_comprehensive_cancer values ('ITPKB');
insert into gene_comprehensive_cancer values ('FH');
insert into gene_comprehensive_cancer values ('MYCN');
insert into gene_comprehensive_cancer values ('NCOA1');
insert into gene_comprehensive_cancer values ('DNMT3A');
insert into gene_comprehensive_cancer values ('ALK');
insert into gene_comprehensive_cancer values ('EML4');
insert into gene_comprehensive_cancer values ('MSH2');
insert into gene_comprehensive_cancer values ('MSH6');
insert into gene_comprehensive_cancer values ('FBXO11');
insert into gene_comprehensive_cancer values ('BCL11A');
insert into gene_comprehensive_cancer values ('REL');
insert into gene_comprehensive_cancer values ('XPO1');
insert into gene_comprehensive_cancer values ('AFF3');
insert into gene_comprehensive_cancer values ('TTL');
insert into gene_comprehensive_cancer values ('PAX8');
insert into gene_comprehensive_cancer values ('GLI2');
insert into gene_comprehensive_cancer values ('ERCC3');
insert into gene_comprehensive_cancer values ('LRP1B');
insert into gene_comprehensive_cancer values ('ACVR1');
insert into gene_comprehensive_cancer values ('SLC4A10');
insert into gene_comprehensive_cancer values ('CHN1');
insert into gene_comprehensive_cancer values ('HOXD13');
insert into gene_comprehensive_cancer values ('HOXD11');
insert into gene_comprehensive_cancer values ('NFE2L2');
insert into gene_comprehensive_cancer values ('TTN');
insert into gene_comprehensive_cancer values ('PMS1');
insert into gene_comprehensive_cancer values ('SF3B1');
insert into gene_comprehensive_cancer values ('CREB1');
insert into gene_comprehensive_cancer values ('IDH1');
insert into gene_comprehensive_cancer values ('IKZF2');
insert into gene_comprehensive_cancer values ('ATIC');
insert into gene_comprehensive_cancer values ('FEV');
insert into gene_comprehensive_cancer values ('PAX3');
insert into gene_comprehensive_cancer values ('ACSL3');
insert into gene_comprehensive_cancer values ('CMKOR1');
insert into gene_comprehensive_cancer values ('SRGAP3');
insert into gene_comprehensive_cancer values ('FANCD2');
insert into gene_comprehensive_cancer values ('VHL');
insert into gene_comprehensive_cancer values ('PPARG');
insert into gene_comprehensive_cancer values ('RAF1');
insert into gene_comprehensive_cancer values ('XPC');
insert into gene_comprehensive_cancer values ('MLH1');
insert into gene_comprehensive_cancer values ('MYD88');
insert into gene_comprehensive_cancer values ('CTNNB1');
insert into gene_comprehensive_cancer values ('SETD2');
insert into gene_comprehensive_cancer values ('NCKIPSD');
insert into gene_comprehensive_cancer values ('RASSF1');
insert into gene_comprehensive_cancer values ('BAP1');
insert into gene_comprehensive_cancer values ('PBRM1');
insert into gene_comprehensive_cancer values ('FHIT');
insert into gene_comprehensive_cancer values ('FOXP1');
insert into gene_comprehensive_cancer values ('TFG');
insert into gene_comprehensive_cancer values ('CBLB');
insert into gene_comprehensive_cancer values ('GATA2');
insert into gene_comprehensive_cancer values ('CNBP');
insert into gene_comprehensive_cancer values ('FOXL2');
insert into gene_comprehensive_cancer values ('WWTR1');
insert into gene_comprehensive_cancer values ('GMPS');
insert into gene_comprehensive_cancer values ('SI');
insert into gene_comprehensive_cancer values ('MECOM');
insert into gene_comprehensive_cancer values ('TBL1XR1');
insert into gene_comprehensive_cancer values ('PIK3CA');
insert into gene_comprehensive_cancer values ('SOX2');
insert into gene_comprehensive_cancer values ('KLHL6');
insert into gene_comprehensive_cancer values ('ETV5');
insert into gene_comprehensive_cancer values ('EIF4A2');
insert into gene_comprehensive_cancer values ('BCL6');
insert into gene_comprehensive_cancer values ('LPP');
insert into gene_comprehensive_cancer values ('TFRC');
insert into gene_comprehensive_cancer values ('FGFR3');
insert into gene_comprehensive_cancer values ('WHSC1');
insert into gene_comprehensive_cancer values ('SLC34A2');
insert into gene_comprehensive_cancer values ('RHOH');
insert into gene_comprehensive_cancer values ('PHOX2B');
insert into gene_comprehensive_cancer values ('GABRG1');
insert into gene_comprehensive_cancer values ('FIP1L1');
insert into gene_comprehensive_cancer values ('CHIC2');
insert into gene_comprehensive_cancer values ('PDGFRA');
insert into gene_comprehensive_cancer values ('KIT');
insert into gene_comprehensive_cancer values ('KDR');
insert into gene_comprehensive_cancer values ('LPHN3');
insert into gene_comprehensive_cancer values ('AFF1');
insert into gene_comprehensive_cancer values ('RAP1GDS1');
insert into gene_comprehensive_cancer values ('TET2');
insert into gene_comprehensive_cancer values ('LEF1');
insert into gene_comprehensive_cancer values ('IL2');
insert into gene_comprehensive_cancer values ('FBXW7');
insert into gene_comprehensive_cancer values ('FAT1');
insert into gene_comprehensive_cancer values ('DUX4');
insert into gene_comprehensive_cancer values ('TERT');
insert into gene_comprehensive_cancer values ('IL7R');
insert into gene_comprehensive_cancer values ('LIFR');
insert into gene_comprehensive_cancer values ('IL6ST');
insert into gene_comprehensive_cancer values ('PIK3R1');
insert into gene_comprehensive_cancer values ('APC');
insert into gene_comprehensive_cancer values ('SNCAIP');
insert into gene_comprehensive_cancer values ('ACSL6');
insert into gene_comprehensive_cancer values ('IL3');
insert into gene_comprehensive_cancer values ('AFF4');
insert into gene_comprehensive_cancer values ('EGR1');
insert into gene_comprehensive_cancer values ('ARHGAP26');
insert into gene_comprehensive_cancer values ('NR3C1');
insert into gene_comprehensive_cancer values ('CSF1R');
insert into gene_comprehensive_cancer values ('PDGFRB');
insert into gene_comprehensive_cancer values ('CD74');
insert into gene_comprehensive_cancer values ('ITK');
insert into gene_comprehensive_cancer values ('EBF1');
insert into gene_comprehensive_cancer values ('RANBP17');
insert into gene_comprehensive_cancer values ('TLX3');
insert into gene_comprehensive_cancer values ('NPM1');
insert into gene_comprehensive_cancer values ('NSD1');
insert into gene_comprehensive_cancer values ('IRF4');
insert into gene_comprehensive_cancer values ('RIPK1');
insert into gene_comprehensive_cancer values ('DEK');
insert into gene_comprehensive_cancer values ('HIST1H3B');
insert into gene_comprehensive_cancer values ('HIST1H1E');
insert into gene_comprehensive_cancer values ('HIST1H4I');
insert into gene_comprehensive_cancer values ('TRIM27');
insert into gene_comprehensive_cancer values ('POU5F1');
insert into gene_comprehensive_cancer values ('CSNK2B');
insert into gene_comprehensive_cancer values ('DAXX');
insert into gene_comprehensive_cancer values ('HMGA1');
insert into gene_comprehensive_cancer values ('FANCE');
insert into gene_comprehensive_cancer values ('SRSF3');
insert into gene_comprehensive_cancer values ('PIM1');
insert into gene_comprehensive_cancer values ('TFEB');
insert into gene_comprehensive_cancer values ('CCND3');
insert into gene_comprehensive_cancer values ('HSPCB');
insert into gene_comprehensive_cancer values ('EPHA7');
insert into gene_comprehensive_cancer values ('PRDM1');
insert into gene_comprehensive_cancer values ('FOXO3');
insert into gene_comprehensive_cancer values ('ROS1');
insert into gene_comprehensive_cancer values ('GOPC');
insert into gene_comprehensive_cancer values ('STL');
insert into gene_comprehensive_cancer values ('MYB');
insert into gene_comprehensive_cancer values ('TNFAIP3');
insert into gene_comprehensive_cancer values ('ECT2L-');
insert into gene_comprehensive_cancer values ('EZR');
insert into gene_comprehensive_cancer values ('QKI');
insert into gene_comprehensive_cancer values ('FGFR1OP');
insert into gene_comprehensive_cancer values ('MLLT4');
insert into gene_comprehensive_cancer values ('CARD11');
insert into gene_comprehensive_cancer values ('PMS2');
insert into gene_comprehensive_cancer values ('ETV1');
insert into gene_comprehensive_cancer values ('HNRNPA2B1');
insert into gene_comprehensive_cancer values ('HOXA9');
insert into gene_comprehensive_cancer values ('HOXA11');
insert into gene_comprehensive_cancer values ('HOXA13');
insert into gene_comprehensive_cancer values ('JAZF1');
insert into gene_comprehensive_cancer values ('IKZF1');
insert into gene_comprehensive_cancer values ('EGFR');
insert into gene_comprehensive_cancer values ('SBDS');
insert into gene_comprehensive_cancer values ('BCL7B');
insert into gene_comprehensive_cancer values ('ELN');
insert into gene_comprehensive_cancer values ('HIP1');
insert into gene_comprehensive_cancer values ('PCLO');
insert into gene_comprehensive_cancer values ('AKAP9');
insert into gene_comprehensive_cancer values ('CDK6');
insert into gene_comprehensive_cancer values ('TRRAP');
insert into gene_comprehensive_cancer values ('CUX1');
insert into gene_comprehensive_cancer values ('RELN');
insert into gene_comprehensive_cancer values ('TES');
insert into gene_comprehensive_cancer values ('MET');
insert into gene_comprehensive_cancer values ('POT1');
insert into gene_comprehensive_cancer values ('SMO');
insert into gene_comprehensive_cancer values ('CREB3L2');
insert into gene_comprehensive_cancer values ('TRIM24');
insert into gene_comprehensive_cancer values ('KIAA1549');
insert into gene_comprehensive_cancer values ('BRAF');
insert into gene_comprehensive_cancer values ('TRB');
insert into gene_comprehensive_cancer values ('FAM131B');
insert into gene_comprehensive_cancer values ('EZH2');
insert into gene_comprehensive_cancer values ('KMT2C');
insert into gene_comprehensive_cancer values ('HLXB9');
insert into gene_comprehensive_cancer values ('PCM1');
insert into gene_comprehensive_cancer values ('WRN');
insert into gene_comprehensive_cancer values ('WHSC1L1');
insert into gene_comprehensive_cancer values ('FGFR1');
insert into gene_comprehensive_cancer values ('KAT6A');
insert into gene_comprehensive_cancer values ('HOOK3');
insert into gene_comprehensive_cancer values ('TCEA1');
insert into gene_comprehensive_cancer values ('PLAG1');
insert into gene_comprehensive_cancer values ('CHCHD7');
insert into gene_comprehensive_cancer values ('CHD7');
insert into gene_comprehensive_cancer values ('MYBL1');
insert into gene_comprehensive_cancer values ('NCOA2');
insert into gene_comprehensive_cancer values ('HEY1');
insert into gene_comprehensive_cancer values ('NBN');
insert into gene_comprehensive_cancer values ('RUNX1T1');
insert into gene_comprehensive_cancer values ('COX6C');
insert into gene_comprehensive_cancer values ('RIMS2');
insert into gene_comprehensive_cancer values ('CSMD3');
insert into gene_comprehensive_cancer values ('RAD21');
insert into gene_comprehensive_cancer values ('EXT1');
insert into gene_comprehensive_cancer values ('MYC');
insert into gene_comprehensive_cancer values ('NDRG1');
insert into gene_comprehensive_cancer values ('RECQL4');
insert into gene_comprehensive_cancer values ('AK3');
insert into gene_comprehensive_cancer values ('JAK2');
insert into gene_comprehensive_cancer values ('CD274');
insert into gene_comprehensive_cancer values ('PDCD1LG2');
insert into gene_comprehensive_cancer values ('KDM4C');
insert into gene_comprehensive_cancer values ('NFIB');
insert into gene_comprehensive_cancer values ('PSIP2');
insert into gene_comprehensive_cancer values ('MLLT3');
insert into gene_comprehensive_cancer values ('CDKN2A');
insert into gene_comprehensive_cancer values ('CDKN2A');
insert into gene_comprehensive_cancer values ('CDKN2B');
insert into gene_comprehensive_cancer values ('FANCG');
insert into gene_comprehensive_cancer values ('PAX5');
insert into gene_comprehensive_cancer values ('GNAQ');
insert into gene_comprehensive_cancer values ('NTRK2');
insert into gene_comprehensive_cancer values ('SYK');
insert into gene_comprehensive_cancer values ('OMD');
insert into gene_comprehensive_cancer values ('FANCC');
insert into gene_comprehensive_cancer values ('PTCH1');
insert into gene_comprehensive_cancer values ('XPA');
insert into gene_comprehensive_cancer values ('NR4A3');
insert into gene_comprehensive_cancer values ('SLC44A1');
insert into gene_comprehensive_cancer values ('TAL2');
insert into gene_comprehensive_cancer values ('CNTRL');
insert into gene_comprehensive_cancer values ('SET');
insert into gene_comprehensive_cancer values ('FNBP1');
insert into gene_comprehensive_cancer values ('ABL1');
insert into gene_comprehensive_cancer values ('NUP214');
insert into gene_comprehensive_cancer values ('TSC1');
insert into gene_comprehensive_cancer values ('RALGDS');
insert into gene_comprehensive_cancer values ('BRD3');
insert into gene_comprehensive_cancer values ('NOTCH1');
insert into gene_comprehensive_cancer values ('COPEB');
insert into gene_comprehensive_cancer values ('GATA3');
insert into gene_comprehensive_cancer values ('MLLT10');
insert into gene_comprehensive_cancer values ('ABI1');
insert into gene_comprehensive_cancer values ('KIF5B');
insert into gene_comprehensive_cancer values ('RET');
insert into gene_comprehensive_cancer values ('NCOA4');
insert into gene_comprehensive_cancer values ('CCDC6');
insert into gene_comprehensive_cancer values ('ARID5B');
insert into gene_comprehensive_cancer values ('EGR2');
insert into gene_comprehensive_cancer values ('TET1');
insert into gene_comprehensive_cancer values ('PRF1');
insert into gene_comprehensive_cancer values ('CDH23');
insert into gene_comprehensive_cancer values ('KAT6B');
insert into gene_comprehensive_cancer values ('NUTM2B');
insert into gene_comprehensive_cancer values ('BMPR1A');
insert into gene_comprehensive_cancer values ('NUTM2A');
insert into gene_comprehensive_cancer values ('PTEN');
insert into gene_comprehensive_cancer values ('TNFRSF6');
insert into gene_comprehensive_cancer values ('IFIT3');
insert into gene_comprehensive_cancer values ('TLX1');
insert into gene_comprehensive_cancer values ('LDB1');
insert into gene_comprehensive_cancer values ('NFKB2');
insert into gene_comprehensive_cancer values ('SUFU');
insert into gene_comprehensive_cancer values ('NT5C2');
insert into gene_comprehensive_cancer values ('ADD3');
insert into gene_comprehensive_cancer values ('SMC3');
insert into gene_comprehensive_cancer values ('GPAM');
insert into gene_comprehensive_cancer values ('VTI1A');
insert into gene_comprehensive_cancer values ('TCF7L2');
insert into gene_comprehensive_cancer values ('FGFR2');
insert into gene_comprehensive_cancer values ('MGMT');
insert into gene_comprehensive_cancer values ('HRAS');
insert into gene_comprehensive_cancer values ('MUC2');
insert into gene_comprehensive_cancer values ('CARS');
insert into gene_comprehensive_cancer values ('NUP98');
insert into gene_comprehensive_cancer values ('LMO1');
insert into gene_comprehensive_cancer values ('FANCF');
insert into gene_comprehensive_cancer values ('WT1');
insert into gene_comprehensive_cancer values ('LMO2');
insert into gene_comprehensive_cancer values ('RAG1');
insert into gene_comprehensive_cancer values ('RAG2');
insert into gene_comprehensive_cancer values ('EXT2');
insert into gene_comprehensive_cancer values ('CREB3L1');
insert into gene_comprehensive_cancer values ('DDB2');
insert into gene_comprehensive_cancer values ('CLP1');
insert into gene_comprehensive_cancer values ('SDH5');
insert into gene_comprehensive_cancer values ('NXF1');
insert into gene_comprehensive_cancer values ('MEN1');
insert into gene_comprehensive_cancer values ('MALAT1');
insert into gene_comprehensive_cancer values ('RELA');
insert into gene_comprehensive_cancer values ('CCND1');
insert into gene_comprehensive_cancer values ('NUMA1');
insert into gene_comprehensive_cancer values ('PICALM');
insert into gene_comprehensive_cancer values ('MAML2');
insert into gene_comprehensive_cancer values ('BIRC3');
insert into gene_comprehensive_cancer values ('ATM');
insert into gene_comprehensive_cancer values ('DDX10');
insert into gene_comprehensive_cancer values ('POU2AF1');
insert into gene_comprehensive_cancer values ('SDHD');
insert into gene_comprehensive_cancer values ('ZBTB16');
insert into gene_comprehensive_cancer values ('PAFAH1B2');
insert into gene_comprehensive_cancer values ('PCSK7');
insert into gene_comprehensive_cancer values ('KMT2A');
insert into gene_comprehensive_cancer values ('DDX6');
insert into gene_comprehensive_cancer values ('CBL');
insert into gene_comprehensive_cancer values ('ARHGEF12');
insert into gene_comprehensive_cancer values ('FLI1');
insert into gene_comprehensive_cancer values ('KDM5A');
insert into gene_comprehensive_cancer values ('ERC1');
insert into gene_comprehensive_cancer values ('CCND2');
insert into gene_comprehensive_cancer values ('ZNF384');
insert into gene_comprehensive_cancer values ('ETV6');
insert into gene_comprehensive_cancer values ('PIK3C2G');
insert into gene_comprehensive_cancer values ('KRAS');
insert into gene_comprehensive_cancer values ('ARID2');
insert into gene_comprehensive_cancer values ('KMT2D');
insert into gene_comprehensive_cancer values ('ATF1');
insert into gene_comprehensive_cancer values ('HOXC13');
insert into gene_comprehensive_cancer values ('HOXC11');
insert into gene_comprehensive_cancer values ('NACA');
insert into gene_comprehensive_cancer values ('DDIT3');
insert into gene_comprehensive_cancer values ('CDK4');
insert into gene_comprehensive_cancer values ('LRIG3');
insert into gene_comprehensive_cancer values ('WIFI');
insert into gene_comprehensive_cancer values ('HMGA2');
insert into gene_comprehensive_cancer values ('MDM2');
insert into gene_comprehensive_cancer values ('BTG1');
insert into gene_comprehensive_cancer values ('SH2B3');
insert into gene_comprehensive_cancer values ('ALDH2');
insert into gene_comprehensive_cancer values ('PTPN11');
insert into gene_comprehensive_cancer values ('HNF1A');
insert into gene_comprehensive_cancer values ('BCL7A');
insert into gene_comprehensive_cancer values ('ZMYM2');
insert into gene_comprehensive_cancer values ('CDX2');
insert into gene_comprehensive_cancer values ('FLT3');
insert into gene_comprehensive_cancer values ('PAN3');
insert into gene_comprehensive_cancer values ('BRCA2');
insert into gene_comprehensive_cancer values ('LHFP');
insert into gene_comprehensive_cancer values ('FOXO1A');
insert into gene_comprehensive_cancer values ('LCP1');
insert into gene_comprehensive_cancer values ('RB1');
insert into gene_comprehensive_cancer values ('DLEU2');
insert into gene_comprehensive_cancer values ('DLEU1');
insert into gene_comprehensive_cancer values ('ERCC5');
insert into gene_comprehensive_cancer values ('CCNB1IP1');
insert into gene_comprehensive_cancer values ('TRA');
insert into gene_comprehensive_cancer values ('TRD');
insert into gene_comprehensive_cancer values ('NKX2-1');
insert into gene_comprehensive_cancer values ('NIN');
insert into gene_comprehensive_cancer values ('KTN1');
insert into gene_comprehensive_cancer values ('OTX2');
insert into gene_comprehensive_cancer values ('GPHN');
insert into gene_comprehensive_cancer values ('RAD51L1');
insert into gene_comprehensive_cancer values ('TSHR');
insert into gene_comprehensive_cancer values ('TRIP11');
insert into gene_comprehensive_cancer values ('GOLGA5');
insert into gene_comprehensive_cancer values ('DICER1');
insert into gene_comprehensive_cancer values ('TCL6');
insert into gene_comprehensive_cancer values ('TCL1A');
insert into gene_comprehensive_cancer values ('BCL11B');
insert into gene_comprehensive_cancer values ('HSPCA');
insert into gene_comprehensive_cancer values ('AKT1');
insert into gene_comprehensive_cancer values ('IGH@');
insert into gene_comprehensive_cancer values ('ATP10A');
insert into gene_comprehensive_cancer values ('SPRED1');
insert into gene_comprehensive_cancer values ('BUB1B');
insert into gene_comprehensive_cancer values ('CASC5');
insert into gene_comprehensive_cancer values ('TGM7');
insert into gene_comprehensive_cancer values ('FLJ27352');
insert into gene_comprehensive_cancer values ('TCF12');
insert into gene_comprehensive_cancer values ('PML');
insert into gene_comprehensive_cancer values ('NTRK3');
insert into gene_comprehensive_cancer values ('IDH2');
insert into gene_comprehensive_cancer values ('CRTC3');
insert into gene_comprehensive_cancer values ('BLM');
insert into gene_comprehensive_cancer values ('CHD2');
insert into gene_comprehensive_cancer values ('RPS2');
insert into gene_comprehensive_cancer values ('TSC2');
insert into gene_comprehensive_cancer values ('CREBBP');
insert into gene_comprehensive_cancer values ('CIITA');
insert into gene_comprehensive_cancer values ('SOCS1');
insert into gene_comprehensive_cancer values ('TNFRSF17');
insert into gene_comprehensive_cancer values ('SNX29');
insert into gene_comprehensive_cancer values ('ERCC4');
insert into gene_comprehensive_cancer values ('MYH11');
insert into gene_comprehensive_cancer values ('PALB2');
insert into gene_comprehensive_cancer values ('IL21R');
insert into gene_comprehensive_cancer values ('FUS');
insert into gene_comprehensive_cancer values ('CYLD');
insert into gene_comprehensive_cancer values ('HERPUD1');
insert into gene_comprehensive_cancer values ('CDH11');
insert into gene_comprehensive_cancer values ('CBFB');
insert into gene_comprehensive_cancer values ('CDH1');
insert into gene_comprehensive_cancer values ('HYDIN');
insert into gene_comprehensive_cancer values ('MAF');
insert into gene_comprehensive_cancer values ('CBFA2T3');
insert into gene_comprehensive_cancer values ('FANCA');
insert into gene_comprehensive_cancer values ('YWHAE');
insert into gene_comprehensive_cancer values ('USP6');
insert into gene_comprehensive_cancer values ('RABEP1');
insert into gene_comprehensive_cancer values ('GPS2');
insert into gene_comprehensive_cancer values ('TP53');
insert into gene_comprehensive_cancer values ('PER1');
insert into gene_comprehensive_cancer values ('GAS7');
insert into gene_comprehensive_cancer values ('MAP2K4');
insert into gene_comprehensive_cancer values ('FLCN');
insert into gene_comprehensive_cancer values ('SPECC1');
insert into gene_comprehensive_cancer values ('NF1');
insert into gene_comprehensive_cancer values ('SUZ12');
insert into gene_comprehensive_cancer values ('TAF15');
insert into gene_comprehensive_cancer values ('MLLT6');
insert into gene_comprehensive_cancer values ('LASP1');
insert into gene_comprehensive_cancer values ('CDK12');
insert into gene_comprehensive_cancer values ('ERBB2');
insert into gene_comprehensive_cancer values ('RARA');
insert into gene_comprehensive_cancer values ('SMARCE1');
insert into gene_comprehensive_cancer values ('BRCA1');
insert into gene_comprehensive_cancer values ('ETV4');
insert into gene_comprehensive_cancer values ('COL1A1');
insert into gene_comprehensive_cancer values ('HLF');
insert into gene_comprehensive_cancer values ('MSI2');
insert into gene_comprehensive_cancer values ('RNF43');
insert into gene_comprehensive_cancer values ('CLTC');
insert into gene_comprehensive_cancer values ('PPM1D');
insert into gene_comprehensive_cancer values ('BRIP1');
insert into gene_comprehensive_cancer values ('MED13');
insert into gene_comprehensive_cancer values ('CD79B');
insert into gene_comprehensive_cancer values ('DDX5');
insert into gene_comprehensive_cancer values ('PRKCA');
insert into gene_comprehensive_cancer values ('PRKAR1A');
insert into gene_comprehensive_cancer values ('SRSF2');
insert into gene_comprehensive_cancer values ('SEPT9');
insert into gene_comprehensive_cancer values ('CANT1');
insert into gene_comprehensive_cancer values ('RNF213');
insert into gene_comprehensive_cancer values ('ASPSCR1');
insert into gene_comprehensive_cancer values ('ZNF521');
insert into gene_comprehensive_cancer values ('SS18');
insert into gene_comprehensive_cancer values ('SETBP1');
insert into gene_comprehensive_cancer values ('MADH4');
insert into gene_comprehensive_cancer values ('MALT1');
insert into gene_comprehensive_cancer values ('BCL2');
insert into gene_comprehensive_cancer values ('KDSR');
insert into gene_comprehensive_cancer values ('FSTL3');
insert into gene_comprehensive_cancer values ('STK11');
insert into gene_comprehensive_cancer values ('RPS15');
insert into gene_comprehensive_cancer values ('TCF3');
insert into gene_comprehensive_cancer values ('GNA11');
insert into gene_comprehensive_cancer values ('SH3GL1');
insert into gene_comprehensive_cancer values ('MLLT1');
insert into gene_comprehensive_cancer values ('DNM2');
insert into gene_comprehensive_cancer values ('SMARCA4');
insert into gene_comprehensive_cancer values ('CALR');
insert into gene_comprehensive_cancer values ('LYL1');
insert into gene_comprehensive_cancer values ('NOTCH3');
insert into gene_comprehensive_cancer values ('BRD4');
insert into gene_comprehensive_cancer values ('TPM4');
insert into gene_comprehensive_cancer values ('JAK3');
insert into gene_comprehensive_cancer values ('ELL');
insert into gene_comprehensive_cancer values ('MECT1');
insert into gene_comprehensive_cancer values ('CCNE1');
insert into gene_comprehensive_cancer values ('CEBPA');
insert into gene_comprehensive_cancer values ('AKT2');
insert into gene_comprehensive_cancer values ('CD79A');
insert into gene_comprehensive_cancer values ('CIC');
insert into gene_comprehensive_cancer values ('BCL3');
insert into gene_comprehensive_cancer values ('CBLC');
insert into gene_comprehensive_cancer values ('ERCC2');
insert into gene_comprehensive_cancer values ('KLK2');
insert into gene_comprehensive_cancer values ('PPP2R1A');
insert into gene_comprehensive_cancer values ('ZNF331');
insert into gene_comprehensive_cancer values ('TFPT');
insert into gene_comprehensive_cancer values ('CNOT3');
insert into gene_comprehensive_cancer values ('ASXL1');
insert into gene_comprehensive_cancer values ('MAFB');
insert into gene_comprehensive_cancer values ('TOP1');
insert into gene_comprehensive_cancer values ('PTPRT');
insert into gene_comprehensive_cancer values ('MYBL2');
insert into gene_comprehensive_cancer values ('SDC4');
insert into gene_comprehensive_cancer values ('GNAS');
insert into gene_comprehensive_cancer values ('SS18L1');
insert into gene_comprehensive_cancer values ('OLIG2');
insert into gene_comprehensive_cancer values ('RUNX1');
insert into gene_comprehensive_cancer values ('ERG');
insert into gene_comprehensive_cancer values ('TMPRSS2');
insert into gene_comprehensive_cancer values ('U2AF1');
insert into gene_comprehensive_cancer values ('CLTCL1');
insert into gene_comprehensive_cancer values ('PNUTL1');
insert into gene_comprehensive_cancer values ('MAPK1');
insert into gene_comprehensive_cancer values ('VPREB1');
insert into gene_comprehensive_cancer values ('BCR');
insert into gene_comprehensive_cancer values ('SMARCB1');
insert into gene_comprehensive_cancer values ('MN1');
insert into gene_comprehensive_cancer values ('CHEK2');
insert into gene_comprehensive_cancer values ('EWSR1');
insert into gene_comprehensive_cancer values ('NF2');
insert into gene_comprehensive_cancer values ('PATZ1');
insert into gene_comprehensive_cancer values ('MYH9');
insert into gene_comprehensive_cancer values ('PDGFB');
insert into gene_comprehensive_cancer values ('EP300');
insert into gene_comprehensive_cancer values ('CRLF2');
insert into gene_comprehensive_cancer values ('P2RY8');
insert into gene_comprehensive_cancer values ('ZRSR2');
insert into gene_comprehensive_cancer values ('BCOR');
insert into gene_comprehensive_cancer values ('DDX3X');
insert into gene_comprehensive_cancer values ('KDM6A');
insert into gene_comprehensive_cancer values ('SSX1');
insert into gene_comprehensive_cancer values ('SSX4');
insert into gene_comprehensive_cancer values ('WAS');
insert into gene_comprehensive_cancer values ('GATA1');
insert into gene_comprehensive_cancer values ('TFE3');
insert into gene_comprehensive_cancer values ('SSX2');
insert into gene_comprehensive_cancer values ('KDM5C');
insert into gene_comprehensive_cancer values ('SMC1A');
insert into gene_comprehensive_cancer values ('TRO');
insert into gene_comprehensive_cancer values ('FAM123B');
insert into gene_comprehensive_cancer values ('MSN');
insert into gene_comprehensive_cancer values ('FOXO4');
insert into gene_comprehensive_cancer values ('MED12');
insert into gene_comprehensive_cancer values ('ZMYM3');
insert into gene_comprehensive_cancer values ('NONO');
insert into gene_comprehensive_cancer values ('ATRX');
insert into gene_comprehensive_cancer values ('SEPT6');
insert into gene_comprehensive_cancer values ('STAG2');
insert into gene_comprehensive_cancer values ('ELF4');
insert into gene_comprehensive_cancer values ('GPC3');
insert into gene_comprehensive_cancer values ('PHF6');
insert into gene_comprehensive_cancer values ('RPL10');
insert into gene_comprehensive_cancer values ('MTCP1');
insert into gene_comprehensive_cancer values ('CRLF2');
insert into gene_comprehensive_cancer values ('P2RY8');

commit;