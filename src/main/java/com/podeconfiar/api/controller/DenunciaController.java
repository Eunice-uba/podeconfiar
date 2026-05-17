package com.podeconfiar.api.controller;

import com.podeconfiar.api.model.Denuncia;
import com.podeconfiar.api.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/denuncias")
@CrossOrigin(origins = "*")
public class DenunciaController {

    @Autowired
    private DenunciaRepository repository;

    @GetMapping
    public List<Denuncia> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public Denuncia registrar(@RequestBody Denuncia denuncia) {
        return repository.save(denuncia);
    }
}