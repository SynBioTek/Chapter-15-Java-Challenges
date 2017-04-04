
package com.eclipse.EduardoZavala;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * This program displays two buttons in a horizontal box. Clicking the buttons
 * changes the background color of the button.
 */

public class ColorChangingDemo extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		// Create two buttons
		Button button = new Button("Red");
		Button button2 = new Button("Yellow");

		// First event handler
		EventHandler<ActionEvent> handler = event -> {
			// Change button color to red
			button.setStyle("-fx-background-color: #ff0000; ");

		};
		// Set the handler on the red button
		button.setOnAction(handler);

		// Second event handler
		EventHandler<ActionEvent> handler2 = event -> {
			// Change button color to yellow
			button2.setStyle("-fx-background-color: #ffff00; ");

		};
		// Set the handler on the yellow button
		button2.setOnAction(handler2);

		// Create pane and add two buttons to it.
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(10));
		hBox.getChildren().addAll(button, button2);

		// Set and show stage
		Scene scene = new Scene(hBox, 250, 50);
		stage.setTitle("Color Changing Buttons");
		stage.setScene(scene);
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}