/*
 * LL1 is a recirsive descent parser created by Seth Tummillo, a student at Illinois State University
 * I own the code written below and forbid anyone to use the code below without my written consent.
 * 
 */


import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class LL1 {
	
	public static String token;
	public static StringTokenizer st;

	public static void main(String[] args) {

		String expression = convertExp(args[0]);
		st = new StringTokenizer(expression, "()*/+-$", true );
		token = st.nextToken();
		try {
			e();
			System.out.println("Yes");
		} catch (IllegalArgumentException e) {
			System.out.println("No");
		} catch (NoSuchElementException e) {
			System.out.println("No");
		}		
	}
	
	public static void e() {
		switch (token) {
		case "n":
			t();ePrime();
			break;
		case "(":
			t();ePrime();
			break;
		default:
			throw new IllegalArgumentException();
		}
		return;
	}
	
	public static void ePrime(){
		switch (token) {
		case "+":
			token=st.nextToken();t();ePrime();
			break;
		case "-":
			token=st.nextToken();t();ePrime();
			break;
		case ")":
			return;
			//break;
		case "$":
			return;
			//break;
		default:
			throw new IllegalArgumentException();
		}
		return;
	}
	
	public static void t() {
		switch (token) {
		case "n":
			f();tPrime();
			break;
		case "(":
			f();tPrime();
			break;
		default:
			throw new IllegalArgumentException();
		}
		return;
	}
	
	public static void tPrime() {
		switch (token) {
		case "+":
			return;
			//break;
		case "-":
			return;
			//break;
		case "*":
			token=st.nextToken();f();tPrime();
			break;
		case "/":
			token=st.nextToken();f();tPrime();
			break;
		case ")":
			return;
			//break;
		case "$":
			return;
			//break;
		default:
			throw new IllegalArgumentException();
		}
		return;
	}
	
	public static void f() {
		switch (token) {
		case "n":
			token=st.nextToken();
			break;
		case "(":
			token=st.nextToken();e();token=st.nextToken();
			break;
		default:
			throw new IllegalArgumentException();
		}
		return;
		
	}
	
	
	
	//Converts the numbers in a string to n if they are valid numbers
	public static String convertExp(String initial) {
		String converted = ""; 
		
		StringTokenizer temp = new StringTokenizer(initial.concat("$"),"()*/+-$", true );
		while (temp.hasMoreTokens()) {
			String token = temp.nextToken();
			if (isNumeric(token)) {
				token = "n";
			}
			converted=converted.concat(token);
			
		}
		return converted;
	}
	
	//checks if a given string is a numeric number. Used in the convertExp method.
	public static boolean isNumeric(String strNum) {
	    try {
	        double d = Integer.parseInt(strNum);
	    } catch (NumberFormatException | NullPointerException nfe) {
	        return false;
	    }
	    return true;
	}

}




