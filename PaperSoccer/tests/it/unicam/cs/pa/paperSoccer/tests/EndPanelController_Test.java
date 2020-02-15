package it.unicam.cs.pa.paperSoccer.tests;



//import java.awt.event.ActionEvent;

import org.junit.jupiter.api.Test;

//import static java.awt.event.ActionEvent.ACTION_PERFORMED;

import it.unicam.cs.pa.paperSoccer.controller.InteractiveMatchController;
import it.unicam.cs.pa.paperSoccer.controller.RandomMatchController;
import it.unicam.cs.pa.paperSoccer.controller.StartPanelController;
import it.unicam.cs.pa.paperSoccer.controller.EndPanelController;

import it.unicam.cs.pa.paperSoccer.model.match.InteractiveMatch;
import it.unicam.cs.pa.paperSoccer.model.match.Match;
import it.unicam.cs.pa.paperSoccer.model.match.RandomMatch;
import it.unicam.cs.pa.paperSoccer.view.View;

class EndPanelController_Test {
	
	View v = new View();
    Match matchType = new InteractiveMatch(13,9);
    String Rematch = new String("Rematch");
    EndPanelController e = new EndPanelController(v, matchType);


	@Test
	void addRematchListener_Test() {

		e.setRow(13);
		e.setColumn(9);
       
		//ActionEvent event = new ActionEvent(e, ACTION_PERFORMED, Rematch);
        
        //v.getEndpanel().getNuovaBtn().getActionListeners()[0].actionPerformed(event);
        if(matchType.getClass() == InteractiveMatch.class) 
        	assert((new InteractiveMatchController(new View(), e.getRow(), e.getColumn())) != null);
        else if(matchType.getClass() == RandomMatch.class) 
        	assert ((new RandomMatchController(new View(), e.getRow(), e.getColumn())) != null);
	}
	
	@Test
	void addOptionListener_Test() {
		
		
		//ActionEvent event = new ActionEvent(e, ACTION_PERFORMED, null);

		//v.getEndpanel().getOptzBtn().getActionListeners()[0].actionPerformed(event);
		
		assert new StartPanelController(new View()) != null;

	}
	
	
	
}
