(defproject reversi-cljs "0.1.0-SNAPSHOT"
  :description "Clojurescript version of reversi"
  :url "https://github.com/xfsnowind/reversi-cljs"
  :min-lein-version  "2.5.0"

  :dependencies [[org.clojure/clojure         "1.7.0"]
                 [org.clojure/clojurescript   "1.7.58"]
                 [org.clojure/core.async      "0.1.346.0-17112a-alpha"]
                 [sablono                     "0.3.5"]
                 [hiccups                     "0.3.0"]
                 [org.omcljs/om               "0.9.0"]
                 [org.clojure/core.match      "0.3.0-alpha4"]
                 [com.keminglabs/c2           "0.2.4-SNAPSHOT"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-figwheel  "0.3.7"]
            [lein-shell     "0.4.0"]
            [lein-sassy     "1.0.7"]]

  :sass {:src "src/scss"
         :dst "resources/public/css"}

  :source-paths ["src/cljs"]
  :clean-targets ^{:protect false} ["resources/public/js/"
                                    "resources/public/css/"
                                    "www/js"
                                    "www/css"
                                    "target"
                                    "out"]

  :hooks [leiningen.cljsbuild leiningen.sass]

  :figwheel {:nrepl-port 7888
             :css-dirs   ["resources/public/css"]}

  :cljsbuild {:builds [{:id           "dev"
                        :source-paths ["src/cljs"]
                        :incremental  true
                        :figwheel     {:on-jsload      "reversi-cljs.core/trigger-synthetic-om-update!"}
                        :compiler     {:main           "reversi-cljs.core"
                                       :output-to      "resources/public/js/reversi.js"
                                       :asset-path     "js"
                                       :output-dir     "resources/public/js/"
                                       :optimizations  :none
                                       :pretty-print   true
                                       :source-map     true
                                       :cache-analysis true}}
                       {:id           "prod"
                        :source-paths ["src/cljs"]
                        :compiler     {:optimizations :advanced
                                       :pretty-print  false
                                       :output-to     "www/js/reversi.js"}}]}

  :aliases {"prod"
            ^{:doc "Prepares a folder, www, ready for copying to production server. Includes polyfills and optimizations."}
            ["do"
             ["sass" "once"]
             ["cljsbuild" "once" "prod"]
             ["shell" "autoprefixer" "-b" "last 2 versions"  "-o" "www/css/reversi.css" "resources/public/css/reversi.css"]]

            "dev"
            ^{:doc "Builds the project and opens a figwheel repl. Open http://localhost:3449 to use. Sourcemaps and pretty-print"}
            ["do"
             ["sass" "once"]
             ["figwheel" "dev"]]})
