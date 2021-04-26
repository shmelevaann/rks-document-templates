package com.company.rks.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "RKS_DOCUMENT_TEMPLATE_LINE", uniqueConstraints = {
        @UniqueConstraint(name = "IDX_RKS_DOCUMENT_TEMPLATE_LINE_UNQ_1", columnNames = {"HEADER", "DOCUMENT_TEMPLATE_ID"}),
        @UniqueConstraint(name = "IDX_RKS_DOCUMENT_TEMPLATE_LINE_UNQ", columnNames = {"NUMBER_", "DOCUMENT_TEMPLATE_ID"})
})
@Entity(name = "rks_DocumentTemplateLine")
@NamePattern("%s|header")
public class DocumentTemplateLine extends StandardEntity {
    private static final long serialVersionUID = -6475952796820801724L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCUMENT_TEMPLATE_ID")
    @OnDelete(DeletePolicy.CASCADE)
    private DocumentTemplate document_template;

    @Column(name = "NUMBER_", nullable = false)
    private @NotNull Integer number;

    @NotNull
    @Column(name = "HEADER", nullable = false)
    private String header;

    @NotNull
    @Column(name = "TYPE_", nullable = false)
    private String type;

    public DynAttrCategory getType() {
        return type == null ? null : DynAttrCategory.fromId(type);
    }

    public void setType(DynAttrCategory type) {
        this.type = type == null ? null : type.getId();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public @NotNull Integer getNumber() {
        return number;
    }

    public void setNumber(@NotNull Integer number) {
        this.number = number;
    }

    public DocumentTemplate getDocument_template() {
        return document_template;
    }

    public void setDocument_template(DocumentTemplate document_template) {
        this.document_template = document_template;
    }
}