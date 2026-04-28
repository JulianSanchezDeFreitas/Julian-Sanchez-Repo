package ej1RedSocial;

import java.util.List;

public class Usuario {
	private String screenName;
	private List<Mensaje> tweets;
	
	public Usuario(String screenName) {
		this.screenName = screenName;
	}
	public void eliminarMensajes() {
		tweets=null;
	}
	public String getNombre() {
		return this.screenName;
	}
	
	public boolean publicarTweet(String texto) {
		if ( texto.length()>280 || texto.length()<0) {
			return false;
		}
		Mensaje tweet = new Tweet(texto);
		tweets.add(tweet);
		return true;
	}
	public void reTweetear(Mensaje mensaje) {
		tweets.add(mensaje.reTweetear());
	}
}
