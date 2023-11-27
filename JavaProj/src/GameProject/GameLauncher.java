package GameProject;

import java.util.Scanner;

public class GameLauncher {
	
	private QuestionDistributor quesDist = new QuestionDistributor();
	private GameSetting gamesetting = new GameSetting();
	
	GameLauncher(){}
	
	public void LaunchGameLoop(int difficulty, Scanner sc) {

		boolean questionCorrect = true; // replace with game settings
		
		//int questionCount = 1; // replace with game settings --> already intiliazed as 1
		
		// print round
		System.out.println("Round Number " + "1"); // Game settings class
		
		while(questionCorrect) {
			System.out.println("\n\nQuestion Number "+ gamesetting.getQuestionCount() + " with a prize amount of \n"); // Game settings class
			
			Question currentQuestion = quesDist.distributeQuestion(gamesetting.getQuestionCount() , difficulty);
			
			System.out.println(currentQuestion.toString());
			
			String choice = getValidChoiceLoop(sc);
			
			if(!choice.isBlank()) {
				questionCorrect = currentQuestion.validateQuestion(choice);
				
				if(!questionCorrect) {
					System.out.println("Incorrect Answer! You have Lost! Returning to the Main Menu\n\n");
				} else {
					gamesetting.addQuestionCount();
					
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
