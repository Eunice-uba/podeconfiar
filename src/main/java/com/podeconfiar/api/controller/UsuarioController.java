package com.podeconfiar.api.controller;

import com.podeconfiar.api.model.Usuario;
import com.podeconfiar.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        if (usuario.getDataNascimento() != null) {
            usuario.setDataNascimento(usuario.getDataNascimento());
        }
        try {
            Usuario salvo = repository.save(usuario);
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Email ou CPF já cadastrado.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario login) {
        Optional<Usuario> usuario = repository.findByEmail(login.getEmail());
        if (usuario.isPresent() && usuario.get().getSenha().equals(login.getSenha())) {
            return ResponseEntity.ok(usuario.get());
        }
        return ResponseEntity.status(401).body("Email ou senha incorretos.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}