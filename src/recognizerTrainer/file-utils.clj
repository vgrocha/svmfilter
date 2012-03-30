(ns recognizerTrainer.file-utils
  (:import (java.io File)))


(defn my-ls [d]
  (println "Files in " (.getName d))
  (doseq [f (.listFiles d)]
    (if (.isDirectory f)
      (print "d ")
      (print "- "))
    (println (.getName f))))

(defn get-dir-Files [d]
  (.listFiles d))

