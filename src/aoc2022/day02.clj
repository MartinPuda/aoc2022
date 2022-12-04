(ns aoc2022.day02
  (:require [clojure.string :as s])
  (:gen-class))

(def data
  (->> (s/split-lines (slurp "resources/input02.txt"))
       (map #(s/split % #" "))))

(defn round-result [s1 s2]
  ([3 6 0 3 6]
   (+ ({"A" 0 "B" 2 "C" 1} s1)
      ({"X" 0 "Y" 1 "Z" 2} s2))))

(defn points-for-round [[s1 s2]]
  (+ ({"X" 1 "Y" 2 "Z" 3} s2)
     (round-result s1 s2)))

(defn my-shape-for-situation [s1 s2]
  (["X" "Y" "Z" "X" "Y"]
   (+ ({"A" 2 "B" 0 "C" 1} s1)
      ({"X" 0 "Y" 1 "Z" 2} s2))))

(defn part1 [data]
  (transduce (map points-for-round) + data))

(defn part2 [data]
  (transduce
    (map (fn [[s1 s2]]
           (->> (my-shape-for-situation s1 s2)
                (vector s1)
                points-for-round)))
    + data))

;;;;;;

(defn tests []
  (assert (= (part1 data) 11475))
  (assert (= (part2 data) 16862)))

(tests)