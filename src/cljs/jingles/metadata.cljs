(ns jingles.metadata
  (:require
   [om.core :as om :include-macros true]
   [om-tools.dom :as d :include-macros true]
   [om-bootstrap.table :refer [table]]
   [om-bootstrap.grid :as g]
   [om-bootstrap.random :as r]
   [om-bootstrap.button :as b]
   [jingles.utils :refer [grid-row]]
   [jingles.utils :refer [make-event menu-items]]))

(defn render [data owner opts]
  (reify
    om/IDisplayName
    (display-name [_]
      "metadata-well")
    om/IRenderState
    (render-state [_ _]
      (r/well
       {}
       "Metadata:"
       (pr-str (:metadata data))))))