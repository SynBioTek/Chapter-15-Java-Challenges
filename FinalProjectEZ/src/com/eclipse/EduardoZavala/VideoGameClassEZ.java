/**
 * 
 */
package com.eclipse.EduardoZavala;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A VideoGame class file that includes (at a minimum): Variables for the title,
 * price, release date, rating (out of 10), etc. Two constructors for the
 * VideoGame class. Getters/Setters for all variables. A method for calculating
 * the trade-in value of the game. A method for calculating the total sum of all
 * game trade-in values.
 * 
 * 
 * NOTE: The trade-in value depends on the number of days since the game was
 * released. Every 60 days, the game loses 10% of its value. 
 * 
 * Additionally, any game with a rating of 8 or higher, will add $5 credit
 * toward the trade-in value.
 * 
 * After the user has seen the current trade-in value of their game, you'll need
 * to display the total trade-in value of all four games. Hint: An array.
 * 
 
 * 
 * 
 * @author Eduardo Zavala
 *
 */
public class VideoGameClassEZ  {
    	
    	// Instance of LocalDate class 
 	private LocalDate today = LocalDate.now();// Current date
 	
    	final private int SIZE = 4; // final variable for array sizes
    	
	private String gameTitles[] = new String[SIZE]; //array for game titles
	private int oGprice[] = new int[SIZE]; // array for original prices
	// Array to hold game release dates
	private LocalDate[] releaseDates = new LocalDate[SIZE];
	private int ratings[] = new int[SIZE]; // array for ratings
	
	private int[] days = new int[SIZE]; // total days from today and input release date
	private double[] tradeInVal = new double[SIZE]; // array for trade-in value
	
	/**
	 * No arg-constructor
	 */
	public VideoGameClassEZ() {
		
	}

	/**
	 * Constructor accepts various types of arrays 
	 */
	public VideoGameClassEZ(String[] titles, int[] price, LocalDate[] inDate, int[] inRate) {
	     
	    	gameTitles = titles;
		oGprice = price; 
		releaseDates = inDate;
		ratings = inRate;
	}
	
	/**
	 * The setTitle method accepts a string as an argument 
	 * it is assigned to 3rd index on array. The other three titles are hard-coded
	 * @param userGame 
	 */
	public void setTitle(String userGame) {
	    	
	    gameTitles[0] = "GTA"; //Example game 1
	    gameTitles[1] = "Kong"; //Example game 2
	    gameTitles[2] = "Metal Slug"; //Example game 3
	    gameTitles[3] = userGame; // user game title
	}
	
	/**
	 * The setGamePrice method accepts an integer and sets
	 * the original price for user game
	 * @param price the original price of the game
	 */
	public void setGamePrice(int userOgPrice) {
	    
	    oGprice[0] = 50; //Example game 1
	    oGprice[1] = 60; //Example game 2
	    oGprice[2] = 19; //Example game 3
	    oGprice[3] = userOgPrice; // user game price
	}

	/**
	 * The setDate method uses a for loop to determine the number of days 
	 * between respective indexes, one of which contains the user input release date.
	 * @param inputDate user selected date 
	 */
	public void setReleaseDate(LocalDate inputDate) {
	   
	    releaseDates[0] = LocalDate.of(2016,01,01); //Example game 1
	    releaseDates[1] = LocalDate.of(2001,11,20); //Example game 2
	    releaseDates[2] = LocalDate.of(1996,07,18); //Example game 3
	    releaseDates[3] = inputDate; // user game release date
	    
	    // For loop compares various dates in array to today's date
	    for (int i =0; i< releaseDates.length; i++)
	    {
	     // Parse into an integer and store the difference of release day and today's date	
	    days[i] = (int) ChronoUnit.DAYS.between(releaseDates[i], today);
	  
	    }
	    
	}

	/**
	 * The setGameRating method accepts an integer for the rating
	 * @param inputRating from [1-10]
	 */
	public void setGameRating(int inputRating) {
	    
	    ratings[0] = 10; //Example game 1
	    ratings[1] = 10; //Example game 2
	    ratings[2] = 10; //Example game 3
	    ratings[3] = inputRating; //user game rating
	}

	
	/**
	 * The calGamePrice calculates the trade-in value of the game based on the number of
	 * days since release and if rating is >8 it adds $5 to final trade-in value.
	 */
	public void calGamePrice(){
	    
	 // 5 dollars to be added to trade-in value 
	 final int CREDIT = 5;

	 // 10% deduction for every 60 days since release
	 final double PERCENT = .1;
	 
	 // Array used to obtain values from the division of days by 60
	 int multOf60days[] = new int[SIZE];

	// For loop for calculating trade-in value
	 for (int i =0; i< days.length; i++){
	     multOf60days[i] = days[i] /60;
	  
	 // Total percent loss
	 double percentLoss = multOf60days[i] * PERCENT;

	 // Amount to be discounted from original price
	 double discount = oGprice[i] * percentLoss;

	 // Determine whether to add 5 dollars to trade-in value based on rating
	 if (ratings[i] >= 8) {
	     
	     tradeInVal[i] = (oGprice[i] - discount) + CREDIT;
	     
	     //System.out.println("trade in after 5:" + tradeInVal[i]);
	 }
	 else {
	 tradeInVal[i] = (oGprice[i] - discount);
	 
	 }}
}
	
	/**
	 * Calculates the total trade-in value of all four games
	 * @return total after program has determined trade-in value
	 */
	public double calcTotal(){
	    double total = 0; // Initialize accumulator 
	    for (int i=0; i< tradeInVal.length; i++)
		total+=tradeInVal[i]; 
	return total; // Total trade-in value
}
	
	/**
	 * The getTitle method returns the game title
	 * @return gameTitles user entered
	 */
	public String[] getTitle() {
	    
	    return gameTitles;

	}

	/**
	 * The getDays method returns the number of days array 
	 * @return days number of days array
	 */
	public int[] getDays() {
		return days;
	}

	/**
	 * The getRating method return a number from [1-10]
	 * @return ratings user's input rating
	 */
	public int[] getRating() {
	    return ratings;
	}
	
	/**
	 * the getGamePrice 
	 * @return tradeInVal the trade-in value of game
	 */
	public double[] getTradeIn(){
	    
	    for (int i =0; i< tradeInVal.length; i++)
	    {

	    if (tradeInVal[i] <= 0)
		 
			tradeInVal[i] = 0;     
	    }
	    return tradeInVal; 
	
}
}
