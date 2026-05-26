package alarma;

public class InactiveState implements State{
	

	public InactiveState() {}

	@Override
	public void trigger(Alarma alarma) {
		// me mantengo en el estado Inactive
	}

	@Override
	public void activate(Alarma alarma) {
		alarma.setState(new ActivateState());
		
	}

	@Override
	public void inactivate(Alarma alarma) {
		// Sigo en el estado Inactive
		
	}

	@Override
	public void sleep(Alarma alarma) {
		// Sigo en el estado Inactive
		
	}

	
}
