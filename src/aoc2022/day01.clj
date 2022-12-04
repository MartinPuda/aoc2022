(ns aoc2022.day01
  (:require [clojure.string :as s])
  (:gen-class))

(defn block->calories [block]
  (transduce (map parse-long) + (s/split-lines block)))

(def data
  (->> (s/split (slurp "resources/input01.txt") #"\n\n")
       (map block->calories)))

(defn part1 [data]
  (reduce max data))

(defn part2 [data]
  (->> data
       (sort >)
       (take 3)
       (reduce +)))

;;;;;

(defn tests []
  (assert (= (part1 data) 68467))
  (assert (= (part2 data) 203420)))

(tests)
