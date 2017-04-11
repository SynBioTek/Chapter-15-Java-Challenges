package com.eclipse.EduardoZavala;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameClockAppEZ extends Application {

	@Override
	public void start(Stage stage) throws Exception {

		// Create and align timer label
		Label timerLabel = new Label("Time in sec: ");
		timerLabel.setStyle("-fx-font-size: 3em;");
		timerLabel.setAlignment(Pos.CENTER_LEFT);

		// Create timer text field
		TextField timer = new TextField();

		// Display 0 in text field
		timer.setText("0");

		// Format appearance of text field
		timer.setPrefColumnCount(5);
		timer.setStyle("-fx-font-size: 2.5em;");
		timer.setAlignment(Pos.CENTER);

		// Make the output field not editable
		timer.setEditable(false);

		// Create buttons
		Button staRes = new Button("Start/Resume");
		Button pause = new Button("Pause");
		Button reset = new Button("Reset");
		Button quit = new Button("Quit");

		// Create Hbox for timer label and timer
		// Gap between components is 10
		HBox hBox1 = new HBox();
		hBox1.setAlignment(Pos.TOP_CENTER);
		hBox1.setPadding(new Insets(10));
		hBox1.getChildren().addAll(timerLabel, timer);

		// Create Hbox for control buttons
		// Gap between components is 10
		HBox hBox2 = new HBox(10);
		hBox2.setAlignment(Pos.CENTER);
		hBox2.setPadding(new Insets(10));
		hBox2.getChildren().addAll(staRes, pause, reset, quit);

		// Create the border pane
		BorderPane pane = new BorderPane();

		// Designate Hbox location within BorderPane
		pane.setTop(hBox1);
		pane.setCenter(hBox2);

		// Convert text into integer and update counter
		EventHandler<ActionEvent> keyframeHandler = event1 -> {

			int count = Integer.parseInt(timer.getText());
			count++;
			timer.setText(String.valueOf(count));

		};

		// Create event handler to allow user interaction with Game Clock
		EventHandler<ActionEvent> staResHandler = event2 -> {

			// Build the keyframe.
			Duration sec = new Duration(1000);
			KeyFrame keyFrame = new KeyFrame(sec, keyframeHandler);

			// Build the timeline animation.
			Timeline timeline = new Timeline(keyFrame);

			// count indefinitely
			timeline.setCycleCount(Animation.INDEFINITE);
			timeline.play();

			// Pause the clock
			EventHandler<ActionEvent> pauseHandler = nestedEvent -> {
				timeline.pause();
			};

			// Set the handler on the Pause button
			pause.setOnAction(pauseHandler);

			// Reset the stop watch
			EventHandler<ActionEvent> resetHandler = nestedEvent -> {
				timeline.stop();
				timer.setText("0");
			};

			// Set the handler on the Pause/Stop button
			reset.setOnAction(resetHandler);
		};

		// Set the handler on the Start/Resume button
		staRes.setOnAction(staResHandler);

		// Exit the application
		EventHandler<ActionEvent> quitHandler = quitEvent -> {

			System.exit(0);

		};
		// Set the handler on the quit button
		quit.setOnAction(quitHandler);

		// Set the stage and show
		stage.setScene(new Scene(pane, 400, 120));
		stage.setTitle("Game Clock");
		stage.show();

	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
