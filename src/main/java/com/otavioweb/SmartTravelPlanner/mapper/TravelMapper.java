package com.otavioweb.SmartTravelPlanner.mapper;

import com.otavioweb.SmartTravelPlanner.dto.TravelDTO;
import com.otavioweb.SmartTravelPlanner.model.TravelItemModel;
import org.springframework.stereotype.Component;

@Component
public class TravelMapper {

  public TravelItemModel map(TravelDTO travelDTO){
    TravelItemModel travelItemModel = new TravelItemModel();

    travelItemModel.setId(travelDTO.getId());
    travelItemModel.setOrigem(travelDTO.getOrigem());
    travelItemModel.setDestino(travelDTO.getDestino());
    travelItemModel.setOrçamento(travelDTO.getOrcamento());
    travelItemModel.setDias(travelDTO.getDias());

    return travelItemModel;
  }

  public TravelDTO map(TravelItemModel travelItemModel){
    TravelDTO travelDTO = new TravelDTO();

    travelDTO.setId(travelItemModel.getId());
    travelDTO.setOrigem(travelItemModel.getOrigem());
    travelDTO.setDestino(travelItemModel.getDestino());
    travelDTO.setOrçamento(travelItemModel.getOrcamento());
    travelDTO.setDias(travelItemModel.getDias());

    return travelDTO;
  }
}
