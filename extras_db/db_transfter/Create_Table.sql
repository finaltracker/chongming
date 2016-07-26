prompt
prompt Creating table CM_COUNTRY
prompt =========================
prompt
create table CM_COUNTRY
(
  ID            NUMBER(4) not null,
  PARENTID      NUMBER(4) default '0',
  DISPLAY_ORDER NUMBER(4) default '0',
  NAME          VARCHAR2(50) not null,
  CONTACT       VARCHAR2(50) not null,
  PHONE         VARCHAR2(15) default '',
  PUBDATE       NUMBER(11) not null,
  AUTHOR        VARCHAR2(50) default ''
)
;
comment on column CM_COUNTRY.ID
  is '主键系统自动生成';
comment on column CM_COUNTRY.PARENTID
  is '父结点ID';
comment on column CM_COUNTRY.DISPLAY_ORDER
  is '显示顺序';
comment on column CM_COUNTRY.NAME
  is '具体名称';
comment on column CM_COUNTRY.CONTACT
  is '联系人';
comment on column CM_COUNTRY.PHONE
  is '联系电话';
comment on column CM_COUNTRY.PUBDATE
  is '创建时间';
comment on column CM_COUNTRY.AUTHOR
  is '创建管理员';
alter table CM_COUNTRY
  add constraint CM_COUNTRY_ID primary key (ID);

prompt
prompt Creating table CM_LEVEL
prompt =======================
prompt
create table CM_LEVEL
(
  ID          NUMBER(4) not null,
  LEVEL_SCORE VARCHAR2(50),
  LEVEL_NAME  VARCHAR2(50),
  AUTHOR      VARCHAR2(50),
  PUBDATE     NUMBER(11)
)
;
comment on column CM_LEVEL.ID
  is '主键系统自动生成';
comment on column CM_LEVEL.LEVEL_SCORE
  is '最低分数';
comment on column CM_LEVEL.LEVEL_NAME
  is '名称';
comment on column CM_LEVEL.AUTHOR
  is '创建人';
comment on column CM_LEVEL.PUBDATE
  is '创建时间';
alter table CM_LEVEL
  add constraint CM_LEVEL_ID primary key (ID);

prompt
prompt Creating table CM_LOG
prompt =====================
prompt
create table CM_LOG
(
  ID      NUMBER(11) not null,
  INFO    VARCHAR2(500),
  PUBDATE NUMBER(11) not null,
  AUTHOR  VARCHAR2(50) default '',
  IP      VARCHAR2(60)
)
;
comment on column CM_LOG.ID
  is '主键系统自动生成';
comment on column CM_LOG.INFO
  is '具体信息';
comment on column CM_LOG.PUBDATE
  is '记录时间';
comment on column CM_LOG.AUTHOR
  is '记录管理员';
alter table CM_LOG
  add constraint CM_LOG_ID primary key (ID);

prompt
prompt Creating table CM_PART
prompt ======================
prompt
create table CM_PART
(
  ID        NUMBER(4) not null,
  PART_NAME VARCHAR2(50) not null
)
;
comment on column CM_PART.ID
  is '主键系统自动生成';
comment on column CM_PART.PART_NAME
  is '名称';
alter table CM_PART
  add constraint CM_PART_ID primary key (ID);

prompt
prompt Creating table CM_PERSON
prompt ========================
prompt
create table CM_PERSON
(
  ID         NUMBER(8) not null,
  TRUENAME   VARCHAR2(50) not null,
  SSID       VARCHAR2(18) not null,
  SEX        VARCHAR2(4) default '男',
  ZZMM       VARCHAR2(20),
  WHCD       VARCHAR2(20),
  COUNTRY_ID NUMBER(4) default 0,
  PHONE      VARCHAR2(15),
  BIRTHDAY   VARCHAR2(10),
  ADDRESS    VARCHAR2(200),
  SCORE      NUMBER(8) default '1000',
  PUBDATE    NUMBER(11) default '0',
  AUTHOR     VARCHAR2(20) not null,
  STAT       NUMBER(1) default '0',
  REMARK     VARCHAR2(4000),
  PART_ID    NUMBER(11)
)
;
comment on column CM_PERSON.ID
  is '主键系统自动生成';
comment on column CM_PERSON.TRUENAME
  is '真实姓名';
comment on column CM_PERSON.SSID
  is '身份证编号';
comment on column CM_PERSON.SEX
  is '性别';
comment on column CM_PERSON.ZZMM
  is '政治面貌';
comment on column CM_PERSON.WHCD
  is '文化程度';
comment on column CM_PERSON.COUNTRY_ID
  is '对应行政村';
comment on column CM_PERSON.PHONE
  is '联系电话';
comment on column CM_PERSON.BIRTHDAY
  is '生日';
comment on column CM_PERSON.ADDRESS
  is '住址';
comment on column CM_PERSON.SCORE
  is '现有分数';
comment on column CM_PERSON.PUBDATE
  is '记录时间';
comment on column CM_PERSON.AUTHOR
  is '操作管理员';
comment on column CM_PERSON.STAT
  is '其它信息';
comment on column CM_PERSON.REMARK
  is '状态 ';
alter table CM_PERSON
  add constraint CM_PERSON_ID primary key (ID);

prompt
prompt Creating table CM_RECORD
prompt ========================
prompt
create table CM_RECORD
(
  ID        NUMBER(8) not null,
  PERSON_ID NUMBER(8) not null,
  TARGET_ID NUMBER(8) not null,
  SCORE     NUMBER(4) not null,
  AUTHOR    NVARCHAR2(20) not null,
  PUBDATE   NUMBER(11) not null,
  STAT      NUMBER(1) default '0',
  DATELINE  NUMBER(11),
  PART_ID   NUMBER(11)
)
;
comment on column CM_RECORD.ID
  is '主键系统自动生成';
