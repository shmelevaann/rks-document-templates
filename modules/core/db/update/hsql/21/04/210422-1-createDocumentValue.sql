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
    DOCUMENT_ID varchar(36) not null,
    --
    primary key (ID)
);