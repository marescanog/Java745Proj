package GameProject;
import java.util.Scanner;

public class Lifeline50_50 extends Lifeline {
	
	Lifeline50_50(){}
	
//	private Question question = new Question();
    @Override
    public void runLifeline() {
        // Implement logic to eliminate two incorrect answers
        System.out.println("You've used the 50/50 lifeline. Two incorrect answers have been eliminated.");
    }
}