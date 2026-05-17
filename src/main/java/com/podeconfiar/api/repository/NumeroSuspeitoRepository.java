package com.podeconfiar.api.repository;

import com.podeconfiar.api.model.NumeroSuspeito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface NumeroSuspeitoRepository extends JpaRepository<NumeroSuspeito, Long> {
    Optional<NumeroSuspeito> findByNumero(String numero);
}