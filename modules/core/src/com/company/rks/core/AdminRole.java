package com.company.rks.core;

import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = "Admin")
public class AdminRole extends AnnotatedRoleDefinition {
    @ScreenAccess(screenIds = {"document-browse", "document-edit",
            "document-template-browse", "document-template-edit"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}
