package GameProject;

import java.util.Random;

public class LifelinePhoneFriend extends Lifeline {

    public void runLifeline() {
    	Question currentQuestion = GameSetting.getCurrentQuestion();
        String[] choices = currentQuestion.getChoices();
        int correctIndex = currentQuestion.getCorrectAnsIndex();

        // Simulate a friend providing assistance
        System.out.println("Calling a friend for help...");

        Random random = new Random();
        int friendConfidence = random.nextInt(10) + 1; // Generate friend's confidence level

        System.out.println("Your friend says:");

        switch (friendConfidence) {
            case 10:
                System.out.println("I'm absolutely certain, it's " + Question.letterChoices[correctIndex]);
                break;
            case 9:
                System.out.println("I'm almost positive it's " + Question.letterChoices[correctIndex]);
                break;
            case 8:
                System.out.println("I'm quite confident the answer is " + Question.letterChoices[correctIndex]);
                break;
            case 7:
                System.out.println("I have a strong feeling it might be " + Question.letterChoices[correctIndex]);
                break;
            case 6:
                System.out.println("I think there's a good chance it's " + Question.letterChoices[correctIndex]);
                break;
            case 5:
                int randomChoice = random.nextInt(choices.length);
                System.out.println("I'm unsure, but maybe it's " + Question.letterChoices[randomChoice]);
                break;
            case 4:
                int anotherRandomChoice = random.nextInt(choices.length);
                System.out.println("I'm not entirely sure, but perhaps it's " + Question.letterChoices[anotherRandomChoice]);
                break;
            case 3:
                int closerChoice = getCloserChoice(correctIndex, choices.length);
                System.out.println("Considering all options, it could be " + Question.letterChoices[closerChoice]);
                break;
            case 2:
                int veryCloseChoice = getVeryCloseChoice(correctIndex, choices.length);
                System.out.println("My intuition strongly hints at " + Question.letterChoices[veryCloseChoice]);
                break;
            default:
                System.out.println("I'm really not sure, sorry!");
        }
    }

    private int getCloserChoice(int correctIndex, int choicesCount) {
        // Simulate a guess closer to the correct answer
        Random random = new Random();
        int deviation = random.nextInt(2) + 1; // Get a small deviation (1 or 2) from the correct index
        return Math.min(choicesCount - 1, Math.max(0, correctIndex + deviation)); // Ensure within valid range
    }

    private int getVeryCloseChoice(int correctIndex, int choicesCount) {
        // Simulate a guess very close to the correct answer
        Random random = new Random();
        int deviation = random.nextInt(1) + 1; // Get a very small deviation (1) from the correct index
        return Math.min(choicesCount - 1, Math.max(0, correctIndex + deviation)); // Ensure within valid range
    }
}
