package com.app.Enums;


public enum Roles {
    LIBRARIAN(1,"Librarian"),
    SCHOLAR(2,"Scholar");

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