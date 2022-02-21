package com.app.Enums;


public enum Roles {
    LIBRARIAN(1,"Librarian"),
    MEMBER(2,"MEMBER");

    Roles(Integer id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
    private Integer id;
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}