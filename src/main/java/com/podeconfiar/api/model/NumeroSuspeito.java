package com.podeconfiar.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "numeros_suspeitos")
public class NumeroSuspeito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String numero;

    @Column(name = "tipo_golpe")
    private String tipoGolpe;

    @Column(name = "total_denuncias")
    private Integer totalDenuncias = 1;

    @Column(name = "data_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getTipoGolpe() { return tipoGolpe; }
    public void setTipoGolpe(String tipoGolpe) { this.tipoGolpe = tipoGolpe; }

    public Integer getTotalDenuncias() { return totalDenuncias; }
    public void setTotalDenuncias(Integer totalDenuncias) { this.totalDenuncias = totalDenuncias; }

    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}