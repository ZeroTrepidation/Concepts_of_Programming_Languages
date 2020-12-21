fun eval(nil, _) = 0.0
| eval(a::T, x) = a + eval(T, x) * x;



