package com.podeconfiar.api.controller;

import com.podeconfiar.api.model.Usuario;
import com.podeconfiar.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        if (usuario.getIdade() <= 17) usuario.setPerfil("jovem");
        else if (usuario.getIdade() <= 59) usuario.setPerfil("adulto");
        else usuario.setPerfil("idoso");
        return repository.save(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}