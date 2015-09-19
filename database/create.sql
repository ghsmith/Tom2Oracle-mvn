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

