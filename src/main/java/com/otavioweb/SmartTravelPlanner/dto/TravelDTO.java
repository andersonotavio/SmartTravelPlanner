package com.otavioweb.SmartTravelPlanner.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class TravelDTO {

  private Long id;
  private String origem;
  private String destino;
  private BigDecimal orcamento;
  private Integer dias;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getDias() {
    return dias;
  }

  public void setDias(Integer dias) {
    this.dias = dias;
  }

  public BigDecimal getOrcamento() {
    return orcamento;
  }

  public void setOrçamento(BigDecimal orcamento) {
    this.orcamento = orcamento;
  }

  public String getDestino() {
    return destino;
  }

  public void setDestino(String destino) {
    this.destino = destino;
  }

  public String getOrigem() {
    return origem;
  }

  public void setOrigem(String origem) {
    this.origem = origem;
  }
}
