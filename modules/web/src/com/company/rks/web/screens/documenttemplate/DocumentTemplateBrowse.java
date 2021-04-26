package com.company.rks.web.screens.documenttemplate;

import com.company.rks.entity.DocumentTemplate;
import com.haulmont.cuba.gui.screen.*;

@UiController("rks_DocumentTemplate.browse")
@UiDescriptor("document-template-browse.xml")
@LookupComponent("documentTemplatesTable")
@LoadDataBeforeShow
public class DocumentTemplateBrowse extends StandardLookup<DocumentTemplate> {
}