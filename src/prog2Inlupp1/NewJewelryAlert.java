//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewJewelryAlert extends NewValuableAlert {
	private TextField nameField = new TextField();
	private TextField stonesField = new TextField();
	private CheckBox box = new CheckBox("Gold?");

	public NewJewelryAlert() {
		super(AlertType.CONFIRMATION);
		GridPane jewelryGrid = new GridPane();
		jewelryGrid.setStyle("-fx-font-size: 14");
		jewelryGrid.addRow(0, new Label("Name: "), nameField);
		jewelryGrid.addRow(1, new Label("Stones: "), stonesField);
		jewelryGrid.addRow(2, box);
		getDialogPane().setContent(jewelryGrid);
	}

	public String getName() {
		return nameField.getText();
	}

	public int getStones() {
		return Integer.parseInt(stonesField.getText());
	}

	public boolean isGold() {
		return box.isSelected();
	}
}
