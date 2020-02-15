package it.unicam.cs.pa.paperSoccer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.core.Size;

class MatrixSoccerField_Test {

	Size size = new Size(13,9);
	MatrixSoccerField f = new MatrixSoccerField(size);
	
	
	@Test
	void InitTest() {
		f.init();
	}

	
	
	@Test
	void setEdge_Test() {
		
		f.setEdge(0, 0, Directions.NORTH);
		
		assertFalse(f.getCell(0, 0).getArrayLoc().contains(Directions.NORTH));
		
		assertTrue(f.getCell(0, 0).getArrayLoc().contains(Directions.EAST));
		assertTrue(f.getCell(0, 0).getArrayLoc().contains(Directions.WEST));
		assertTrue(f.getCell(0, 0).getArrayLoc().contains(Directions.SOUTH_EAST));
		assertTrue(f.getCell(0, 0).getArrayLoc().contains(Directions.SOUTH_WEST));
		assertTrue(f.getCell(0, 0).getArrayLoc().contains(Directions.NORTH_EAST));
		assertTrue(f.getCell(0, 0).getArrayLoc().contains(Directions.NORTH_WEST));
		assertTrue(f.getCell(0, 0).getArrayLoc().contains(Directions.SOUTH));
	}
	
	
	@Test
	void setColumn_Test() {
		
		f.setColumn(0, Directions.EAST, Directions.NORTH_EAST, Directions.SOUTH_EAST);
		
		assertFalse(f.getCell(2, 0).getArrayLoc().contains(Directions.NORTH_EAST));
		assertFalse(f.getCell(2, 0).getArrayLoc().contains(Directions.SOUTH_EAST));
		assertFalse(f.getCell(2, 0).getArrayLoc().contains(Directions.EAST));
		assertTrue(f.getCell(2, 0).getArrayLoc().contains(Directions.SOUTH));
		assertTrue(f.getCell(2, 0).getArrayLoc().contains(Directions.SOUTH_WEST));
		assertTrue(f.getCell(2, 0).getArrayLoc().contains(Directions.NORTH));
		assertTrue(f.getCell(2, 0).getArrayLoc().contains(Directions.NORTH_WEST));
		assertTrue(f.getCell(2, 0).getArrayLoc().contains(Directions.WEST));
	
	}
	
	
	@Test
	void setRow_Test() {
		
		f.setRow(1,Directions.SOUTH, Directions.SOUTH_EAST, Directions.SOUTH_WEST);
		
		
		assertTrue(f.getCell(1, 2).getArrayLoc().contains(Directions.NORTH));
		assertTrue(f.getCell(1, 2).getArrayLoc().contains(Directions.NORTH_WEST));
		assertTrue(f.getCell(1, 2).getArrayLoc().contains(Directions.EAST));
		assertTrue(f.getCell(1, 2).getArrayLoc().contains(Directions.NORTH_EAST));
		assertTrue(f.getCell(1, 2).getArrayLoc().contains(Directions.WEST));
	
	}
	
	
	@Test
	void setGoalLines() {
		f.getCell(1, f.getGoal1()[0].getLoc().getColumn()).getArrayLoc().contains(Directions.WEST);
		f.getCell(1, f.getGoal1()[0].getLoc().getColumn()).getArrayLoc().contains(Directions.NORTH_WEST);
		f.getCell(1, f.getGoal1()[0].getLoc().getColumn()).getArrayLoc().contains(Directions.NORTH);
		f.getCell(size.getRow()-2, f.getGoal2()[2].getLoc().getColumn()).getArrayLoc().contains(Directions.EAST);
		f.getCell(size.getRow()-2, f.getGoal2()[2].getLoc().getColumn()).getArrayLoc().contains(Directions.SOUTH_EAST);
		f.getCell(size.getRow()-2, f.getGoal2()[2].getLoc().getColumn()).getArrayLoc().contains(Directions.SOUTH);



	}
	
	



	
}