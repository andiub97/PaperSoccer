package it.unicam.cs.pa.paperSoccer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.core.Size;
import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;

class DefaultRuleSet_Test {
	
    private Size size = new Size(13,9);
	MatrixSoccerField field = new MatrixSoccerField(size);
    Ball ball = new Ball(4,1);
    private int currentPlayer;
	DefaultRuleSet ref = new DefaultRuleSet();
    
    
	@Test
	void checkEdge_Cell_Test() {
		
		ball.setX(6);
		ball.setY(8);
		assertTrue(ref.checkEdge(field.getCell(ball.getX(), ball.getY())));
	}
	
	
	
	
	@Test
	void checkMove_Dir_Test() {
		
		
		this.ball.setX(5);
		this.ball.setY(5);
		ref.setBall(ball);
		ref.setField(field);
		
		
		field.getCell(ball.getY()-1, ball.getX()).addListDirections(Directions.SOUTH_WEST, Directions.EAST, Directions.NORTH_EAST,
																	Directions.NORTH_WEST, Directions.WEST,Directions.SOUTH_EAST);

		assert(ref.checKMove(Directions.NORTH) == Directions.NORTH) ;
	}
	
	@Test
	void checkMove_Cell_Test() {
		
		ball.setX(5);
		ball.setY(5);
		
		ref.setBall(ball);
		ref.setField(field);
		assertTrue(ref.checkMove(this.field.getCell(4, 5)));
	}
	
	
	
	@Test
	void score_Test () {
		
		ball.setX(4);
		ball.setY(0);
		ref.setBall(ball);
		ref.setField(field);
		

	    
	    assertTrue(ref.score());
	}
	
	@Test
	void noMovesAvailable_Test () {
		
		ball.setX(5);
		ball.setY(5);
		ref.setBall(ball);
		ref.setField(field);
		field.getCell(ball.getY(), ball.getX()).addListDirections(Directions.values());
		
	    
	    assertTrue(ref.noMovesAvailable(currentPlayer));
	}
}