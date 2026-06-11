package com.podeconfiar.api.controller;

import com.podeconfiar.api.model.Denuncia;
import com.podeconfiar.api.model.NumeroSuspeito;
import com.podeconfiar.api.repository.DenunciaRepository;
import com.podeconfiar.api.repository.NumeroSuspeitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/denuncias")
@CrossOrigin(origins = "*")
public class DenunciaController {

    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private NumeroSuspeitoRepository numeroSuspeitoRepository;

    @GetMapping
    public List<Denuncia> listarTodas() {
        return denunciaRepository.findAll();
    }

    @PostMapping
    public Denuncia registrar(@RequestBody Denuncia denuncia) {
        Denuncia salva = denunciaRepository.save(denuncia);

        Optional<NumeroSuspeito> existente = numeroSuspeitoRepository.findByNumero(denuncia.getNumero());
        if (existente.isPresent()) {
            NumeroSuspeito ns = existente.get();
            ns.setTotalDenuncias(ns.getTotalDenuncias() + 1);
            numeroSuspeitoRepository.save(ns);
        } else {
            NumeroSuspeito novo = new NumeroSuspeito();
            novo.setNumero(denuncia.getNumero());
            novo.setTipoGolpe(denuncia.getTipoGolpe() != null ? denuncia.getTipoGolpe() : "Denunciado por usuário");
            novo.setTotalDenuncias(1);
            numeroSuspeitoRepository.save(novo);
        }

        return salva;
    }
}