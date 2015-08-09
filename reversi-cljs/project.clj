(defproject reversi-cljs "0.1.0-SNAPSHOT"
  :description "Reversi of Clojurescript version"
  :url "https://github.com/xfsnowind/reversi-cljs"
  :min-lein-version  "2.5.0"
  :license {:name "MIT"}

  :dependencies [[org.clojure/clojure         "1.7.0"]
                 [org.clojure/clojurescript   "1.7.58"]
                 [org.clojure/core.async      "0.1.346.0-17112a-alpha"]
                 [org.omcljs/om               "0.9.0"]
                 [org.omcljs/ambly            "0.6.0"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-shell     "0.4.0"]]

  :source-paths ["src/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/"
                                    "resources/public/css/"
                                    "www/js"
                                    "www/css"
                                    "target"]

  :cljsbuild {:builds {:dev {:source-paths ["src"]
                             :incremental  true
                             :compiler {:output-to "target/out/main.js"
                                        :output-dir "target/out"
                                        :optimizations :none}}}}
  )
