(ns alfa.core
  (:require
    [clojure.set :as st :refer [union difference intersection]]
    [clojure.string :as cs :refer [split-lines]]))

(defn prime?
  [^long p]
  (cond
    (< p 2) false
    (== p 2) true
    (even? p) false
    :else (->> (range 3 (inc (int (Math/sqrt p))) 2)
               (map #(rem p %))
               (every? pos?))))




