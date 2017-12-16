package edu.gqq.design.jukebox;

public class SongSelector {

	private Song currentSong;

	public SongSelector(Song s) {

		currentSong = s;

	}

	public void setTrack(Song s) {

		currentSong = s;

	}

	public Song getCurrentSong() {

		return currentSong;

	}

}