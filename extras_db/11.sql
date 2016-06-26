----------------------------------------------------
-- Export file for user EMPTY                     --
-- Created by Administrator on 2016/6/6, 10:20:54 --
----------------------------------------------------

spool 11.log

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
  AUTHOR  VARCHAR2(50) default '' --记录管理员,
  IP      VARCHAR2(15)
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
prompt Creating table LADP_APPLICATION
prompt ===============================
prompt
create table LADP_APPLICATION
(
  APPLICATION_ID  VARCHAR2(25) not null,
  APPLICATIONNAME VARCHAR2(100),
  SUBSYSTEMNAME   VARCHAR2(100),
  WORKFLOWNAME    VARCHAR2(100),
  STEPNAME        VARCHAR2(100),
  STEPPAGE        VARCHAR2(100),
  STEPDESC        VARCHAR2(200),
  CREATEBY        VARCHAR2(50),
  CREATEDATE      DATE,
  ORDER_ID        NUMBER
)
;

prompt
prompt Creating table MODEL_INDEX_INFO
prompt ===============================
prompt
create table MODEL_INDEX_INFO
(
  MODEL_INDEX_ID VARCHAR2(50) not null,
  MODEL_ID       VARCHAR2(50),
  INDEX_ID       VARCHAR2(50),
  WEIGHT         NUMBER,
  MAX_VALUE      NUMBER,
  MIN_VALUE      NUMBER,
  IS_FOUJUE      VARCHAR2(50),
  SX             NUMBER
)
;
alter table MODEL_INDEX_INFO
  add constraint MODEL_INDEX_INFO_ID primary key (MODEL_INDEX_ID);

prompt
prompt Creating table MODEL_INFO
prompt =========================
prompt
create table MODEL_INFO
(
  MODEL_ID              VARCHAR2(50) not null,
  MODEL_NAME            VARCHAR2(200),
  MODEL_RESULT_TABLE    VARCHAR2(100),
  MODEL_SEQUENCE        VARCHAR2(100),
  MODEL_LEVEL_ID        VARCHAR2(50),
  NEW_RESULT            NUMBER,
  NEW_CREATE_TIME       TIMESTAMP(6),
  CREATE_TIME           DATE,
  CREATE_USER           VARCHAR2(50),
  REMARK                VARCHAR2(500),
  MODEL_RESULT_MX_TABLE VARCHAR2(100),
  MODEL_MX_SEQUENCE     VARCHAR2(100)
)
;
alter table MODEL_INFO
  add constraint MODEL_INFO_ID primary key (MODEL_ID);

prompt
prompt Creating table MODEL_RESULT_MX_21
prompt =================================
prompt
create table MODEL_RESULT_MX_21
(
  MODEL_RESULT_MX_ID NUMBER not null,
  MODEL_ID           VARCHAR2(50),
  INDEX_ID           VARCHAR2(50),
  ENTERPRISE_ID      VARCHAR2(50),
  INDEX_DATA         NUMBER,
  RESULT             VARCHAR2(100),
  CREATE_DATE        TIMESTAMP(6)
)
;
alter table MODEL_RESULT_MX_21
  add constraint MODEL_RESULT_MX_21_KEY primary key (MODEL_RESULT_MX_ID);

prompt
prompt Creating table PERFORM_INFO
prompt ===========================
prompt
create table PERFORM_INFO
(
  PID         VARCHAR2(50) not null,
  P_DAPART    VARCHAR2(200),
  P_USERNAMER VARCHAR2(200),
  P_UPTYPE    VARCHAR2(200) default '1',
  P_POINTALL  NUMBER(20),
  P_DATE      DATE default SYSDATE not null,
  P_STARTDATE DATE not null,
  P_ENDDATE   DATE not null,
  P_POINTTYPE VARCHAR2(200),
  P_CONTSTAT  VARCHAR2(200),
  P_EX_3      VARCHAR2(200)
)
;
alter table PERFORM_INFO
  add constraint PK_PERFORM_INFO_P_ID primary key (PID);
create index PK_PERFORM_END_DATE on PERFORM_INFO (P_ENDDATE, P_STARTDATE);
create index PK_PERFORM_P_DAPERT on PERFORM_INFO (P_DAPART);

prompt
prompt Creating table SYS_APPAUTHORIZE
prompt ===============================
prompt
create table SYS_APPAUTHORIZE
(
  APPAUTH_ID     VARCHAR2(50) not null,
  APPLICATION_ID VARCHAR2(50),
  AUTHTO_ID      VARCHAR2(50),
  AUTHTOTYPE     NUMBER(2)
)
;

prompt
prompt Creating table SYS_CERTUSER
prompt ===========================
prompt
create table SYS_CERTUSER
(
  ID           VARCHAR2(50) not null,
  CERTSN       VARCHAR2(50),
  USERID       VARCHAR2(50),
  UPDATETIME   DATE,
  REGISTERTIME DATE,
  POP1         VARCHAR2(50),
  POP2         VARCHAR2(50),
  POP3         VARCHAR2(50),
  DWMC         VARCHAR2(500),
  NAME         VARCHAR2(100),
  LXDH         VARCHAR2(50),
  CSZW         VARCHAR2(100)
)
;
alter table SYS_CERTUSER
  add primary key (ID);

prompt
prompt Creating table SYS_DOMAIN
prompt =========================
prompt
create table SYS_DOMAIN
(
  DOMAIN_ID      VARCHAR2(50) not null,
  DOMAINADMIN_ID VARCHAR2(50),
  DOMAINNAME     VARCHAR2(100),
  DOMAINDESC     VARCHAR2(200),
  DOMAINSTATUS   NUMBER(2),
  CREATEBY       CHAR(25),
  CREATEDATE     DATE
)
;

prompt
prompt Creating table SYS_DOMAINAPPLICATION
prompt ====================================
prompt
create table SYS_DOMAINAPPLICATION
(
  DOMAINAPPLICATION_ID VARCHAR2(50) not null,
  DOMAIN_ID            VARCHAR2(50),
  APPLICATION_ID       VARCHAR2(50)
)
;

prompt
prompt Creating table SYS_FLDJ
prompt =======================
prompt
create table SYS_FLDJ
(
  FLDJID  VARCHAR2(50),
  MXID    VARCHAR2(50),
  DJBZ    VARCHAR2(200),
  TOPZ    VARCHAR2(50),
  ENDZ    VARCHAR2(50),
  XH      VARCHAR2(50),
  PARAMT1 VARCHAR2(50),
  PARAMT2 VARCHAR2(50),
  PARAMT3 VARCHAR2(50),
  PARAMT4 VARCHAR2(50),
  PARAMT5 VARCHAR2(50)
)
;

prompt
prompt Creating table SYS_GROUP
prompt ========================
prompt
create table SYS_GROUP
(
  GROUP_ID       VARCHAR2(50) not null,
  GROUPNAME      VARCHAR2(100),
  GROUPDESC      VARCHAR2(200),
  GROUPLEVEL     NUMBER(2),
  GROUPUSETYPE   NUMBER(2),
  PARENTGROUP_ID VARCHAR2(50),
  GROUPSTATUS    NUMBER(2),
  OUID           VARCHAR2(50),
  CREATEBY       VARCHAR2(25),
  CREATEDATE     DATE
)
;

prompt
prompt Creating table SYS_GROUPMEMBER
prompt ==============================
prompt
create table SYS_GROUPMEMBER
(
  GROUPMEMBER_ID VARCHAR2(50) not null,
  GROUP_ID       VARCHAR2(50),
  MEMBER_ID      VARCHAR2(50),
  MEMBERTYPE     NUMBER(2)
)
;

