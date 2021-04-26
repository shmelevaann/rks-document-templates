package com.company.rks.entity;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum DynAttrCategory implements EnumClass<String> {

    STRING("string"),
    NUMBER("number"),
    DATE("date"),
    TIME("time"),
    ENTITY("entity");

    private String id;

    DynAttrCategory(String value) {
        this.id = value;
    }

    @Nullable
    public static DynAttrCategory fromId(String id) {
        for (DynAttrCategory at : DynAttrCategory.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }
}