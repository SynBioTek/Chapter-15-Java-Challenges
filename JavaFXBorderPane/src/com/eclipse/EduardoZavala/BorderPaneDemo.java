package com.eclipse.EduardoZavala;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/*
 * This program demonstrates the use of BorderPane class
 * It allows the user to enter only numbers and squares them. 
 * 
*/

public class BorderPaneDemo extends Application {
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) {

		// Create labels
		Label top = new Label("Enter Whole Number: ");
		Label bottom = new Label("Square of Number: ");

		// Create text fields
		TextField userInput = new TextField();
		TextField userOutput = new TextField();

		// Adjust the size of the Text fields
		userInput.setPrefColumnCount(5);
		userOutput.setPrefColumnCount(5);

		// Make the output field not editable
		userOutput.setEditable(false);

		// Create two horizontal boxes
		HBox hBox = new HBox();
		HBox hBox2 = new HBox();

		// Specify margins and paddings
		hBox.setPadding(new Insets(10));
		hBox.setSpacing(10);
		hBox2.setPadding(new Insets(10, 10, 20, 10));
		hBox2.setSpacing(10);

		// Add labels and text fields
		hBox.getChildren().addAll(top, userInput);
		hBox2.getChildren().addAll(bottom, userOutput);

		// Create the border pane
		BorderPane pane = new BorderPane();

		// Designate location within BorderPane
		pane.setCenter(hBox);
		pane.setBottom(hBox2);

		// Event handler
		userInput.setOnAction(event -> {

			// Obtain input as a String
			String inputText = userInput.getText();

			// Calculate square for whole numerical input
			if (inputText.matches("[0-9]*")) {

				// Parse String input
				int number = Integer.parseInt(inputText);

				// Square the input number
				int square = number * number;

				// Store result in userOutput field
				userOutput.setText(String.valueOf(square));

			}

		});

		// Set and show stage
		stage.setScene(new Scene(pane, 250, 100));
		stage.setTitle("Square Calculator");
		stage.show();
	}

}
