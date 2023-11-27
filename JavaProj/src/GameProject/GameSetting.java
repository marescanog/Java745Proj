package GameProject;

public class GameSetting {
	
	private String screen;
    private String playerName;
    private int difficulty;
    private static int question = 1;
    private static int round = 1;
//    private int[] questionValuesEasy;
//    private int[] questionValuesHard;
    private boolean usedLifeLine = false;  
  private static boolean isCorrect = false;
//  feel like we might not need to track this
    private int[] usedLifeLines;
    
    public String getCurrentScreen() {
        return screen;
    }

    public void setCurrentScreen(String screen) {
        this.screen = screen;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int choice) {
    	this.difficulty = choice;
    }
    
    public int getQuestionCount() {
    	return question;
    }
    
    public void addQuestionCount() {
    	this.question++;
    }
    
//    public void setCurrentQuestion(int num) {
//    	this.question= num;
//    }
    
    public int getCurrentRound() {
    	return round;
    }
    
    public void setCurrentRound(int num) {
    	this.round= num;
    }
    

    public void retrieveStoredData() {
        // Implement logic to retrieve stored data
    }
    
}
    