datatype 'data tree = Empty
| Node of 'data tree * 'data * 'data tree;

fun appendall Empty = []
| appendall (Node(l,x,r)) = (appendall l @ x @ appendall r);
