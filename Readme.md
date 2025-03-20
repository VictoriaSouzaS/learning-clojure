# To-Do List Project

Este projeto fornece uma API para consulta de tarefas utilizando **Clojure** e segue a **Arquitetura Hexagonal** (**Ports and Adapters**). Ele busca dados da API pública JSONPlaceholder e permite listagem e filtragem de tarefas de forma simples e organizada.

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

## Dependências

Para instalar as dependências, execute:

```bash
clojure -M:deps
```

## Como Rodar o Projeto

1. Clone o repositório:

    ```bash
    git clone https://github.com/seu-usuario/todo-list-clj.git
    cd todo-list-clj
    ```

2. Inicie a API REST:

    ```bash
    clojure -M -m todo.adapter.input.todo-api
    ```

3. Faça requisições HTTP para acessar as tarefas.

## Testes

Os testes estão na pasta `test/todo_list/` e podem ser executados com:

```bash
clojure -M:test
```

## Licença

Este projeto é licenciado sob a [MIT License](LICENSE).
