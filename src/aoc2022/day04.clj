(ns aoc2022.day04
  (:require [clojure.string :as s]
            [clojure.set :as set])
  (:gen-class))

(defn range-from-str-range [s]
  (->> (s/split s #"-")
       (map parse-long)
       ((fn [[start end]] (range start (inc end))))))

(def data
  (for [line (s/split-lines (slurp "resources/input04.txt"))]
    (->> (s/split line #",")
         (map range-from-str-range)
         (mapv set))))

(defn part1 [data]
  (count (for [[s1 s2] data
               :when (or (set/subset? s1 s2)
                         (set/subset? s2 s1))]
           [s1 s2])))

(defn part2 [data]
  (count (for [[s1 s2] data
               :when (seq (set/intersection s1 s2))]
           [s1 s2])))

;;;;;

(defn tests []
  (assert (= (part1 data) 605))
  (assert (= (part2 data) 914)))

(tests)