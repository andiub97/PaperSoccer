package it.unicam.cs.pa.paperSoccer.tests;



import org.junit.jupiter.api.Test;


import it.unicam.cs.pa.paperSoccer.controller.StartPanelController;
import it.unicam.cs.pa.paperSoccer.controller.InteractiveMatchController;
import it.unicam.cs.pa.paperSoccer.controller.RandomMatchController;

import it.unicam.cs.pa.paperSoccer.view.View;

class StartPanelController_Test {
	
	View view = new View();
	StartPanelController s = new StartPanelController(view);

	@Test
	void addStartBtn_Test() {
		int row = 13;
		int col = 9;
		s.setView(view);
        if(s.getView().getStartpanel().getPvp().isSelected()){
			assert(new InteractiveMatchController(view, row, col)) != null;
        }
        
        if(s.getView().getStartpanel().getMvm().isSelected()){
            assert (new RandomMatchController(view, row, col)) != null;
        }
		
	}

}