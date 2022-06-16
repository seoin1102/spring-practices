package com.douzone.container.videosystem;

public class IronMan implements DigitalVideoDisc {
	private String title = "Iron Man";
	private String studio = "MARVEL";
	
	@Override
	public String play() {
		// TODO Auto-generated method stub
		return "Playing Movie " + studio +"'s "+ title;
	}

}
