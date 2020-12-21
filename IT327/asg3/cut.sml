fun cut n = fn nil => nil 
| (a::T) => 
	let
		val x = cut n T;
	in
		if n>a then x else a::x
	end;
