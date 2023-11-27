package GameProject;

public class GameSetting {
	
	private String currentScreen;
    private String playerName;
    private String difficulty;
    private static int currentQuestion = 1;
    private static int currentRound = 1;
    private int[] questionValuesEasy;
    private int[] questionValuesHard;
    private boolean usedLifeLine = false;
    private boolean isConfirmed = false;
    private static boolean isCorrect = false;
    private int[] usedLifeLines;
    
    public String getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(String screen) {
        this.currentScreen = screen;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void promptAskPlayerName(String playerName) {
        if (playerName != null && !playerName.trim().isEmpty()) {
            setPlayerName(playerName);
            System.out.println("Player name set as: " + playerName);
        } else {
            System.out.println("Invalid player name. Please provide a valid name.");
        }
    }

    public void promptDifficulty(String difficulty) {
    	
    	
    	if (difficulty != null && !difficulty.isEmpty()) {
    		  setDifficulty(difficulty);
              System.out.println("Difficulty set as: " + difficulty);
    	}else {
            System.out.println("Invalid difficulty. Please choose a valid difficulty.");
    	}
      
    }

    public void retrieveStoredData() {
        // Implement logic to retrieve stored data
    }
    
}
    