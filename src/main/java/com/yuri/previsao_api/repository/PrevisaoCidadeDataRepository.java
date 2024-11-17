package com.yuri.previsao_api.repository;

import com.yuri.previsao_api.entity.Previsao;
import com.yuri.previsao_api.entity.PrevisaoCidadeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrevisaoCidadeDataRepository extends JpaRepository<PrevisaoCidadeData, Long> {
}
