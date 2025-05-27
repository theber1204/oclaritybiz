package com.oclaritybiz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManualPage {
    private Long id;
    private Long manualId; // <-- Agregado
    private String imageUrl;
    private String observations;
    private int order;

    public ManualPage() {
    }

    public ManualPage(Long id, Long manualId, String imageUrl, String observations, int order) {
        this.id = id;
        this.manualId = manualId;
        this.imageUrl = imageUrl;
        this.observations = observations;
        this.order = order;
    }
}