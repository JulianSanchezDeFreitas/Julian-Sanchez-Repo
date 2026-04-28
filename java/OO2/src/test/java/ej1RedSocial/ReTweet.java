package ej1RedSocial;

public class ReTweet extends Mensaje {
	private Mensaje tweetReferenciado;
	
	
	public ReTweet(Mensaje mensaje) {
		this.tweetReferenciado=mensaje;
	}
	
	
}
