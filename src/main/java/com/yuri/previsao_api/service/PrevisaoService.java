package com.yuri.previsao_api.service;

import com.yuri.previsao_api.dto.PrevisaoDTO;
import com.yuri.previsao_api.entity.Previsao;
import com.yuri.previsao_api.repository.PrevisaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrevisaoService {

    public final RestTemplate restTemplate;

    @Autowired
    private PrevisaoRepository previsaoRepository;

    @Autowired
    public PrevisaoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PrevisaoDTO> listarTodas() {
        return previsaoRepository.findAll()
                .stream()
                .map(PrevisaoDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<PrevisaoDTO> buscarPorId(Long id) {
        return previsaoRepository.findById(id)
                .map(PrevisaoDTO::new);
    }

    public PrevisaoDTO salvar(PrevisaoDTO previsaoDTO) {
        Previsao previsao = new Previsao();
        BeanUtils.copyProperties(previsaoDTO, previsao);
        Previsao previsaoSalva = previsaoRepository.save(previsao);
        return new PrevisaoDTO(previsaoSalva);
    }

    public void deletar(Long id) {
        previsaoRepository.deleteById(id);
    }
}
