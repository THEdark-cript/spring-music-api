# 🎵 Spring Music

API de gerenciamento de eventos e votação do Spring Music, desenvolvido como projeto acadêmico para facilitar a seleção de artistas com base na demanda do público.

---

## 📌 Sobre o Projeto

O **Spring Music** é uma plataforma que permite:

- **Usuários comuns (espectadores)** votarem em artistas para eventos.
- **Artistas** se cadastrarem e acompanharem sua colocação no ranking.
- **Administrador** criar, editar e gerenciar eventos.

---

## ✨ Funcionalidades Principais

### 🔐 Autenticação e Cadastro
- Cadastro de usuários com **nome completo, CPF, e-mail e senha**.
- Login com e-mail e senha.
- Três perfis de acesso: **Usuário Comum**, **Artista** e **Administrador**.

### 🗳️ Votação em Artistas
- Usuários comuns podem votar em artistas de um evento específico.
- Cada voto é **único por artista** (não pode ser desfeito).
- É possível votar em **múltiplos artistas** em um mesmo evento.

### 🎤 Cadastro de Artistas
- Após login, o artista preenche um formulário com:
    - Nome completo (ou nome do grupo)
    - Descrição da apresentação
- O artista **não pode editar ou excluir** sua participação após o envio.

### ⚙️ Gerenciamento de Eventos (Administrador)
- Criação, edição, atualização e exclusão de eventos.
- Controle total sobre as informações do evento.

### 🏆 Ranking de Artistas
- Ranking atualizado em tempo real com base nos votos.
- Resultado final fixo após o prazo de votação.
- Filtro por cidade para visualização do ranking desejado.

---

## 🛠️ Tecnologias Utilizadas

- Java 21;
- Maven;
- Spring Boot;
- PostgreSQL;
- JWT

## 🚀 Como Executar o Projeto

### Pré-requisitos

É necessário ter instalado em seu dispositivo:

- Java 21;
- PostgreSQL;
- Maven.

---

### 1. Clonar o repositório
```bash
git clone https://github.com/THEdark-cript/spring-music-api.git
```

### 2. Criar banco de dados

No terminal do linux, rode os seguinte comandos para criar o banco de dados:

1. Entrar no psql:
    ```bash
    sudo -u postgres psql
    ```
   
2. Criar o banco:
    ```psql
    CREATE DATABASE spring_music;
    ```
   
3. Para verificar se o banco foi criado com sucesso execute o seguinte comando:
    ```psql
    \l
    ```
    Se na lista aparecer o banco spring_music, é porque o banco foi criado com sucesso.
4. Para sair do psql execute o comando:
    ```bash
    \q
    ```

### 3. Configuração de Variáveis de Ambiente

O arquivo [application.properties](./src/main/resources/application.properties) utiliza variáveis de ambiente com valores padrão (ex.: `${DB_USER:postgres}`). Para adequar às credenciais do seu banco de dados, você pode optar por uma das seguintes formas:

- **Edição direta** – Substitua os valores padrão pelas suas configurações no próprio arquivo.  
  ⚠️ *Evite versionar essas alterações para não expor dados sensíveis.*

- **Definição via IntelliJ (recomendada)** – Siga os passos abaixo para criar um perfil de execução com variáveis de ambiente:

    1. Acesse `Current File` → `Edit Configurations...`.
    2. Clique em `+` e escolha `Application`.
    3. Em `Modify options`, ative a opção `Environment variables`.
    4. No campo `Environment variables`, clique no ícone ao lado da pasta e adicione cada variável necessária (ex.: `DB_USER`, `DB_PASSWORD`), informando o valor correspondente.
    5. Certifique-se de que os nomes das variáveis coincidam exatamente com os declarados no `application.properties`.

Dessa forma, você mantém as credenciais fora do código e facilita a troca entre ambientes.

### 4. Executando o projeto



Para executar o projeto, você pode ir na classe [SpringMusicApiApplication.java](./src/main/java/com/sofar/spring_music_api/SpringMusicApiApplication.java) e clicar no botão de run ou digitar este comando no terminal:

```bash
./mvnw spring-boot:run
```

Esta API é consumida pelo front-end do Spring Music, para acessar o repositório do front, [clique aqui](https://github.com/RhuanFelix/spring-music.git). 

No front não tem como você criar um administrador, então você terá que usar um cliente HTTP como Insomnia ou Postman para criar um perfil de administrador utilizando o endpoint ```POST /auth/cadastrar/admin```, enviando como corpo da requisição um objeto JSON com os atributos do DTO [CadastroRequestDTO.java](./src/main/java/com/sofar/spring_music_api/domain/dto/autenticacao/CadastroRequestDTO.java).

---

## Arquitetura de Pastas

A estrutura do projeto adota o padrão de **Camadas**. Ela garante a separação clara de responsabilidades, alta testabilidade e facilidade de manutenção.

```
src/main/java/com/sofar/spring_music_api/
├── controller/                             # Camada de Entrada (REST Controllers)
│
├── domain/                                 # Modelagem do Domínio da Aplicação
│   ├── dto/                                # Objetos de Transferência de Dados (Request/Response)
│   │   ├── usuario/
│   │   │   ├── UsuarioRequest.java
│   │   │   └── UsuarioResponse.java
│   ├── entity/                             # Entidades JPA que espelham as tabelas do Banco de Dados
│   └── enums/                              # Enumeradores globais (Ex: UserRole)
│
├── exception/                              # Tratamento de erros global da API (@ControllerAdvice e subexceções)
│
├── mapper/                                 # Mapeamento entre entidade e DTOs
│
├── repository/                             # Camada de Acesso ao Banco (Interfaces Spring Data JPA)
│
├── security/                               # Infraestrutura de Autenticação e Autorização (Spring Security + JWT)
│
└── service/                                # Camada de Regras de Negócio e Lógica da Aplicação
```
## Desenvolvedores

Os dois projetos do Spring Music (front e back), foram desenvolvidos por:

- [Anthony Kiss](https://github.com/THEdark-cript);
- [Francisco Neto](https://github.com/Netoady);
- [Rhuan Félix](https://github.com/RhuanFelix).