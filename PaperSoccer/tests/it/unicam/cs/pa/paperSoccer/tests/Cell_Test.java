package it.unicam.cs.pa.paperSoccer.tests;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.CellLocation;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.Utils;


class Cell_Test {

	Cell c = new Cell(new CellLocation(9,5));
	Cell c1 = new Cell(new CellLocation(8,5));
	
	
	@Test
	void arrayLocIsFull_Test() {
		c.addListDirections(Directions.NORTH, Directions.EAST, Directions.NORTH_EAST, Directions.NORTH_WEST, Directions.SOUTH,
							Directions.SOUTH_EAST, Directions.SOUTH_WEST, Directions.WEST);
		assertTrue(c.arrayLocIsFull());
	}
	
	
	@Test
	void addDirections_Test() {
		c.addListDirections(Directions.SOUTH);
		assertTrue(c.getArrayLoc().contains(Directions.SOUTH));
	}

	
	@Test
	void matchDirections_Test() {
		assert(Directions.NORTH.equals(Utils.matchDirection(c,c1)));
	}


}