prompt
prompt Creating table SYS_MXJS
prompt =======================
prompt
create table SYS_MXJS
(
  MXJSID  VARCHAR2(50),
  MXZBID  VARCHAR2(50),
  DEPID   VARCHAR2(50),
  TABLEID VARCHAR2(50),
  FIEDID  VARCHAR2(50),
  VALZHI  VARCHAR2(2000),
  TJSJ    VARCHAR2(50),
  PARAMT1 VARCHAR2(50),
  PARAMT2 VARCHAR2(50),
  PARAMT3 VARCHAR2(50),
  PARAMT4 VARCHAR2(50),
  PARAMT5 VARCHAR2(50)
)
;

prompt
prompt Creating table SYS_MXZB
prompt =======================
prompt
create table SYS_MXZB
(
  MXZBID  VARCHAR2(50),
  MXNAME  VARCHAR2(200),
  ZFFDX   VARCHAR2(50),
  SHUOM   VARCHAR2(2000),
  DJ      VARCHAR2(50),
  ZHZXSJ  VARCHAR2(50),
  TJSJ    VARCHAR2(50),
  PARAMT1 VARCHAR2(50),
  PARAMT2 VARCHAR2(50),
  PARAMT3 VARCHAR2(50),
  PARAMT4 VARCHAR2(50),
  PARAMT5 VARCHAR2(50),
  PARAMT6 VARCHAR2(50),
  PARAMT7 VARCHAR2(50)
)
;

prompt
prompt Creating table SYS_MXZB_ZBQZ
prompt ============================
prompt
create table SYS_MXZB_ZBQZ
(
  ZBQZID  VARCHAR2(50),
  INDEXID VARCHAR2(50),
  MXZBID  VARCHAR2(50),
  XH      VARCHAR2(50),
  PARAMT1 VARCHAR2(50),
  PARAMT2 VARCHAR2(50),
  PARAMT3 VARCHAR2(50)
)
;

prompt
prompt Creating table SYS_ORGLIST
prompt ==========================
prompt
create table SYS_ORGLIST
(
  ORGID        VARCHAR2(50) not null,
  ORGNAME      VARCHAR2(80),
  STATUS       NUMBER(2),
  TEL          VARCHAR2(80),
  FAX          VARCHAR2(80),
  ADDRESS      VARCHAR2(80),
  WEB          VARCHAR2(160),
  MAIL         VARCHAR2(80),
  DES          VARCHAR2(200),
  DISPLAYORDER NUMBER(18),
  CREATEDATE   DATE
)
;

prompt
prompt Creating table SYS_ORGTABLE
prompt ===========================
prompt
create table SYS_ORGTABLE
(
  DEPTARTMENT_ID VARCHAR2(50),
  SQL_ID         VARCHAR2(50),
  ORDER_ID       VARCHAR2(50)
)
;

prompt
prompt Creating table SYS_OULIST
prompt =========================
prompt
create table SYS_OULIST
(
  OUID         VARCHAR2(50) not null,
  OUNAME       VARCHAR2(80),
  ORGID        VARCHAR2(50),
  PARENTOUID   VARCHAR2(50),
  STATUS       NUMBER(2),
  OUCHARGER    VARCHAR2(100),
  SYSCHARGER   VARCHAR2(25),
  DISPLAYORDER NUMBER(18),
  CREATEDATE   DATE
)
;

prompt
prompt Creating table SYS_USER
prompt =======================
prompt
create table SYS_USER
(
  CN             VARCHAR2(50) not null,
  SN             VARCHAR2(50),
  O              VARCHAR2(50),
  OU             VARCHAR2(50),
  EMAIL          VARCHAR2(50),
  PUBLICKEY      VARCHAR2(255),
  USER_STATUS    NUMBER(2),
  PWD            VARCHAR2(2000),
  CREATEPOSITION NUMBER(2),
  DISPLAYORDER   NUMBER(18),
  CREATEDATE     DATE,
  USERJB         VARCHAR2(10) default 1
)
;
alter table SYS_USER
  add constraint SYS_USER_ID primary key (CN);

prompt
prompt Creating table SYS_YPFJZBVAL
prompt ============================
prompt
create table SYS_YPFJZBVAL
(
  YPFJZBVALID VARCHAR2(50),
  FIEDID      VARCHAR2(50),
  CONTSTYLE   VARCHAR2(50),
  VAL_1       VARCHAR2(200),
  VAL_2       VARCHAR2(200),
  YULIU1      VARCHAR2(50),
  YULIU2      VARCHAR2(50),
  YULIU3      VARCHAR2(50),
  YULIU4      VARCHAR2(50),
  YULIU5      VARCHAR2(50)
)
;

prompt
prompt Creating table SYS_ZSGL
prompt =======================
prompt
create table SYS_ZSGL
(
  ZSGLID    VARCHAR2(50),
  ZSNAME    VARCHAR2(50),
  STATER    VARCHAR2(50),
  REMARK    VARCHAR2(2000),
  ZHI       VARCHAR2(50),
  FENSHU    VARCHAR2(50),
  CREATTIME VARCHAR2(50),
  YUL1      VARCHAR2(50),
  YUL2      VARCHAR2(50)
)
;

prompt
prompt Creating table T_LEVEL_INFO
prompt ===========================
prompt
create table T_LEVEL_INFO
(
  LEVEL_ID   VARCHAR2(50) not null,
  LEVEL_NAME VARCHAR2(100),
  REMARK     VARCHAR2(500)
)
;
alter table T_LEVEL_INFO
  add constraint T_LEVEL_INFO_ID primary key (LEVEL_ID);

prompt
prompt Creating table T_LEVEL_INFO_MX
prompt ==============================
prompt
create table T_LEVEL_INFO_MX
(
  MX_ID                VARCHAR2(50) not null,
  LEVEL_ID             VARCHAR2(50),
  LEVEL_IDENTIFICATION VARCHAR2(50),
  BEGIN_VALUE          NUMBER,
  END_VALUE            NUMBER,
  SX                   NUMBER
)
;
alter table T_LEVEL_INFO_MX
  add constraint T_LEVEL_INFO_MX_ID primary key (MX_ID);

prompt
prompt Creating table T_MKDZ_INFO
prompt ==========================
prompt
create table T_MKDZ_INFO
(
  MK_ID   VARCHAR2(50) not null,
  MK_NAME VARCHAR2(50),
  JFLX    VARCHAR2(50),
  JFSC    NUMBER,
  JF      NUMBER,
  ZT      VARCHAR2(50),
  JFSCLX  VARCHAR2(20),
  MK_TYPE VARCHAR2(100)
)
;
comment on column T_MKDZ_INFO.MK_TYPE
  is '积分类型(0:登录;1:法人查询;2:自然人查询;3:数据导入)';
alter table T_MKDZ_INFO
  add constraint L_MKDZ_INFO primary key (MK_ID);

prompt
prompt Creating table T_OPT_LOG
prompt ========================
prompt
create table T_OPT_LOG
(
  LOG_ID      VARCHAR2(50) not null,
  USER_ID     VARCHAR2(50),
  IP_ADDRESS  VARCHAR2(50),
  OPT_TIME    DATE,
  OPT_MENU    VARCHAR2(400),
  OPT_CONTENT VARCHAR2(3000)
)
;
alter table T_OPT_LOG
  add constraint T_OPT_LOG_ID primary key (LOG_ID);

prompt
prompt Creating table T_UPLOAD_LOGS
prompt ============================
prompt
create table T_UPLOAD_LOGS
(
  LOG_ID          VARCHAR2(50) not null,
  LOG_USER        VARCHAR2(50),
  LOG_TIME        DATE,
  LOG_TABLEID     VARCHAR2(100),
  LOG_SUN_SIZE    INTEGER,
  LOG_REPLAY_SIZE INTEGER,
  LOG_UPLOAD_SIZE INTEGER,
  LOG_FAIL_SIZE   INTEGER,
  LOG_STATES      VARCHAR2(50),
  REMARK          VARCHAR2(4000),
  REMARK2         VARCHAR2(4000),
  BDCGS           INTEGER,
  BDSBS           INTEGER,
  GJQYSL          VARCHAR2(30),
  GJGRSL          VARCHAR2(30)
)
;
comment on column T_UPLOAD_LOGS.LOG_ID
  is '编号';
