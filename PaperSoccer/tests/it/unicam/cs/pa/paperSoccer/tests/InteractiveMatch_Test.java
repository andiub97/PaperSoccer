package it.unicam.cs.pa.paperSoccer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.match.InteractiveMatch;
import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;

class InteractiveMatch_Test {
	
	DefaultRuleSet ref = new DefaultRuleSet();
	Ball b = new Ball(0, 0);
	InteractiveMatch i = new InteractiveMatch(13,9);
	Cell start = i.getField().getCell(5, 5);
	Cell dest = i.getField().getCell(4, 5);

	
	@Test
	void playInteractive_Test() {
		//i.getPlayers()[i.getCurrentPlayer()].moveBall(b, dest);
		i.getBall().setX(5);
		i.getBall().setY(5);
		i.playInteractive(dest);
		assertTrue(i.getPlayers()[i.getCurrentPlayer()].getMoves() == 1);
		assertTrue(start.getArrayLoc().contains(Directions.NORTH));
		assertTrue(dest.getArrayLoc().contains(Directions.SOUTH));


		
	}



	@Test
	void CheckDest_Test() {
		i.getBall().setX(5);
		i.getBall().setY(5);
		int currentPlayer = 0;

		if ( i.getReferee().isEnd(i.getCurrentPlayer()) ) {
			assert(i.getReferee().checkDest(dest,currentPlayer)==false);
		}
		
			if ( ! i.getReferee().checkMove(dest) ) {
				assert(i.getReferee().checkDest(dest, currentPlayer) == false);
			}
		
	}


}