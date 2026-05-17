package com.podeconfiar.api.controller;

import com.podeconfiar.api.model.NumeroSuspeito;
import com.podeconfiar.api.repository.NumeroSuspeitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/numeros")
@CrossOrigin(origins = "*")
public class NumeroSuspeitoController {

    @Autowired
    private NumeroSuspeitoRepository repository;

    @GetMapping
    public List<NumeroSuspeito> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/verificar/{numero}")
    public ResponseEntity<?> verificar(@PathVariable String numero) {
        Optional<NumeroSuspeito> resultado = repository.findByNumero(numero);
        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.ok("Número não encontrado na base de suspeitos.");
        }
    }

    @PostMapping
    public NumeroSuspeito cadastrar(@RequestBody NumeroSuspeito numeroSuspeito) {
        return repository.save(numeroSuspeito);
    }
}