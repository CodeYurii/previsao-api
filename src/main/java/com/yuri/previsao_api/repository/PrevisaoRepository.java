package com.yuri.previsao_api.repository;

import com.yuri.previsao_api.entity.Previsao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrevisaoRepository extends JpaRepository<Previsao, Long> {
}
