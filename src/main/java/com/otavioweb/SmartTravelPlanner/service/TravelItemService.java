package com.otavioweb.SmartTravelPlanner.service;

import com.otavioweb.SmartTravelPlanner.dto.TravelDTO;
import com.otavioweb.SmartTravelPlanner.mapper.TravelMapper;
import com.otavioweb.SmartTravelPlanner.model.TravelItemModel;
import com.otavioweb.SmartTravelPlanner.repository.TravelItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravelItemService {

  private final TravelItemRepository repository;
  private final TravelMapper mapper;

  public TravelItemService(TravelItemRepository repository, TravelMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  public TravelDTO salvarItem(TravelDTO itemDTO){
    TravelItemModel item = mapper.map(itemDTO);
    item = repository.save(item);
    return mapper.map(item);
  }

  public List<TravelDTO> listarItens(){
    List<TravelItemModel> items = repository.findAll();
    return items.stream()
            .map(mapper::map)
            .collect(Collectors.toList());
  }

  public TravelDTO listarPorId(Long id){
    Optional<TravelItemModel> item = repository.findById(id);
    return item.map(mapper::map).orElse(null);

  }
  public TravelDTO atualizarItem(Long id, TravelDTO itemDTO){
    Optional<TravelItemModel> item = repository.findById(id);
    if(item.isPresent()){
      TravelItemModel itemAtualizado = mapper.map(itemDTO);
      itemAtualizado.setId(id);
      TravelItemModel itemSalvo = repository.save(itemAtualizado);
      return mapper.map(itemSalvo);
    }
    return null;
  }

  public void deletar(Long id){
    repository.deleteById(id);
  }
}
