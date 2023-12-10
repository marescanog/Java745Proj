package GameProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Lifeline50_50 extends Lifeline {
	
	public static int[] indexesToRemove = new int[2];
	 int indexToRemove = -1;
	
    @Override
    public void runLifeline() {
    
    	
    	Question currentQuestion = GameSetting.getCurrentQuestion();
    	String[] choices = currentQuestion.getChoices();
        int correctIndex = currentQuestion.getCorrectAnsIndex();

        // Create a list to track the indices of incorrect choices, ex; 0,1,2 if corecdtIndex = 3
        ArrayList<Integer> incorrectIndices = new ArrayList<>();
        for (int i = 0; i < choices.length; i++) {
            if (i != correctIndex) {
                incorrectIndices.add(i);
            }
        }

        // Randomly select and eliminate two incorrect choices
        Random random = new Random();
            int randomIndex = random.nextInt(incorrectIndices.size()); //random num from 0 to size exclusive
            indexToRemove = incorrectIndices.get(randomIndex);
        
        

        // Display the updated question with the eliminated choices
        System.out.println("Two incorrect choices have been eliminated!");
        
        
        
//        for (int i = 0; i < choices.length; i++) {
//            if (!choices[i].isEmpty()) {
//                System.out.println(Question.letterChoices[i] + ".) " + choices[i]);
//            }
//        }
 
    }
    
    @Override
    public void reprintResult() {
    	if (indexToRemove > 0) {
    		System.out.print(GameSetting.getCurrentQuestion().toString(indexToRemove, GameSetting.getCurrentQuestion().getCorrectAnsIndex()));
    	}
    	
    }
}
