package GameProject;

import java.util.ArrayList;
import java.util.Random;

public class Lifeline50_50 extends Lifeline {
	

    @Override
    public void runLifeline() {
    
    	
    	Question currentQuestion = GameSetting.getCurrentQuestion();
        String[] choices = currentQuestion.getChoices();
        int correctIndex = currentQuestion.getCorrectAnsIndex();

        // Create a list to track the indices of incorrect choices
        ArrayList<Integer> incorrectIndices = new ArrayList<>();
        for (int i = 0; i < choices.length; i++) {
            if (i != correctIndex) {
                incorrectIndices.add(i);
            }
        }

        // Randomly select and eliminate two incorrect choices
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int randomIndex = random.nextInt(incorrectIndices.size());
            int indexToRemove = incorrectIndices.get(randomIndex);
            choices[indexToRemove] = ""; // Eliminate the choice by emptying it
            incorrectIndices.remove(randomIndex);
        }

        // Display the updated question with the eliminated choices
        System.out.println("Two incorrect choices have been eliminated:");
        for (int i = 0; i < choices.length; i++) {
            if (!choices[i].isEmpty()) {
                System.out.println(Question.letterChoices[i] + ".) " + choices[i]);
            }
        }
    }
}
