//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;

//Smyckesklassen
class Jewelry extends Valuable {
	private int numberOfStones;
	private Boolean gold;

	public Jewelry(String name, int numberOfStones, Boolean gold) {
		super(name);
		this.numberOfStones = numberOfStones;
		this.gold = gold;
	}

	public int getNumberOfStones() {
		return numberOfStones;
	}

	public Boolean getGold() {
		return gold;
	}

	public double getValue() {
		if (gold == true) {
			return getNumberOfStones() * 500 + 2000;
		} else {
			return getNumberOfStones() * 500 + 700;
		}

	}

	public String toString() {
		return String.format("Type: %s, Gemstones: %d, Material: %s, Value: %.2f", getName(), getNumberOfStones(),
				getGold(), getValueWithVAT());
	}
}
