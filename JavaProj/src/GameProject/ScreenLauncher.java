package GameProject;


import java.util.Scanner;

public class ScreenLauncher {
	private GameLauncher gameLauncher = new GameLauncher();
	private GameSetting gamesetting = new GameSetting();

	
	ScreenLauncher(){}
	
	public void GameLoop(Scanner sc) {
		System.out.println("\n\nGameLoop\n\n");
		// Enter your name
		
//		if (gamesetting.getPlayerName().equals("")) {
		    System.out.print("Please enter your name: ");
			gamesetting.setPlayerName(sc.nextLine());
			System.out.println("Hello " + gamesetting.getPlayerName() + ", Welcome to the game!\n");
//		}
				
		// Enter a difficulty choice - This has to be static Capital G
		GameSetting.setDifficulty(difficultyLoopSelection(sc));
		
		gameLauncher.LaunchGameLoop(sc);
	}
	
	// Validation
	private int difficultyLoopSelection(Scanner sc) {
		int retVal = -1;
		String choice = "";
		while(retVal < 0 && choice.isEmpty()) {
			System.out.println("Please select a difficulty");
			System.out.println("E - Easy, H - Hard");
			System.out.print("Your difficulty: ");
			choice = sc.nextLine();
			switch(choice) {
				case "e":
				case "E":
					retVal = 0;
					break;
				case "h":
				case "H":
					retVal = 1;
					break;
				default:
					System.out.println("Invalid choice. Please select only E or H.");
					choice = "";
			}
		}
		return retVal;
	}
	
	public void InstructionsLoop(Scanner sc) {
	
		
		String insChoice = "";
		
		while(insChoice.isBlank() || insChoice.isEmpty()) {
			System.out.println("\nHow to play who wants to be a millionaire:");
			System.out.println("Select an option for more details:");
			System.out.println("A.) Easy Mode");
			System.out.println("B.) Hard Mode");
			System.out.println("C.) Go back to the Main Menu");
			System.out.print("Your option: ");
			
			insChoice = sc.nextLine();
			
			System.out.println("");
			
			switch(insChoice) {
				case "A":
				case "a":
					System.out.println("===========================================================");
					System.out.println("=                       Easy Mode                         =");
					System.out.println("===========================================================");
					System.out.println("1.) Easy Mode has a total of 9 questions and 3 rounds.");
					System.out.println("2.) There are 3 trivia questions each round.");
					System.out.println("3.) You will be presented with 4 choices to each question.");
					System.out.println("4.) Select the letter to the choice which you think is the correct answer.");
					System.out.println("5.) If correct, you will be entitled to a prize value based on the question.");
					System.out.println("6.) If incorrect, you will lose whatever prize value you are entitled to.");
					System.out.println("7.) At the end of each round, you can choose to walk away and keep your entitled prize value.");
					System.out.println("8.) However if you answer all 9 questions you will win the game and a prize of 1,000,000!");
					System.out.println("9.) You can use 3 different lifelines to help you but you can only use each once!");
					pressEnterToContinue(sc);
					insChoice = "";
					break;
				case "B":
				case "b":
					System.out.println("===========================================================");
					System.out.println("=                       Hard Mode                         =");
					System.out.println("===========================================================");
					System.out.println("1.) Hard Mode has a total of 15 questions and 3 rounds.");
					System.out.println("2.) There are 5 trivia questions each round.");
					System.out.println("3.) You will be presented with 4 choices to each question.");
					System.out.println("4.) Select the letter to the choice which you think is the correct answer.");
					System.out.println("5.) If correct, you will be entitled to a prize value based on the question.");
					System.out.println("6.) If incorrect, you will lose whatever prize value you are entitled to.");
					System.out.println("7.) At the end of each round, you can choose to walk away and keep your entitled prize value.");
					System.out.println("8.) However if you answer all 9 questions you will win the game and a prize of 1,000,000!");
					System.out.println("9.) Starting at Round 2 you can use 3 different lifelines to help you but you can only use each once!");
					pressEnterToContinue(sc);
					insChoice = "";
					break;
				case "C":
				case "c":
					System.out.println("\nGoing back to the main menu...\n\n");
					break;
				default:
					System.out.println("\nThat is not a valid selection. Please choose A, B or C.\n");
					insChoice = "";
			}
		}
		

		
	}
	
	 private void pressEnterToContinue(Scanner sc)
	 { 
	        System.out.println("\n\nPress Enter key to continue...");
	        sc.nextLine();  
	 }
	 
	public void PrintExitScreen() {
		System.out.println("\n\nGood Bye! Thank you for playing!");
	}
	
	public void printLaunchScreenText() {
		System.out.println("Please select from the following options:");
		System.out.println("S or s - Start Game");
		System.out.println("I or i - Instructions");
		System.out.println("X or x - exit");
		
		System.out.print("\nYour selection: ");
	}
	
}
