package com.company.rks.web.screens.documenttemplate;

import com.company.rks.entity.DocumentTemplate;
import com.company.rks.entity.DocumentTemplateLine;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("rks_DocumentTemplate.edit")
@UiDescriptor("document-template-edit.xml")
@EditedEntityContainer("documentTemplateDc")
@LoadDataBeforeShow
public class DocumentTemplateEdit extends StandardEditor<DocumentTemplate> {
    @Inject
    private DataContext dataContext;
    @Inject
    private InstanceContainer<DocumentTemplate> documentTemplateDc;
    @Inject
    private CollectionContainer<DocumentTemplateLine> documentTemplateLinesDc;

    @Subscribe("documentTemplatesTable.add")
    public void onAdd(Action.ActionPerformedEvent event) {
        DocumentTemplateLine line = dataContext.create(DocumentTemplateLine.class);
        line.setDocument_template(documentTemplateDc.getItem());
        documentTemplateLinesDc.getMutableItems().add(line);
    }
}