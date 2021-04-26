package com.company.rks.core;

import com.company.rks.entity.Document;
import com.company.rks.entity.DocumentTemplate;
import com.company.rks.entity.DocumentTemplateLine;
import com.company.rks.entity.DocumentValue;
import com.haulmont.cuba.security.app.role.AnnotatedRoleDefinition;
import com.haulmont.cuba.security.app.role.annotation.EntityAccess;
import com.haulmont.cuba.security.app.role.annotation.EntityAttributeAccess;
import com.haulmont.cuba.security.app.role.annotation.Role;
import com.haulmont.cuba.security.app.role.annotation.ScreenAccess;
import com.haulmont.cuba.security.entity.EntityOp;
import com.haulmont.cuba.security.role.EntityAttributePermissionsContainer;
import com.haulmont.cuba.security.role.EntityPermissionsContainer;
import com.haulmont.cuba.security.role.ScreenPermissionsContainer;

@Role(name = "User", isDefault = true)
public class UserRole extends AnnotatedRoleDefinition {
    @EntityAccess(entityClass = Document.class,
            operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @EntityAccess(entityClass = DocumentValue.class,
            operations = {EntityOp.CREATE, EntityOp.READ, EntityOp.UPDATE, EntityOp.DELETE})
    @EntityAccess(entityClass = DocumentTemplate.class,
            operations = {EntityOp.READ})
    @EntityAccess(entityClass = DocumentTemplateLine.class,
            operations = {EntityOp.READ})
    @Override
    public EntityPermissionsContainer entityPermissions() {
        return super.entityPermissions();
    }

    @EntityAttributeAccess(entityClass = Document.class, modify = "*")
    @EntityAttributeAccess(entityClass = DocumentValue.class, modify = "*")
    @EntityAttributeAccess(entityClass = DocumentTemplate.class, view = "*")
    @EntityAttributeAccess(entityClass = DocumentTemplateLine.class, view = "*")
    @Override
    public EntityAttributePermissionsContainer entityAttributePermissions() {
        return super.entityAttributePermissions();
    }

    @ScreenAccess(screenIds = {"application-rks", "rks_Document.browse", "rks_Document.edit"})
    @Override
    public ScreenPermissionsContainer screenPermissions() {
        return super.screenPermissions();
    }
}
