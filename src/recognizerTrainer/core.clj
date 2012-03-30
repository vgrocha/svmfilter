(ns recognizerTrainer.core
  (:import (java.io File)))

(def folder (File. "/home/usuario/workspace/samples/trunk/captchas/detranPr"))

(def ext "jpg")

(defn get-files-from-folder [filterfn path]
  (filter filterfn (.listFiles path)))

(defn File-has-extension [ext F]
  (let [name (.getName F)
        nF (count name)
        next (count ext)
        start (- nF next)]
    (if (<= 0 start)
      (= (subs (.getName F) start nF) ext))
    false
    ))

(defn file-image? [f]
  (File-has-extension ext f))

(defn get-images-from-subfolders [path]
  (mapcat (partial get-files-from-folder file-image?) (get-files-from-folder #(.isDirectory %) path)))

(defn get-recognized-Files2 [path]
  (filter #(.isDirectory %) (.listFiles path)))

(def folders (get-recognized-Files2 folder))