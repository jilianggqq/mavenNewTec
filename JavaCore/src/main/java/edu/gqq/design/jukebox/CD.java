package edu.gqq.design.jukebox;

import java.util.List;

public class CD {
	private String cdName;
	private List<Song> songs;

	public CD(List<Song> songs, String cdName) {
		this.songs = songs;
		this.cdName = cdName;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public String getCdName() {
		return cdName;
	}

}
