#_{:clj-kondo/ignore [:namespace-name-mismatch]}
(ns core.service.todo-service
  ;; Define o namespace

  (:require [clj-http.client :as client]
            ;; Importa biblioteca para fazer requisições HTTP
            [cheshire.core :as json]
            ;; Importa biblioteca para trabalhar com JSON
            [core.domain.todo :refer :all]
            ;; Importa namespace, e referencia todas funcoes e váriveis, desta forma não é necessário utilizar o prefixo do namespace
            [core.ports.todo-port :refer :all]))

(def api-url "https://jsonplaceholder.typicode.com/todos")
;; Define a variavel/URL da API que fornece dados de tarefas "todo"

(defn fetch-tasks []
  ;; Define função. [] indica que a função não recebe nenhum argumento
  (let [response (client/get api-url {:as :json})]
    ;; let cria var local, (client/get api-url {:as :json}) faz uma requisição HTTP GET para a URL armazenada em api-url. Especifica tratamento como JSON
    (map #(->ToDo (:id %) (:title %) (:completed %)) (:body response))))
    ;; map tranforma os dados da resposta. Aplica a função a cada item no corpo da resposta
    ;; (:body response) extrai o corpo da resposta HTTP, que é onde os dados JSON estão localizados
    ;; #(->ToDo (:id %) (:title %) (:completed %)) função anônima que é aplicada a cada item no corpo da resposta. Extrai o valor de cada campo
    ;; (->ToDo ...) cria uma nova instância do defrecord ToDo usando os valores extraídos

(def todo-service {:get-tasks fetch-tasks})
;; Define todo-service como um mapa contendo a função fetch-tasks sob a chave :get-tasks