package com.company.rks.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Table(name = "RKS_DOCUMENT_TEMPLATE")
@Entity(name = "rks_DocumentTemplate")
@NamePattern("%s|name")
public class DocumentTemplate extends StandardEntity {
    private static final long serialVersionUID = 6665249018718089646L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "document_template")
    @OrderBy("number")
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    private List<DocumentTemplateLine> lines = new ArrayList<>();

    public List<DocumentTemplateLine> getLines() {
        return lines;
    }

    public void setLines(List<DocumentTemplateLine> lines) {
        this.lines = lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}