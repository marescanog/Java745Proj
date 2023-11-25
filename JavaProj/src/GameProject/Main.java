package GameProject;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ScreenLauncher screenLauncher = new ScreenLauncher();
		// Declare game Settings class GameSettings.
		
		boolean gameRunning = true; // Replace with Game Settings
		String launchScreenOption = ""; // Replace with Game Settings
		
		// Launch Screen Loop 
		while(gameRunning){ // Replace with GameSettings.getGameRunning()
			do {
				// Launch Screen Loop
				screenLauncher.printLaunchScreenText();
				launchScreenOption = sc.nextLine();
				
				switch(launchScreenOption) {
					case "S":
					case "s":
						screenLauncher.GameLoop(sc);
						break;
					case "I":
					case "i":
						screenLauncher.InstructionsLoop(sc);
						break;
					case "X":
					case "x":
						screenLauncher.PrintExitScreen();
						gameRunning = false; // Replace with GameSettings.setGameRunning(false);
						break;
					default:
						System.out.print("\n("+launchScreenOption+") is an inavlid option. ");
						launchScreenOption = "";
				}
				
			} while(launchScreenOption.isEmpty());
		}
		
		sc.close();
	}

}
