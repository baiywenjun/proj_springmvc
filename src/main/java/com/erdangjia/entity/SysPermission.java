package com.erdangjia.entity;

public class SysPermission {
    private String permissionId;

    private String permissionName;

    private String parentId;

    private String plevel;

    private String pisuse;

    private String pismenu;

    private String pcode;

    private String url;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getPlevel() {
        return plevel;
    }

    public void setPlevel(String plevel) {
        this.plevel = plevel == null ? null : plevel.trim();
    }

    public String getPisuse() {
        return pisuse;
    }

    public void setPisuse(String pisuse) {
        this.pisuse = pisuse == null ? null : pisuse.trim();
    }

    public String getPismenu() {
        return pismenu;
    }

    public void setPismenu(String pismenu) {
        this.pismenu = pismenu == null ? null : pismenu.trim();
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode == null ? null : pcode.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}