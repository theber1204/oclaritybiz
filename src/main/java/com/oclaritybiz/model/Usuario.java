package com.oclaritybiz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private int id;
    private String name;
    private String password;
    private Company company;
    private String email;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor completo
    public Usuario(int id, String name, String password, Company company, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.company = company;
        this.email = email;
    }
}