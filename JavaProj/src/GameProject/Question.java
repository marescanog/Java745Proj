package GameProject;

public class Question {
	
	public static char[] letterChoices = {'A','B','C','D'};
	private static int questionID = 1; 
	
	private int ID;
	private String questionLine;
	private String[] choices = new String[4];
	private int correctAnsIndex;
	private int difficultyLevel;
	
	public Question(String questionLine, String choice1, String choice2, String choice3, String choice4,
	int correctAnsIndex, int difficultyLevel) {
		this.questionLine = questionLine;
		choices[0] = choice1;
		choices[1] = choice2;
		choices[2] = choice3;
		choices[3] = choice4;
		this.correctAnsIndex = correctAnsIndex;
		this.difficultyLevel = difficultyLevel;
		ID = questionID++;
	}
	
	public int getID() {
		return ID;
	}
	
	public String getQuestionLine() {
		return questionLine;
	}
	
	public String[] getChoices() {
		return choices;
	}
	
	public int getCorrectAnsIndex() {
		return correctAnsIndex;
	}
	
	public int getDifficultyLevel() {
		return difficultyLevel;
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
