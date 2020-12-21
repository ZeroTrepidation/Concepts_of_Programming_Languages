fun factor(n, x) =
	if x > n then []
	else if n mod x = 0 then x::factor(n, x+1)
	else factor(n, x+1);
fun factorize n =
	factor(n, 1);


