(ns cerberus.main
  (:require [cerberus.core :as core]))

(core/main)

(defn ws-host []
  (let [location (.-location js/window)
        proto (.-protocol js/location)
        ws (clojure.string/replace proto #"^http" "ws")
        host (.-hostname location)
        port (.-port location)]
    (str ws "//" host ":" port))
  "ws://192.168.1.41")
