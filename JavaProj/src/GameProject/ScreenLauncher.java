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
		System.out.println("\n\nInstructionsLoop\n\n");
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
