package com.otavioweb.SmartTravelPlanner.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@Service
public class ChatGptService {
  private final WebClient webClient;
  private String apiKey = System.getenv("OPENAI_API_KEY");

  public ChatGptService(WebClient webClient) {
    this.webClient = webClient;
  }

//  "Agora vc é um especialista em roteiro de viagens com base nos dados informados."
  public Mono<String> generateTravel(){
      String prompt = "Me sugira roteiro de viagens simples";
    Map<String, Object> requestBody = Map.of(
            "model", "gpt-4",
            "messages", List.of(
                    Map.of("role", "system", "content", "Você é um especialista em roteiro de viagens que gera roteiros personalizados."),
                    Map.of("role", "user", "content", prompt)
            )
    );

      return webClient.post()
              .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
              .header(HttpHeaders.AUTHORIZATION, "Bearer "+apiKey)
              .bodyValue(requestBody)
              .retrieve()
              .bodyToMono(Map.class)
              .map(response ->{
                var choices = (List<Map<String, Object>>) response.get("choices");
                if(choices != null && !choices.isEmpty()){
                  Map<String, Object> menssage = (Map<String, Object>) choices.get(0).get("menssage");
                  return menssage.get("content").toString();
                }
                return "Nenhum roteiro gerado";
              });
  }
}
