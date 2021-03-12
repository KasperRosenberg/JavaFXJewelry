//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;

class Gadget extends Valuable {
	private int purchasePrice;
	private int condition;

	public Gadget(String name, int purchasePrice, int condition) {
		super(name);
		this.purchasePrice = purchasePrice;
		this.condition = condition;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getCondition() {
		return condition;
	}

	@Override
	public double getValue() {
		double value = (getCondition() / 10.0) * getPurchasePrice();
		return value;
	}

	public String toString() {
		return String.format("Type: %s, Purchase Price: %d,Condition: %d, Value: %.2f", getName(), getPurchasePrice(),
				getCondition(), getValueWithVAT());
	}
}