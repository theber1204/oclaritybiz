package com.oclaritybiz.model;

public class Module {
    private String id;
    private String name;
    private String icon;
    private String link;
    private String status;

    // Constructor vacío
    public Module() {
    }
    // Constructor completo
    public Module(String id, String name, String icon, String link, String status) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.link = link;
        this.status = status;
    }
    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}