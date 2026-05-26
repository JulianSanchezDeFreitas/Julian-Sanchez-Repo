package alarma;

public class SleepingState implements State{

	public SleepingState() {}

	@Override
	public void trigger(Alarma alarma) {
		alarma.setState(new ActivateState());
	}

	@Override
	public void activate(Alarma alarma) {
		// Se mantiene en sleep
		
	}

	@Override
	public void inactivate(Alarma alarma) {
		// Se mantiene en sleep
		
	}

	@Override
	public void sleep(Alarma alarma) {
		// Se mantiene en sleep
		
	}
	
	
}
