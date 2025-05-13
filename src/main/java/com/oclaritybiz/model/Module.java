package com.oclaritybiz.model;

import java.util.ArrayList;
import java.util.List;

public class Module {

    private String id;
    private String name;
    private String icon;
    private String link;
    private String status;
    private List<Module> subModules;

    // Constructor principal
    public Module(String id, String name, String icon, String link, String status) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.link = link;
        this.status = status;
        this.subModules = new ArrayList<>();
    }

    // Constructor sin link (opcional, según lo necesites)
    public Module(String id, String name, String icon, String status) {
        this(id, name, icon, "#", status);
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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Module> getSubModules() { return subModules; }
    public void setSubModules(List<Module> subModules) { this.subModules = subModules; }

    public void addSubModule(Module subModule) {
        this.subModules.add(subModule);
    }
}