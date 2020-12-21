fun choose 0 _ = [nil]
	| choose _ nil = nil
	| choose n (a::T) = 
		choose n T @ map(fn x => a::x)(choose(n-1) T);
