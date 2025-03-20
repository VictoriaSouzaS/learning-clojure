#_{:clj-kondo/ignore [:namespace-name-mismatch]}
(ns config.app-config
  (:require [integrant.core :as ig]
            [adapter.output.todo-repository :as repo]
            [adapter.input.todo-api :as api]
            [core.ports.todo-port :as port]
            [core.service.todo-service :as service]
            [ring.adapter.jetty :as jetty])) ;; Adaptador do Ring para o servidor Jetty

(def config
  {:todo-repository {}
   :todo-api {:handler (api/handler)
              :port 8081}})

(defmethod ig/init-key :todo-repository [_ _]
  (repo/new-todo-repository))

(defmethod ig/init-key :todo-api [_ {:keys [handler port]}]
  (jetty/run-jetty handler {:port port}))

(defn init []
  (ig/init config))