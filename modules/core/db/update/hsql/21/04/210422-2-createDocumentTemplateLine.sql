alter table RKS_DOCUMENT_TEMPLATE_LINE add constraint FK_RKS_DOCUMENT_TEMPLATE_LINE_ON_DOCUMENT_TEMPLATE foreign key (DOCUMENT_TEMPLATE_ID) references RKS_DOCUMENT_TEMPLATE(ID);
create unique index IDX_RKS_DOCUMENT_TEMPLATE_LINE_UNQ on RKS_DOCUMENT_TEMPLATE_LINE (DOCUMENT_TEMPLATE_ID, NUMBER_);
create unique index IDX_RKS_DOCUMENT_TEMPLATE_LINE_UNQ_1 on RKS_DOCUMENT_TEMPLATE_LINE (DOCUMENT_TEMPLATE_ID, HEADER);
create index IDX_RKS_DOCUMENT_TEMPLATE_LINE_ON_DOCUMENT_TEMPLATE on RKS_DOCUMENT_TEMPLATE_LINE (DOCUMENT_TEMPLATE_ID);
