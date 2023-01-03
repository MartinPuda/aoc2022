(ns aoc2022.day06
  (:require [clojure.string :as str])
  (:gen-class))

(def data
  (slurp "resources/input06.txt"))

(defn solution [data marker-size]
  (->> data
       (partition marker-size 1)
       (take-while #(apply (complement distinct?) %))
       count
       (+ marker-size)))

;1909
(defn part1 [data]
  (solution data 4))

;3380
(defn part2 [data]
  (solution data 14))

;;;;;

(defn tests []
  (assert (= (part1 data) 1909))
  (assert (= (part2 data) 3380)))

(tests)