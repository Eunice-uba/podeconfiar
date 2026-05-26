package com.podeconfiar.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "simulacoes")
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "perfil_alvo")
    private String perfilAlvo;

    @Column(nullable = false)
    private String descricao;

    @Column(name = "e_golpe", nullable = false)
    private Boolean eGolpe;

    @Column(nullable = false)
    private String explicacao;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPerfilAlvo() { return perfilAlvo; }
    public void setPerfilAlvo(String perfilAlvo) { this.perfilAlvo = perfilAlvo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Boolean getEGolpe() { return eGolpe; }
    public void setEGolpe(Boolean eGolpe) { this.eGolpe = eGolpe; }

    public String getExplicacao() { return explicacao; }
    public void setExplicacao(String explicacao) { this.explicacao = explicacao; }
}