drop table fusion;
create table fusion
(
  fusion_said number not null,
  library_prep varchar2(100) not null,
  sample_name varchar2(100) not null,
  pipeline varchar2(100) not null,
  fusion_genes varchar2(100) not null,
  left_breakpoint varchar2(100) not null,
  right_breakpoint varchar2(100) not null,
  junction_reads number not null,
  spanning_frags number,
  classification varchar2(100),
  left_gene varchar2(100),
  right_gene varchar2(100),
  constraint fusion_pk primary key
  (
    fusion_said
  )--,
  --constraint fusion_uk unique
  --(
  --  library_prep,
  --  sample_name,
  --  pipeline,
  --  fusion_genes,
  --  left_breakpoint,
  --  right_breakpoint
  --)
);

create sequence said_seq start with 10000
/

delete from fusion;
select * from fusion;
commit;
select count(*) from fusion;
select library_prep, sample_name, pipeline, count(*) from fusion
group by library_prep, sample_name, pipeline
order by 2, 1, 3;

drop table fusion;
drop table variant;
create table variant
(
  variant_said number not null,
  library_prep varchar2(100) not null,
  sample_name varchar2(100) not null,
  pipeline varchar2(100) not null,
  gene_refgene varchar2(100),
  func_refgene varchar2(100),
  exonic_func_refgene varchar2(100),
  alt_variant_freq number,
  read_depth number,
  alt_read_depth number,
  chr_name varchar2(100),
  start_pos number,
  end_pos number,
  ref_base varchar2(100),
  alt_base varchar2(100),
  genedetail_refgene varchar2(1000),
  aachange_refgene varchar2(1000),
  one000g2014sep_all varchar2(1000),
  snp138 varchar2(1000),
  cosmic70 varchar2(1000),
  clinvar_20140929 varchar2(1000),
  exac03 varchar2(1000),
  constraint variant_pk primary key
  (
    variant_said
  )
);


select count(*) from fusion;

delete from variant;
commit; 

drop table variant;

create table variant
(
  variant_said number not null,
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
  clinvar_20140929 varchar2(2000),
  exac03 varchar2(2000),
  constraint variant_pk primary key
  (
    variant_said
  )
);

select count(*) from variant;

select
  upper(sample_name) sample_name,
  upper(library_prep) library_prep,
  upper(pipeline) pipeline,
  count(*)
from
  variant
group by
  sample_name,
  library_prep,
  pipeline
order by
  1, 2, 3;

select
  sample_name,
  count(*)
from
  (
    select sample_name, chr_name, start_pos, end_pos, alt_base
    from variant
    where upper(library_prep) = 'RNACCESS' and upper(pipeline) = 'STAR-ALIGNED_VARIANTS-GATK'
    intersect
    select sample_name, chr_name, start_pos, end_pos, alt_base
    from variant
    where upper(library_prep) = 'RNACCESS' and upper(pipeline) = 'STAR-ALIGNED_VARIANTS-VARSCAN'
    intersect
    select sample_name, chr_name, start_pos, end_pos, alt_base
    from variant
    where upper(library_prep) = 'RNACCESS' and upper(pipeline) = 'TOPHAT-ALIGNED_VARIANTS-VARSCAN'
    intersect
    select sample_name, chr_name, start_pos, end_pos, alt_base
    from variant
    where upper(library_prep) = 'SURESELECT' and upper(pipeline) = 'STAR-ALIGNED_VARIANTS-GATK'
    intersect
    select sample_name, chr_name, start_pos, end_pos, alt_base
    from variant
    where upper(library_prep) = 'SURESELECT' and upper(pipeline) = 'STAR-ALIGNED_VARIANTS-VARSCAN'
    intersect
    select sample_name, chr_name, start_pos, end_pos, alt_base
    from variant
    where upper(library_prep) = 'SURESELECT' and upper(pipeline) = 'TOPHAT-ALIGNED_VARIANTS-VARSCAN'
  )
group by
  sample_name
order by
  1;

  
select distinct
  upper(library_prep),
  upper(pipeline)
from
  fusion
order by
  1, 2;
  
select
  sample_name,
  chr_name,
  
from
  variant;
  
drop table fusion;

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

select * from fusion where fusion_gene1 = fusion_gene2;

select
  sample_name,
  fusion_gene_least_alphabet,
  fusion_gene_greatest_alphabet,
  max(decode(sign(instr(pipelines, 'RNACCESS JAFFA-FUSION')), 1, 'X', NULL)) ra_jf,
  max(decode(sign(instr(pipelines, 'RNACCESS STAR-ALIGNED_STAR-FUSION')), 1, 'X', NULL)) ra_sa,
  max(decode(sign(instr(pipelines, 'SURESELECT JAFFA-FUSION')), 1, 'X', NULL)) ss_jf,
  max(decode(sign(instr(pipelines, 'SURESELECT STAR-ALIGNED_STAR-FUSION')), 1, 'X', NULL)) ss_sa
from
  (
    select
      sample_name,
      least(fusion_gene1, fusion_gene2) fusion_gene_least_alphabet,
      greatest(fusion_gene1, fusion_gene2) fusion_gene_greatest_alphabet,
      upper(listagg(library_prep || ' ' || pipeline, ';') within group(order by library_prep || ' ' || pipeline)) pipelines
    from
      fusion
    group by
      sample_name,
      least(fusion_gene1, fusion_gene2),
      greatest(fusion_gene1, fusion_gene2)
    having
      count(distinct library_prep || ' ' || pipeline) > 1
  )
group by
  sample_name,
  fusion_gene_least_alphabet,
  fusion_gene_greatest_alphabet
order by
  1,
  2, 
  3;

  
select
  sample_name,
  count(*)
from
  (
    select sample_name, least(fusion_gene1, fusion_gene2), greatest(fusion_gene1, fusion_gene2)
    from fusion
    where upper(library_prep) = 'RNACCESS' and upper(pipeline) = 'JAFFA-FUSION'
    intersect
    select sample_name, least(fusion_gene1, fusion_gene2), greatest(fusion_gene1, fusion_gene2)
    from fusion
    where upper(library_prep) = 'RNACCESS' and upper(pipeline) = 'STAR-ALIGNED_STAR-FUSION'
    intersect
    select sample_name, least(fusion_gene1, fusion_gene2), greatest(fusion_gene1, fusion_gene2)
    from fusion
    where upper(library_prep) = 'SURESELECT' and upper(pipeline) = 'JAFFA-FUSION'
    intersect
    select sample_name, least(fusion_gene1, fusion_gene2), greatest(fusion_gene1, fusion_gene2)
    from fusion
    where upper(library_prep) = 'SURESELECT' and upper(pipeline) = 'STAR-ALIGNED_STAR-FUSION'
  )
group by
  sample_name
order by
  1;
