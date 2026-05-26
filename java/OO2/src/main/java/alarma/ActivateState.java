package alarma;

public class ActivateState implements State {

	public ActivateState() {	}

	@Override
	public void trigger(Alarma alarma) {
		alarma.setState(new RingingState());	
	}

	@Override
	public void activate(Alarma alarma) {
		// Me mantengo en Activate
		
	}

	@Override
	public void inactivate(Alarma alarma) {
		alarma.setState(new InactiveState());
		
	}

	@Override
	public void sleep(Alarma alarma) {
		// Me mantengo en active
		
	}
}
