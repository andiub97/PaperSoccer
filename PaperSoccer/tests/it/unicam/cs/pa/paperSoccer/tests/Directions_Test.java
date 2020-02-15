package it.unicam.cs.pa.paperSoccer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.model.core.Directions;

class Directions_Test {
	Directions d = Directions.SOUTH;

	@Test
	void getOppositeDirections_Test() {
		assertTrue(Directions.NORTH.equals(d.getOppositeDirection()));
	}
	

	

}