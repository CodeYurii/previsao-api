package com.yuri.previsao_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Previsao")
public class Previsao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "text", nullable = false, columnDefinition = "TEXT")
    private String text;

    public Previsao() {}

    public Previsao(Long id, String country, LocalDate date, String text) {
        this.id = id;
        this.country = country;
        this.date = date;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String pais) {
        this.country = pais;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate data) {
        this.date = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String descricao) {
        this.text = descricao;
    }

    @Override
    public String toString() {
        return "Previsao{" +
                "id=" + id +
                ", pais='" + country + '\'' +
                ", data=" + date +
                ", descricao='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Previsao previsao = (Previsao) o;
        return id.equals(previsao.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
