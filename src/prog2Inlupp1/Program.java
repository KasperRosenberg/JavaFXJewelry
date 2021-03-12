//Karo5568
//Kasper Rosenberg
package prog2Inlupp1;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Program extends Application {
	private ArrayList<Valuable> valuable = new ArrayList<Valuable>();
	private TextArea display;
	private MenuButton menuButton = new MenuButton("Choose Valuable");
	private MenuItem jewelry = new MenuItem("Jewelry");
	private MenuItem share = new MenuItem("Share");
	private MenuItem gadget = new MenuItem("Gadget");
	Valuable found = null;

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-font-size: 14");
		//addValuables();

		// Top BorderPane
		Label valuables = new Label("Valuables");
		valuables.setPadding(new Insets(5));
		valuables.setAlignment(Pos.CENTER);
		root.setTop(valuables);

		// Center BorderPane
		display = new TextArea();
		root.setCenter(display);
		display.setPadding(new Insets(5));
		display.setEditable(false);

		Scene scene = new Scene(root, 400, 280);
		primaryStage.setTitle("Register");
		primaryStage.setScene(scene);
		primaryStage.show();

		// Nedre BorderPane
		FlowPane flowLow = new FlowPane();
		flowLow.getChildren().add(new Label("New: "));
		menuButton.getItems().addAll(jewelry, share, gadget);
		flowLow.getChildren().add(menuButton);
		Button showButton = new Button("Show");
		Button stockMarketCrash = new Button("Stock Market Crash");
		flowLow.getChildren().add(showButton);
		showButton.setOnAction(new ShowHandler());
		flowLow.getChildren().add(stockMarketCrash);
		stockMarketCrash.setOnAction(new CrashHandler());
		jewelry.setOnAction(new JewelryHandler());
		share.setOnAction(new ShareHandler());
		gadget.setOnAction(new GadgetHandler());
		flowLow.setAlignment(Pos.CENTER);
		flowLow.setHgap(5);
		flowLow.setVgap(5);
		flowLow.setPadding(new Insets(5));
		root.setBottom(flowLow);

		// Högra BorderPane
		RadioButton nameButton = new RadioButton("Name");
		RadioButton valueButton = new RadioButton("Value");
		FlowPane flowRight = new FlowPane();
		flowRight.setOrientation(Orientation.VERTICAL);
		flowRight.getChildren().add(new Label("Sorty By:"));
		flowRight.getChildren().add(nameButton);
		flowRight.getChildren().add(valueButton);
		flowRight.setHgap(5);
		flowRight.setVgap(5);
		flowRight.setPadding(new Insets(5));
		nameButton.setSelected(true);
		nameButton.setOnAction(new NameButtonHandler());
		valueButton.setOnAction(new ValueButtonHandler());

		ToggleGroup group = new ToggleGroup();
		nameButton.setToggleGroup(group);
		valueButton.setToggleGroup(group);
		root.setRight(flowRight);
	}

	class GadgetHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			try {
				NewGadgetAlert dialog = new NewGadgetAlert();
				Optional<ButtonType> result = dialog.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) {
					String name = dialog.getName();
					int condition = dialog.getCondition();
					int purchasePrice = dialog.getPurchasePrice();
					if (name.trim().isEmpty()) {
						Alert msg = new Alert(AlertType.ERROR, "Empty Field!");
						msg.showAndWait();
						return;
					}
					if (purchasePrice <= 0) {
						Alert msg = new Alert(AlertType.ERROR, "Enter a price above 0");
						msg.showAndWait();
					}
					if (condition < 1 || condition > 10) {
						Alert msg = new Alert(AlertType.ERROR, "Enter a value between 1-10");
						msg.showAndWait();
					} else {
						Gadget gadget = new Gadget(name, purchasePrice, condition);
						valuable.add(gadget);
					}
				}
			} catch (NumberFormatException e) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Wrong format!");
				msg.showAndWait();

			}

		}
	}

	class ShareHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			try {
				NewShareAlert dialog = new NewShareAlert();
				Optional<ButtonType> result = dialog.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) {
					String name = dialog.getName();
					int amount = dialog.getAmount();
					int course = dialog.getCourse();
					if (name.trim().isEmpty()) {
						Alert msg = new Alert(AlertType.ERROR, "Empty Field!");
						msg.showAndWait();
						return;
					}
					if (amount < 1 || course < 0) {
						Alert msg = new Alert(AlertType.ERROR, "Enter a value higher then 0");
						msg.showAndWait();
					} else {
						Share share = new Share(name, amount, course);
						valuable.add(share);
					}
				}
			} catch (NumberFormatException e) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Wrong format!");
				msg.showAndWait();

			}

		}
	}

	class JewelryHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			try {
				NewJewelryAlert dialog = new NewJewelryAlert();
				Optional<ButtonType> result = dialog.showAndWait();
				if (result.isPresent() && result.get() == ButtonType.OK) {
					String name = dialog.getName();
					int numberOfStones = dialog.getStones();
					if (name.trim().isEmpty()) {
						Alert msg = new Alert(AlertType.ERROR, "Empty Field!");
						msg.showAndWait();
						return;
					}
					if (numberOfStones < 0) {
						Alert msg = new Alert(AlertType.ERROR, "Enter a value higher then 0");
						msg.showAndWait();

					} else {
						boolean gold = dialog.isGold();
						Jewelry jewelry = new Jewelry(name, numberOfStones, gold);
						valuable.add(jewelry);
					}
				}
			} catch (NumberFormatException e) {
				Alert msg = new Alert(AlertType.ERROR);
				msg.setContentText("Wrong format!");
				msg.showAndWait();
			}
		}
	}

	class CrashHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			for (Valuable v : valuable) {
				if (v instanceof Share) {
					((Share) v).stockCrash();
				}
			}

		}
	}

	class ShowHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			display.clear();
			for (Valuable things : valuable) {
				display.appendText(things.toString() + "\n");

			}
		}
	}

	class NameButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			display.clear();
			valuable.sort((v1, v2) -> v1.getName().compareToIgnoreCase(v2.getName()));
		}
	}

	class ValueButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			display.clear();
			valuable.sort(Comparator.comparing(Valuable::getValueWithVAT).reversed());
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

//	private void addValuables() {
//		valuable.add(new Jewelry("Ring", 4, true));
//		valuable.add(new Jewelry("Necklace", 6, false));
//		valuable.add(new Share("Stock", 5, 15));
//		valuable.add(new Gadget("Computer", 6000, 7));
//	}
}