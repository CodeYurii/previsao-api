package com.yuri.previsao_api.dto;

import com.yuri.previsao_api.entity.PrevisaoCidadeData;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class PrevisaoCidadeDataDTO {

    private LocalDate date;
    private String date_br;
    private Double climate_rain;
    private Double last_year;
    private Double normal;
    private Double forecast;

    public PrevisaoCidadeDataDTO() {}

    public PrevisaoCidadeDataDTO(PrevisaoCidadeData previsaoCidadeData) {
        BeanUtils.copyProperties(previsaoCidadeData, this);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDate_br() {
        return date_br;
    }

    public void setDate_br(String date_br) {
        this.date_br = date_br;
    }

    public Double getClimate_rain() {
        return climate_rain;
    }

    public void setClimate_rain(Double climate_rain) {
        this.climate_rain = climate_rain;
    }

    public Double getLast_year() {
        return last_year;
    }

    public void setLast_year(Double last_year) {
        this.last_year = last_year;
    }

    public Double getNormal() {
        return normal;
    }

    public void setNormal(Double normal) {
        this.normal = normal;
    }

    public Double getForecast() {
        return forecast;
    }

    public void setForecast(Double forecast) {
        this.forecast = forecast;
    }
}
