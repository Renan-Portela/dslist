# 🎮 DSList - Sistema de Gerenciamento de Listas de Jogos

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.6-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.9-blue.svg)](https://maven.apache.org/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue.svg)](https://www.postgresql.org/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](https://github.com/Renan-Portela/dslist/blob/main/LICENSE)

> 🚀 **Projeto desenvolvido durante o Intensivão Java Spring do DevSuperior**

Uma API REST robusta para gerenciamento de listas de jogos, permitindo organizar, categorizar e reordenar coleções de games de forma intuitiva e eficiente.

---

## 📋 Sumário

- [🎯 Sobre o Projeto](#-sobre-o-projeto)
- [✨ Funcionalidades](#-funcionalidades)
- [🛠️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
- [🚀 Como Executar](#-como-executar)
- [📚 Endpoints da API](#-endpoints-da-api)
- [🏗️ Arquitetura do Projeto](#️-arquitetura-do-projeto)
- [🌍 Ambientes](#-ambientes)
- [📊 Modelo de Dados](#-modelo-de-dados)
- [🤝 Como Contribuir](#-como-contribuir)
- [📖 Aprendizados](#-aprendizados)
- [🏆 Créditos](#-créditos)
- [📄 Licença](#-licença)

---

## 🎯 Sobre o Projeto

O **DSList** é como um Netflix para gamers! 🎬➡️🎮 

Imagine que você tem uma coleção gigante de jogos (física ou digital) e quer organizá-los em listas temáticas como "Aventura e RPG" ou "Jogos de Plataforma". Este sistema permite exatamente isso, mas de forma digital e super organizada.

### 💡 Analogia Simples
Pense no DSList como um **organizador de gavetas inteligente**:
- Cada **jogo** é um item que você quer guardar
- Cada **lista** é uma gaveta temática (RPG, Plataforma, Ação, etc.)
- O sistema permite **reordenar** os itens dentro de cada gaveta
- Você pode **consultar** rapidamente o que tem em cada gaveta

---

## ✨ Funcionalidades

### 🎮 Gerenciamento de Jogos
- ✅ Listagem completa de jogos
- ✅ Busca detalhada de jogo por ID
- ✅ Informações ricas (título, ano, gênero, plataformas, score, descrições)

### 📝 Gerenciamento de Listas
- ✅ Criação de listas temáticas
- ✅ Listagem de todas as listas disponíveis
- ✅ Visualização de jogos por lista específica
- ✅ **Reordenação dinâmica** de jogos dentro das listas

### 🔄 Funcionalidades Avançadas
- ✅ API RESTful completa
- ✅ Reordenação por drag-and-drop (via API)
- ✅ Consultas otimizadas com projeções
- ✅ Configuração de CORS para frontend
- ✅ Múltiplos ambientes (test, dev, prod)

---

## 🛠️ Tecnologias Utilizadas

### Backend Core
- **Java 17** - A linguagem robusta e moderna
- **Spring Boot 3.4.6** - O framework que simplifica tudo
- **Spring Data JPA** - Para facilitar o acesso aos dados
- **Maven** - Gerenciador de dependências

### Banco de Dados
- **PostgreSQL** - Para produção (robusto como um cofre 🏦)
- **H2 Database** - Para testes (rápido como um post-it 📝)

### Ferramentas de Desenvolvimento
- **Spring Boot DevTools** - Para desenvolvimento ágil
- **JUnit** - Para testes unitários

---

## 🚀 Como Executar

### Pré-requisitos
```bash
☑️ Java 17 ou superior
☑️ Maven 3.6+
☑️ PostgreSQL (para ambiente de produção)
☑️ Git
```

### 1️⃣ Clone o Repositório
```bash
git clone https://github.com/Renan-Portela/dslist.git
cd dslist
```

### 2️⃣ Execute com Maven
```bash
# Para ambiente de teste (H2)
./mvnw spring-boot:run

# Para ambiente de desenvolvimento (PostgreSQL)
./mvnw spring-boot:run -Dspring.profiles.active=dev

# Para ambiente de produção
./mvnw spring-boot:run -Dspring.profiles.active=prod
```

### 3️⃣ Acesse a Aplicação
- **API Base URL:** `http://localhost:8080`
- **H2 Console:** `http://localhost:8080/h2-console` (apenas em modo test)

---

## 📚 Endpoints da API

### 🎮 Games
| Método | Endpoint | Descrição | Exemplo de Resposta |
|--------|----------|-----------|-------------------|
| `GET` | `/games` | Lista todos os jogos | `[{id: 1, title: "Mass Effect Trilogy", year: 2012, ...}]` |
| `GET` | `/games/{id}` | Busca jogo por ID | `{id: 1, title: "Mass Effect Trilogy", description: "...", ...}` |

### 📝 Lists
| Método | Endpoint | Descrição | Exemplo de Resposta |
|--------|----------|-----------|-------------------|
| `GET` | `/lists` | Lista todas as categorias | `[{id: 1, name: "Aventura e RPG"}]` |
| `GET` | `/lists/{id}/games` | Jogos de uma lista específica | `[{id: 1, title: "Mass Effect Trilogy", position: 0}]` |
| `POST` | `/lists/{id}/replacement` | Reordena jogos na lista | `Status 200 OK` |

### 🔄 Exemplo de Reordenação
```json
POST /lists/1/replacement
Content-Type: application/json

{
  "sourceIndex": 2,
  "destinationIndex": 0
}
```

### 📊 Dados de Exemplo
O sistema vem com dados pré-carregados incluindo:
- **Aventura e RPG:** Mass Effect Trilogy, Red Dead Redemption 2, The Witcher 3, etc.
- **Jogos de Plataforma:** Super Mario World, Hollow Knight, Ori and the Blind Forest, etc.

---

## 🏗️ Arquitetura do Projeto

```
src/main/java/com/Renan_Portela/dslist/
├── 🎯 controllers/          # Endpoints REST
│   ├── GameController.java
│   └── GameListController.java
├── 📊 dto/                  # Data Transfer Objects
│   ├── GameDTO.java
│   ├── GameMinDTO.java
│   ├── GameListDTO.java
│   └── ReplacementDTO.java
├── 🏢 entities/             # Entidades JPA
│   ├── Game.java
│   ├── GameList.java
│   ├── Belonging.java
│   └── BelongingPK.java
├── 🔍 projections/          # Consultas otimizadas
│   └── GameMinProjection.java
├── 💾 repositories/         # Acesso aos dados
│   ├── GameRepository.java
│   └── GameListRepository.java
├── ⚙️ services/             # Regras de negócio
│   ├── GameService.java
│   └── GameListService.java
└── 🔧 config/               # Configurações
    └── WebConfig.java
```

### 🧩 Padrão de Arquitetura
O projeto segue o padrão **MVC + Repository + Service**:
- **Controllers** = Garçons (recebem pedidos e entregam respostas)
- **Services** = Chefs (processam a lógica do negócio)
- **Repositories** = Despensa (buscam e armazenam dados)
- **DTOs** = Pratos prontos (dados formatados para entrega)

---

## 🌍 Ambientes

### 🧪 Test (Padrão)
```properties
# H2 em memória - perfeito para testes rápidos
spring.profiles.active=test
Database: H2 (em memória)
Console: http://localhost:8080/h2-console
```

### 🚧 Development
```properties
# PostgreSQL local
spring.profiles.active=dev
Database: localhost:5433/dslist
User: postgres
Password: 1234567
```

### 🚀 Production
```properties
# PostgreSQL em produção
spring.profiles.active=prod
Database: Configurado via variáveis de ambiente
- DB_URL
- DB_USERNAME  
- DB_PASSWORD
```

---

## 📊 Modelo de Dados

### 🎮 Game
```sql
tb_game {
  id: BIGINT (PK)
  title: VARCHAR
  game_year: INTEGER
  genre: VARCHAR
  platforms: VARCHAR
  score: DOUBLE
  img_url: VARCHAR
  short_description: TEXT
  long_description: TEXT
}
```

### 📝 GameList
```sql
tb_game_list {
  id: BIGINT (PK)
  name: VARCHAR
}
```

### 🔗 Belonging (Relacionamento N:N)
```sql
tb_belonging {
  list_id: BIGINT (FK)
  game_id: BIGINT (FK)
  position: INTEGER
}
```

### 🔄 Relacionamentos
- **Game** ↔ **GameList**: Muitos para Muitos através de **Belonging**
- **Belonging**: Tabela de associação com posição para ordenação
- **BelongingPK**: Chave composta (game_id + list_id)

---

## 🤝 Como Contribuir

### 1️⃣ Fork o Projeto
```bash
# Clique no botão "Fork" no GitHub
```

### 2️⃣ Crie uma Branch
```bash
git checkout -b feature/nova-funcionalidade
```

### 3️⃣ Faça suas Alterações
```bash
git add .
git commit -m "✨ Adiciona nova funcionalidade incrível"
```

### 4️⃣ Push e Pull Request
```bash
git push origin feature/nova-funcionalidade
# Crie um Pull Request no GitHub
```

### 💡 Ideias para Contribuições
- 🔍 Sistema de busca avançada por gênero/plataforma
- 👤 Sistema de usuários e listas personalizadas
- 📊 Dashboard com estatísticas de jogos
- 🏷️ Sistema de tags para jogos
- 📱 Implementação de frontend React/Angular
- 🔐 Sistema de autenticação JWT
- 📸 Upload de imagens para jogos
- ⭐ Sistema de avaliações

---

## 📖 Aprendizados

### 🎯 Conceitos Aplicados
- ✅ **API REST** - Comunicação padronizada
- ✅ **JPA/Hibernate** - Mapeamento objeto-relacional
- ✅ **DTO Pattern** - Transferência eficiente de dados
- ✅ **Repository Pattern** - Abstração do acesso aos dados
- ✅ **Profiles Spring** - Configuração por ambiente
- ✅ **Relacionamentos N:N** - Com atributos extras (position)

### 🧠 Destaques Técnicos
- **Projeções JPA** para consultas otimizadas
- **Query nativa** para busca em relacionamentos complexos
- **Transações** para operações de reordenação
- **CORS** configurado para integração frontend
- **Chave composta** com `@EmbeddedId`
- **BeanUtils** para mapeamento de entidades

### 💼 Skills Desenvolvidas
- Arquitetura de APIs RESTful
- Modelagem de banco de dados relacional complexo
- Configuração de múltiplos ambientes Spring
- Implementação de operações CRUD avançadas
- Gerenciamento de relacionamentos JPA

---

## 🏆 Créditos

### 👨‍🏫 DevSuperior
Este projeto foi desenvolvido durante o **Intensivão Java Spring** da [DevSuperior](https://devsuperior.com.br/), ministrado pelo professor **Nelio Alves**.

- 🔗 **Repositório de Referência:** [DSList](https://github.com/devsuperior/dslist-backend)
- 🎓 **Curso:** Intensivão Java Spring
- 👨‍💻 **Instrutor:** Nelio Alves
- 🏫 **Instituição:** DevSuperior

### 🙏 Agradecimentos
- À equipe DevSuperior pela qualidade do conteúdo
- À comunidade Spring Boot pela documentação excelente
- Aos colegas de curso pelas discussões enriquecedoras
- Ao Professor Nelio pela didática excepcional

---

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](https://github.com/Renan-Portela/dslist/blob/main/LICENSE) para detalhes.

---

## 📞 Contato

**Renan Portela**
- 📧 Email: renanportela@protonmail.com
- 🐙 GitHub: [@Renan-Portela](https://github.com/Renan-Portela)

---

<div align="center">

### ⭐ Se este projeto te ajudou, deixe uma estrela!

**Desenvolvido com ❤️ durante o Intensivão Java Spring DevSuperior**

</div>

---

## 🚀 Comandos Git para Implementação

```bash
# 1. Adicione o README ao seu repositório
git add README.md
git commit -m "📝 Adiciona documentação completa do projeto DSList"

# 2. Crie uma release tag (opcional)
git tag -a v1.0.0 -m "🎉 Primeira versão do DSList"

# 3. Push para o repositório
git push origin main
git push origin --tags
```

### 📁 Estrutura de Pastas Recomendada
```
dslist/
├── README.md                 # ← Este arquivo
├── docs/                    # Documentação adicional
│   ├── api-documentation.md
│   ├── deployment-guide.md
│   └── database-schema.md
├── .github/                 # Templates do GitHub
│   ├── ISSUE_TEMPLATE.md
│   └── PULL_REQUEST_TEMPLATE.md
└── assets/                  # Imagens para o README
    ├── logo.png
    ├── architecture-diagram.png
    └── api-endpoints.png
```

#### Issue Templates
```markdown
<!-- .github/ISSUE_TEMPLATE/bug_report.md -->
## 🐛 Bug Report
**Descrição do bug**
Uma descrição clara do que está acontecendo.

**Ambiente**
- OS: [e.g. Windows 10]
- Java Version: [e.g. 17]
- Spring Boot Version: [e.g. 3.4.6]
```

---

**Meta-descrição:** DSList é uma API REST em Java Spring Boot para gerenciamento de listas de jogos, desenvolvida durante o Intensivão DevSuperior. Permite organizar, categorizar e reordenar coleções de games com PostgreSQL, H2 e funcionalidades avançadas de CRUD.

**Tags:** `#java` `#spring-boot` `#api-rest` `#postgresql` `#jpa` `#devsuperior` `#maven` `#games` `#backend` `#crud` `#hibernate`
