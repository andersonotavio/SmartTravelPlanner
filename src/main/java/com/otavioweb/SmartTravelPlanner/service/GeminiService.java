package com.otavioweb.SmartTravelPlanner.service;

import com.otavioweb.SmartTravelPlanner.dto.TravelDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {
  private final WebClient webClient;
  private String apiKey = System.getenv("GOOGLE_API_KEY");

  public GeminiService(WebClient webClient) {
    this.webClient = webClient;
  }


  public Mono<String> generateTravel(List<TravelDTO> travelItems) {

    String infor = travelItems.stream()
            .map(item -> String.format("Origem: %s | Destino: %s | Orçamento: R$ %.2f | Dias: %d",
                    item.getOrigem(),
                    item.getDestino(),
                    item.getOrcamento(),
                    item.getDias()))
            .collect(Collectors.joining("\n"));
    String prompt = "Você é um especialista em roteiro de viagem. Baseado nas informações no meu banco de dados gere um roteiro de viagens:\n "+infor;

    Map<String, Object> requestBody = Map.of(
            "contents", List.of(
                    Map.of(
                            "parts", List.of(
                                    Map.of("text", prompt)
                            )
                    )
            )

    );

    return webClient.post()
            .uri("/v1beta/models/gemini-2.0-flash:generateContent?key=" + apiKey)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(requestBody)
            .retrieve()
            .bodyToMono(Map.class)
            .map(response -> {
              var candidates = (List<Map<String, Object>>) response.get("candidates");
              if (candidates != null && !candidates.isEmpty()) {
                Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
                if (content != null) {
                  List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
                  if (parts != null && !parts.isEmpty()) {
                    return parts.get(0).get("text").toString();
                  }
                }
              }
              return "Nenhum roteiro gerado";
            })
            .onErrorMap(ex -> {
              System.err.println("Erro na chamada da API Gemini: " + ex.getMessage());
              return new RuntimeException("Falha ao gerar roteiro de viagem", ex);
            });
  }
}
