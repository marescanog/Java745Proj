package GameProject;

public class GameSetting {
	
	private String screen=""; //[Menu, Instructions, Game]
    private String playerName="";
    private int difficulty; //0 for easy 1 for hard
    private int question = 1;
    private int round = 1;
    private boolean questionCorrect = false;
    private int[] prizeValuesEasy = {100, 500, 1000, 8000, 16000, 32000, 125000, 500000, 1000000}; //9 values for Easy
    private int[] prizeValuesHard = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000}; //15 values for hard
    private String[] usedLifeLines; //store lifelines that has been used, if empty: player never used lifeline
    private int prizeMoney = 0;
    
    
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

    public int getCurrentRound() {
    	return round;
    }
    
    public void updateRound() {
    	this.round = (int)Math.ceil((double) question / 3);
    }
    
    public boolean getQuestionCorrect() {
    	return this.questionCorrect;
    }
    
    public void setQuestionCorrect(boolean choice) {
    	this.questionCorrect = choice;
    }
    
    public int[] getPrizeValues(int difficulty) {
    	//if difficulty = 1 = hard then return hard prize values
        return (difficulty == 1) ? this.prizeValuesHard : this.prizeValuesEasy;
    }
    
    public double returnPrize(){
    	return prizeMoney;
    }
    
    public void resetGame() {
    	this.question = 1;
    	this.questionCorrect = false;
    	this.prizeMoney = 0;
    }
    
//    public void resetQuestionCount() {
//    	this.question= 0;
//    }
//    
//    public void resetQuestion() {
//    	this.questionCorrect = false;
//    }
//    
//    public void resetPrize() {
//    	this.prizeMoney = 0;
//    }
    
    public void addPrize(int prize) {
    	this.prizeMoney+= prize;
    }
    
    public void retrieveStoredData() {
        // Implement logic to retrieve stored data
    }
    
}
    