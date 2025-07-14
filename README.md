# Cadastro de Periféricos - API RESTful

Este é um projeto Full Stack desenvolvido com Java 21 e Spring Boot, que permite o cadastro, listagem, atualização, exclusão e exportação de periféricos de TI. O front-end é integrado via Thymeleaf e o banco de dados utilizado é o H2 (em memória). A API é documentada com Swagger/OpenAPI.


<img width="1517" height="385" alt="image" src="https://github.com/user-attachments/assets/2ea24c3a-07e6-4e48-8a23-73b6d32e4a21" />
## Tecnologias Utilizadas

- Java 21
- Spring Boot
  - Spring Web
  - Spring Data JPA
  - Springdoc OpenAPI (Swagger)
- Banco H2
- Thymeleaf
- Apache POI (para geração de Excel)
- Maven

## Funcionalidades da API

### Registrar um novo periférico
- **POST** `/`
- `@Operation(summary = "Registrar um novo periférico")`
- Envia um JSON com os dados do periférico.

### Listar todos os periféricos
- **GET** `/`
- `@Operation(summary = "Listar todos os periféricos")`

### Buscar periférico por número de série
- **GET** `/{id}`
- `@Operation(summary = "Buscar periférico por número de série")`

### Atualizar periférico
- **PUT** `/{id}`
- `@Operation(summary = "Atualizar informações de um periférico")`

### Excluir periférico
- **DELETE** `/{id}`
- `@Operation(summary = "Excluir periférico pelo número de série")`

### Exportar relatório em Excel
- **GET** `/excel`
- `@Operation(summary = "Gerar relatório Excel com tempo de uso.")`
- Gera e faz download de um arquivo `perifericos.xlsx`.

## Front-end (Thymeleaf)

O projeto inclui páginas HTML com Thymeleaf para:
- Formulário de cadastro de periféricos
- Lista de periféricos cadastrados
- Botão para exportação do relatório em Excel
- Integração direta com os endpoints da API

## Banco de Dados H2

A aplicação utiliza o H2 como banco em memória para testes locais.

### Acesso ao console:
- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:perifericosdb`
- Usuário: `sa`
- Senha: (em branco ou conforme definido no `application.properties`)

## Documentação Swagger

A documentação da API está disponível via Swagger UI:
- URL: `http://localhost:8080/swagger-ui.html`
- ou: `http://localhost:8080/swagger-ui/index.html`

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/filipecrodrigues/cadastro-perifericos.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd cadastro-perifericos
   ```

3. Execute o projeto com Maven:
   ```bash
   mvn spring-boot:run
   ```

4. Acesse o sistema:
   - Front-end (Thymeleaf): `http://localhost:8080/perifericos`
   - Swagger: `http://localhost:8080/swagger-ui.html`

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/perifericos/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── templates/
│       └── application.properties
└── test/
```

## Pré-requisitos

- Java 21 ou superior
- Maven 3.6+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)


## Autor

**Filipe Rodrigues**
- GitHub: [filipecrodrigues](https://github.com/filipecrodrigues)

## Licença

Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
