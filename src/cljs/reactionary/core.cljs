(ns reactionary.core
  (:require [reagent.core :as reagent]
            [re-frame.core :refer [dispatch dispatch-sync]]
            [reactionary.handlers]
            [reactionary.subs]
            [reactionary.views]))


(enable-console-print!)

(defn mount-root []
  (reagent/render [reactionary.views/app]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dispatch-sync [:init-db])
  (dispatch-sync [:init-subs])
  (dispatch-sync [:init-todo-items])
  (mount-root))
