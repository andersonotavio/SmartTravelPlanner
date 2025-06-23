package com.otavioweb.SmartTravelPlanner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "travel_item")
@NoArgsConstructor
@AllArgsConstructor
public class TravelItemModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String origem;
  private String destino;
  @Column(precision = 10, scale = 2)
  private BigDecimal orcamento;
  private Integer dias;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public BigDecimal getOrcamento() {
    return orcamento;
  }

  public void setOrçamento(BigDecimal orcamento) {
    this.orcamento = orcamento;
  }

  public Integer getDias() {
    return dias;
  }

  public void setDias(Integer dias) {
    this.dias = dias;
  }
}
