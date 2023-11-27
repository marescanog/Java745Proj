package GameProject;

import java.util.Scanner;

public class GameLauncher {
	
	private QuestionDistributor quesDist = new QuestionDistributor();
	private GameSetting gamesetting = new GameSetting();
	
	GameLauncher(){}
	
	public void LaunchGameLoop(int difficulty, Scanner sc) {

		boolean questionCorrect = true; // replace with game settings
		
		// print round
		System.out.println("Round Number " + "1"); // Game settings class
		
		while(questionCorrect) {
			
			//0 for easy
			//this will get the array for difficulty easy prize values and the use questionCount as index to access and progress
			System.out.println("\n\nQuestion Number "+ gamesetting.getQuestionCount() + " with a prize amount of " + gamesetting.getPrizeValues(difficulty)[gamesetting.getQuestionCount()-1]+ "\n");
		
			
			Question currentQuestion = quesDist.distributeQuestion(gamesetting.getQuestionCount() , difficulty);
			
			System.out.println(currentQuestion.toString());
			
			String choice = getValidChoiceLoop(sc);
			
			if(!choice.isBlank()) {
				questionCorrect = currentQuestion.validateQuestion(choice);
				
				if(!questionCorrect) {
					System.out.println("Incorrect Answer! You have Lost! Returning to the Main Menu\n\n");
					//reset prize 
					gamesetting.resetPrize();
				} else {
					//if correct
					//add prize money
					gamesetting.addPrize(gamesetting.getPrizeValues(difficulty)[gamesetting.getQuestionCount()-1]);
					System.out.println("Correct Answer! Prize is currently: " + gamesetting.returnPrize() + "\n");
					gamesetting.addQuestionCount(); //increment question count
					
					if(gamesetting.getQuestionCount() > 3) { // modify later
						System.out.println("3 Questions asked! Developer Please add more questions and functionality!");
						System.out.println("Returning to the Main Menu");
						questionCorrect = false;
					}
				}
			}
			
		}
		
		quesDist.reset();
		
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
