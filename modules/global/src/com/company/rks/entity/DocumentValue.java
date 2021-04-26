package com.company.rks.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

@Table(name = "RKS_DOCUMENT_VALUE")
@Entity(name = "rks_DocumentValue")
@NamePattern("%s|value")
public class DocumentValue extends StandardEntity {
    private static final long serialVersionUID = 2106084335672586726L;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOCUMENT_TEMPLATE_LINE_ID")
    private DocumentTemplateLine documentTemplateLine;

    @Lob
    @Column(name = "VALUE_")
    private String value;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DOCUMENT_ID")
    private Document document;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @MetaProperty
    public String getDefaultValue() {
        return getGenericValue(value -> value, DynAttrCategory.STRING, DynAttrCategory.ENTITY);
    }

    @MetaProperty
    public void setDefaultValue(String defaultValue) {
        value = defaultValue;
    }

    @MetaProperty
    public Date getDateValue() {
        return getGenericValue(value -> new Date(Long.parseLong(value)),
                DynAttrCategory.DATE, DynAttrCategory.TIME);
    }

    @MetaProperty
    public void setDateValue(Date dateValue) {
        value = String.valueOf(dateValue.getTime());
    }

    @MetaProperty
    public BigDecimal getNumberValue() {
        return getGenericValue(BigDecimal::new, DynAttrCategory.NUMBER);
    }

    @MetaProperty
    public void setNumberValue(BigDecimal numberValue) {
        value = numberValue.toString();
    }

    private <T> T getGenericValue(Function<String, T> parser, DynAttrCategory... categories) {
        if (value == null) {
            return null;
        }

        if (documentTemplateLine == null || documentTemplateLine.getType() == null) {
            return null;
        }

        if (Arrays.stream(categories).noneMatch(item -> item == documentTemplateLine.getType())) {
            return null;
        }

        return parser.apply(value);
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public DocumentTemplateLine getDocumentTemplateLine() {
        return documentTemplateLine;
    }

    public void setDocumentTemplateLine(DocumentTemplateLine documentTemplateLine) {
        this.documentTemplateLine = documentTemplateLine;
    }
}