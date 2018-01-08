package edu.gqq.design.jukebox;

import java.util.ArrayList;
import java.util.List;

public class PlayList {

	private List<Song> list;
	private int idx;
	
	public PlayList() {
		list = new ArrayList<>();
		idx = 0;
	}

	public Song getNextSongToPlay() {
		++idx;
		if (idx >= list.size()) {
			return list.get(0);
		}
		return list.get(idx);
	}

	public void addSong(Song s) {
		this.list.add(s);
	}
	
	public void shuffle() {
		
	}
}
