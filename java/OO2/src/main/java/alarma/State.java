package alarma;

public interface State {
	
	public void trigger(Alarma alarma);
	public void activate(Alarma alarma);
	public void inactivate(Alarma alarma);
	public void sleep(Alarma alarma);
}
