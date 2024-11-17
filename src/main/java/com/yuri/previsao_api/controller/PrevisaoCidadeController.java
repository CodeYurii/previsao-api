package com.yuri.previsao_api.controller;

import com.yuri.previsao_api.dto.PrevisaoCidadeDTO;
import com.yuri.previsao_api.service.PrevisaoCidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/previsao/cidade")
public class PrevisaoCidadeController {

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private PrevisaoCidadeService previsaoCidadeService;

    @GetMapping("/consulta/cidade")
    public ResponseEntity<List<PrevisaoCidadeDTO>> consultarApiExterna(@RequestParam Long id, @RequestParam String token) {
        String url = String.format("http://apiadvisor.climatempo.com.br/api/v1/climate/rain/locale/%d?token=%s", id, token);
        ResponseEntity<List<PrevisaoCidadeDTO>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PrevisaoCidadeDTO>>() {}
        );
        List<PrevisaoCidadeDTO> listPrevisaoCidadeDTO = responseEntity.getBody();
        if (listPrevisaoCidadeDTO != null) {
            for (PrevisaoCidadeDTO dto : listPrevisaoCidadeDTO) {
                previsaoCidadeService.salvar(dto);
            }
        }
        return ResponseEntity.ok(listPrevisaoCidadeDTO);
    }
}
