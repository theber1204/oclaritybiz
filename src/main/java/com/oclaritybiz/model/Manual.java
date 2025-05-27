package com.oclaritybiz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Manual {
    private Long id;
    private String title;
    private String description;
    private List<ManualPage> pages;
    private String status;

    public Manual() {
    }

    public Manual(Long id, String title, String description, List<ManualPage> pages, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pages = pages;
        this.status = status;
    }
}