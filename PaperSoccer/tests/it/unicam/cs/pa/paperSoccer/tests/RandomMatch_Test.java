package it.unicam.cs.pa.paperSoccer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.match.RandomMatch;
import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;

class RandomMatch_Test {

	
	DefaultRuleSet ref = new DefaultRuleSet();
	Ball b = new Ball(0, 0);
	RandomMatch i = new RandomMatch(13,9);

	
	
	@Test
	void playRandom_Test() {
		
		Cell start = i.getField().getCell(b.getY(), b.getX());
		i.playRandom();
		assertTrue(i.getPlayers()[i.getCurrentPlayer()].getMoves() == 1);
		assertTrue(i.getBall().getY() != start.getLoc().getRow() && i.getBall().getX() != start.getLoc().getColumn());
	}
	
	

	
	
}