/**
 * 
 */
package com.eclipse.EduardoZavala;

import java.time.LocalDate;
import java.util.Locale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

public class VideoGameClassDemo extends Application {

    // Instance of VideoGameClassEZ 
    static VideoGameClassEZ userGame = new VideoGameClassEZ();
    
    private Stage stage; // Javafx stage
    private DatePicker releaseDate; // user selected release date
    private DatePicker today; // today's date used to compare releaseDate

    public static void main(String[] args) {
	
	// Specifying locale for time objects 
	Locale.setDefault(Locale.US); 
	launch(args);
	
	String[] gameTitles = userGame.getTitle(); //
	int[] days = userGame.getDays();
	double tradeVals[] = userGame.getTradeIn();
	
	System.out.printf("%-15s %-20s %-15s\n", "Game Title", "Days Since Release","Trade-in Value");
	System.out.println("------------    ------------------   --------------");
	// for loop to display data
	for (int i =0; i< gameTitles.length; i++)
	{
	 System.out.printf("%-20s %-15s $%.2f\n", gameTitles[i],  days[i],  tradeVals[i]);
	 
	}
	System.out.printf("\n");
	
	double total = userGame.calcTotal();
	System.out.print("Total trade-in Value: ");
	System.out.printf("$%.2f", total);
	
    }
  
    @Override
    public void start(Stage stage) throws Exception

    {
	this.stage = stage;
	stage.setTitle("Game_Trade Calculator");
	showWindow();
	stage.show();
	
    }
    
    public void showWindow()  {
	
	// Create DatePicker objects
	releaseDate = new DatePicker();
	today = new DatePicker();
	
	// Set current date
	today.setValue(LocalDate.now());

	// Labels and instructions
	Label instructions = new Label("Instructions:\n" 
		+ "1) Enter info from top down\n"
		+ "2) Push enter after input\n"
		+ "NOTE: Valid input will turn field green.\n"
		+ "Onced entered, you cannot edit input.\n"
		+ "Output will be in eclipse console.");
	
	Label gameName = new Label("Name of Your Game");
	Label oGprice = new Label("Enter Original Price (whole number)");
	Label gameRating = new Label("Enter Rating (0-10) ");
	Label releaseDatelabel = new Label("Release Date: (select a date)");

	// GridPane object and vertical space between elements
	GridPane gridPane = new GridPane();
	gridPane.setVgap(5);

	//gridPane.setAlignment(Pos.TOP_CENTER);
	
	// Add labels to gridPane (column, row)
	gridPane.add(instructions, 0, 0);
	gridPane.add(gameName, 0, 1);
	gridPane.add(oGprice, 0, 3);
	gridPane.add(releaseDatelabel, 0, 5);
	gridPane.add(gameRating, 0, 7);

	// Create Text fields
	TextField userGameF = new TextField();
	TextField inputPrice = new TextField();
	TextField userRatingF = new TextField();
	
	//instructions.setStyle("-fx-font-size:  1.5em;");
	//instructions.setAlignment(Pos.CENTER_LEFT);
	
	
	// Adjust the size of the Text fields
	inputPrice.setPrefColumnCount(5);
	userRatingF.setPrefColumnCount(5);

	ToggleButton toggleButton1 = new ToggleButton("Calculate Trade In");
	

	// Add text fields and calendar to gridPane
	gridPane.add(userGameF, 0, 2);
	gridPane.add(inputPrice, 0, 4);
	gridPane.add(releaseDate, 0, 6);
	gridPane.add(userRatingF, 0, 8);
	gridPane.add(toggleButton1, 0, 9);
	
	
	// Specify column widths
	//gridPane.getColumnConstraints().add(new ColumnConstraints(100)); 

	HBox hBox = new HBox();
	hBox.setStyle("-fx-padding: 40;");
	hBox.getChildren().add(gridPane);
	
	

	Scene scene = new Scene(hBox, 350, 450);
	stage.setScene(scene);

	// Disable future dates as options for release date.
	// Nor my comfort zone but I got it to work
	final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
	    @Override
	public DateCell call(final DatePicker datePicker) {
	return new DateCell() {
	 @Override
	 public void updateItem(LocalDate item, boolean empty) {
	     super.updateItem(item, empty);

	if (item.isAfter(today.getValue())) 
	{
	    // Disable dates after today and color fields red    
	    setDisable(true);
	    setStyle("-fx-background-color: #ffc0cb;");
	}}};}};
	
	releaseDate.setDayCellFactory(dayCellFactory);
	// releaseDate.setValue(LocalDate.now());
	
	// Nested Event handlers to insure user enters information in a specific order
		 userGameF.setOnAction(event1 -> {

		     // Obtain input as a String
		     String inputText = userGameF.getText();
		     
		     // Change button color to green after user has acceptable input
		     userGameF.setStyle("-fx-background-color: #00ff00; ");
		     
		     // Prevent user from changing input once entered 
		     userGameF.setEditable(false);
		     
		     // Pass game title to setTitle method
		     userGame.setTitle(inputText);
		  
	// Event handler for inputPrice
		 inputPrice.setOnAction(event2 -> {
		     
		     	// Obtain input as a String from text field
		     	String inputPriceStr = inputPrice.getText();
		     	
		     	// Get length of the String to compare with max length
		     	int length = inputPrice.getText().length();
		     	
		     	final int MAX = 10; // limit number of characters
		     	
		     	// Validate user input allowing only numbers and limit input size
		     	if (inputPriceStr.matches("[0-9]*") && length < MAX ) {
		     	
		     	// Parse String input
			int price = Integer.parseInt(inputPriceStr);
			
			// Change button color to green after user has acceptable input
			 inputPrice.setStyle("-fx-background-color: #00ff00; ");
			 
			// Prevent user from changing input once entered 
			 inputPrice.setEditable(false);
			 
			 // Pass the price of original game to setGamePrice method
			 userGame.setGamePrice(price);
			 
		// Event handler for the Date
		 releaseDate.setOnAction(event3 -> {
			     
		     	// Change button color to green after user selects a date
		     	releaseDate.setStyle("-fx-background-color: #00ff00; ");  
		     	
		     	// Pass the user selected date to the setReleaseDate method
		     	userGame.setReleaseDate(releaseDate.getValue());
			 
		// Event handler on user input rating
		userRatingF.setOnAction(event4 -> {

			 // Obtain input as a String from text field
			String inputRatingField = userRatingF.getText();

			// Validate user input allowing only number from 0-10
			if (inputRatingField.matches("[0-9]?|10")) {
			    
			// Parse String input
			int number = Integer.parseInt(inputRatingField);
				 	    
			// Change button color to green after user has acceptable input
			 userRatingF.setStyle("-fx-background-color: #00ff00; "); 
			 
			// Prevent user from changing input once entered
			 userRatingF.setEditable(false);
			
			// Pass the rating as an integer 
			 userGame.setGameRating(number);
			
			// ToggleButton to calculate the trade_in value from user input 
			toggleButton1.setOnAction(a -> { 
			userGame.calGamePrice();
			
			stage.close();
			});}}); });}}); });
	 
		 
	 
	
    }
    
}