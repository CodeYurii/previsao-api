package com.yuri.previsao_api.entity;

import com.yuri.previsao_api.dto.PrevisaoCidadeDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "previsao_cidade")
public class PrevisaoCidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "previsaoCidade", orphanRemoval = true)
    private List<PrevisaoCidadeData> previsaoCidadeData = new ArrayList<>();

    public PrevisaoCidade() {}

    public PrevisaoCidade(PrevisaoCidadeDTO previsaoCidadeDTO) {
        BeanUtils.copyProperties(previsaoCidadeDTO, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<PrevisaoCidadeData> getPrevisaoCidadeData() {
        return previsaoCidadeData;
    }

    public void setPrevisaoCidadeData(List<PrevisaoCidadeData> previsaoCidadeData) {
        this.previsaoCidadeData = previsaoCidadeData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrevisaoCidade that = (PrevisaoCidade) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
