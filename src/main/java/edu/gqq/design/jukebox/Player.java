package edu.gqq.design.jukebox;

/**
 * cd player is a player. it can play either one CD or playlist.
 * @author gqq
 *
 */
public class Player {
	private CD _cd;
	private PlayList _plist;
	private Song selectedSong;
	// play type. 0: CD , 1: Playlist.
	private boolean isCD;
	
	public Player(CD cd, PlayList playList) {
		this._cd = cd;
		this._plist = playList;
	}
	
	public void play() {
		if (selectedSong != null) {
			System.out.println("selected is playing");
		}
	}
	
	
	
	/**
	 * just CD.
	 * @param _cd
	 */
	public Player(CD _cd) {
		this._cd = _cd;
	}
	
	/**
	 * just has play list.
	 * @param plist
	 */
	public Player(PlayList plist) {
		this._plist = plist;
	}

	public CD get_cd() {
		return _cd;
	}

	public void setCD(CD _cd) {
		this._cd = _cd;
	}

	public PlayList get_plist() {
		return _plist;
	}

	public void setPlaylist(PlayList _plist) {
		this._plist = _plist;
	}
	
	public void playSong(Song s) {
		
	}

	public void setIsCD(boolean _type) {
		this.isCD = _type;
	}

	public Song getSelectedSong() {
		return selectedSong;
	}

	public void setSelectedSong(Song selectedSong) {
		this.selectedSong = selectedSong;
	}

	
}