comment on column T_UPLOAD_LOGS.LOG_USER
  is '上传人';
comment on column T_UPLOAD_LOGS.LOG_TIME
  is '归集时间';
comment on column T_UPLOAD_LOGS.LOG_TABLEID
  is '表编号';
comment on column T_UPLOAD_LOGS.LOG_SUN_SIZE
  is '共需导入条';
comment on column T_UPLOAD_LOGS.LOG_REPLAY_SIZE
  is '重复条数';
comment on column T_UPLOAD_LOGS.LOG_UPLOAD_SIZE
  is '成功条数';
comment on column T_UPLOAD_LOGS.LOG_FAIL_SIZE
  is '失败数';
comment on column T_UPLOAD_LOGS.LOG_STATES
  is '状态-暂无用';
comment on column T_UPLOAD_LOGS.REMARK
  is '备注1';
comment on column T_UPLOAD_LOGS.REMARK2
  is '备注2';
comment on column T_UPLOAD_LOGS.BDCGS
  is '比对成功数';
comment on column T_UPLOAD_LOGS.BDSBS
  is '比对失败数';
comment on column T_UPLOAD_LOGS.GJQYSL
  is '归集企业数量';
comment on column T_UPLOAD_LOGS.GJGRSL
  is '归集个人数量';

prompt
prompt Creating table WARN_RESULT_61
prompt =============================
prompt
create table WARN_RESULT_61
(
  WARN_RESULT_ID NUMBER not null,
  WARN_ID        VARCHAR2(50),
  ENTERPRISE_ID  VARCHAR2(50),
  INDEX_DATA     NUMBER,
  GRADE          VARCHAR2(100),
  CREATE_DATE    TIMESTAMP(6)
)
;
alter table WARN_RESULT_61
  add constraint WARN_RESULT_61_KEY primary key (WARN_RESULT_ID);

prompt
prompt Creating table WARN_SUBSCRIBE
prompt =============================
prompt
create table WARN_SUBSCRIBE
(
  SUB_ID  VARCHAR2(50) not null,
  DEPT_ID VARCHAR2(50),
  WARN_ID VARCHAR2(50)
)
;
alter table WARN_SUBSCRIBE
  add constraint WARN_SUBSCRIBE_ID primary key (SUB_ID);

prompt
prompt Creating sequence L_JINTAI_QU_SQUENCE
prompt =====================================
prompt
create sequence L_JINTAI_QU_SQUENCE
minvalue 1
maxvalue 999999999999999999999999999
start with 100
increment by 1
nocache;

prompt
prompt Creating sequence PERFORM_P_SQUENCE
prompt ===================================
prompt
create sequence PERFORM_P_SQUENCE
minvalue 1
maxvalue 999999999999999999999999999
start with 582
increment by 1
nocache;

prompt
prompt Creating sequence SEQ_ALL_TABLES
prompt ================================
prompt
create sequence SEQ_ALL_TABLES
minvalue 1
maxvalue 9999999999999999999
start with 3341
increment by 1
cache 20;

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
prompt Creating sequence SEQ_INDEX
prompt ===========================
prompt
create sequence SEQ_INDEX
minvalue 1000
maxvalue 9999999999
start with 1240
increment by 1
cache 20;

prompt
prompt Creating sequence SEQ_TABLE_VIEW_NAME
prompt =====================================
prompt
create sequence SEQ_TABLE_VIEW_NAME
minvalue 100
maxvalue 9999
start with 360
increment by 1
cache 20;

prompt
prompt Creating sequence S_MODEL_NO
prompt ============================
prompt
create sequence S_MODEL_NO
minvalue 1
maxvalue 9999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence S_MODEL_RESULT_1
prompt ==================================
prompt
create sequence S_MODEL_RESULT_1
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence S_MODEL_RESULT_21
prompt ===================================
prompt
create sequence S_MODEL_RESULT_21
minvalue 1
maxvalue 999999999999999999999999999
start with 345261
increment by 1
cache 20;

prompt
prompt Creating sequence S_MODEL_RESULT_MX_1
prompt =====================================
prompt
create sequence S_MODEL_RESULT_MX_1
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence S_MODEL_RESULT_MX_21
prompt ======================================
prompt
create sequence S_MODEL_RESULT_MX_21
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence S_WARN_NO
prompt ===========================
prompt
create sequence S_WARN_NO
minvalue 1
maxvalue 999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence S_WARN_RESULT_1
prompt =================================
prompt
create sequence S_WARN_RESULT_1
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence S_WARN_RESULT_2
prompt =================================
prompt
create sequence S_WARN_RESULT_2
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence S_WARN_RESULT_21
prompt ==================================
prompt
create sequence S_WARN_RESULT_21
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence S_WARN_RESULT_22
prompt ==================================
prompt
create sequence S_WARN_RESULT_22
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence S_WARN_RESULT_3
prompt =================================
prompt
create sequence S_WARN_RESULT_3
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence S_WARN_RESULT_41
prompt ==================================
prompt
create sequence S_WARN_RESULT_41
minvalue 1
maxvalue 999999999999999999999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence TOTLE_SQUENCE
prompt ===============================
prompt
create sequence TOTLE_SQUENCE
minvalue 1
maxvalue 999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating view CM_RECORD_VIEW
prompt ============================
prompt
create or replace view cm_record_view as
select cm_record.id AS id,cm_record.PART_ID AS PART_ID,cm_record.score AS score,cm_record.stat AS stat,cm_record.dateline AS dateline,cm_record.person_id AS person_id,cm_record.target_id AS target_id,cm_record.author AS author,cm_record.pubdate AS pubdate,cm_person.truename AS truename,cm_person.ssid AS ssid,cm_person.country_id AS country_id,cm_target.target_name AS target_name from ((cm_record left join cm_person on((cm_record.person_id = cm_person.id))) left join cm_target on((cm_record.target_id = cm_target.id)));

prompt
prompt Creating view CM_STATISTICS
prompt ===========================
prompt
CREATE OR REPLACE VIEW CM_STATISTICS AS
SELECT max(truename) as truename,max(ssid) as ssid,max(country_id) as country_id,sum(score) as score,person_id FROM cm_record_view GROUP BY person_id HAVING 1=1 ORDER BY person_id asc;

prompt
prompt Creating function DECRYPT256
prompt ============================
prompt
create or replace function decrypt256(v_input raw) return varchar2

is

v_result raw(1999);

c_key char(32) := '1q2wa3es4rz5tx6ycD*UF8tif9ogjen2';

begin

v_result := DBMS_CRYPTO.DECRYPT(

v_input,

DBMS_CRYPTO.ENCRYPT_AES256+DBMS_CRYPTO.CHAIN_CBC+DBMS_CRYPTO.PAD_PKCS5,

UTL_I18N.STRING_TO_RAW(c_key, 'AL32UTF8'));

return UTL_I18N.RAW_TO_CHAR(v_result, 'AL32UTF8');

end;
/

prompt
prompt Creating function ENCRYPT256
prompt ============================
prompt
create or replace function encrypt256(v_input varchar2) return raw

is

v_result raw(1999);

c_key char(32) := '1q2wa3es4rz5tx6ycD*UF8tif9ogjen2';

begin

