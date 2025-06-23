# Smart Travel Planner ✈️

Um aplicativo inteligente que ajuda usuários a planejarem viagens personalizadas com base em informações como cidade atual, destino, orçamento e número de dias. Usando a inteligência artificial da API Gemini, o sistema gera um roteiro econômico com sugestões de transporte, hospedagem e passeios.

## ✨ Sobre o Projeto

Planejar uma viagem pode ser uma tarefa complexa e demorada. O **Smart Travel Planner** surge como uma solução para simplificar esse processo, oferecendo roteiros de viagem completos e personalizados de forma automatizada. A aplicação utiliza o poder da IA para analisar as preferências do usuário e criar um itinerário otimizado, focando em economia e na melhor experiência possível.

## 🚀 Funcionalidades Principais

O sistema foi desenhado para ser intuitivo e eficiente. As principais funcionalidades incluem:

* **Entrada de Dados do Usuário:**

    * 📍 **Cidade de Origem:** Ponto de partida da viagem.
    * 🎯 **Destino Desejado:** O local que o usuário sonha em conhecer.
    * 💰 **Orçamento Disponível:** Valor total que o usuário pretende gastar.
    * 📅 **Número de Dias:** Duração total da viagem.

* **Geração de Roteiro Personalizado com IA:**

    * ✈️ **Estimativa de Transporte:** Sugestões de voos ou meios de transporte com estimativas de preço.
    * 🏨 **Sugestões de Hospedagem:** Recomendações de acomodações que se encaixam no orçamento.
    * 🗺️ **Passeios Diários:** Um itinerário dia a dia com atividades, pontos turísticos e dicas locais.
    * 💸 **Estimativa de Custos:** Um resumo detalhado dos gastos previstos para manter a viagem dentro do orçamento.

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando um conjunto de tecnologias modernas e robustas para garantir performance e escalabilidade.

* **Backend:**

    * [**Spring Boot**](https://spring.io/projects/spring-boot): Framework principal para a construção de aplicações Java de forma rápida e eficiente.
    * [**Spring WebFlux**](https://docs.spring.io/spring-framework/docs/current/reference/html/web-reactive.html): Utilizado para criar um serviço reativo e não bloqueante, ideal para lidar com chamadas a APIs externas.
    * [**Spring Data JPA**](https://spring.io/projects/spring-data-jpa): Facilita a implementação da camada de persistência de dados.
    * [**Project Lombok**](https://projectlombok.org/): Reduz a verbosidade do código Java automatizando a criação de getters, setters, construtores, etc.

* **Banco de Dados:**

    * [**H2 Database**](https://www.h2database.com/): Um banco de dados em memória leve, perfeito para ambientes de desenvolvimento e testes.
    * [**Flyway**](https://flywaydb.org/): Ferramenta para controle de versão do banco de dados, automatizando as migrações de schema.

* **Inteligência Artificial:**

    * [**Google Gemini API**](https://ai.google.dev/): O cérebro por trás da geração dos roteiros. O modelo de linguagem processa os dados do usuário para criar itinerários inteligentes e personalizados.

## ⚙️ Começando

Para executar este projeto localmente, siga os passos abaixo.

### Pré-requisitos

* JDK 17 ou superior
* Apache Maven 3.8+
* Uma chave de API do Google Gemini. Você pode obter a sua no [Google AI Studio](https://aistudio.google.com/app/apikey).

### Instalação

1.  **Clone o repositório:**

    ```bash
    git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
    cd SEU_REPOSITORIO
    ```

2.  **Configure suas credenciais:**
    Renomeie o arquivo `src/main/resources/application.properties.example` para `application.properties` e insira a sua chave da API Gemini:

    ```properties
    # Gemini API Configuration
    gemini.api.key=SUA_CHAVE_API_AQUI
    ```

3.  **Execute a aplicação:**
    Use o Maven para compilar e iniciar o projeto.

    ```bash
    mvn spring-boot:run
    ```

4.  A aplicação estará disponível em `http://localhost:8080`.

## 🤝 Como Contribuir

Contribuições são o que tornam a comunidade de código aberto um lugar incrível para aprender, inspirar e criar. Qualquer contribuição que você fizer será **muito apreciada**.

1.  Faça um *fork* do projeto
2.  Crie uma *branch* para sua feature (`git checkout -b feature/AmazingFeature`)
3.  Faça o *commit* de suas alterações (`git commit -m 'Add some AmazingFeature'`)
4.  Faça o *push* para a *branch* (`git push origin feature/AmazingFeature`)
5.  Abra um *Pull Request*

## 📄 Licença

Distribuído sob a licença MIT. Veja `LICENSE` para mais informações.