(ns alfa.core.stm
  (:require [alfa.core.paralel :refer [sum-prime-1]]))

(def number-1 100)

(def number (atom 0))

(def number-2 (ref 0))

(defonce ranks
         (atom (for [i (range 200000)]
                 {:nama  (str "jojon" i)
                  :score (rand-int 100)})))

(defn start [interval]
  (loop []
    (reset! ranks (sort-by :score @ranks))
    (println (take 30 @ranks))
    (Thread/sleep interval)
    (recur)))

