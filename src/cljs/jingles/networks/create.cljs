(ns jingles.networks.create
  (:refer-clojure :exclude [get list])
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require
   ;[jingles.networks.api :refer [root]]
   [jingles.api :as api]
   [jingles.http :as http]
   [jingles.utils :refer [initial-state make-event]]
   [jingles.state :refer [set-state!]]))

(defn render [app]
  "This is a add networks section")
