package com.yuri.previsao_api.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Previsao")
public class Previsao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "token", nullable = false)
    private String token;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    public Previsao() {}

    public Previsao(Long id, String pais, String token, LocalDate data, String descricao) {
        this.id = id;
        this.pais = pais;
        this.token = token;
        this.data = data;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Previsao{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", token='" + token + '\'' +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
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
