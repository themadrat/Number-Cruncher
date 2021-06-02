package numberCruncher;

import java.util.Arrays;
import java.util.Random;

public class NumberCruncherManager2 {										//This is a newer version of the initial class built from scratch on 05/31/21

	private int[] randomizedNumbers;
	private int[] numbersToRandomize;
	
	private int attempts;
	private int tracks;
	private int range;
	private int selectedMode;
	private int score = 0;
	private int level = 1;
	
	private int[] orderedNumberArray;
	
	Random numberRandomizer;
	
	//Accessor Methods Start
	public int[] getRandomizedNumbers() {
		return randomizedNumbers;
	}
	public void setRandomizedNumbers(int[] randomizedNumbers) {
		this.randomizedNumbers = randomizedNumbers;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public int getTracks() {
		return tracks;
	}
	public void setTracks(int tracks) {
		this.tracks = tracks;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getSelectedMode() {
		return selectedMode;
	}
	public void setSelectedMode(int selectedMode) {
		this.selectedMode = selectedMode;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	//Accessor Methods End
	
	public void getMode(int theMode) {
		/* Method				:	getMode
		 * 
		 * Method Parameters	:	int theMode
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method sets the variables needed for playing the game
		 * 							such as how many attempts are left, the number of tracks to 
		 * 							complete, the range, and tells the program which set of code to perform
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/31/21	Jared Shaddick	Initial Setup
		 * 							06/01/21	Jared Shaddick	Comments Added
		 */
		if (theMode == 1) {
			attempts = 5;
			tracks = 3;
			range = 10;
			selectedMode = 1;
		}
		
		if (theMode == 2) {
			attempts = 7;
			tracks = 5;
			range = 100;
			selectedMode = 2;
		}
		
		if (theMode == 3) {
			attempts = 11;
			tracks = 7;
			range = 1000;
			selectedMode = 3;
		}
	}
	
	private void theNumberArray() {
		orderedNumberArray = new int[range];
		int numberToUse = 1;
		for (int indexCounter = 0; indexCounter < orderedNumberArray.length; indexCounter++) {
			orderedNumberArray[indexCounter] = numberToUse;
			numberToUse++;
		}
		System.out.println(Arrays.toString(orderedNumberArray));
	}

	public void trackGenerator() {
		/*
		 * Method				:	trackGenerator
		 * 
		 * Method Parameters	:	None
		 * 
		 * Method Return		:	Void
		 * 
		 * Synopsis				:	This method will generate random numbers within a certain
		 * 							range and use them as the tracks for the player to guess
		 * 
		 * Modifications		:	Date:		Developer:		Notes:
		 * 							05/31/21	Jared Shaddick	Initial Setup
		 * 							06/01/21	Jared Shaddick	Comments Added
		 */
		numbersToRandomize = new int[range];
		
		 for (int indexCounter = 0; indexCounter < numbersToRandomize.length; indexCounter++) 
	        {
			 numbersToRandomize[indexCounter] = orderedNumberArray[indexCounter];
	        }
		numberRandomizer = new Random();
		for(int indexCounter = 0; indexCounter < numbersToRandomize.length; ++indexCounter)
	    	{
				numbersToRandomize[indexCounter] = numberRandomizer.nextInt(range);
				randomizedNumbers = numbersToRandomize;
	    	}
	}
}
