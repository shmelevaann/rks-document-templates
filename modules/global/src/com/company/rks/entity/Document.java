package com.company.rks.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Table(name = "RKS_DOCUMENT")
@Entity(name = "rks_Document")
@NamePattern("%s|")
public class Document extends StandardEntity {
    private static final long serialVersionUID = 384229596288919712L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOCUMENT_TEMPLATE_ID")
    private DocumentTemplate documentTemplate;

    @OneToMany(mappedBy = "document")
    private List<DocumentValue> values;

    public List<DocumentValue> getValues() {
        return values;
    }

    public void setValues(List<DocumentValue> values) {
        this.values = values;
    }

    public DocumentTemplate getDocumentTemplate() {
        return documentTemplate;
    }

    public void setDocumentTemplate(DocumentTemplate documentTemplate) {
        this.documentTemplate = documentTemplate;
    }
}