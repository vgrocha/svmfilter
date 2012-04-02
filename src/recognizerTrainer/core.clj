;well, i want to link up the whole thing to our current decaptcher
                                        ;framework
;maybe check mr. bellanis sources =)

(ns recognizerTrainer.core
  (:import (java.io File)
           (java.awt.image BufferedImage)
           (javax.imageio ImageIO)))

(defmacro dbg[x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))

(def folder2 (File. "/home/usuario/workspace/samples/trunk/captchas/detranPr"))

(def folder (File. "/home/vgrocha/tmp/cap"))

(def ext "jpg")

(defn get-files-from-folder [filterfn path]
  (filter filterfn (.listFiles path)))



(defn File-has-extension [ext F]
  (let [name (.getName F)
        nF (count name)
        next (count ext)
        start (- nF next)]
    (if (<= 0 start)
      (= (subs (.getName F) start nF) ext)
      false)
    ))

(defn load-image [path]
  (try
    (ImageIO/read path)
    (catch Exception e (.printStackTrace e))))


(defn file-image? [f]
  (File-has-extension ext f))

(defn get-images-from-subfolders [path]
  (mapcat (partial get-files-from-folder file-image?) (get-files-from-folder #(.isDirectory %) path)))

(defn get-recognized-Files2 [path]
  (filter #(.isDirectory %) (.listFiles path)))

(def folders (get-recognized-Files2 folder))