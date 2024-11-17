package com.yuri.previsao_api.service;

import com.yuri.previsao_api.dto.PrevisaoCidadeDTO;
import com.yuri.previsao_api.entity.PrevisaoCidade;
import com.yuri.previsao_api.entity.PrevisaoCidadeData;
import com.yuri.previsao_api.repository.PrevisaoCidadeDataRepository;
import com.yuri.previsao_api.repository.PrevisaoCidadeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PrevisaoCidadeService {

    private final RestTemplate restTemplate;

    @Autowired
    private PrevisaoCidadeRepository previsaoCidadeRepository;

    @Autowired
    private PrevisaoCidadeDataRepository previsaoCidadeDataRepository;

    @Autowired
    public PrevisaoCidadeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Transactional
    public PrevisaoCidadeDTO salvar(PrevisaoCidadeDTO previsaoCidadeDTO) {
        PrevisaoCidade previsaoCidade = new PrevisaoCidade(previsaoCidadeDTO);
        for (PrevisaoCidadeData data : previsaoCidade.getPrevisaoCidadeData()) {
            data.setPrevisaoCidade(previsaoCidade); // Define o relacionamento com a cidade
        }
        PrevisaoCidade previsaoSalva = previsaoCidadeRepository.save(previsaoCidade);
        return new PrevisaoCidadeDTO(previsaoSalva);
    }
}
