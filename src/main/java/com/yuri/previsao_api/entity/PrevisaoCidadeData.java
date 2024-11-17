package com.yuri.previsao_api.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "previsao_cidade_data")
public class PrevisaoCidadeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "previsao_cidade_id", nullable = false)
    private PrevisaoCidade previsaoCidade;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String date_br;
    @Column(name = "climate_rain", nullable = false)
    private Double climate_rain;
    @Column(name = "last_year", nullable = false)
    private Double last_year;
    @Column(name = "normal", nullable = false)
    private Double normal;
    @Column(name = "forecast", nullable = false)
    private Double forecast;

    public PrevisaoCidadeData() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PrevisaoCidade getPrevisaoCidade() {
        return previsaoCidade;
    }

    public void setPrevisaoCidade(PrevisaoCidade previsaoCidade) {
        this.previsaoCidade = previsaoCidade;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrevisaoCidadeData that = (PrevisaoCidadeData) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