v_result := DBMS_CRYPTO.ENCRYPT(

UTL_I18N.STRING_TO_RAW(v_input, 'AL32UTF8'),

DBMS_CRYPTO.ENCRYPT_AES256+DBMS_CRYPTO.CHAIN_CBC+DBMS_CRYPTO.PAD_PKCS5,

UTL_I18N.STRING_TO_RAW(c_key, 'AL32UTF8'));

return v_result;

end;
/

prompt
prompt Creating function F_SFZH15_18
prompt =============================
prompt
CREATE OR REPLACE FUNCTION f_SFZH15_18 (as_old_sfzh IN VARCHAR2)
   RETURN VARCHAR2
AS
   ls_new_sfzh   VARCHAR2 (200);
   ls_power      VARCHAR2 (18);
   ls_table      VARCHAR2 (11);
   ls_hm         VARCHAR (1);
   li_month      NUMBER (15, 0);
   li_day        NUMBER (15, 0);
   li_count      NUMBER (15, 0);
   li_i          NUMBER (15, 0);
   li_len        NUMBER (15, 0);
   li_mod        NUMBER (15, 0);
   li_right      NUMBER (15, 0);
   e_errout      EXCEPTION;
BEGIN
   ls_table := '10X98765432';
   ls_power := '790584216379058421';
   li_month := 0;
   li_day := 0;
   li_count := 0;
   li_i := 0;
   li_mod := 0;
   li_right := 0;
   li_len := LENGTH (TRIM (as_old_sfzh));

   IF li_len = 15
   THEN
      BEGIN
         li_count := 0;
         ls_new_sfzh :=
               SUBSTR (TRIM (as_old_sfzh), 1, 6)
            || '19'
            || SUBSTR (TRIM (as_old_sfzh), 7, 9);
         li_i := 1;

         WHILE li_i <= 17
         LOOP
            li_right := TO_NUMBER (SUBSTR (ls_power, li_i, 1));

            IF li_right = 0
            THEN
               li_right := 10;
            END IF;

            ls_hm := SUBSTR (ls_new_sfzh, li_i, 1);

            IF ls_hm < '0' OR ls_hm > '9'
            THEN
               RAISE e_errout;
            END IF;

            li_count := li_count + (TO_NUMBER (ls_hm) * li_right);
            li_i := li_i + 1;
         END LOOP;

         li_month := TO_NUMBER (SUBSTR (ls_new_sfzh, 11, 2));

         IF li_month < 1 OR li_month > 12
         THEN
            RAISE e_errout;
         END IF;

         li_day := TO_NUMBER (SUBSTR (ls_new_sfzh, 13, 2));

         IF li_month < 1 OR li_month > 31
         THEN
            RAISE e_errout;
         END IF;

         IF     (li_month = 4 OR li_month = 6 OR li_month = 9 OR li_month = 11
                )
            AND li_day > 30
         THEN
            RAISE e_errout;
         END IF;

         li_mod := MOD (li_count, 11) + 1;
         ls_new_sfzh := RTRIM (ls_new_sfzh) || SUBSTR (ls_table, li_mod, 1);
      END;
   ELSE
      IF li_len <> 15
      THEN
         ls_new_sfzh := RTRIM (as_old_sfzh);
      END IF;
   END IF;

   RETURN UPPER (ls_new_sfzh);
EXCEPTION
   WHEN e_errout
   THEN
      BEGIN
         ls_new_sfzh := RTRIM (as_old_sfzh);
         RETURN UPPER (ls_new_sfzh);
      END;
   WHEN OTHERS
   THEN
      BEGIN
         ls_new_sfzh := RTRIM (as_old_sfzh);
         RETURN UPPER (ls_new_sfzh);
      END;
END f_SFZH15_18;
/

prompt
prompt Creating procedure P_BDZH
prompt =========================
prompt
create or replace procedure P_BDZH(table_name in varchar2,table_ename in varchar2,table_id in varchar2) as

--比对次数sql
bdcountsql varchar2(200);

--对应正式sql
dyzssql varchar2(200);

--获取除主键外所有字段
getfieldsql varchar2(200);

--要比对的字段
bdzd varchar2(500);
--对应正式表的字段
dyzszd varchar2(2000);
dyzszdename varchar2(2000);
fieldname varchar2(200);

dycxename varchar2(2000);
dytjename varchar2(2000);

insertsql varchar2(2000);
updatesql varchar2(2000);
noupdatesql varchar2(2000);

upenteridsql varchar2(2000);



dytename  varchar2(2000);

--比对次数
bd_count number;

TYPE emp_cur_type1 IS REF CURSOR;
bdcountcur emp_cur_type1;

TYPE emp_cur_type2 IS REF CURSOR;
bdzdcur emp_cur_type2;

TYPE emp_cur_type3 IS REF CURSOR;
fieldcur emp_cur_type3;

