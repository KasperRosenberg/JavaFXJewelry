//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;

class Share extends Valuable {
	private int amount;
	private int course;

	public Share(String name, int amount, int course) {
		super(name);
		this.amount = amount;
		this.course = course;
	}

	public int getAmount() {
		return amount;
	}

	public int getCourse() {
		return course;
	}

	public double getValue() {
		return getAmount() * getCourse();
	}

	public void setCourse(int newCourse) {
		course = newCourse;
	}

	public void stockCrash() {
		course = 0;
	}

	public String toString() {
		return String.format("Type: %s, Amount: %d, Course: %d,Value: %.2f", getName(), getAmount(), getCourse(),
				getValueWithVAT());
	}
}