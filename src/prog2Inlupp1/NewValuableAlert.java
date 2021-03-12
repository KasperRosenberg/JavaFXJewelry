//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class NewValuableAlert extends Alert {
	private TextField nameField = new TextField();
	public NewValuableAlert(AlertType confirmation) {
		super(AlertType.CONFIRMATION);
		GridPane jewelryGrid = new GridPane();
		jewelryGrid.setStyle("-fx-font-size: 14");
		jewelryGrid.addRow(0, new Label("Name: "), nameField);
	}
}
