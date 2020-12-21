
public class Key {
	private int state;
	private String symbol;
	private int value;
	
	public Key(String symbol, int state, int value) {
		this.state = state;
		this.symbol = symbol;
		this.value = value;
	}
	
	

	public Key() {
		this.state = 0;
		this.symbol = "-";
		this.value = 0;
	}



	public int getState() {
		return state;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public void setValue(int value) {
		this.value = value;
	}



	@Override
	public String toString() {
		if (symbol == "n")
			return "[" + value + ":" + state + "]";
		else
			return "[" + symbol + ":" + state + "]";
	}
	
	
	
	
	
}



