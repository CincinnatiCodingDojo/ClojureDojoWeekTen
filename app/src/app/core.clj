(ns app.core)

(defn remove-multiples-of [base numberList]
;	if numberList contains base, remove base and all remove-multiples-of

	(remove #(zero? (mod % base)) numberList
	)

)

(defn sieve [n]
	(loop [primes []
		   leftovers (range 2 (inc n))]
		(if (empty? leftovers)
			primes
		    (recur (conj primes (first leftovers))
		    		(remove-multiples-of 
		    			(first leftovers) leftovers)
		    )
		)
	)
)

(defn -main [& args]
	(sieve (Integer. (first args)))
)
