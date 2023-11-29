package GameProject;

public class LifelinePhoneFriend extends Lifeline {
	
	LifelinePhoneFriend(){}
	
    @Override
    public void runLifeline() {
        System.out.println("Calling a friend for help...");
    }
}