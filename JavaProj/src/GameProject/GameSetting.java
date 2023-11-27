package GameProject;

public class GameSetting {
	
	private String screen;
    private String playerName;
    private int difficulty;
    private static int question = 1;
    private static int round = 1;
<<<<<<< HEAD
    private int[] questionValuesEasy = {100, 500, 1000, 8000, 16000, 32000, 125000, 500000, 1000000}; //9 values for Easy
    private int[] questionValuesHard = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000}; //15 values for hard
    private int[] usedLifeLines; //store lifelines that has been used, if empty: player never used lifeline
    private double prizeMoney = 0;
    
=======
//    private int[] questionValuesEasy;
//    private int[] questionValuesHard;
    private boolean usedLifeLine = false;  
  private static boolean isCorrect = false;
//  feel like we might not need to track this
    private int[] usedLifeLines;
>>>>>>> 30abefc1b1cbb4fcbfb201c4ccccf9c2bfeec569
    
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
    
<<<<<<< HEAD
    public double returnPrize(){
    	return prizeMoney;
    }
    
    public void addPrize(int prize) {
    	this.prizeMoney+= prize;
    }
    
=======
>>>>>>> 30abefc1b1cbb4fcbfb201c4ccccf9c2bfeec569

    public void retrieveStoredData() {
        // Implement logic to retrieve stored data
    }
    
}
    