begin


           bdcountsql:='select bdyxj as num from sys_field where sfbd=1 and bdyxj>0 and tableid = '''||table_id||''' group by bdyxj order by bdyxj ';

           OPEN bdcountcur FOR bdcountsql;
           loop FETCH bdcountcur INTO bd_count;
                EXIT WHEN bdcountcur%NOTFOUND;

                dyzssql:='select ename,bddyzszd from sys_field where tableid = '''||table_id||''' and sfbd=1 and bdyxj='||bd_count;
                dyzszdename:='';
                dytename:='';
                OPEN bdzdcur FOR dyzssql;
                loop FETCH bdzdcur INTO bdzd,dyzszd;
                     EXIT WHEN bdzdcur%NOTFOUND;

                     begin

                       if dyzszd='1' then
                          begin
                               dyzszdename:=dyzszdename||' and a.'||bdzd||'=b.qymc';
                               dytename:=dytename||' and a.'||bdzd||'=b.'||bdzd;
                          end;
                       elsif dyzszd='2' then
                          begin
                               dyzszdename:=dyzszdename||' and a.'||bdzd||'=b.zzjgdm';
                               dytename:=dytename||' and a.'||bdzd||'=b.'||bdzd;
                          end;
                       elsif dyzszd='3' then
                          begin
                               dyzszdename:=dyzszdename||' and a.'||bdzd||'=b.gszch';
                               dytename:=dytename||' and a.'||bdzd||'=b.'||bdzd;
                          end;

                       end if;

                     end;

                end loop;
                CLOSE bdzdcur;

                begin

                 if dyzszdename is not null then


                       getfieldsql:='select ename from sys_field where tableid =  '''||table_id||''' and sfzj = 0';
                       dycxename:='';
                       dytjename:='';
                       OPEN fieldcur FOR getfieldsql;
                       loop FETCH fieldcur INTO fieldname;
                            EXIT WHEN fieldcur%NOTFOUND;

                            dycxename:=dycxename||'a.'||fieldname||',';
                            dytjename:=dytjename||fieldname||',';

                       end loop;
                       CLOSE fieldcur;

                       upenteridsql:='update '||table_ename||' a set enterprise_id =(select b.enterprise_id  from hzcx_qy_base b where 1=1  ' ||dyzszdename|| ') where (a.msg_op=0 or a.msg_op=1) and exists ( select * from  hzcx_qy_base b where 1=1  ' ||dyzszdename|| ')';

                       execute immediate upenteridsql;
                       commit;

                       insertsql:='insert into '||table_name;

                       insertsql:=insertsql||'(ENTERPRISE_ID,SEQ_VALUE,INPUT_DATE,'||substr(dytjename,0,length(dytjename)-1)||')';

                       insertsql:=insertsql||'(select b.enterprise_id,a.SEQ_VALUE,a.INPUT_DATE,'||substr(dycxename,0,length(dycxename)-1);

                       insertsql:=insertsql||' from '|| table_ename || ' a inner join hzcx_qy_base b on 1=1 '||dyzszdename|| ' where a.MSG_OP=0 or a.MSG_OP=1)';


                       --dbms_output.PUT_LINE(insertsql);

                       execute immediate insertsql;
                       commit;


                       updatesql:='update '|| table_ename ||' a set MSG_OP = 2 where (a.msg_op=0 or a.msg_op=1) and exists ( select * from  hzcx_qy_base b where 1=1  ' ||dyzszdename|| ') ';
                       --dbms_output.PUT_LINE(updatesql);
                       execute immediate updatesql;
                       commit;

                       noupdatesql:='update '|| table_ename ||' a set MSG_OP = 1 where (a.msg_op=0 or a.msg_op=1)';

                       execute immediate noupdatesql;
                       commit;
                 end if;
                 end;



           end loop;
           CLOSE bdcountcur;

end;
/

prompt
prompt Creating procedure P_GRBDZH
prompt ===========================
prompt
create or replace procedure P_GRBDZH(table_name in varchar2,table_ename in varchar2,table_id in varchar2) as

--比对次数sql
bdcountsql varchar2(200);

--对应正式sql
dyzssql varchar2(200);

--获取除主键外所有字段
getfieldsql varchar2(200);

--要比对的字段
bdzd varchar2(500);
--对应正式表的字段
dyzszd varchar2(2000);
dyzszdename varchar2(2000);
fieldname varchar2(200);

dycxename varchar2(2000);
dytjename varchar2(2000);

insertsql varchar2(2000);
updatesql varchar2(2000);
noupdatesql varchar2(2000);

upenteridsql varchar2(2000);



dytename  varchar2(2000);

--比对次数
bd_count number;

TYPE emp_cur_type1 IS REF CURSOR;
bdcountcur emp_cur_type1;

TYPE emp_cur_type2 IS REF CURSOR;
bdzdcur emp_cur_type2;

TYPE emp_cur_type3 IS REF CURSOR;
fieldcur emp_cur_type3;

begin


           bdcountsql:='select bdyxj as num from sys_field where sfbd=1 and bdyxj>0 and tableid = '''||table_id||''' group by bdyxj order by bdyxj ';

           OPEN bdcountcur FOR bdcountsql;
           loop FETCH bdcountcur INTO bd_count;
                EXIT WHEN bdcountcur%NOTFOUND;

                dyzssql:='select ename,bddyzszd from sys_field where tableid = '''||table_id||''' and sfbd=1 and bdyxj='||bd_count;
                dyzszdename:='';
                dytename:='';
                OPEN bdzdcur FOR dyzssql;
                loop FETCH bdzdcur INTO bdzd,dyzszd;
                     EXIT WHEN bdzdcur%NOTFOUND;

                     begin

                       if dyzszd='1' then
                          begin
                               dyzszdename:=dyzszdename||' and F_SFZH15_18(a.'||bdzd||')=b.sfzhm';
                               dytename:=dytename||' and a.'||bdzd||'=b.'||bdzd;
                          end;

                       end if;

                     end;

                end loop;
                CLOSE bdzdcur;

                begin

                 if dyzszdename is not null then


                       getfieldsql:='select ename from sys_field where tableid =  '''||table_id||''' and sfzj = 0';
                       dycxename:='';
                       dytjename:='';
                       OPEN fieldcur FOR getfieldsql;
                       loop FETCH fieldcur INTO fieldname;
                            EXIT WHEN fieldcur%NOTFOUND;

                            dycxename:=dycxename||'a.'||fieldname||',';
                            dytjename:=dytjename||fieldname||',';

                       end loop;
                       CLOSE fieldcur;

                       upenteridsql:='update '||table_ename||' a set personal_id =(select b.personal_id  from hzcx_gr_base b where 1=1  ' ||dyzszdename|| ') where (a.msg_op=0 or a.msg_op=1) and exists ( select * from  hzcx_gr_base b where 1=1  ' ||dyzszdename|| ')';

                       execute immediate upenteridsql;
                       commit;

                       insertsql:='insert into '||table_name;

                       insertsql:=insertsql||'(personal_id,SEQ_VALUE,INPUT_DATE,'||substr(dytjename,0,length(dytjename)-1)||')';

                       insertsql:=insertsql||'(select b.personal_id,a.SEQ_VALUE,a.INPUT_DATE,'||substr(dycxename,0,length(dycxename)-1);

                       insertsql:=insertsql||' from '|| table_ename || ' a inner join hzcx_gr_base b on 1=1 '||dyzszdename|| ' where a.MSG_OP=0 or a.MSG_OP=1)';


                       --dbms_output.PUT_LINE(insertsql);

                       execute immediate insertsql;
                       commit;


                       updatesql:='update '|| table_ename ||' a set MSG_OP = 2 where (a.msg_op=0 or a.msg_op=1) and exists ( select * from  hzcx_gr_base b where 1=1  ' ||dyzszdename|| ') ';
                       --dbms_output.PUT_LINE(updatesql);
                       execute immediate updatesql;
                       commit;

                       noupdatesql:='update '|| table_ename ||' a set MSG_OP = 1 where (a.msg_op=0 or a.msg_op=1)';

                       execute immediate noupdatesql;
                       commit;
                 end if;
                 end;



           end loop;
           CLOSE bdcountcur;

end;
/

prompt
prompt Creating procedure P_MODEL_CREATE_MX_TABLE
prompt ==========================================
prompt
create or replace procedure P_MODEL_CREATE_MX_TABLE(modelmxtable in varchar2) as

  createsql varchar2(1000);
  altersql varchar2(1000);

  begin

            createsql:=' create table '||modelmxtable||'(MODEL_RESULT_MX_ID NUMBER not null,MODEL_ID VARCHAR2(50),INDEX_ID VARCHAR2(50),ENTERPRISE_ID VARCHAR2(50),INDEX_DATA NUMBER,RESULT VARCHAR2(100),CREATE_DATE TIMESTAMP(6))';

            altersql:='alter table '||modelmxtable||' add constraint '||modelmxtable||'_KEY primary key (MODEL_RESULT_MX_ID)';

            execute immediate  'grant create table to wzcx';

            execute immediate createsql;

            execute immediate altersql;


  end;
/

prompt
prompt Creating procedure P_MODEL_CREATE_TABLE
prompt =======================================
prompt
create or replace procedure P_MODEL_CREATE_TABLE(warntable in varchar2) as

  createsql varchar2(1000);
  altersql varchar2(1000);

  begin

            createsql:=' create table '||warntable||'(MODEL_RESULT_ID NUMBER not null,MODEL_ID VARCHAR2(50),ENTERPRISE_ID VARCHAR2(50),MODEL_DATA NUMBER,GRADE VARCHAR2(100),CREATE_DATE TIMESTAMP(6))';

            altersql:='alter table '||warntable||' add constraint '||warntable||'_KEY primary key (MODEL_RESULT_ID)';

            execute immediate  'grant create table to wzcx';

            execute immediate createsql;

            execute immediate altersql;


  end;
/

prompt
prompt Creating procedure P_MODEL_RESULT
prompt =================================
prompt
create or replace procedure P_MODEL_RESULT(modelId in varchar2,modelTable in varchar2,modelSequences in varchar2,levelbigid in varchar2,modelmxTable in varchar2,modelmxSequences in varchar2) as

  --modelId  varchar2(50);
  --modelTable varchar2(100);
  --modelSequences varchar2(100);
  --levelbigid varchar2(50);
  --modelmxTable varchar2(100);
  --modelmxSequences varchar2(100);



  baseselectsql varchar2(200);
  modelindexselectsql varchar2(200);

  indexTable varchar2(100);
  weight number;

  indexdata number;

  indexsql varchar2(200);

  levelsql varchar2(200);

  levelname varchar2(200);

  beginData number;

  endData number;

  lastlevel varchar2(200);

  indexid varchar2(50);

  result1 varchar2(100);

  mxaddsql varchar2(1000);



  TYPE emp_cur_type1 IS REF CURSOR;
  basecur emp_cur_type1;

  TYPE emp_cur_type2 IS REF CURSOR;
  indexcur emp_cur_type2;

  TYPE emp_cur_type3 IS REF CURSOR;
  levelcur emp_cur_type3;



  --deletesql varchar2(1000);
  insertsql varchar2(1000);
  TYPE emp_cur_type IS REF CURSOR;
  cur emp_cur_type;
  enterprise_id varchar2(1000);
  datainfo number;


  countinfo number;

  updatesql varchar2(1000);

  nowdate timestamp;
  sss varchar2(200);

  begin




           sss:=to_char(sysdate,'YYYY-MM-DD HH24:MI:SS');
           nowdate:=to_date(sss,'YYYY-MM-DD HH24:MI:SS');

           countinfo:=0;

           modelindexselectsql:='select b.index_view,a.weight,b.index_id from model_index_info a left join sys_index b on a.index_id=b.index_id where a.model_id ='''||modelId||'''';



           baseselectsql:='select enterprise_id from hzcx_qy_base ';


           OPEN basecur FOR baseselectsql;

           loop FETCH basecur INTO enterprise_id;

           datainfo:=0;

                EXIT WHEN basecur%NOTFOUND;

                OPEN cur FOR modelindexselectsql;

                loop FETCH cur INTO indexTable,weight,indexid;

                     EXIT WHEN cur%NOTFOUND;

                     indexsql:='select result,result1 from '||indexTable||' where enterprise_id='''||enterprise_id||''' and rownum<=1';

                     OPEN indexcur FOR indexsql;

                     loop FETCH indexcur INTO indexdata,result1;

                          EXIT WHEN indexcur%NOTFOUND;

                          mxaddsql:='insert into '||modelmxTable||'(model_result_mx_id,model_id,index_id,enterprise_id,index_data,result,create_date) values ('||modelmxSequences||'.nextval,'''||modelId||''','''||indexid||''','''||enterprise_id||''','||indexdata||','''||result1||''','''||nowdate||''')';

                          execute immediate mxaddsql;

                          datainfo:=datainfo+indexdata*weight;

                     end loop;

                     CLOSE indexcur;

                end loop;

                CLOSE cur;



                levelsql:='select mx_id,begin_value,end_value from t_level_info_mx where level_id='''||levelbigid||'''';

                OPEN levelcur FOR levelsql;

                loop FETCH levelcur INTO levelname,beginData,endData;

                     EXIT WHEN levelcur%NOTFOUND;

                     begin

                       if datainfo>=beginData and datainfo<=endData then

                          lastlevel:=levelname;

                       end if;

                     end;


                end loop;

                CLOSE levelcur;

                insertsql:='insert into '||modelTable||'(model_result_id,model_id,enterprise_id,model_data,grade,create_date) values ('||modelSequences||'.nextval,'''||modelId||''','''||enterprise_id||''','||datainfo||','''||lastlevel||''','''||nowdate||''')';
                execute immediate insertsql;


                countinfo:=countinfo+1;

           end loop;
           CLOSE basecur;
           commit;



           updatesql:='update model_info set new_result='||countinfo||' ,new_create_time='''||nowdate||''' where model_id='''||modelId||'''';
           execute immediate updatesql;
           commit;


  end;
/

prompt
prompt Creating procedure P_WARN_CREATE_TABLE
prompt ======================================
prompt
create or replace procedure P_WARN_CREATE_TABLE(warntable in varchar2) as

  createsql varchar2(1000);
  altersql varchar2(1000);

  begin

            createsql:=' create table '||warntable||'(WARN_RESULT_ID NUMBER not null,WARN_ID VARCHAR2(50),ENTERPRISE_ID VARCHAR2(50),INDEX_DATA NUMBER,GRADE VARCHAR2(100),CREATE_DATE TIMESTAMP(6))';

            altersql:='alter table '||warntable||' add constraint '||warntable||'_KEY primary key (WARN_RESULT_ID)';

            execute immediate  'grant create table to CMCXPT';

            execute immediate createsql;

            execute immediate altersql;


  end;
/

prompt
prompt Creating procedure P_WARN_RESULT
prompt ================================
prompt
create or replace procedure P_WARN_RESULT(warnId in varchar2,indexTable in varchar2,warnTable in varchar2,warnSequences in varchar2) as



  --deletesql varchar2(1000);
  insertsql varchar2(1000);
  selectsql varchar2(1000);
  TYPE emp_cur_type IS REF CURSOR;
  cur emp_cur_type;
  enterprise_id varchar2(1000);
  datainfo varchar2(1000);


  countinfo number;

  updatesql varchar2(1000);

  nowdate timestamp;
  sss varchar2(200);

  begin


           sss:=to_char(sysdate,'YYYY-MM-DD HH24:MI:SS');
           nowdate:=to_date(sss,'YYYY-MM-DD HH24:MI:SS');

           countinfo:=0;

           selectsql:='select enterprise_id,result from '||indexTable||' where result > 0 ';

           OPEN cur FOR selectsql;

           loop FETCH cur INTO enterprise_id,datainfo;

               EXIT WHEN cur%NOTFOUND;
               insertsql:='insert into '||warnTable||'(warn_result_id,warn_id,enterprise_id,index_data,create_date) values ('||warnSequences||'.nextval,'''||warnId||''','''||enterprise_id||''','||datainfo||','''||nowdate||''')';
               execute immediate insertsql;

               countinfo:=countinfo+1;

           end loop;
           CLOSE cur;
           commit;

           updatesql:='update warn_info set result_count='||countinfo||' ,result_time='''||nowdate||''' where warn_id='''||warnId||'''';
           execute immediate updatesql;
           commit;


  end;
/

prompt
prompt Creating procedure SP_EX_UPDATE_GR
prompt ==================================
prompt
create or replace procedure SP_EX_UPDATE_GR (p_gjsj in varchar2,--归集时间
                                            tableid in varchar2 --表id
                                           ) as
v_sql varchar2(4000);
v_cursor varchar2(4000);
c_bdzd number(10);
bd_count number;
bdzd varchar2(500);
dyzszdename varchar2(500);
dytename varchar2(500);
TYPE emp_cur_type2 IS REF CURSOR;
bdzdcur emp_cur_type2;
dyzszd varchar2(2000);
bdcountsql varchar2(200);
TYPE emp_cur_type1 IS REF CURSOR;
bdcountcur emp_cur_type1;
dyzssql varchar2(200);
v_bdzd1 varchar2(300);
v_bdzd2 varchar2(300);
v_start number(3);
v_rksl number(20);
v_gjsj date;
v_rksj date;
v_gjqysl number(20);
v_gjgrsl number(20);
v_ycsl number(20);
v_dept varchar2(500);
cbdzd varchar2(2000);
cbdzd1 varchar2(2000);
cbdzd2 varchar2(2000);
v_gjsl number(20);
v_cfsl number(20);
sfbd number(2);
x number(2);
i number(2);
table_name varchar2(500);
begin

EXECUTE IMMEDIATE 'alter session set nls_date_format=''YYYY-MM-DD HH24:MI:SS''';

