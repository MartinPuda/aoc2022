(ns aoc2022.day03
  (:require [clojure.string :as s]
            [clojure.set :as set])
  (:gen-class))

(def data (-> (slurp "resources/input03.txt")
              (s/split-lines)))

(defn priority [^Character c]
  (- (int c) (if (Character/isLowerCase c) 96 38)))

(defn common-char-with-rating [group]
  (->> (map set group)
       (apply set/intersection)
       first
       priority))

(defn line-get-common-char [line]
  (let [c (count line)]
    (common-char-with-rating (split-at (/ c 2) line))))

(defn part1 [data]
  (transduce (map line-get-common-char)
             +
             data))

(defn part2 [data]
  (transduce (map common-char-with-rating)
             +
             (partition 3 data)))

;;;;;

(defn testy []
  (assert (= (part1 data) 7737))
  (assert (= (part2 data) 2697)))

(testy)


