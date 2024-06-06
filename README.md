# Sistema de Distribuição de Solicitações da Invext

## Descrição do Projeto

Este projeto foi desenvolvido como parte do Desafio Técnico para a vaga de Desenvolvedor(a) Full-Stack Pleno na Ubots. O objetivo é criar um sistema que distribua solicitações de clientes para os times de atendimento corretos na central de relacionamento da Invext, uma fintech. A distribuição deve ser feita de acordo com o tipo de solicitação e a disponibilidade dos atendentes.

## Estrutura do Projeto

### Pacotes Principais

- `com.miguel.ubots_test`: Contém a classe principal para inicialização da aplicação.
- `com.miguel.ubots_test.config`: Contém as classes de configuração da aplicação.
- `com.miguel.ubots_test.controller`: Contém as classes de controladores REST.
- `com.miguel.ubots_test.model`: Contém as classes de modelo de dados.
- `com.miguel.ubots_test.service`: Contém as classes de serviço responsáveis pela lógica de distribuição de solicitações.

## Configuração e Execução

### Pré-requisitos

- Java 11+
- Maven 3.6+

### Passos para Execução

1. **Clone o repositório:**

    ```bash
    git clone <URL do Repositório>
    cd <diretório-do-projeto>
    ```

2. **Compile o projeto:**

    ```bash
    mvn clean install
    ```

3. **Execute a aplicação:**

    ```bash
    mvn spring-boot:run
    ```

### Estrutura de Arquivos

- `src/main/java/com/miguel/ubots_test/Application.java`: Classe principal que inicializa a aplicação Spring Boot.
- `src/main/java/com/miguel/ubots_test/config/AppConfig.java`: Configura os beans e inicializa os times de atendimento.
- `src/main/java/com/miguel/ubots_test/controller/SolicitationController.java`: Controlador REST para receber solicitações.
- `src/main/java/com/miguel/ubots_test/model/Solicitation.java`: Classe modelo que representa uma solicitação.
- `src/main/java/com/miguel/ubots_test/model/Agent.java`: Classe modelo que representa um agente.
- `src/main/java/com/miguel/ubots_test/model/Team.java`: Classe modelo que representa um time de atendimento.
- `src/main/java/com/miguel/ubots_test/service/SolicitationDistributor.java`: Serviço que contém a lógica de distribuição de solicitações.

## Endpoints da API

- `POST /solicitations`: Endpoint para receber uma nova solicitação.
    - **Request Body:**
      ```json
      {
        "type": "Card Issues",
        "clientId": "12345"
      }
      ```

### Exemplo de Uso

Para enviar uma nova solicitação, execute o seguinte comando:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"type": "Card Issues", "clientId": "12345"}' http://localhost:8080/solicitations
