package com.yuri.previsao_api.dto;

import com.yuri.previsao_api.entity.Previsao;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;


public class PrevisaoDTO {
    private Long id;
    private String pais;
    private String token;
    private LocalDate data;
    private String descricao;

    public PrevisaoDTO() {}

    public PrevisaoDTO(Previsao entity) {
        BeanUtils.copyProperties(entity, this);
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
}