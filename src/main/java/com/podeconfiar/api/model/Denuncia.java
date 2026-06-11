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

    @Column(name = "tipo_golpe")
    private String tipoGolpe;

    @Column(name = "tipo_contato")
    private String tipoContato;

    @Column(name = "banco_mencionado")
    private String bancoMencionado;

    @Column(name = "o_que_pediu")
    private String oQuePediu;

    @Column(name = "valor_perdido")
    private Double valorPerdido;

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

    public String getTipoGolpe() { return tipoGolpe; }
    public void setTipoGolpe(String tipoGolpe) { this.tipoGolpe = tipoGolpe; }

    public String getTipoContato() { return tipoContato; }
    public void setTipoContato(String tipoContato) { this.tipoContato = tipoContato; }

    public String getBancoMencionado() { return bancoMencionado; }
    public void setBancoMencionado(String bancoMencionado) { this.bancoMencionado = bancoMencionado; }

    public String getOQuePediu() { return oQuePediu; }
    public void setOQuePediu(String oQuePediu) { this.oQuePediu = oQuePediu; }

    public Double getValorPerdido() { return valorPerdido; }
    public void setValorPerdido(Double valorPerdido) { this.valorPerdido = valorPerdido; }

    public LocalDate getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(LocalDate dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }

    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}