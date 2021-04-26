package com.company.rks.web.screens.document;

import com.company.rks.entity.Document;
import com.haulmont.cuba.gui.screen.*;

@UiController("rks_Document.browse")
@UiDescriptor("document-browse.xml")
@LookupComponent("documentsTable")
@LoadDataBeforeShow
public class DocumentBrowse extends StandardLookup<Document> {
}