EXECUTE IMMEDIATE 'alter session set nls_date_format=''YYYY/MM/DD HH24:MI:SS''';

v_sql:='select ename from sys_table where tableid = '||tableid||'';
execute immediate v_sql into table_name;

v_gjsj := to_date(p_gjsj,'YYYY/MM/DD HH24:MI:SS') ;
dbms_output.PUT_LINE(v_gjsj);


v_sql:='select count(*) from sys_field where sfbd !=0 and tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into c_bdzd;

if c_bdzd=1 then

dyzssql:='select ename from sys_field where tableid = '''||tableid||''' and sfbd=1';
dbms_output.PUT_LINE(dyzssql);
execute immediate dyzssql into bdzd;
v_sql := 'select cname from sys_field where ename = '''||bdzd||''' and tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into cbdzd;



        if bdzd = 'SFZHM'
        then
        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd||'为空'' where exists (select sys_id from ' ||table_name|| ' where  ' || bdzd || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy ='''||cbdzd||'和辨识表中不相同'' where not exists (select * from hzcx_gr_base b where  a.'|| bdzd || '=b.sfzhm and a.'|| bdzd || ' is not null ) ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        else
        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd||'为空'' where exists (select sys_id from ' ||table_name|| ' where  ' || bdzd || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy ='''||cbdzd||'和辨识表中不相同'' where not exists (select * from hzcx_gr_base b where  a.'|| bdzd || '=b.sfzhm and a.'|| bdzd || ' is not null ) ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        end if;

elsif  c_bdzd=2 then

 dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=2 ';
 execute immediate dyzssql into v_bdzd1,cbdzd1;
 dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=3 ';
 execute immediate dyzssql into v_bdzd2,cbdzd2;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'和'||cbdzd2||'均为空'' where exists (select sys_id from hzcx_gr_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'空'||cbdzd2||'不为空'' where exists (select sys_id from hzcx_gr_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is not null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'不空'||cbdzd2||'为空'' where exists (select sys_id from hzcx_gr_base where  ' || v_bdzd2 || ' is not null and ' || v_bdzd2 || ' is  null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'和'||cbdzd2||'在辨识表均不存在'' where not exists (select * from hzcx_gr_base b where a.'||v_bdzd1|| ' = b.sfzhm) and not exists (select * from hzcx_gr_base b where a.'||v_bdzd2|| ' = b.sfzhm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表存在，'||cbdzd2||'在辨识表不存在'' where exists (select * from hzcx_gr_base b where a.'||v_bdzd1|| ' = b.sfzhm) and not exists (select * from hzcx_gr_base b where a.'||v_bdzd2|| ' = b.sfzhm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表不存在，'||cbdzd2||'在辨识表存在'' where not exists (select * from hzcx_gr_base b where a.'||v_bdzd1|| ' = b.sfzhm) and exists (select * from hzcx_gr_base b where a.'||v_bdzd2|| ' = b.sfzhm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        end if;

commit;

v_sql:='select sjlx from sys_table where tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into i;

if i = 1 then

v_sql:='select ename from sys_field where sfbd =1 and tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into bdzd;

v_sql := ' select count(distinct '||bdzd||') from '||table_name||' where input_date = '''||v_gjsj||'''' ;
        dbms_output.PUT_LINE(v_sql);
execute immediate v_sql  into v_gjqysl;

update T_UPLOAD_LOGS set gjgrsl =v_gjqysl where log_time=p_gjsj and log_tableid=tableid;



elsif i = 3  then


dyzssql:='select ename from sys_field where tableid = '''||tableid||''' and zdlx=2 ';
execute immediate dyzssql into bdzd;

v_sql := ' select count(distinct '||bdzd||') from '||table_name||' where input_date = '''||v_gjsj||'''' ;
execute immediate v_sql  into v_gjgrsl;


update T_UPLOAD_LOGS set gjgrsl=v_gjgrsl where log_time=p_gjsj and log_tableid=tableid;

end if;
commit;
end;
/

prompt
prompt Creating procedure SP_EX_UPDATE_QY
prompt ==================================
prompt
create or replace procedure SP_EX_UPDATE_QY (p_gjsj in varchar2,--归集时间
                                            tableid in varchar2 --表id
                                           ) as

table_name varchar2(500);
v_sql varchar2(4000);
v_cursor varchar2(4000);
c_bdzd number(10);
bd_count number;
bdzd varchar2(500);
dyzszdename varchar2(500);
dytename varchar2(500);
TYPE emp_cur_type2 IS REF CURSOR;
bdzdcur emp_cur_type2;
dyzszd varchar2(2000);
bdcountsql varchar2(200);
TYPE emp_cur_type1 IS REF CURSOR;
bdcountcur emp_cur_type1;
dyzssql varchar2(200);
v_bdzd1 varchar2(300);
v_bdzd2 varchar2(300);
v_start number(3);
v_rksl number(20);
v_gjsj date;
v_rksj date;
v_gjqysl number(20);
v_gjgrsl number(20);
v_ycsl number(20);
v_dept varchar2(500);
cbdzd varchar2(2000);
cbdzd1 varchar2(2000);
cbdzd2 varchar2(2000);
v_gjsl number(20);
v_cfsl number(20);
zdlx number(2);
i number(2);
v_dyzd number(2);
x number(2);
is_bd number(2);

begin


EXECUTE IMMEDIATE 'alter session set nls_date_format=''YYYY/MM/DD HH24:MI:SS''';

