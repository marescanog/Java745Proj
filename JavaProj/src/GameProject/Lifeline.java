package GameProject;
import java.util.Scanner;

public class Lifeline {
	
    public void runLifeline() {
    	
    	Lifeline50_50 lifeline5050 = new Lifeline50_50();
        LifelineAskAudience lifelineAudience = new LifelineAskAudience();
        LifelinePhoneFriend lifelineFriend = new LifelinePhoneFriend();
        
    	Scanner s = new Scanner(System.in);
		System.out.println("\nSelect the type of Lifeline (you can only use each once!):");
		System.out.println("A or a - 50/50 --> This lifeline allows the game to eliminate two incorrect answers");
		System.out.println("B or b - Ask the Audience--> This lifeline allows the player to “ask the audience”for the correct answer. Be creative with regards to how you implement this.");
		System.out.println("C or c - Phone a friend --> This lifeline allows the player to “phone to afriend” for the correct answer. Be creative with regards to how you implement this");		
		System.out.print("\nYour selection:");
		String option = s.nextLine();
		
		if (option.equals("a") || option.equals("A")) {
		    // lifeline 50/50
		    lifeline5050.runLifeline();
		} else if (option.equals("b") || option.equals("B")) {
		    // ask audience
		    lifelineAudience.runLifeline();
		} else if (option.equals("c") || option.equals("C")) {
		    // phone a friend
		    lifelineFriend.runLifeline();
		} else {
		    System.out.println("Invalid choice. Please enter a valid choice from letter A-C: ");
		}

    }
}