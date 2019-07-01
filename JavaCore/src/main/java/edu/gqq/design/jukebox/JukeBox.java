package edu.gqq.design.jukebox;

import java.util.Set;

public class JukeBox {
	private Player player;

	private Set<CD> cdCollection;
	private Set<PlayList> playLists;

	private SongSelector ts;
	// 0:cd, 1:playlist.
	private boolean isCD = true;
	
	/**
	 * creat new playlist.
	 */
	public void addNewPlaylist() {
		PlayList newpl = new PlayList();
		playLists.add(newpl);
	}
	
	/**
	 * selected song.
	 * @param s
	 */
	public void selectSong(Song s) {
		player.setSelectedSong(s);
	}
	
	/**
	 * play cd.
	 * @param cd
	 */
	public void selectCD(CD cd) {
		isCD = true;
		player.setIsCD(isCD);
		player.setCD(cd);
	}
	
	/**
	 * user select playlist.
	 * @param playList
	 */
	public void selectPlayList(PlayList playList) {
		isCD = false;
		player.setIsCD(false);
		player.setPlaylist(playList);
	}

	public Song getCurrentSong() {
		return ts.getCurrentSong();
	}

}
