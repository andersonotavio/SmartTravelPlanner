package com.otavioweb.SmartTravelPlanner.controller;

import com.otavioweb.SmartTravelPlanner.dto.TravelDTO;
import com.otavioweb.SmartTravelPlanner.service.TravelItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travel")
public class TravelItemController {

  private final TravelItemService service;

  public TravelItemController(TravelItemService service) {

    this.service = service;
  }

  @PostMapping("/add")
  public ResponseEntity<String> add(@RequestBody TravelDTO items){
    TravelDTO novoItem = service.salvarItem(items);
    return ResponseEntity.status(HttpStatus.CREATED)
            .body("Adiconado com sucesso");
  }

  @GetMapping("/items")
  public ResponseEntity<List<TravelDTO>> listar(){
    List<TravelDTO> items = service.listarItens();
    return ResponseEntity.ok(items);
  }

  @GetMapping("/item/{id}")
  public ResponseEntity<?> listarPorId(@PathVariable Long id){
    TravelDTO item = service.listarPorId(id);
    if(item != null){
      return ResponseEntity.ok(item);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
              .body("Item não encontrado");
    }
  }

  @PutMapping("/editar/{id}")
  public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody TravelDTO itemDTO){
    TravelDTO itemAtualizado = service.atualizarItem(id, itemDTO);
    if(itemAtualizado != null){
      return ResponseEntity.ok(itemAtualizado);
    }else{
      return ResponseEntity.status(HttpStatus.NOT_MODIFIED)
              .body("Erro ao editar item");
    }
  }

  @DeleteMapping("/excluir/{id}")
  public ResponseEntity<Void> excluir(@PathVariable Long id){
    service.deletar(id);
    return ResponseEntity.noContent().build();

  }

}
