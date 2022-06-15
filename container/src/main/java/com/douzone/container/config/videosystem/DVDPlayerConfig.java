package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import com.douzone.container.videosystem.DVDPlayer;

public class DVDPlayerConfig {
	@Bean
	public DVDPlayer DVDPlayer() {
		return new DVDPlayer();
	}
}
