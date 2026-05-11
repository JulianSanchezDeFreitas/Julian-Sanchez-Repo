package ej3MediaPlayer;

public class VideoStreamAdapter extends Media {
	private VideoStream videoStream;
	
	public void play() {
		videoStream.reproduce();
	}
}
