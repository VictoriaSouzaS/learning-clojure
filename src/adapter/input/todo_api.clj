#_{:clj-kondo/ignore [:namespace-name-mismatch]}
(ns adapter.input.todo-api
  ;; adaptador de entrada permite acessar a lógica do sistema via HTTP. Quando rodar o servidor, ele expõe um endpoint para listar tarefas
  (:require [org.httpkit.server :refer [run-server]]
            ;; org.httpkit.server é uma biblioteca para criar servidores HTTP assíncronos em Clojure
            ;; run-server função usada para iniciar o servidor HTTP
            ;; Biblioteca conhecida por criar servidores HTTP assíncronos de alto desempenho em Clojure
            [cheshire.core :as json]
            ;; cheshire.core é uma biblioteca para trabalhar com JSON
            [core.service.todo-service :refer [todo-service]]
            ;; importa a variavel todo-service do namespace core.service.todo-service. Essa variavel contem a implementação do serviço que provê a lista de tasks
            [config.app-config :refer [config]]))  ;; Adiciona a importação do config para obter a porta


(defn filter-tasks [tasks criteria]
  "Filtra as tarefas baseadas nos critérios fornecidos"
  (filter (fn [task]
            (every? (fn [[k v]]
                      (= (k task) v)) criteria))
          tasks))

(defn handler [req]
  ;; define uma função chamada handler. Função que será chamada para lidar com as requisições HTTP recebidas pelo servidor
  ;; req, que representa a requisição HTTP recebida
  (let [tasks ((:get-tasks todo-service))]
    ;; let cria uma variável local chamada tasks
    ;; (get-tasks todo-service) chama a função get-tasks passando como argumento a variavel todo-service, recuperando a lista de tarefas
    {:status 200
     ;; :status 200, garante que o cliente receberá a confirmação de que a solicitação para listar tarefas foi bem-sucedida
     :headers {"Content-Type" "application/json"}
     ;; define o cabeçalho Content-Type como application/json, indicando que a resposta está em formato JSON
     :body (json/generate-string tasks)}))
     ;; define o corpo da resposta como a lista de tarefas serializada em formato JSON usando json/generate-string

   ;; cria um mapa que representa a resposta HTTP

(defn start-server [& _]
  ;; define função chamada start-server. A qual é responsável por iniciar o servidor HTTP
  (let [port (get-in config [:todo-api :port] 8081)]  ;; Pega a porta do config, com fallback para 8081
    (run-server handler {:port port})))  ;; Inicia o servidor na porta configurada
  ;; chama a função run-server para iniciar o servidor:
  ;; handler é a função que será usada para lidar com as requisições HTTP

(comment
  (start-server)) ;; Inicie o servidor chamando essa função
;; bloco não será executado quando o arquivo for carregado
