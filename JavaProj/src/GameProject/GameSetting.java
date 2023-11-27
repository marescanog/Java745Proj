package GameProject;

public class GameSetting {
	
	private String screen;
    private String playerName;
    private int difficulty;
    private static int question = 1;
    private static int round = 1;
    
    private int[] questionValuesEasy = {100, 500, 1000, 8000, 16000, 32000, 125000, 500000, 1000000}; //9 values for Easy
    private int[] questionValuesHard = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000}; //15 values for hard
    private String[] usedLifeLines; //store lifelines that has been used, if empty: player never used lifeline
    private double prizeMoney = 0;
    
    
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
    
    public double returnPrize(){
    	return prizeMoney;
    }
    
    public void addPrize(int prize) {
    	this.prizeMoney+= prize;
    }
    
    public void retrieveStoredData() {
        // Implement logic to retrieve stored data
    }
    
}
    