package GameProject;

import java.util.ArrayList;

public class QuestionDistributor {
	
	private ArrayList<Question> filteredQuestions = new ArrayList<Question>();
	private ArrayList<Integer> doneQuestions = new ArrayList<Integer>();
	
	public QuestionDistributor() {}
	
	public Question distributeQuestion (int currentQuestionNumber, int gameDifficulty) {
		// QuestionNumbers 1 - 9 for Easy, QuestionNumbers 1 - 15 for Hard
		// GameDifficulty 0 - Easy, 1 - Hard
		/*
		 * Notes for how the questions are filtered & how minimum max ranges are computed
		 * 
		 * GameDifficulty on Easy will have sub difficulty range from 1 - 5 	
		 * GameDifficulty on Hard will have sub difficulty range from 3 - 10
		 * 
		 * Q# Easy Sub-difficulty Range	| Q# Hard Sub-difficulty Range
		 * ----------------------------------------------------------------------
		 * 1: 1 , 1						| 1: 1 , 1
		 * 2: 1 , 2						| 2:  1 , 2
		 * 3: 2 , 2						| 3:  2 , 2
		 * 4: 2 , 3						| 4:  2 , 3
		 * 5: 3 , 3						| 5:  3 , 3
		 * 6: 3 , 4						| 6:  3 , 4
		 * 7: 4 , 4						| 7:  4 , 4
		 * 8: 4 , 5						| 8:  4 , 5	
		 * 9: 5 , 5						| 9:  5 , 5	
		 * 10: --						| 10: 5 , 6
		 * 11: --						| 11: 6 , 6
		 * 12: --						| 12: 6 , 7
		 * 13: --						| 13: 7 , 7
		 * 14: --						| 14: 8 , 9
		 * 15: --						| 15: 9 , 9
		 * 
		 */
		
		// Do not distribute question when max questions asked is reached
		if((gameDifficulty == 0 && currentQuestionNumber > 9) || (gameDifficulty == 1 && currentQuestionNumber > 15)) {
			return null;
		}
		
		filteredQuestions.clear();
		
		int minDifficultyRange = (currentQuestionNumber % 2 == 0 ? ((currentQuestionNumber / 2)) : ((currentQuestionNumber / 2) + 1));
		int maxDifficultyRange = minDifficultyRange + (currentQuestionNumber % 2 == 0 ? 1 : 0);
		int totalQuestionsInList = (maxDifficultyRange - minDifficultyRange + 1)*10;
		
		filterQuestions(minDifficultyRange, maxDifficultyRange, totalQuestionsInList);
		
		int randIndex = getRandomIndex();
		
		try {
			
			boolean hasBeenAsked = checkIfQuestionHasBeenAskedBefore(filteredQuestions.get(randIndex).getID());
			
			// Delete this later, to guard against infinite loops
			int breaker = 0;
			
			while(hasBeenAsked && filteredQuestions.size() != 0 && breaker < 50) {
				// Obtain a number between [0 to size()-1].
				randIndex = getRandomIndex();
				
				// check if question has been asked before
				hasBeenAsked = checkIfQuestionHasBeenAskedBefore(filteredQuestions.get(randIndex).getID());
				
				// Delete this later, to guard against infinite loops
				breaker++;
			}
		
		
			if(filteredQuestions.size() != 0){
				doneQuestions.add(filteredQuestions.get(randIndex).getID());
				return filteredQuestions.get(randIndex);
			} else {
				return null;
			}
			
		}catch(IndexOutOfBoundsException ex) {
			System.out.println("minDifficultyRange "+minDifficultyRange);
			System.out.println("maxDifficultyRange "+maxDifficultyRange);
			System.out.println("totalQuestionsInList "+totalQuestionsInList);
			System.out.println("randIndex "+randIndex);
			System.out.println("Your Current Question Number is "+currentQuestionNumber);
			System.out.println("This question number is out of the bounds of the bank of questions");
			return null;
		}

		
	}
	
	private int getRandomIndex() {
		return (int)(Math.random() * filteredQuestions.size());
	}
	
	private boolean checkIfQuestionHasBeenAskedBefore(int questionID) {
		boolean flag = false;
		for(int x = 0; x < doneQuestions.size() && !flag; x++) {
			if (doneQuestions.get(x) == questionID) {
				flag = true;
			}
		}
		return flag;
	}
	
	private void filterQuestions (int minDifficultyRange, int maxDifficultyRange, int totalQuestionsInList) {
		if(minDifficultyRange > 0 && maxDifficultyRange < 10 && minDifficultyRange <= maxDifficultyRange) {
			for(int x = 0; x < QuestionBank.QList.length && filteredQuestions.size() < totalQuestionsInList; x++) {
				if(QuestionBank.QList[x].getDifficultyLevel() >= minDifficultyRange && QuestionBank.QList[x].getDifficultyLevel() <= maxDifficultyRange) {
					filteredQuestions.add(QuestionBank.QList[x]);
				}
			}
		}
	}
	
	public void reset() {
		filteredQuestions.clear();
		doneQuestions.clear();
	}
}
