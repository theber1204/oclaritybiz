package com.oclaritybiz.model;

public class Contacto {
    private int id;
    private int userId;
    private String name;
    private String surnames;
    private String phone;
    private String email;
    private String linkedin;
    private int companyId;

    // Getters y setters
    public Contacto() {
    }

    public Contacto(int id, int userId, String name, String surnames, String phone, String email,String linkedin, int companyId) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.email = email;
        this.linkedin = linkedin;
        this.companyId = companyId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedin() {return linkedin;}

    public void setLinkedin(String linkedin) {this.linkedin = linkedin;}

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}