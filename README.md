# Previsão API

## Sobre o Projeto

A Previsão API é uma API desenvolvida para fornecer informações sobre a previsão do tempo, utilizando o endpoint do **ClimaTempo**. O objetivo principal deste projeto é integrar com a API externa e fornecer as informações de previsão de forma simples e eficiente. Além disso, a API salva as consultas realizadas em um banco de dados H2, permitindo histórico das previsões consultadas.


## Funcionalidades

- Consultar a previsão do tempo para uma cidade ou país específico.
- Integração com a API externa do ClimaTempo para obter as previsões.
- Salvar as consultas feitas no banco de dados H2 para manutenção de histórico.
- Respostas detalhadas sobre as condições climáticas para a data e localização consultada.

## Tecnologias Utilizadas

### Back end
- **Java 11**: Linguagem de programação.
- **Spring Boot**: Framework para o desenvolvimento da API.
- **JPA / Hibernate**: Para mapeamento objeto-relacional (ORM) e persistência de dados.
- **Maven**: Gerenciamento de dependências e construção do projeto.
- **Banco de Dados H2**: Banco de dados em memória para armazenamento do histórico de consultas.

### Ferramentas e Bibliotecas Externas
- **RestTemplate**: Utilizado para realizar requisições HTTP para o ClimaTempo.
- **Spring Web**: Para gerenciamento de requisições HTTP e criação dos endpoints da API.

## Como Executar o Projeto

### Pré-requisitos
- Java 11 instalado na máquina.

### Passos

1. **Clone o repositório:**

```bash
git clone git@github.com:CodeYurii/previsao-api.git
```

2. **Navegue até o diretorio do projeto:**
```bash
cd previsao-api
```

3. **Execute o projeto**
```bash
./mvnw spring-boot:run
```
- A aplicação estará rodando em http://localhost:8080.


## Como Usar a API

### Endpoints

1. **Consultar previsão de um país:**
- URL: /api/previsao/consulta
- Método: GET 
- Parâmetros:
    - pais: Código do país (Ex: "BR" para Brasil).
    - token: O seu Token de acesso.
- Exemplo de chamada(para país):
    - GET http://localhost:8080/api/previsao/cidade/consulta/cidade?pais=BR&token=seu-token

2. **Resposta esperada**:
[
  {
    "country": "BR",
    "date": "2010-03-06",
    "text": "Uma frente fria permanece semi-estacionária entre MG e BA, deixando o tempo chuvoso nestas áreas."
  }
]

## Como o histórico é armazenado
As consultas feitas à API são armazenadas no banco de dados H2, que está configurado para manter o histórico de previsões consultadas. 
Cada consulta salva inclui a cidade, país, data da consulta e a previsão do tempo retornada.


## Banco de Dados
O banco de dados H2 é embutido e não requer configurações adicionais para ser utilizado.
O acesso ao banco pode ser feito através da URL http://localhost:8080/h2-console quando o projeto estiver em execução. 
A configuração do banco de dados está pronta para ser utilizada.


### Autor

Yuri Omar Victor Seixeiro
https://www.linkedin.com/in/yuri-seixeiro/

