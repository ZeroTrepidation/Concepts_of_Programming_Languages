fun even [] = nil |
	even a = 
	if (hd a) mod 2 = 0 then (hd a)::even(tl a)
	else even(tl a);
	
