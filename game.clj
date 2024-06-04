(def min-num (atom 1))
(def max-num (atom 100))
(def current-guess (atom 50))

(defn start [n m]
  (reset! min-num n)
  (reset! max-num m)
  (reset! current-guess (quot (+ n m) 2))
  (println "Я готов..."))

(defn guess-my-number []
  @current-guess)

(defn smaller []
  (swap! max-num (fn [_] (dec @current-guess)))
  (swap! current-guess (fn [_] (quot (+ @min-num @max-num) 2)))
  @current-guess)

(defn bigger []
  (swap! min-num (fn [_] (inc @current-guess)))
  (swap! current-guess (fn [_] (quot (+ @min-num @max-num) 2)))
  @current-guess)
