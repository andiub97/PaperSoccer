package it.unicam.cs.pa.paperSoccer.tests;


import static org.junit.Assert.assertTrue;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

import it.unicam.cs.pa.paperSoccer.controller.InteractiveMatchController;
import it.unicam.cs.pa.paperSoccer.model.match.InteractiveMatch;
import it.unicam.cs.pa.paperSoccer.view.View;

class InteractiveMatchController_Test {

	View v = new View();
	InteractiveMatchController c = new InteractiveMatchController(v, 13, 9);
    InteractiveMatch interactiveMatch;
	
	
	@Test
	void addClickedCellUpdater_Test() {
		
        JPanel ghiera = v.getCampo().getGhiera();

        //I parametri numero 5 e 6 devono essere moltiplicati per 50 
        MouseEvent e = new MouseEvent(ghiera, 0, 0, 0, 300 ,250 , 0, false);


        ghiera.getMouseListeners()[0].mouseClicked(e);
		assertTrue(c.getClickedCell().getLoc().getRow() == (c.getInteractiveMatch().getField().getCell(5, 6).getLoc().getRow()));

    }
	
	// y ->righe, x-> colonne
	@Test
	public void addInteractiveListener_Test(){

        JPanel ghiera = v.getCampo().getGhiera();

        MouseEvent e = new MouseEvent(ghiera, 0, 0, 0, 250, 250 , 0, false);

        ghiera.getMouseListeners()[0].mouseClicked(e);
        ghiera.getMouseListeners()[1].mouseClicked(e);

		assertTrue(c.getInteractiveMatch().getBall().getX()==5);
		assertTrue(c.getInteractiveMatch().getBall().getY()==5);
    }


}