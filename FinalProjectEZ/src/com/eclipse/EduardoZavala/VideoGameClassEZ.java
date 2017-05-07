/**
 * 
 */
package com.eclipse.EduardoZavala;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * biggest gamer complaint is not having an easy way to find the trade-in value
 * of their games. Program Requirements (80% of Final Project Grade) At a
 * minimum, your application should contain the following:
 * 
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
public class VideoGameClassEZ {

	private String gameTitle;
	private int oGprice;
	private double tradeInVal, total;
	private int rating;
	private int days;

	// Instance of LocalDate class and declaration of date variable
	private LocalDate releaseDate;
	private LocalDate today = LocalDate.now();

	/**
	 * No arg-constructor initializes variables to not available (N/A)
	 */
	public VideoGameClassEZ() {
		gameTitle = "N/A";
		oGprice = 0;
		releaseDate = LocalDate.now();
		rating = (1);
	}

	/**
	 * Constructor accepts input of various types to initialize variables
	 */
	public VideoGameClassEZ(String inTitle, double price, LocalDate inDate, int inRate) {
		gameTitle = inTitle;
		oGprice = 0;
		releaseDate = inDate;
		rating = inRate;

	}

	public void setTitle(String inputTitle) {
		gameTitle = inputTitle;
		System.out.println("Game Title: " + gameTitle);
	}
	
	public void setGamePrice(int price) {
	    oGprice =  price;
	    
	    if (oGprice > 999)
	    {
		 System.out.println("seems like an unreasonable price, but my job is to calculate");
	    }
	    System.out.println("Original Price: $" + oGprice);
	}

	/**
	 * The setDate method
	 * 
	 * @param localDate
	 * 
	 */
	public void setReleaseDate(LocalDate inputDate) {

		releaseDate = inputDate;

		days = (int) ChronoUnit.DAYS.between(releaseDate, today);

		System.out.println("Days since release: " + days);
		System.out.println("date: " + releaseDate);

		// keyboard.close();
	}

	public void setGameRating(int inputRating) {
		rating = inputRating;

		System.out.println("Rating is: " + rating);
		// System.out.println("total is :" + total);

		
	}

	public String getTitle() {
		return gameTitle;

	}

	public LocalDate getReleaseDate() {
		return releaseDate;

	}

	public int getRating() {
	    return rating;
	}
	
	public void calGamePrice(){
	    
	 // 5 dollars are added to trade-in value if rating is >8
	 final int CREDIT = 5;

	 // 10% deduction for every 60 days since release
	 final double PERCENT = .1;

	 int multOf60days = days / 60;

	 // Total percent loss
	 double percentLoss = multOf60days * PERCENT;

	 double discount = oGprice * percentLoss;

	 if (rating >= 8) {
	 tradeInVal = (oGprice - discount) + CREDIT;

	 } else {
	 tradeInVal = oGprice - discount;
	 }

	 if (tradeInVal < 0)
	 {
	     System.out.println("Sorry, currently your game has no trade-in value");
	 }
	 else
	System.out.print("Trade-in value : $");     
	System.out.printf("%.2f", + tradeInVal);
	}
	
	public void calcTotal(){
	    
	}
	
	public double getGamePrice(){
	    
	    return tradeInVal;
	}

}
