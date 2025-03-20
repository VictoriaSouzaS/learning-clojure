#_{:clj-kondo/ignore [:namespace-name-mismatch]}
(ns core.ports.todo-port)
;; Define o namespace. as portas definem as interações com o mundo externo

(defprotocol TodoPort
  ;; Protocolo para operações relacionadas a tarefas 'todo'
  (get-tasks [this]))
  ;; Retorna uma coleção de tarefas 'todo'


;; Define protocolo. Define um conjunto de funções que um tipo de dados deve implementar para ser considerado um "implementador" do protocolo
;; Define a funcão get-tasks, a qual recebe um unico argumento
;; Em Clojure, this é convencionalmente usado para se referir à instância do objeto que implementa o protocolo.(Tipo Self)

;; Protocolos são usados para definir contratos entre diferentes partes de um sistema, 
;; permitindo que você escreva código que opere em abstrações em vez de implementações concretas