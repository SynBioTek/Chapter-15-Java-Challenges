package com.eclipse.EduardoZavala;

/**
 * This program has a method that accepts an integer argument 
 * and returns the sum of all the integers 
 * from 1 up to the number passed as an argument. 
 * For example, if 5 is passed as an argument, 
 * the method will return the sum of 5+4+3+2+1 which is = 15 
 *
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SumofNumbersDemo extends Application {
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) {

		// Create labels
		Label top = new Label("Enter Whole Positive Number: ");
		Label bottom = new Label("Sum of your Number: ");

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

			// Calculate sum for whole numerical input
			if (inputText.matches("[0-9]*")) {

				// Parse String input
				int number = Integer.parseInt(inputText);

				// Sum the input number
				int sum = sumOfNumber(number);

				// Store result in userOutput field
				userOutput.setText(String.valueOf(sum));

			}

		});

		// Set and show stage
		stage.setScene(new Scene(pane, 300, 100));
		stage.setTitle("Sum of a Number Calculator");
		stage.show();
	}

	// Recursive method to sum a number
	public static int sumOfNumber(int number) {

		if (number == 0)
			return 0; // Base case
		else
			return number + sumOfNumber(number - 1);

	}
}
