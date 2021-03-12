//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewShareAlert extends NewValuableAlert {
	private TextField nameField = new TextField();
	private TextField amountField = new TextField();
	private TextField courseField = new TextField();

	public NewShareAlert() {
		super(AlertType.CONFIRMATION);
		GridPane shareGrid = new GridPane();
		shareGrid.setStyle("-fx-font-size: 14");
		shareGrid.addRow(0, new Label("Name: "), nameField);
		shareGrid.addRow(1, new Label("Amount: "), amountField);
		shareGrid.addRow(2, new Label("Course: "), courseField);
		getDialogPane().setContent(shareGrid);
	}

	public String getName() {
		return nameField.getText();
	}

	public int getAmount() {
		return Integer.parseInt(amountField.getText());
	}

	public int getCourse() {
		return Integer.parseInt(courseField.getText());
	}
}
