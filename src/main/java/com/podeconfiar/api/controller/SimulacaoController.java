package com.podeconfiar.api.controller;

import com.podeconfiar.api.model.Simulacao;
import com.podeconfiar.api.repository.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/simulacoes")
@CrossOrigin(origins = "*")
public class SimulacaoController {

    @Autowired
    private SimulacaoRepository repository;

    @GetMapping
    public List<Simulacao> listarTodas() {
        return repository.findAll();
    }

    @GetMapping("/perfil/{perfil}")
    public List<Simulacao> buscarPorPerfil(@PathVariable String perfil) {
        return repository.findByPerfilAlvo(perfil);
    }
}