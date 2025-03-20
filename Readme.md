# To-Do List Project

Este projeto fornece uma API para consulta de tarefas utilizando **Clojure** e segue a **Arquitetura Hexagonal** (**Ports and Adapters**). Ele busca dados da API pública JSONPlaceholder e permite listagem e filtragem de tarefas de forma simples e organizada.

## Arquitetura Hexagonal

A Arquitetura Hexagonal (também conhecida como Ports and Adapters) busca desacoplar a lógica central da aplicação de suas interações externas. No projeto, isso é feito dividindo a aplicação em três partes principais:

- **Core (Domínio):** Contém a lógica de negócio principal.
- **Portas:** Interfaces para interação com o mundo externo.
- **Adaptadores:** Implementações que convertem as chamadas para as portas e realizam a interação real com sistemas externos (como a API JSONPlaceholder).

## Arquitetura do Projeto

A arquitetura hexagonal mantém o sistema desacoplado das interações externas. O fluxo de dados ocorre por meio de **portas** e **adaptadores**, garantindo modularidade e facilidade de manutenção.

### Módulos do Projeto

- **Domínio (core):** Contém a lógica central da aplicação.
- **Interface do Usuário (UI):** Exposição dos dados via API REST.
- **Integração Externa:** Consumo da API pública JSONPlaceholder.

## Estrutura de Diretórios

```plaintext
todo-list-clj/
├── src/
│   ├── core/
│   │   ├── domain/
│   │   │   └── todo.clj         # Definição da entidade ToDo
│   │   ├── service/
│   │   │   └── todo-service.clj # Regras de negócio
│   │   ├── ports/
│   │   │   └── todo-port.clj    # Interface (Port) para comunicação
│   ├── adapter/
│   │   ├── input/
│   │   │   └── todo-api.clj     # API REST para interação com o usuário
│   │   ├── output/
│   │   │   └── todo-client.clj  # Cliente HTTP para consumo da API externa
├── config/
│   └── app-config.clj           # Configuração do sistema
├── deps.edn                     # Gerenciamento de dependências
├── README.md                    # Este arquivo de documentação
└── .gitignore                   # Arquivos ignorados pelo Git
```

## Funcionalidades

- **Listagem de Tarefas:** Busca tarefas da API JSONPlaceholder.
- **Filtragem de Tarefas:** Permite filtrar tarefas por status (completas ou pendentes).
- **API REST:** Interface para acesso às informações de forma estruturada.

## Tecnologias Usadas

- **Clojure:** Linguagem funcional para desenvolvimento.
- **JSONPlaceholder:** API pública para simulação de tarefas.
- **Clojure CLI:** Gerenciamento de dependências e execução.

## Ambiente de Desenvolvimento

Para rodar o projeto localmente, você precisa do [Clojure](https://clojure.org/guides/getting_started) instalado na sua máquina.

- Para verificar se o Clojure está instalado corretamente, execute o seguinte comando:

  ```bash
  clojure -v
  ```

- Se o comando retornar a versão do Clojure, significa que a instalação foi bem-sucedida.

- Caso ainda não tenha o Clojure instalado, siga os passos de instalação no site oficial.

## Dependências

Para instalar as dependências, execute:

```bash
clojure -M:deps
```

## Como Rodar o Projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/VictoriaSouzaS/learning-clojure.git
    ```

2. Inicie a API REST:

    ```bash
    clojure -X adapter.input.todo-api/start-server
    ```

3. Faça requisições HTTP para acessar as tarefas.

## Exemplo

### Testando a API

Para testar a API e obter a lista de tarefas, você pode usar o seguinte comando `curl`:

```
curl http://localhost:8081
```

### Filtrar por título

```
curl "http://localhost:8081?title=Tarefa%201"
```

### Filtrar por tarefa completa

```
curl "http://localhost:8081?completed=true"
```

### Filtrar por título e status de completude

```
curl "http://localhost:8081?title=Tarefa%201&completed=true"
```

## Testes

Os testes estão na pasta `test/todo_list/` e podem ser executados com:

```bash
clojure -M:test
```

## Aviso

Este projeto é para fins educacionais e não possui uma licença formal. O código pode ser modificado para fins pessoais de estudo.