v_sql:='select ename from sys_table where tableid = '||tableid||'';
execute immediate v_sql into table_name;

v_gjsj := to_date(p_gjsj,'YYYY/MM/DD HH24:MI:SS') ;
dbms_output.PUT_LINE(v_gjsj);


v_sql:='select count(*) from sys_field where sfbd !=0 and tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into c_bdzd;

if c_bdzd=1 then
dyzssql:='select ename from sys_field where tableid = '''||tableid||''' and sfbd=1';
execute immediate dyzssql into bdzd;
v_sql := 'select cname from sys_field where ename = '''||bdzd||''' and tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into cbdzd;
v_sql :=  'select bddyzszd from sys_field where  tableid = '''||tableid||''' and sfbd !=0';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into v_dyzd;
      if v_dyzd = '1'
        then
        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd||'为空'' where exists (select sys_id from ' ||table_name|| ' where  ' || bdzd || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;
        v_sql:='update ' ||table_name|| ' a set ycyy ='''||cbdzd||'和辨识表中不相同'' where not exists (select * from hzcx_qy_base b where  a.'|| bdzd || '=b.qymc and a.'|| bdzd || ' is not null )';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

      elsif v_dyzd = '2'
        then
        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd||'为空'' where exists (select sys_id from ' ||table_name|| ' where  ' || bdzd || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;
        v_sql:='update ' ||table_name|| ' a set ycyy ='''||cbdzd||'和辨识表中不相同'' where not exists (select * from hzcx_qy_base b where  a.'|| bdzd || '=b.zzjgdm and a.'|| bdzd || ' is not null )';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        elsif v_dyzd = '3'
        then
        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd||'为空'' where exists (select sys_id from ' ||table_name|| ' where  ' || bdzd || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;
        v_sql:='update ' ||table_name|| ' a set ycyy ='''||cbdzd||'和辨识表中不相同'' where not exists (select * from hzcx_qy_base b where  a.'|| bdzd || '=b.GSZCH and a.'|| bdzd || ' is not null )';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;
       end if;

