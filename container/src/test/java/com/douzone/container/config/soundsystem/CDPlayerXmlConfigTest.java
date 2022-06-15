package com.douzone.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.douzone.container.soundsystem.CDPlayer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:com/douzone/container/config/soundsystem/CDPlayerConfig.xml")
public class CDPlayerXmlConfigTest {
	@Autowired
	CDPlayer cdPlayer;
	
	@Test
	public void testCDPlayerNot() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlay() {
		cdPlayer.play();
	}
}
