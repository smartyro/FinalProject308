package Controller;

public class ControlHandler {
	private ControlHandler instance;
	
	private ControlHandler() {}
	
	public ControlHandler getInstance() {
		if(instance == null) {
			instance = new ControlHandler();
		}
		return instance;
	}
}
