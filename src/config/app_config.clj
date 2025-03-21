#_{:clj-kondo/ignore [:namespace-name-mismatch]}
(ns config.app-config
  (:require [integrant.core :as ig]
            [ring.adapter.jetty :as jetty]))

(def config
  {:todo-api {:port 8081}})

(defmethod ig/init-key :todo-api [_ {:keys [port]}]
  (let [api (requiring-resolve 'adapter.input.todo-api/handler)]  ;; Carrega dinamicamente o handler evitando ref circular
    (jetty/run-jetty api {:port port})))

(defn init []
  (ig/init config))