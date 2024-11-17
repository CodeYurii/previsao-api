package com.yuri.previsao_api.dto;

import com.yuri.previsao_api.entity.PrevisaoCidade;
import org.springframework.beans.BeanUtils;
import java.util.List;

public class PrevisaoCidadeDTO {

    private String name;
    private String state;
    private String country;
    private List<PrevisaoCidadeDataDTO> previsaoCidadeDataDTO;

    public PrevisaoCidadeDTO() {}

    public PrevisaoCidadeDTO(PrevisaoCidade previsaoCidade) {
        BeanUtils.copyProperties(previsaoCidade, this);
        this.previsaoCidadeDataDTO = previsaoCidade.getPrevisaoCidadeData()
                .stream()
                .map(PrevisaoCidadeDataDTO::new)
                .toList();
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

    public List<PrevisaoCidadeDataDTO> getPrevisaoCidadeDataDTO() {
        return previsaoCidadeDataDTO;
    }

    public void setPrevisaoCidadeDataDTO(List<PrevisaoCidadeDataDTO> previsaoCidadeDataDTO) {
        this.previsaoCidadeDataDTO = previsaoCidadeDataDTO;
    }
}
