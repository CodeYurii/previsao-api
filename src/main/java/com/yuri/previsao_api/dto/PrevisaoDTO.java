package com.yuri.previsao_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yuri.previsao_api.entity.Previsao;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;


public class PrevisaoDTO {
    private String country;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String text;

    public PrevisaoDTO() {}

    public PrevisaoDTO(Previsao entity) {
        BeanUtils.copyProperties(entity, this);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}