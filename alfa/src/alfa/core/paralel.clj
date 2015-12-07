(ns alfa.core.paralel
  (:require [alfa.core :refer [prime?]]))

;; Clojure's transducer

(defn sum-prime-1
  [lim]
  (->> (range 3 lim 2)
       (map #(+ % (rand-int 100)))
       (filter prime?)
       (reduce +)
       time))

;; transduce => reduce
;; sequence =>

(def xform-fun
  (comp (map #(+ % (rand-int 100)))
        (filter prime?)))

(defn sum-prime-2
  [lim]
  (sequence xform-fun (range 3 lim 2)))

