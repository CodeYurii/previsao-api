package com.yuri.previsao_api.controller;

import com.yuri.previsao_api.dto.PrevisaoDTO;
import com.yuri.previsao_api.entity.Previsao;
import com.yuri.previsao_api.service.PrevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/previsao")
public class PrevisaoController {

    @Autowired
    private PrevisaoService previsaoService;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<PrevisaoDTO> listarTodas() {
        return previsaoService.listarTodas();
    }

    // Endpoint para buscar previsão por ID
    @GetMapping("/{id}")
    public ResponseEntity<PrevisaoDTO> buscarPorId(@PathVariable Long id) {
        Optional<PrevisaoDTO> previsao = previsaoService.buscarPorId(id);
        return previsao.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para salvar uma nova previsão
    @PostMapping
    public PrevisaoDTO salvar(@RequestBody PrevisaoDTO previsaoDTO) {
        return previsaoService.salvar(previsaoDTO);
    }

    // Endpoint para deletar uma previsão
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        previsaoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/consulta")
    public ResponseEntity<String> consultarApiExterna(@RequestParam String country, @RequestParam String token) {
        String url = String.format("http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/%s?token=%s", country, token);
        String resultado = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(resultado);
    }
}
