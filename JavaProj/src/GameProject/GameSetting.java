package GameProject;

import java.util.ArrayList;

public class GameSetting {
	
	private String screen=""; //[Menu, Instructions, Game]
    private String playerName="";
    private static int difficulty = 0; //0 for easy 1 for hard
    private static Question currentQuestion = null;
    private int question = 1;
    private int round = 1;
    private boolean questionCorrect = false;
    private int[] prizeValuesEasy = {100, 500, 1000, 8000, 16000, 32000, 125000, 500000, 1000000}; //9 values for Easy
    private int[] prizeValuesHard = {100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000}; //15 values for hard
    private static ArrayList<String> usedLifeLines = new ArrayList<String>(); //store lifelines that has been used, if empty: player never used lifeline
    private int prizeMoney = 0;
//    public static Lifeline lifeline5050 = new Lifeline50_50();
//    public static Lifeline lifelineAudience = new LifelineAskAudience();
//    public static Lifeline lifelineFriend = new LifelinePhoneFriend();
    public static Lifeline[] lifelines = {new Lifeline50_50(),new LifelineAskAudience(), new LifelinePhoneFriend()};
    
    //gamesetting.setPrizeMoney(prizeValuessEasy[gamesetting.getQuestionCount()-1]);
    
//    GameSetting() {
//    	lifelines[0] = lifeline5050;
//    	lifelines[1] = lifelineAudience;
//    	lifelines[2] = lifelineFriend;
//    }
    
    
    public static void setCurrentQuestion(Question question) {
        currentQuestion = question;

    }
    
    public static Question getCurrentQuestion() {
        return currentQuestion;
    }
    
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

    public static int getDifficulty() {
        return difficulty;
    }

    public static void setDifficulty(int choice) {
    	difficulty = choice;
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
    	if(difficulty == 0) {
    		this.round = (int)Math.ceil((double) question / 3);
    	} else {
    		this.round = (int)Math.ceil((double) question / 5);
    	}
    	
    }
    
    public boolean getQuestionCorrect() {
    	return this.questionCorrect;
    }
    
    public void setQuestionCorrect(boolean choice) {
    	this.questionCorrect = choice;
    }
    
    public static int getUsedLifeLinesCount() {
    	return usedLifeLines.size();
    }
    
    public static ArrayList<String> getUsedLifeLines() {
    	return usedLifeLines;
    }
    
    public static void addLifeline(String lifeline) {
    	if(!Lifeline.checkIsLifeLineInArrayList(usedLifeLines, lifeline) // If lifeline is not in array list
    		&& Lifeline.checkIsLifeLineValid(lifeline)) {				// and if lifeline is one of the defined lifeline strings
        	usedLifeLines.add(lifeline);								// add the lifeline to the arraylist
    	} else {
    		System.out.println("You already used this lifeline.");
    	}
    }
    
//lets conce
//    public static void resetLifelines() {
//    	usedLifeLines.clear();
//    }
    
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
    	this.round = 1;
    	currentQuestion = null;
    	usedLifeLines.clear();
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
    
    public void setPrize(int prize) {
    	this.prizeMoney= prize;
    }
    
    public void retrieveStoredData() {
        // Implement logic to retrieve stored data
    }
    
    public Boolean canRunLifeline() {
        return (difficulty == 0 ) || (difficulty == 1 && round > 1);
    }
    
}
    