package com.podeconfiar.api.repository;

import com.podeconfiar.api.model.Simulacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SimulacaoRepository extends JpaRepository<Simulacao, Long> {
    List<Simulacao> findByPerfilAlvo(String perfilAlvo);
}