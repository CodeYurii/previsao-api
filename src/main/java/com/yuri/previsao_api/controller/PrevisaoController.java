package com.yuri.previsao_api.controller;

import com.yuri.previsao_api.dto.PrevisaoDTO;
import com.yuri.previsao_api.entity.Previsao;
import com.yuri.previsao_api.repository.PrevisaoRepository;
import com.yuri.previsao_api.service.PrevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/previsao")
public class PrevisaoController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private PrevisaoService previsaoService;

    @GetMapping("/consulta")
    public ResponseEntity<List<PrevisaoDTO>> consultarApiExterna(@RequestParam String country, @RequestParam String token) {
        String url = String.format("http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/%s?token=%s", country, token);
        ResponseEntity<List<PrevisaoDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PrevisaoDTO>>() {}
        );
        List<PrevisaoDTO> listPrevisaoDTO = responseEntity.getBody();
        if (listPrevisaoDTO != null) {
            for (PrevisaoDTO dto : listPrevisaoDTO) {
                previsaoService.salvar(dto);
            }
        }
        return ResponseEntity.ok(listPrevisaoDTO);
    }
}
