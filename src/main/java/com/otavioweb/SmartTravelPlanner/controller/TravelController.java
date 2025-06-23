package com.otavioweb.SmartTravelPlanner.controller;

//import com.otavioweb.SmartTravelPlanner.service.ChatGptService;
import com.otavioweb.SmartTravelPlanner.dto.TravelDTO;
import com.otavioweb.SmartTravelPlanner.service.GeminiService;
import com.otavioweb.SmartTravelPlanner.service.TravelItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class TravelController {

  //private ChatGptService chatGptService;

  /*
  public TravelController(ChatGptService chatGptService) {
    this.chatGptService = chatGptService;
  }

 */

  private final GeminiService geminiService;
  private final TravelItemService travelItemService;

  public TravelController(GeminiService geminiService, TravelItemService travelItemService) {
    this.geminiService = geminiService;
    this.travelItemService = travelItemService;
  }

  @GetMapping("/generate")
  public Mono<ResponseEntity<String>> generateTravel(){
    List<TravelDTO> travelItem = travelItemService.listarItens();
    return geminiService.generateTravel(travelItem)
            .map(travel -> ResponseEntity.ok(travel))
            .defaultIfEmpty(ResponseEntity.noContent().build());
  }
}
