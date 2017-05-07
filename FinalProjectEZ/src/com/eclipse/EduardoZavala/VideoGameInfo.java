package com.eclipse.EduardoZavala;


import java.time.LocalDate;

/**
 * @author Eduardo Zavala
 *
 */
public class VideoGameInfo {
   
    // Set the release dates for example games
    private LocalDate date1 = LocalDate.of(2016, 01, 01);
    private LocalDate date2 = LocalDate.of(2004, 11, 20);
    private LocalDate date3 = LocalDate.of(1996, 04, 18);
    
    
    public void GameExamples(){

    
  // Instance of VideoGameClassEZ classes
  VideoGameClassEZ game1 = new VideoGameClassEZ();		
  VideoGameClassEZ game2 = new VideoGameClassEZ();   		
  VideoGameClassEZ game3 = new VideoGameClassEZ();
  
  // Store data for game number 1 and pass it  
  //as an argument to designated methods
   game1.setTitle("GTA");
   game1.setGamePrice(50);
   game1.setReleaseDate(date1);
   game1.setGameRating(9);
   
   //Store data for game number 2 and pass it  
   //as an argument to designated methods 
   game2.setTitle("Medal of Honor");
   game2.setGamePrice(60);
   game2.setReleaseDate(date2);
   game2.setGameRating(10);
   
   // Store data for game number 1 and pass it  
   // as an argument to designated methods
   game3.setTitle("Metal Slug");
   game3.setGamePrice(20);
   game3.setReleaseDate(date3);
   game3.setGameRating(10);
   
   
  
    }
    	

    		// Example information for game 3
    		//userGame.setTitle(gameName);

    		//System.out.println("Enter the release date ");
    		// userGame.setReleaseDate();

    		// System.out.println("Enter game rating");
    		// userGame.setRating();

    		// LocalDate today = LocalDate.now();
    		// format(today, "M/d/yyyy");
    		// LocalDate releaseDate = LocalDate("1999, 12, 1");
    		// LocalDate tomorrow = today.plus(0, ChronoUnit.DAYS);
    		// LocalDate yesterday = tomorrow.minusDays(60);

    		// System.out.print(exGame1.getTitle() + exGame1.getReleaseDate() +
    		// exGame1.getPlatform());
    		// System.out.print(exGame2.getTitle() + exGame2.getReleaseDate() +
    		// exGame2.getPlatform());
    		// System.out.print(exGame3.getTitle() + exGame3.getReleaseDate() +
    		// exGame3.getPlatform());

    	

    	

	

    


}
