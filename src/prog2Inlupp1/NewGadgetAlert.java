//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewGadgetAlert extends NewValuableAlert {
	private TextField nameField = new TextField();
	private TextField purchasePriceField = new TextField();
	private TextField conditionField = new TextField();

	public NewGadgetAlert() {
		super(AlertType.CONFIRMATION);
		GridPane gadgetGrid = new GridPane();
		gadgetGrid.setStyle("-fx-font-size: 14");
		gadgetGrid.addRow(0, new Label("Name: "), nameField);
		gadgetGrid.addRow(1, new Label("Price: "), purchasePriceField);
		gadgetGrid.addRow(2, new Label("Condition: "), conditionField);
		getDialogPane().setContent(gadgetGrid);
	}

	public String getName() {
		return nameField.getText();
	}

	public int getPurchasePrice() {
		return Integer.parseInt(purchasePriceField.getText());
	}

	public int getCondition() {
		return Integer.parseInt(conditionField.getText());
	}
}
