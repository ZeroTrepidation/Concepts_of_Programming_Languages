import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class LR1 {

	public static String token;
	public static StringTokenizer st;
	public static ArrayList<String> tokenList;
	public static Stack<Key> keyStack;

	public static void main(String[] args) {
		try {
			keyStack = new Stack<Key>();
			tokenList = new ArrayList<String>();

			if (args.length > 0) {
				String expression = args[0];
				expression = expression.concat("$");
				st = new StringTokenizer(expression, "()*/+-$", true);

				while (st.hasMoreTokens()) {
					token = st.nextToken();
					tokenList.add(token);

				}

				keyStack.push(new Key());

				while (!tokenList.isEmpty()) {
					token = tokenList.get(0);
					// System.out.println(keyStack.peek().getState());
					switch (keyStack.peek().getState()) {
					case 0:
						state0(token);
						break;
					case 1:
						state1(token);
						break;
					case 2:
						state2(token);
						break;
					case 3:
						state3(token);
						break;
					case 4:
						state4(token);
						break;
					case 5:
						state5(token);
						break;
					case 6:
						state6(token);
						break;
					case 7:
						state7(token);
						break;
					case 8:
						state8(token);
						break;
					case 9:
						state9(token);
						break;
					case 10:
						state10(token);
						break;
					case 11:
						state11(token);
						break;
					default:
						throw new IllegalArgumentException();

					}
				}
			}

//		Key keytest = new Key();
//		
//		System.out.println(keytest);

		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Expression");
		}
	}

	public static void state0(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		switch (token) {
		case "n":
			pushStack(new Key(token, 5, value), true);
			break;
		case "(":
			pushStack(new Key(token, 4, value), true);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state1(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		switch (token) {
		case "+":
			pushStack(new Key(token, 6, value), true);
			break;
		case "-":
			pushStack(new Key(token, 6, value), true);
			break;
		case "$":

			// end the program accept
			System.out.printf("Valid Expression, value = %d", keyStack.peek().getValue());
			System.out.println();
			tokenList.remove(0);

			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state2(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		Key temp;
		switch (token) {
		case "+":
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "-":
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "*":
			pushStack(new Key(token, 7, value), true);
			break;
		case "/":
			pushStack(new Key(token, 7, value), true);
			break;
		case ")":
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "$":
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;

		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state3(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		Key temp;
		switch (token) {
		case "+":
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "-":
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "*":
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "/":
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case ")":
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "$":
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state4(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		switch (token) {
		case "n":
			pushStack(new Key(token, 5, value), true);
			break;
		case "(":
			pushStack(new Key(token, 4, value), true);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state5(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		Key temp;
		switch (token) {
		case "+":
			temp = keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "-":
			temp = keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "*":
			temp = keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "/":
			temp = keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case ")":
			temp = keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "$":
			temp = keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state6(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		switch (token) {
		case "n":
			pushStack(new Key(token, 5, value), true);
			break;
		case "(":
			pushStack(new Key(token, 4, value), true);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state7(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		switch (token) {
		case "n":
			pushStack(new Key(token, 5, value), true);
			break;
		case "(":
			pushStack(new Key(token, 4, value), true);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state8(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		switch (token) {
		case "+":
			pushStack(new Key(token, 6, value), true);
			break;
		case "-":
			pushStack(new Key(token, 6, value), true);
			break;
		case ")":
			pushStack(new Key(token, 11, value), true);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state9(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		Key temp;
		switch (token) {
		case "+":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "-":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "*":
			pushStack(new Key(token, 7, value), true);
			break;
		case "/":
			pushStack(new Key(token, 7, value), true);
		case ")":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "$":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("E");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state10(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		Key temp;
		switch (token) {
		case "+":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "-":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "*":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "/":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case ")":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "$":
			operate();
			temp = keyStack.pop();
			temp.setSymbol("T");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public static void state11(String token) {
		int value = 0;
		if (isNumeric(token)) {
			value = Integer.parseInt(token);
			token = "n";
		}
		Key temp;
		switch (token) {
		case "+":
			keyStack.pop();
			temp = keyStack.pop();
			keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "-":
			keyStack.pop();
			temp = keyStack.pop();
			keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "/":
			keyStack.pop();
			temp = keyStack.pop();
			keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "*":
			keyStack.pop();
			temp = keyStack.pop();
			keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case ")":
			keyStack.pop();
			temp = keyStack.pop();
			keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		case "$":
			keyStack.pop();
			temp = keyStack.pop();
			keyStack.pop();
			temp.setSymbol("F");
			temp = peekCheck(temp);
			pushStack(temp, false);
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	// checks if a given string is a numeric number. Used in the convertExp method.
	public static boolean isNumeric(String strNum) {
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

	public static Key peekCheck(Key temp) {
		switch (keyStack.peek().getState()) {
		case 0:
			switch (temp.getSymbol()) {
			case "E":
				temp.setState(1);
				break;
			case "T":
				temp.setState(2);
				break;
			case "F":
				temp.setState(3);
				break;
			default:
				throw new IllegalArgumentException();

			}
			break;
		case 4:
			switch (temp.getSymbol()) {
			case "E":
				temp.setState(8);
				break;
			case "T":
				temp.setState(2);
				break;
			case "F":
				temp.setState(3);
				break;
			default:
				throw new IllegalArgumentException();

			}

			break;
		case 6:
			switch (temp.getSymbol()) {
			case "T":
				temp.setState(9);
				break;
			case "F":
				temp.setState(3);
				break;
			default:
				throw new IllegalArgumentException();

			}
			break;
		case 7:
			switch (temp.getSymbol()) {
			case "F":
				temp.setState(10);
				break;
			default:
				throw new IllegalArgumentException();

			}
			break;
		default:
			throw new IllegalArgumentException();
		}

		return temp;
	}

	public static void operate() {
		Key key3 = keyStack.pop(), key2 = keyStack.pop(), key1 = keyStack.pop();

		switch (key2.getSymbol()) {
		case "+":
			key1.setValue(key1.getValue() + key3.getValue());
			break;
		case "-":
			key1.setValue(key1.getValue() - key3.getValue());
			break;
		case "*":
			key1.setValue(key1.getValue() * key3.getValue());
			break;
		case "/":
			key1.setValue(key1.getValue() / key3.getValue());
			break;
		default:
			throw new IllegalArgumentException();
		}

		keyStack.push(key1);
	}

	public static void pushStack(Key temp, boolean newKey) {
		if (newKey == true) {
			keyStack.push(temp);
			tokenList.remove(0);
			printStack();
		} else {
			keyStack.push(temp);
			printStack();
		}
	}

	public static void printStack() {
		Stack<Key> tempStack = new Stack<Key>();

		while (!keyStack.isEmpty()) {
			tempStack.push((Key) keyStack.pop());
		}

		while (!tempStack.isEmpty()) {
			Key tempKey = (Key) tempStack.pop();
			System.out.print(tempKey);
			keyStack.push(tempKey);
		}

		System.out.print(" ");

		for (int i = 0; i < tokenList.size(); i++) {
			System.out.print(tokenList.get(i) + " ");
		}
		System.out.println();

	}

}



