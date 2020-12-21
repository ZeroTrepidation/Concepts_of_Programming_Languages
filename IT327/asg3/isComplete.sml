datatype 'data tree = Empty
| Node of 'data tree * 'data * 'data tree;

fun isComplete Empty = true
| isComplete(Node(Empty, y, Empty)) = true
| isComplete(Node(x, y, Empty)) = false
| isComplete(Node(Empty, y, z)) = false
| isComplete(Node(x,y,z)) = 
	isComplete x andalso isComplete z;
