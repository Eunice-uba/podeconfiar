package com.podeconfiar.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String numero;

    private String descricao;

    @Column(name = "data_ocorrencia")
    private LocalDate dataOcorrencia;

    @Column(name = "data_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public LocalDate getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(LocalDate dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }

    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}