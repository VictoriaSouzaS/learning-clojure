
(ns core.domain.todo)
;; declara um namespace

;; named class with a set of given fields, and, optionally, methods for one or more protocols and/or interfaces.
;; É ideal para representar entidades de domínio com propriedades bem definidas.
(defrecord ToDo [id title completed])