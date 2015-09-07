(ns cerberus.alert
  (:require-macros
   [cljs.core.async.macros :refer [go]]
   [cljs.core.match.macros :refer [match]])
  (:require
   [cerberus.utils :refer [goto val-by-id by-id a menu-items]]
   [cerberus.state :refer [delete-state! set-state!]]))

;; miliseconds the overlay stays visible
(def overlay-timeout 1000)

;; miliseconds before the alert is automaticaly closed
(def alert-timeouts
  {:danger false
   :success 5000})

(defn alert-timeout [type]
  (get-in alert-timeouts [type] 10000))

(defn clear [alert]
  (match
   [alert]
   [{:id id}] (delete-state! [:alerts id])
   [id] (delete-state! [:alerts id])))

(defn raise [type text]
  (let [id (str "alert-" (Math/round (* 10000000 (rand))))]
    (js/setTimeout #(set-state! [:alerts id :overlay] false) 1000)
    (if-let [timeout (alert-timeout type)]
      (js/setTimeout #(clear id) timeout))
    (set-state! [:alerts id] {:id id :overlay true :type type :text text})))

(defn alerts [success error]
  {:success #(raise :success success)
   :error #(raise :danger error)
   503 #(raise :danger (str error " - not all services are available."))
   404 #(raise :warning (str error " - not found."))})