comment on column CM_RECORD.PERSON_ID
  is '人员ID';
comment on column CM_RECORD.TARGET_ID
  is '考评ID';
comment on column CM_RECORD.SCORE
  is '考评分数';
comment on column CM_RECORD.AUTHOR
  is '操作管理员';
comment on column CM_RECORD.PUBDATE
  is '记录时间戳';
comment on column CM_RECORD.STAT
  is '状态';
comment on column CM_RECORD.DATELINE
  is '有效时间戳';
comment on column CM_RECORD.PART_ID
  is '考核部门编号';
alter table CM_RECORD
  add constraint CM_RECORD_ID primary key (ID);

prompt
prompt Creating table CM_ROLE
prompt ======================
prompt
create table CM_ROLE
(
  ID              NUMBER(4) not null,
  ROLE_NAME       VARCHAR2(50) not null,
  ROLE_AUTHORLIST VARCHAR2(500) not null
)
;
alter table CM_ROLE
  add constraint CM_ROLE_ID primary key (ID);

prompt
prompt Creating table CM_TARGET
prompt ========================
prompt
create table CM_TARGET
(
  ID           NUMBER(4) not null,
  TARGET_NAME  VARCHAR2(50) not null,
  TARGET_SCORE NUMBER(4) not null,
  AUTHOR       VARCHAR2(50) not null,
  PUBDATE      NUMBER(11) not null,
  DATELINE     NUMBER(11) not null,
  PART_ID      NUMBER(4) not null
)
;
comment on column CM_TARGET.ID
  is '主键系统自动生成';
comment on column CM_TARGET.TARGET_NAME
  is '名称';
comment on column CM_TARGET.TARGET_SCORE
  is '对应标准分数';
comment on column CM_TARGET.AUTHOR
  is '创建管理员';
comment on column CM_TARGET.PUBDATE
  is '创建时间';
comment on column CM_TARGET.DATELINE
  is '有效期';
comment on column CM_TARGET.PART_ID
  is '考评部门ID';
alter table CM_TARGET
  add constraint CM_TARGET_ID primary key (ID);
  
  
prompt
prompt Creating sequence SEQ_CM_COUNTRY
prompt ================================
prompt
create sequence SEQ_CM_COUNTRY
minvalue 1
maxvalue 9999999999999999999999999999
start with 28
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CM_LEVEL
prompt ==============================
prompt
create sequence SEQ_CM_LEVEL
minvalue 1
maxvalue 9999999999999999999999999999
start with 15
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CM_LOG
prompt ============================
prompt
create sequence SEQ_CM_LOG
minvalue 1
maxvalue 9999999999999999999999999999
start with 793
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CM_PART
prompt =============================
prompt
create sequence SEQ_CM_PART
minvalue 1
maxvalue 9999999999999999999999999999
start with 27
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CM_PERSON
prompt ===============================
prompt
create sequence SEQ_CM_PERSON
minvalue 1
maxvalue 9999999999999999999999999999
start with 45
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CM_RECORD
prompt ===============================
prompt
create sequence SEQ_CM_RECORD
minvalue 1
maxvalue 9999999999999999999999999999
start with 55
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CM_ROLE
prompt =============================
prompt
create sequence SEQ_CM_ROLE
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_CM_TARGET
prompt ===============================
prompt
create sequence SEQ_CM_TARGET
minvalue 1
maxvalue 9999999999999999999999999999
start with 39
increment by 1
nocache;
  
prompt
prompt Creating trigger tig_cm_country
prompt ===============================
prompt
create or replace trigger "tig_cm_country"
before insert on cm_country
for each row
when (new.id is null)
begin
select seq_cm_country.nextval into:new.id from dual;
end;
/

prompt
prompt Creating trigger tig_cm_level
prompt =============================
prompt
create or replace trigger "tig_cm_level"
before insert on cm_level
for each row
when (new.id is null)
begin
select seq_cm_level.nextval into:new.id from dual;
end;
/

prompt
prompt Creating trigger tig_cm_log
prompt ===========================
prompt
create or replace trigger "tig_cm_log"
before insert on cm_log
for each row
when (new.id is null)
begin
select seq_cm_log.nextval into:new.id from dual;
end;
/

prompt
prompt Creating trigger tig_cm_part
prompt ============================
prompt
create or replace trigger "tig_cm_part"
before insert on cm_part
for each row
when (new.id is null)
begin
select seq_cm_part.nextval into:new.id from dual;
end;
/

prompt
prompt Creating trigger tig_cm_person
prompt ==============================
prompt
create or replace trigger "tig_cm_person"
before insert on cm_person
for each row
when (new.id is null)
begin
select seq_cm_person.nextval into:new.id from dual;
end;
/

prompt
prompt Creating trigger tig_cm_record
prompt ==============================
prompt
create or replace trigger "tig_cm_record"
before insert on cm_record
for each row
when (new.id is null)
begin
select seq_cm_record.nextval into:new.id from dual;
end;
/

prompt
prompt Creating trigger tig_cm_role
prompt ============================
prompt
create or replace trigger "tig_cm_role"
before insert on cm_role
for each row
when (new.id is null)
begin
select seq_cm_role.nextval into:new.id from dual;
end;
/

prompt
prompt Creating trigger tig_cm_target
prompt ==============================
prompt
create or replace trigger "tig_cm_target"
before insert on cm_target
for each row
when (new.id is null)
begin
select seq_cm_target.nextval into:new.id from dual;
end;
/
