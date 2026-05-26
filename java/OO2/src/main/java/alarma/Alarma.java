package alarma;

public class Alarma {
	private State state;
	
	public void setState(State state) {
		this.state = state;
	}

	public void trigger() {
		state.trigger(this);
	}
	public void activate() {
		state.activate(this);
	}
	public void inactivate() {
		state.inactivate(this);
	}
	public void sleep() {
		state.sleep(this);
	}
}
