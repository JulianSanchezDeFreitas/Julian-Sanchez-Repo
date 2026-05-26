package alarma;

public class RingingState implements State {

	public RingingState() {}

	@Override
	public void trigger(Alarma alarma) {
		// Se mantiene en trigger
		
	}

	@Override
	public void activate(Alarma alarma) {
		// Se mantiene en trigger
		
	}

	@Override
	public void inactivate(Alarma alarma) {
		// Se mantiene en trigger
		
	}

	@Override
	public void sleep(Alarma alarma) {
		alarma.setState(new SleepingState());
		
	}
	
	
}
