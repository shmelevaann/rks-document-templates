-- begin RKS_DOCUMENT
create table RKS_DOCUMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_TEMPLATE_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end RKS_DOCUMENT
-- begin RKS_DOCUMENT_TEMPLATE_LINE
create table RKS_DOCUMENT_TEMPLATE_LINE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_TEMPLATE_ID varchar(36),
    NUMBER_ integer not null,
    HEADER varchar(255) not null,
    TYPE_ varchar(50) not null,
    --
    primary key (ID)
)^
-- end RKS_DOCUMENT_TEMPLATE_LINE
-- begin RKS_DOCUMENT_VALUE
create table RKS_DOCUMENT_VALUE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DOCUMENT_TEMPLATE_LINE_ID varchar(36) not null,
    VALUE_ longvarchar,
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end RKS_DOCUMENT_VALUE
-- begin RKS_DOCUMENT_TEMPLATE
create table RKS_DOCUMENT_TEMPLATE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end RKS_DOCUMENT_TEMPLATE
