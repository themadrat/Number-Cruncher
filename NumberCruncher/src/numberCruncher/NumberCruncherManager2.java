package numberCruncher;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.regex.Pattern;

public class NumberCruncherManager2 {										//This is a newer version of the initial class built from scratch on 05/31/21

	private int[] randomizedNumbers;
	private int[] numbersToRandomize;
	
	private int tracks;
	private int range;
	private int selectedDifficulty;
	private int score = 0;
	private int level = 1;
	private int modeIndexCounter;
	private int[] checkResultArray;
	
	private boolean tracksChecked;
	private boolean numberTooLow;
	private boolean numberTooHigh;
	
	private int[] orderedNumberArray;
	
	Random numberRandomizer;
	
	//Accessor Methods Start
	public int[] getRandomizedNumbers() {
		return randomizedNumbers;
	}
	
	public int getTracks() {
		return tracks;
	}
	
	public int getRange() {
		return range;
	}
	
	public int getSelectedMode() {
		return selectedDifficulty;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getLevel() {
		return level;
	}
	
	public boolean getTracksChecked() {
		return tracksChecked;
	}
	
	public boolean isNumberHigh() {
		return numberTooHigh;
	}

	public boolean isNumberLow() {
		return numberTooLow;
	}
	
	public int[] getResult() {
		return checkResultArray;
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
			tracks = 3;
			range = 10;
			selectedDifficulty = 1;
		}
		
		if (theMode == 2) {
			tracks = 5;
			range = 100;
			selectedDifficulty = 2;
		}
		
		if (theMode == 3) {
			tracks = 7;
			range = 1000;
			selectedDifficulty = 3;
		}
	}
	
	public void theNumberArray() {
		orderedNumberArray = new int[range];
		int numberToUse = 1;
		for (int indexCounter = 0; indexCounter < orderedNumberArray.length; indexCounter++) {
			orderedNumberArray[indexCounter] = numberToUse;
			numberToUse++;
		}
		trackGenerator();
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
		randomizedNumbers = new int[tracks];
		numbersToRandomize = new int[1000];
		int indexCounter;
		int minRandom = 1;
		int maxRandom = range;
		numberRandomizer = new Random();
		for (indexCounter = 0; indexCounter < numbersToRandomize.length; indexCounter++) {
				numbersToRandomize[indexCounter] = numberRandomizer.nextInt(maxRandom + minRandom) + minRandom;
		}
		
		System.out.println(Arrays.toString(randomizedNumbers));
	}
	
	public void checkTracks(int[] numbersGuessed) {
		checkResultArray = new int[tracks];
		for (int indexCounter = 0; indexCounter < checkResultArray.length; indexCounter++) {
			if (numbersGuessed[indexCounter] == randomizedNumbers[indexCounter]) {
				checkResultArray[indexCounter] = 1;
			}
			else {
				checkResultArray[indexCounter] = 0;
			}
		}
	}
	
	public void levelUp(boolean tracksMatch) {
		range += 10;
		level++;
		score += 100;
		
		theNumberArray();
	}
}
