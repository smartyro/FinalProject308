package View;

public class Blackboard {
	private Blackboard instance;
	
	private Blackboard() {
	
	}
	
	public Blackboard getInstance() {
		if(instance == null) {
			instance = new Blackboard();
		}
		return instance;
	}
}
