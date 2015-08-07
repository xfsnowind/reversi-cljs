(ns reversi-cljs.core
  (:require [om.core :as om]
            [om.dom :as dom]))

(def app-state (atom {}))

(defn trigger-synthetic-om-update!
  [state]
  (swap! state #(update-in % [:fake-val] not)))

(defn reversi-cljs
 [data owner]
 (reify
   om/IRender
   (render [_]
     (dom/h1 nil "ss"))))

(om/root reversi-cljs
         app-state
         {:target (.getElementById js/document "reversi")})
