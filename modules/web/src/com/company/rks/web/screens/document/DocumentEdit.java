package com.company.rks.web.screens.document;

import com.company.rks.entity.Document;
import com.company.rks.entity.DocumentTemplate;
import com.company.rks.entity.DocumentTemplateLine;
import com.company.rks.entity.DocumentValue;
import com.haulmont.chile.core.datatypes.DatatypeRegistry;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UiController("rks_Document.edit")
@UiDescriptor("document-edit.xml")
@EditedEntityContainer("documentDc")
@LoadDataBeforeShow
public class DocumentEdit extends StandardEditor<Document> {
    @Inject
    private DataContext dataContext;
    @Inject
    private UiComponents uiComponents;
    @Inject
    private DatatypeRegistry datatypeRegistry;
    @Inject
    private LookupField<DocumentTemplate> documentTemplateField;
    @Inject
    private Table<DocumentValue> documentTable;

    @Subscribe
    public void onAfterShow(AfterShowEvent event) {
        documentTemplateField.addValueChangeListener(valueChangeEvent -> {
            Document entity = getEditedEntity();

            if (entity.getValues() != null) {
                for (DocumentValue value : new ArrayList<>(entity.getValues())) {
                    dataContext.remove(value);
                }
            }

            List<DocumentValue> values = entity
                    .getDocumentTemplate()
                    .getLines()
                    .stream()
                    .map(documentTemplateLine -> createDocumentValue(entity, documentTemplateLine))
                    .collect(Collectors.toList());
            entity.setValues(values);
        });
    }

    private DocumentValue createDocumentValue(Document entity, DocumentTemplateLine documentTemplateLine) {
        DocumentValue documentValue = dataContext.create(DocumentValue.class);
        documentValue.setDocumentTemplateLine(documentTemplateLine);
        documentValue.setDocument(entity);
        return documentValue;
    }

    public Component cellTypeGenerator(DocumentValue entity) {
        dataContext.setModified(entity, true);
        switch (entity.getDocumentTemplateLine().getType()) {
            case DATE:
                return createComponent(DateField.class, entity, "dateValue");
            case TIME:
                return createComponent(TimeField.class, entity, "dateValue");
            case NUMBER:
                TextField<BigDecimal> field = createComponent(TextField.class, entity, "numberValue");
                field.setDatatype(datatypeRegistry.get(BigDecimal.class));
                return field;
            default:
                return createComponent(TextField.class, entity, "defaultValue");
        }
    }

    private <T extends Field<?>> T createComponent(Class<T> componentClass, DocumentValue entity, String property) {
        T field = uiComponents.create(componentClass);
        field.setValueSource(new ContainerValueSource<>(documentTable.getInstanceContainer(entity), property));
        return field;
    }
}