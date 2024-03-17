package com.api.redesocial.entity.usuario;


public enum Roles {

    ADMIN("administrador"),
    USER("usuario");

    private String role;


    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