elsif  c_bdzd=2 then
                        v_sql:='select max(sfbd) from sys_field where tableid = '''||tableid||'''';
                        dbms_output.PUT_LINE(v_sql);
                        execute immediate v_sql into x;
                        if x = 2 then
                          dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=2 and bddyzszd=1';
                          execute immediate dyzssql into v_bdzd2,cbdzd2;
                          v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd2||'为空'' where exists (select sys_id from ' ||table_name|| ' where  ' || v_bdzd2 || ' is null )';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                          v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd2||'在辨识表不存在'' where not exists (select * from hzcx_gr_base b where a.'||v_bdzd2|| ' = b.sfzhm) and '||v_bdzd2||' is not null';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;

                        v_sql:='select bddyzszd from sys_field where sfbd=1 and tableid = '''||tableid||'''';
                        dbms_output.PUT_LINE(v_sql);
                        execute immediate v_sql into x;
                                if x=1
                                then
                          dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=1';
                          execute immediate dyzssql into v_bdzd1,cbdzd1;
                          v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null )';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                          v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and '||v_bdzd1||' is not null';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                           v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'和身份证号码辨识表均不存在'' where MSG_op =1 and msg_op_gr =1 ';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;

                          elsif x=2
                          then
                           dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=2';
                          execute immediate dyzssql into v_bdzd1,cbdzd1;
                          v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null )';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                          v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.zzjgdm) and '||v_bdzd1||' is not null';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                         elsif x=3
                          then
                           dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=3';
                          execute immediate dyzssql into v_bdzd1,cbdzd1;
                          v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null )';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                          v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.gszch) and '||v_bdzd1||' is not null';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                         end if;


                    else



                              v_sql:='select max(bd_yxj) from sys_field where sfbd is not null and tableid = '''||tableid||'''';
                              dbms_output.PUT_LINE(v_sql);
                              execute immediate v_sql into is_bd;
                        v_sql:='select max(bddyzszd) from sys_field where sfbd=1 and tableid = '''||tableid||'''';
                        dbms_output.PUT_LINE(v_sql);
                        execute immediate v_sql into x;
                                if x=2
                                  then
                              dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=1';
                              execute immediate dyzssql into v_bdzd1,cbdzd1;
                              dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=2';
                               execute immediate dyzssql into v_bdzd2,cbdzd2;
                               elsif x=3
                                 then
                              dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=1';
                              execute immediate dyzssql into v_bdzd1,cbdzd1;
                              dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=3';
                               execute immediate dyzssql into v_bdzd2,cbdzd2;
                               end if;

                               if is_bd = 1 then
                               v_sql :=  'select bddyzszd from sys_field where  tableid = '''||tableid||''' and bddyzszd=1';
                               dbms_output.PUT_LINE(v_sql);
                               execute immediate v_sql into v_dyzd;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'和'||cbdzd2||'均为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'空'||cbdzd2||'不为空'' where  exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is not null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'不空'||cbdzd2||'为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is not null and ' || v_bdzd2 || ' is  null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'和'||cbdzd2||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表存在，'||cbdzd2||'在辨识表不存在'' where exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表不存在，'||cbdzd2||'在辨识表存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        /* v_sql :=  'select bddyzszd from sys_field where  tableid = '''||tableid||''' and bddyzszd=2';
                               dbms_output.PUT_LINE(v_sql);
                               execute immediate v_sql into v_dyzd;

                v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'和'||cbdzd2||'均为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'空'||cbdzd2||'不为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is not null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'不空'||cbdzd2||'为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd2 || ' is not null and ' || v_bdzd2 || ' is  null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'和'||cbdzd2||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.zzjgdm) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表存在，'||cbdzd2||'在辨识表不存在'' where exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.zzjgdm) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表不存在，'||cbdzd2||'在辨识表存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.zzjgdm) and exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;*/

                              elsif is_bd = 2 then
/*         v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'和'||cbdzd2||'均为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;
            v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'和'||cbdzd2||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;*/

         v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'和'||cbdzd2||'均为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'空'||cbdzd2||'不为空'' where  exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is not null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'不空'||cbdzd2||'为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is not null and ' || v_bdzd2 || ' is  null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'和'||cbdzd2||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表存在，'||cbdzd2||'在辨识表不存在'' where exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表不存在，'||cbdzd2||'在辨识表存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        end if;
end if;


elsif c_bdzd=3 then
                        v_sql:='select max(sfbd) from sys_field where tableid = '''||tableid||'''';
                        dbms_output.PUT_LINE(v_sql);
                        execute immediate v_sql into x;
                        if x = 2 then
                          dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=2 and bddyzszd=1';
                          execute immediate dyzssql into v_bdzd2,cbdzd2;
                          v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd2||'为空'' where exists (select sys_id from ' ||table_name|| ' where  ' || v_bdzd2 || ' is null )';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;
                          v_sql:='update ' ||table_name|| ' a set ycyy_gr = '''||cbdzd2||'在辨识表不存在'' where not exists (select * from hzcx_gr_base b where a.'||v_bdzd2|| ' = b.sfzhm) and '||v_bdzd2||' is not null';
                          dbms_output.PUT_LINE(v_sql);
                          execute immediate v_sql;

                        v_sql:='select count(*) from sys_field where sfbd=1 and tableid = '''||tableid||'''';
                        dbms_output.PUT_LINE(v_sql);
                        execute immediate v_sql into x;

                        end if;
                              v_sql:='select max(bd_yxj) from sys_field where sfbd is not null and tableid = '''||tableid||'''';
                              dbms_output.PUT_LINE(v_sql);
                              execute immediate v_sql into is_bd;
                              dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=1';
                              execute immediate dyzssql into v_bdzd1,cbdzd1;
                              dyzssql:='select ename,cname from sys_field where tableid = '''||tableid||''' and sfbd=1 and bddyzszd=2';
                               execute immediate dyzssql into v_bdzd2,cbdzd2;
                               if is_bd = 1 then
                               v_sql :=  'select bddyzszd from sys_field where  tableid = '''||tableid||''' and sfbd=1 and bddyzszd=1';
                               dbms_output.PUT_LINE(v_sql);
                               execute immediate v_sql into v_dyzd;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'和'||cbdzd2||'均为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'空'||cbdzd2||'不为空'' where  exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is null and ' || v_bdzd2 || ' is not null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' set ycyy = '''||cbdzd1||'不空'||cbdzd2||'为空'' where exists (select sys_id from hzcx_qy_base where  ' || v_bdzd1 || ' is not null and ' || v_bdzd2 || ' is  null)';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'和'||cbdzd2||'在辨识表均不存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表存在，'||cbdzd2||'在辨识表不存在'' where exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and not exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

        v_sql:='update ' ||table_name|| ' a set ycyy = '''||cbdzd1||'在辨识表不存在，'||cbdzd2||'在辨识表存在'' where not exists (select * from hzcx_qy_base b where a.'||v_bdzd1|| ' = b.qymc) and exists (select * from hzcx_qy_base b where a.'||v_bdzd2|| ' = b.zzjgdm) and '||v_bdzd1||' is not null and '||v_bdzd2||' is not null ';
        dbms_output.PUT_LINE(v_sql);
        execute immediate v_sql;

end if;
end if;
commit;

if i = 0 then
v_sql:='select ename from sys_field where sfbd =1 and tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into bdzd;

v_sql := ' select count(distinct '||bdzd||') from '||table_name||' where input_date = '''||v_gjsj||'''' ;
        dbms_output.PUT_LINE(v_sql);
execute immediate v_sql  into v_gjqysl;

update T_UPLOAD_LOGS set gjqysl =v_gjqysl where log_time=p_gjsj and log_tableid=tableid;


elsif i = 2  then
v_sql:='select ename from sys_field where sfbd =1 and tableid = '''||tableid||'''';
dbms_output.PUT_LINE(v_sql);
execute immediate v_sql into bdzd;

v_sql := ' select count(distinct '||bdzd||') from '||table_name||' where input_date = '''||v_gjsj||'''' ;
        dbms_output.PUT_LINE(v_sql);
execute immediate v_sql  into v_gjqysl;

dyzssql:='select ename from sys_field where tableid = '''||tableid||''' and zdlx=2 ';
execute immediate dyzssql into bdzd;

v_sql := ' select count(distinct '||bdzd||') from '||table_name||' where input_date = '''||v_gjsj||'''' ;
execute immediate v_sql  into v_gjgrsl;


update T_UPLOAD_LOGS set gjqysl =v_gjqysl,gjgrsl=v_gjgrsl where log_time=p_gjsj and log_tableid=tableid;

end if;
commit;
end;
/

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


spool off
