package GameProject;

import java.util.ArrayList;
import java.util.Comparator;

public class LifelineAskAudience extends Lifeline {
	
	private ArrayList<Integer> randPollValues = new ArrayList<Integer>();
	LifelineAskAudience(){}
	
	int maxval = 0;
	int secondmaxval = 0; 
	
    @Override
    public void runLifeline() {
        System.out.println("Ask the audience for the correct answer.");
        
        generateRandPollValues();
        
        System.out.println("\n\nThe audience voted:");
        if(headsOrTails() || GameSetting.getDifficulty() == 0) {
        	 //System.out.println("Audience gives out correct answer");
        	assignCorrectPollValues();
        } else {
        	 //System.out.println("Audience gives out incorrect answer");
        	assignInCorrectPollValues();
        }
        System.out.println("\n\n");
    }
    
    public boolean headsOrTails() {
    	return ((int)((Math.random() * 2)+1)) == 1;
    }
    
    private void generateRandPollValues() {
    	int maxpoll = 100;
    	int pollCount = 0;
    	while(maxpoll > 0 && pollCount < 4) {
    		if(pollCount == 3) {
    			randPollValues.add(maxpoll);
    			maxpoll = 0;
    		} else {
    			int randPoll;
    			switch(pollCount) {
    				case 0:
    					randPoll = ensureNoTwoRandomPollsAreTheSame((int) (Math.random() * 45) + 1);
    					randPollValues.add(randPoll);
    					maxpoll -= randPoll;
    					break;
    				case 1:
    					randPoll = ensureNoTwoRandomPollsAreTheSame((int) (Math.random() * 35) + 1);
    					randPollValues.add(randPoll);
    					maxpoll -= randPoll;
    					break;
    				case 2:
    					randPoll = ensureNoTwoRandomPollsAreTheSame((int) (Math.random() * 15) + 1);
    					randPollValues.add(randPoll);
    					maxpoll -= randPoll;
    					break;
    			}
    		}
    		pollCount++;
    	}
    	randPollValues.sort(Comparator.naturalOrder());
    	maxval = randPollValues.get(randPollValues.size()-1);
    	secondmaxval = randPollValues.get(randPollValues.size()-2);
    }
    
    private int ensureNoTwoRandomPollsAreTheSame(int randPoll) {
		while(randPollValues.contains(randPoll)) {
			if(randPoll == 100) {
				randPoll--;
			} else if (randPoll >= 0) {
				randPoll++;
			} else {
				randPoll = (int) (Math.random() * 45) + 1;
			}
		}
		return randPoll;
    }
    private void assignCorrectPollValues() {
    	// assign the highest poll value to the correct answer
    	// random values to rest
    	Question currentQuestion = GameSetting.getCurrentQuestion();
    	String[] choices = currentQuestion.getChoices();
    	
    	for(int x = 0; x < choices.length; x++) {
    		System.out.print(Question.letterChoices[x] + ".) "+ choices[x] + ": ");
    		if(currentQuestion.getCorrectAnsIndex() == x) {
    			System.out.println(randPollValues.get(randPollValues.size()-1)+"%");
    			randPollValues.remove(randPollValues.size()-1);
    		} else {
    			int randIndex = -1;
    			while(randIndex == -1) {
        			randIndex = (int)(Math.random() * randPollValues.size() );
        			if(maxval != randPollValues.get(randIndex)) {
            			System.out.println(randPollValues.get(randIndex)+"%");
            			randPollValues.remove(randIndex);
        			} else {
        				randIndex = -1;
        			}
    			}
    		}
    
    	}
    }
    
    private void assignInCorrectPollValues() {
    	// assign the second highest poll value to the correct answer
    	// random values to rest
    	Question currentQuestion = GameSetting.getCurrentQuestion();
    	String[] choices = currentQuestion.getChoices();
    	
    	for(int x = 0; x < choices.length; x++) {
    		System.out.print(Question.letterChoices[x] + ".) "+ choices[x] + ": ");
    		if(currentQuestion.getCorrectAnsIndex() == x) {
    			System.out.println(secondmaxval+"%");
    			randPollValues.remove(Integer.valueOf(secondmaxval));
    		} else {
    			int randIndex = -1;
    			while(randIndex == -1) {
        			randIndex = (int)(Math.random() * randPollValues.size() );
        			if(secondmaxval != randPollValues.get(randIndex)) {
            			System.out.println(randPollValues.get(randIndex)+"%");
            			randPollValues.remove(randIndex);
        			} else {
        				randIndex = -1;
        			}
    			}
    		}
    
    	}
    	
    }
}