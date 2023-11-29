package GameProject;
import java.util.Scanner;

public class Lifeline {
	
	private Lifeline50_50 lifeline5050 = new Lifeline50_50();
	private LifelineAskAudience lifelineAudience = new LifelineAskAudience();
	private LifelinePhoneFriend lifelineFriend = new LifelinePhoneFriend();
	
    public void runLifeline() {
    	Scanner s = new Scanner(System.in);
		System.out.println("\nSelect the type of Lifeline (you can only use each once!):");
		System.out.println("A or a - 50/50 --> This lifeline allows the game to eliminate two incorrect answers");
		System.out.println("B or b - Ask the Audience--> This lifeline allows the player to “ask the audience”for the correct answer. Be creative with regards to how you implement this.");
		System.out.println("C or c - Phone a friend --> This lifeline allows the player to “phone to afriend” for the correct answer. Be creative with regards to how you implement this");		
		System.out.print("\nYour selection:");
		String option = s.nextLine();
		
		if (option == "a" || option == "A") {
			//lifeline 50/50
			lifeline5050.runLifeline();
			
		}else if (option == "b" || option == "B") {
			//ask audience
			lifelineAudience.runLifeline();
			
		}else if (option == "c" || option == "C") {
			//phone a friend
			lifelineFriend.runLifeline();
		}else {
			System.out.println("Invaid choice, Please enter a valid choice from letter A-C: ");
		}
    }
}