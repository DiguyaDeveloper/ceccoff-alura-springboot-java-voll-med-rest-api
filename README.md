# ceccoff-alura-springboot-java-voll-med-rest-api

# API REST com Spring Boot, Spring Data JPA e PostgreSQL

Este projeto foi desenvolvido durante o curso "Spring Boot 3: desenvolva uma API rest em Java" oferecido pela Alura. O objetivo do projeto é criar uma API REST utilizando Spring Boot, Spring Data JPA e PostgreSQL como banco de dados.

## Sobre o Curso

O curso "Spring Boot 3: desenvolva uma API rest em Java", oferecido pela Alura, foi essencial para a criação deste projeto. 
Durante o curso, foram abordados os fundamentos e práticas recomendadas para o desenvolvimento de APIs RESTful utilizando Spring Boot, Spring Data JPA e PostgreSQL. 

Links úteis:
- [URL Figma](https://www.figma.com/design/N4CgpJqsg7gjbKuDmra3EV/Voll.med?node-id=2-1007&t=0onrJVxrVKe9Cl9e-0): Protótipos e design do projeto.
- [URL Trello](https://trello.com/b/O0lGCsKb/api-voll-med): Planejamento e gerenciamento das tarefas do projeto.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- PostgreSQL
- Maven

## Configuração do Banco de Dados

Antes de iniciar a aplicação, configure o banco de dados PostgreSQL:

1. Crie um banco de dados no PostgreSQL.
2. Atualize o arquivo `application.properties` com as informações do seu banco de dados.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Executando a Aplicação

1. Clone o repositório:

```bash
git clone https://github.com/DiguyaDeveloper/ceccoff-alura-springboot-java-voll-med-rest-api.git
```

2. Navegue até o diretório do projeto:

```bash
cd ceccoff-alura-springboot-java-voll-med-rest-api
```

3. Compile o projeto e resolva as dependências:

```bash
mvn clean install
```

4. Inicie a aplicação:

```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`.

## Como Contribuir

Sinta-se à vontade para contribuir para este repositório. Se você encontrar erros, deseja adicionar mais recursos ou compartilhar seu próprio projeto baseado no curso, abra uma **issue** ou envie um **pull request**.

## Agradecimentos

- Agradecimento especial à equipe da Alura pelo excelente curso "Spring Boot 3: desenvolva uma API rest em Java".

## Pré-requisitos e Configuração

Antes de começar, certifique-se de ter os seguintes pré-requisitos instalados:

- [Java](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) - Necessário para executar os exemplos e projetos do curso.
- [InteliJJ](https://www.jetbrains.com/idea/download/?section=windows) - Recomendado como ambiente de desenvolvimento.

Divirta-se aprendendo Webpack do básico ao avançado e construindo projetos incríveis!

Happy coding! 🚀