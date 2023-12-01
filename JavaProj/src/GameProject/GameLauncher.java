package GameProject;

import java.util.Scanner;

public class GameLauncher {
	
	private QuestionDistributor quesDist = new QuestionDistributor();
	private GameSetting gamesetting = new GameSetting();
	private Lifeline lifeline = new Lifeline();
	
	private Question currentQuestion = null;
	String questionAnswer = "";
	
	GameLauncher(){}
	
	public void LaunchGameLoop(Scanner sc) {

		gamesetting.setQuestionCorrect(true); // Initialize to true at start of game
			
		while(gamesetting.getQuestionCorrect()) {
			
			System.out.println("\n---GAME INFO---");	
			
			// This ensures that we still have 
			currentQuestion = quesDist.distributeQuestion(gamesetting.getQuestionCount() , gamesetting.getDifficulty());
			
			//{
			if(currentQuestion == null) {
				//done with the game
				System.out.println("**********************************************");
		        System.out.println("*                                            *");
		        System.out.println("*          Congratulations!                  *");
		        System.out.println("*           You have won the game!           *");
		        System.out.println("*                                            *");
		        System.out.println("**********************************************");
				System.out.println("Returning to the Main Menu");
				reset();
			} else {
				// print round
				System.out.println("The current round is: " + gamesetting.getCurrentRound()); // Game settings class
				//logic: (int)Math.ceil((double)gamesetting.getQuestionCount()/3))
				
				//0 -for easy, 1 - hard
				//this will get the array for difficulty easy prize values and the use questionCount as index to access and progress
				System.out.println("Question Number "+ gamesetting.getQuestionCount() + " with a prize amount of $" + gamesetting.getPrizeValues(gamesetting.getDifficulty())[gamesetting.getQuestionCount()-1]+ "\n");				
				
				// Loops until we get a valid choice from player
				getValidChoiceLoop(sc);
				
				// Once we have a valid choice, we validate the user input to check
				// if choice was the correct answer
				checkPlayerAnswer(currentQuestion, questionAnswer);
				
				if(gamesetting.getQuestionCorrect() // guard to make sure this function only runs if player question correct
				&& ((GameSetting.getDifficulty()==0 && gamesetting.getQuestionCount() <= 9)
				|| (GameSetting.getDifficulty()==1 && gamesetting.getQuestionCount() <= 15))
				) { 
					// Check if end of round and ask player if they would like to walk away
					// After 3 questions - Easy, After 5 questions - hard,
					givePlayerOptionToWalkaway(sc);
				}

				
			}//if currentQustion!= null			
		}
	}
	
	private void givePlayerOptionToWalkaway (Scanner sc) {
		if( (GameSetting.getDifficulty()==0 && (gamesetting.getQuestionCount()-1)%3 == 0) || 
		    (GameSetting.getDifficulty()==1 && (gamesetting.getQuestionCount()-1)%5 == 0)) {
			
			String walkawaychoice = "";
			
			while(walkawaychoice.isEmpty() || walkawaychoice.isBlank()) {
				System.out.println("\n\n ==========================================================");
				System.out.println(" =               It is the end of the round!              =");
				System.out.println(" ==========================================================");
				System.out.println("\n              You have the option to walk away ");
				System.out.println(" If you walk away you get to keep your current prize worth:");
				System.out.println("                          $"+gamesetting.returnPrize());
				System.out.println("\n        Or you can choose to continue and earn more!\n");
				System.out.println("     But if you get a question wrong, you lose it all!\n");
				System.out.println(" ==========================================================");
				System.out.print(" Enter C to Continue or X to Walkaway:");
				
				walkawaychoice = sc.nextLine();
				
				switch(walkawaychoice) {
					case "C":
					case "c":
						System.out.println("\n\nYou chose to continue! Moving to next round!");
						break;
					case "X":
					case "x":
						System.out.println("\n\n**********************************************");
				        System.out.println("*                                            *");
				        System.out.println("*          You chose to walkaway!            *");
				        System.out.println("*                                            *");
				        System.out.println("**********************************************");
						System.out.println("\n\nYou get to keep your prize of $"+gamesetting.returnPrize()+"\n\n");
						System.out.println("Returning to the Main Menu...\n");
						reset();
						break;
					default:
						walkawaychoice = "";
				}
			}
		}
	}
	
	private void checkPlayerAnswer(Question currentQuestion, String questionAnswer) {
		
		gamesetting.setQuestionCorrect(currentQuestion.validateQuestion(questionAnswer));
		
		if(!gamesetting.getQuestionCorrect()) {
			//incorrect
			System.out.println("\n\nIncorrect Answer! You have Lost! Returning to the Main Menu\n\n");
			reset();
			
		// Add guard to make sure we wont run these statements if out-of-question bounds (9/easy, 15/hard)
		} else if (GameSetting.getDifficulty() == 0 && gamesetting.getQuestionCount() <= 9
				|| (GameSetting.getDifficulty() == 1 && gamesetting.getQuestionCount() <= 15)) {
			//Set current Prize Money Amount according to question
			gamesetting.setPrize(gamesetting.getPrizeValues(GameSetting.getDifficulty())[gamesetting.getQuestionCount()-1]);
			System.out.println("\n\nCorrect Answer! Prize is currently: $" + gamesetting.returnPrize() + "\n");
			gamesetting.addQuestionCount(); //increment question count
			gamesetting.updateRound();
		}		
	}
	
	private void getValidChoiceLoop(Scanner sc) {
		do {
			//printing question with choices
			System.out.println(currentQuestion.getString());
			questionAnswer = getPlayerChoice(sc);
			// Check if input is for life line
			if(questionAnswer.equals("L") || questionAnswer.equals("l")) {
				// Check if we can run life line
				if(gamesetting.canRunLifeline()) {
					// Check if life lines are still remaining
					if(GameSetting.getUsedLifeLinesCount() == 3) {
						System.out.println("That choice is invalid. You have no more lifelines. Please select only A, B, C or D");
						questionAnswer = "";
					} else {
						lifeline.runLifeline();
						questionAnswer = "";
					}
				} else {
					System.out.println("That choice is invalid. Please select only A, B, C or D");
					questionAnswer = "";
				}
			} 
		} while(questionAnswer.isEmpty() || questionAnswer.isBlank());
		// Since get player choice returns an empty string, this is not a valid choice and must continue to loop
	}
	
	private String getPlayerChoice(Scanner sc) {
		System.out.println("\n\n");
		if(gamesetting.canRunLifeline()) {
			System.out.println((3-GameSetting.getUsedLifeLinesCount() == 0 ? "Cannot Use Lifelines Anymore " : "Press (L) to Use lifeline ")+"("+(3-GameSetting.getUsedLifeLinesCount())+"/3) Remaining");
		}
		System.out.println("Please enter the letter of your choice (A, B, C, D):");
		String choice = sc.nextLine();
		
		switch(choice) {
			case "a":
			case "A":
			case "B":
			case "b":
			case "c":
			case "C":
			case "D":
			case "d":
			case "L":
			case "l":				
				break;
			default:
				System.out.println("That choice is invalid. Please select only A, B, C or D");
				choice = "";
		}
		
		return choice;
	}
	
	private void reset() {
		currentQuestion = null;
		questionAnswer = "";
		gamesetting.resetGame();
		quesDist.reset();
		GameSetting.resetLifelines();
	}
	
}
