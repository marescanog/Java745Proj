package GameProject;
import java.util.ArrayList;
import java.util.Scanner;

public class Lifeline {
	
	public static final String[] LIFELINE_DEF = {"50/50","Ask Audience","Call Friend"};
    private boolean isActive = false;
	
	Lifeline(){};
	
    public void runLifeline() {
    	
        
    	Scanner s = new Scanner(System.in);
		System.out.println("\nSelect the type of Lifeline (you can only use each once!):");
		
		ArrayList<String> usedLifelines = GameSetting.getUsedLifeLines();
		
		// Only print instructions if life line is not used. Otherwise print used.
		checkIsLifeLineInArrayList(usedLifelines, LIFELINE_DEF[0]);
		
		System.out.println("A or a - 50/50 "+(checkIsLifeLineInArrayList(usedLifelines, LIFELINE_DEF[0]) ? "(Used)" : "--> This lifeline allows the game to eliminate two incorrect answers")); 
		System.out.println("B or b - Ask the Audience "+(checkIsLifeLineInArrayList(usedLifelines, LIFELINE_DEF[1]) ? "(Used)" : "--> This lifeline allows the player to “ask the audience”for the correct answer. A poll will be released on what audience thinks is correct.")); // 
		System.out.println("C or c - Phone a friend "+(checkIsLifeLineInArrayList(usedLifelines, LIFELINE_DEF[2]) ? "(Used)" : "--> This lifeline allows the player to “phone a friend”. This friend will help give a hint on the correct answer."	)); 	
		System.out.print("\nYour selection: ");
		String option = s.nextLine();
		
		if (option.equals("a") || option.equals("A")) {
		    // lifeline 50/50
			if(!checkIsLifeLineInArrayList (usedLifelines, LIFELINE_DEF[0])) {
				GameSetting.lifelines[0].runLifeline();
				GameSetting.lifelines[0].setActive(true);
//				GameSetting.lifelines[1].setActive(false);
//				GameSetting.lifelines[2].setActive(false);
			}
		    GameSetting.addLifeline(LIFELINE_DEF[0]);
		} else if (option.equals("b") || option.equals("B")) {
		    // ask audience
			if(!checkIsLifeLineInArrayList (usedLifelines, LIFELINE_DEF[1])) {
				GameSetting.lifelines[1].runLifeline();
				GameSetting.lifelines[1].setActive(true);
			}
		    GameSetting.addLifeline(LIFELINE_DEF[1]);
		} else if (option.equals("c") || option.equals("C")) {
		    // phone a friend
			if(!checkIsLifeLineInArrayList (usedLifelines, LIFELINE_DEF[2])) {
				GameSetting.lifelines[2].runLifeline();
				GameSetting.lifelines[2].setActive(true);
			}
		    GameSetting.addLifeline(LIFELINE_DEF[2]);
		} else {
		    System.out.println("Invalid choice. Please enter a valid choice from letter A-C: ");
		}

		// s.close(); // Will error if closed, pass the scanner into the func instead so there is no 2 instances of a scanner
    }
    
    public static boolean checkIsLifeLineInArrayList (ArrayList<String> myArrayList, String lifelineChoice){
    	boolean retval = false;
    	for(String lifeL : myArrayList) {
    		if(lifeL.equals(lifelineChoice)) {
    			retval = true;
    		}
    	}
    	return retval;
    }
    
    public static boolean checkIsLifeLineValid(String lifelineChoice) {
    	boolean retval = false;
    	for(String lifeL : LIFELINE_DEF) {
    		if(lifeL.equals(lifelineChoice)) {
    			retval = true;
    		}
    	}
    	return retval;
    }
    
    public void setActive(boolean status) {
    	isActive = status;
    }
    
    public boolean getIsActive() {
    	return isActive;
    }
    
    public void reprintResult() {
    	
    }
    
}