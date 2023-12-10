package GameProject;

import java.util.ArrayList;
import java.util.Comparator;

public class LifelineAskAudience extends Lifeline {
	
	private ArrayList<Integer> randPollValues = new ArrayList<Integer>();	
	int maxval = 0;
	int secondmaxval = 0; 
	String pollString = "";
	
	LifelineAskAudience(){}
	
    @Override
    public void runLifeline() {
    	
    	pollString = "";
    	
        System.out.println("Ask the audience for the correct answer.");
        
        generateRandPollValues();
        
        if(headsOrTails() || GameSetting.getDifficulty() == 0) {
          	 //System.out.println("Audience gives out correct answer");
	      	assignCorrectPollValues();
        } else {
	      	 //System.out.println("Audience gives out incorrect answer");
	  		assignInCorrectPollValues();
        }
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
    	
//    	System.out.println("Your random poll values are: ");
//    	for(int ranEl : randPollValues) {
//    		System.out.println(ranEl);
//    	}
//      	System.out.println("Your max value is: "+maxval);
//      	System.out.println("Your secondmaxval is: "+secondmaxval);
    }
    
    private int ensureNoTwoRandomPollsAreTheSame(int randPoll) {
		while(randPollValues.contains(randPoll)) {
			if(randPoll == 100) {
				randPoll = (int) (Math.random() * 10) + 1;
			} else {
				randPoll++;
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
    		pollString = pollString + Question.letterChoices[x] + ".) "+ choices[x] + ": ";
    		if(currentQuestion.getCorrectAnsIndex() == x) {
    			pollString = pollString + randPollValues.get(randPollValues.size()-1)+"%" + "\n";
    			randPollValues.remove(randPollValues.size()-1);
    		} else {
    			int randIndex = -1;
    			while(randIndex == -1) {
        			randIndex = (int)(Math.random() * randPollValues.size() );
        			if(maxval != randPollValues.get(randIndex)) {
        				pollString = pollString + randPollValues.get(randIndex)+"%" + "\n";
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
    		pollString = pollString + Question.letterChoices[x] + ".) "+ choices[x] + ": ";
    		if(currentQuestion.getCorrectAnsIndex() == x) {
    			pollString = pollString + secondmaxval+"%" + "\n";
    			randPollValues.remove(Integer.valueOf(secondmaxval));
    		} else {
    			int randIndex = -1;
    			while(randIndex == -1) {
        			randIndex = (int)(Math.random() * randPollValues.size() );
        			if(secondmaxval != randPollValues.get(randIndex)) {
        				pollString = pollString + randPollValues.get(randIndex)+"%" + "\n";
            			randPollValues.remove(randIndex);
        			} else {
        				randIndex = -1;
        			}
    			}
    		}
    
    	}
    	
    }
    
    @Override
    public void reprintResult() {
       System.out.println("\n\nThe audience voted:");
       System.out.println(pollString);
       System.out.println("\n");
    }
    
 }