package it.unicam.cs.pa.paperSoccer.tests;

import static java.awt.event.KeyEvent.VK_SPACE;
import static org.junit.Assert.assertFalse;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.controller.RandomMatchController;
import it.unicam.cs.pa.paperSoccer.view.View;



class RandomMatchController_Test {
	
	View v = new View();
	RandomMatchController r = new RandomMatchController(v, 13, 9);

	@Test
	void addSpacebarListener_Test() {
		
		JPanel ghiera = v.getCampo().getGhiera();

		KeyEvent k = new KeyEvent(ghiera, 0, 0, 0, VK_SPACE,(char) VK_SPACE) ;
  
	    v.getCampo().getFinestra().getKeyListeners()[0].keyPressed(k);

		assertFalse(r.getRandomMatch().getBall().getY()==6);
	}

}
