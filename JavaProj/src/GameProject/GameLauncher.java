package GameProject;

import java.util.Scanner;

public class GameLauncher {
	
	private QuestionDistributor quesDist = new QuestionDistributor();
	private GameSetting gamesetting = new GameSetting();
	private Lifeline lifeline = new Lifeline();
	
	GameLauncher(){}
	
	public void LaunchGameLoop(Scanner sc) {

		
		gamesetting.setQuestionCorrect(true); // replace with game settings
		
		
		//check difficulty
			
			while(gamesetting.getQuestionCorrect()) {
				
				//check difficulty, if hard --> only available in round 2 and 3, if easy --> round 1
				
				if (gamesetting.getDifficulty() == 1) {
					
				}
				
				System.out.println("\n---GAME INFO---");	
				// print round
				System.out.println("The current round is: " + gamesetting.getCurrentRound()); // Game settings class
				//logic: (int)Math.ceil((double)gamesetting.getQuestionCount()/3))
				
				//0 for easy
				//this will get the array for difficulty easy prize values and the use questionCount as index to access and progress
				System.out.println("Question Number "+ gamesetting.getQuestionCount() + " with a prize amount of $" + gamesetting.getPrizeValues(gamesetting.getDifficulty())[gamesetting.getQuestionCount()-1]+ "\n");
			
				
				Question currentQuestion = quesDist.distributeQuestion(gamesetting.getQuestionCount() , gamesetting.getDifficulty());
				
				
				//{
				if(currentQuestion == null) {
					//done with the game
					System.out.println("**********************************************");
			        System.out.println("*                                            *");
			        System.out.println("*          Congratulations!                  *");
			        System.out.println("*           You have won the game!           *");
			        System.out.println("*                                            *");
			        System.out.println("**********************************************");
					System.out.println("No more questions in bank.");
					System.out.println("Returning to the Main Menu");
					gamesetting.resetGame();
					quesDist.reset();
				} else {
			
					//printing question with choices
					System.out.println(currentQuestion.getString());
					
					//check if lifelines are remaining, if 3 all lifelines consumed
					if (gamesetting.getUsedLifeLines().length == 3) {
						//proceed, no lifelines left
						String questionAnswer = getValidChoiceLoop(sc);
						validateUserInput(currentQuestion, questionAnswer);
					}else {
						//still lifelines left
						System.out.println("You still have lifelines left, would you like to use a lifeline?(enter y or n)");
						String choice = sc.nextLine();
						switch(choice) {
							case "y":
							case "Y":
								//call lifeline
								lifeline.runLifeline();
								break;
							case "N":
							case "n":
								//proceed with the game
								String questionAnswer = getValidChoiceLoop(sc);
								validateUserInput(currentQuestion, questionAnswer);
								break;
						}
						
					}//lifeline closing bracket
					
				}//if currentQustion!= null			
			}
	}
	
	private void validateUserInput(Question currentQuestion, String questionAnswer) {
		
		if(!questionAnswer.isBlank()) {
			gamesetting.setQuestionCorrect(currentQuestion.validateQuestion(questionAnswer));
			
			if(!gamesetting.getQuestionCorrect()) {
				//incorrect
				System.out.println("Incorrect Answer! You have Lost! Returning to the Main Menu\n\n");
				gamesetting.resetGame();
				quesDist.reset();
			} else {
				//if correct
				//add prize money
				gamesetting.addPrize(gamesetting.getPrizeValues(gamesetting.getDifficulty())[gamesetting.getQuestionCount()-1]);
				System.out.println("Correct Answer! Prize is currently: $" + gamesetting.returnPrize() + "\n");
				gamesetting.addQuestionCount(); //increment question count
				gamesetting.updateRound();
			}
		}
		
	}
	
	private String getValidChoiceLoop(Scanner sc) {
		System.out.println("\n\nPlease enter the letter of your choice (A, B, C, D):");
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
				break;
			default:
				System.out.println("That choice is invalid. Please select only A, B, C or D");
				choice = "";
		}
		
		return choice;
	}
	
	
}
