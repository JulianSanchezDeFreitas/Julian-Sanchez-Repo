package ej1RedSocial;

public abstract class Mensaje {

	public ReTweet reTweetear() {
			ReTweet retweet = new ReTweet(this);
			return retweet;	
	}
}
