package GameProject;

public class Question {
	
	public static char[] letterChoices = {'A','B','C','D'};
	private static int questionID = 1; 
	
	int id;
	String QuestionLine;
	String[] choices = new String[4];
	int correctAnsIndex;
	int difficultyLevel;
	
	public Question(String QuestionLine, String choice1, String choice2, String choice3, String choice4,
	int correctAnsIndex, int difficultyLevel) {
		this.QuestionLine = QuestionLine;
		choices[0] = choice1;
		choices[1] = choice2;
		choices[2] = choice3;
		choices[3] = choice4;
		this.correctAnsIndex = correctAnsIndex;
		this.difficultyLevel = difficultyLevel;
		id = questionID++;
	}
	
	boolean validateQuestion(int questionIndex) {
		return questionIndex == correctAnsIndex;
	}
	
	boolean validateQuestion(char playerChoice) {
		return letterChoices[correctAnsIndex] == playerChoice;
	}
	
	boolean validateQuestion(String playerChoice) {
		return (playerChoice.toUpperCase()).equals(Character.toString(letterChoices[correctAnsIndex]));
	}
}
