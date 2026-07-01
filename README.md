# 🎵 Spring Music

API de gerenciamento de eventos e votação do Spring Music, desenvolvido como projeto acadêmico para facilitar a seleção de artistas com base na demanda do público.

---

## 📌 Sobre o Projeto

O **Spring Music** é uma plataforma que permite:

- **Usuários comuns (espectadores)** votarem em artistas para eventos.
- **Artistas** se cadastrarem e acompanharem sua colocação no ranking.
- **Administradores** criarem, editarem e gerenciarem eventos.

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
git clone https://github.com/seu-usuario/spring-music.git
cd spring-music
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
   
### 3. Configurando variáveis de ambiente

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

Você pode ir na classe [SpringMusicApiApplication.java](./src/main/java/com/sofar/spring_music_api/SpringMusicApiApplication.java) e clicar no botão de run ou digitar este comando no terminal:

```bash
./mvnw spring-boot:run
```

---

## Estratégia de Branches (Fluxo de Trabalho)

Para manter o histórico de código organizado, seguro e mitigar conflitos entre a equipe, o projeto adota um modelo baseado nas melhores práticas do *Git Flow*.

- **`main`**: É a branch de produção da API.
  > Contém exclusivamente o código estável, exaustivamente testado e pronto para o usuário final. **Nunca** deve receber commits ou desenvolvimento direto.

- **`develop`**: É a branch de integração e o coração do desenvolvimento.
  > Centraliza todas as novas funcionalidades que estão sendo construídas pela equipe. Quando a `develop` atinge um estado totalmente estável e validado, um deploy é preparado para ser mesclado com a `main`.

- **Branches de Funcionalidade (`feature/`, `fix/`)**: Onde o trabalho real acontece.
  > O desenvolvedor deve criar uma nova branch **sempre a partir da `develop`** para isolar a criação de uma funcionalidade ou a correção de um problema.
  >
  > *   *Nomenclatura recomendada:* `feature/nome-da-tarefa` ou `fix/nome-do-erro`
  > *   *Fluxo:* Após concluir e validar a tarefa localmente, o desenvolvedor abre um *Pull Request* para integrar o código de volta à branch `develop`.

## Padrões de Commit (Conventional Commits)

Adotamos o padrão de *Conventional Commits* para garantir que o histórico de alterações do Git seja legível, organizado e fácil de automatizar.

Os commits devem ser escritos em letras minúsculas e seguir a estrutura:  
`tipo: descrição curta e direta`

- **`feat`**: Introdução de uma nova funcionalidade no sistema.
  > *Exemplo:* `feat: implementa a autenticacao jwt no login`

- **`fix`**: Correção de um bug, erro ou comportamento inesperado.
  > *Exemplo:* `fix: corrige validacao de cpf no cadastro de usuários`

- **`refactor`**: Reorganização ou melhoria do código existente sem alterar seu comportamento final.
  > *Exemplo:* `refactor: otimiza a consulta de listagem de usuários`

- **`docs`**: Alterações exclusivas na documentação do projeto.
  > *Exemplo:* `docs: atualiza a arquitetura de pastas no readme`

- **`style`**: Mudanças de formatação e estilo que não afetam a lógica do código (espaços, identação, ponto e vírgula, etc.).
  > *Exemplo:* `style: formata as classes do pacote service conforme o padrao`

- **`test`**: Criação, modificação ou acréscimo de testes unitários ou de integração.
  > *Exemplo:* `test: adiciona testes de integracao para o fluxo de cadastro`

- **`chore`**: Tarefas gerais de manutenção, atualização de dependências, scripts ou configurações de build.
  > *Exemplo:* `chore: atualiza as dependencias do spring boot no pom.xml`

- **`hotfix`**: Correção urgente aplicada diretamente para resolver uma falha grave encontrada em ambiente de produção.
  > *Exemplo:* `hotfix: corrige vazamento de memoria na validacao do token`

## Arquitetura de Pastas

A estrutura do projeto adota o padrão de **Camadas**. Ela garante a separação clara de responsabilidades, alta testabilidade e facilidade de manutenção.

```
src/main/java/com/sofar/spring_music_api/
├── config/                                 # Configurações globais da aplicação (Beans, OpenAPI/Swagger)
│
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
├── repository/                             # Camada de Acesso ao Banco (Interfaces Spring Data JPA)
│
├── security/                               # Infraestrutura de Autenticação e Autorização (Spring Security + JWT)
│
└── service/                                # Camada de Regras de Negócio e Lógica da Aplicação
```
