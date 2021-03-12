//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;

//Superklassen
abstract class Valuable {
	private String name;
	private static final double moms = 1.25;

	public Valuable(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// Gör abstract
	abstract public double getValue();

	public final double getValueWithVAT() {
		return getValue() * moms;
	}
}