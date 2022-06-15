package com.douzone.container.videosystem;

public class DVDPlayer {
	private DigitalVideoDisc dvd;
	
	public DVDPlayer(DigitalVideoDisc dvd) {
		this.dvd=dvd;
	}
	public DVDPlayer() {
		// TODO Auto-generated constructor stub
	}
	public String play() {
		return dvd.play();
	}
	public void setDvd(DigitalVideoDisc dvd) {
		this.dvd = dvd;
	}
}
