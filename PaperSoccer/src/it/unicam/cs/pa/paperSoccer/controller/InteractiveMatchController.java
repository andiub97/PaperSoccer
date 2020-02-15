package it.unicam.cs.pa.paperSoccer.controller;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;

import it.unicam.cs.pa.paperSoccer.model.match.InteractiveMatch;
import it.unicam.cs.pa.paperSoccer.view.View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * controller che gestisce il match player vs player
 */
public class InteractiveMatchController {

    private View view;
    private InteractiveMatch interactiveMatch;

    
	private int appY, appX;
    private Cell clickedCell;

    public InteractiveMatchController(View view, int row, int column){

        this.view = view;
        this.interactiveMatch = new InteractiveMatch(row, column);
        this.view.initCampo(row, column);

        addClickedCellUpdater();
        addInteractiveListener();

    }

    private void addClickedCellUpdater(){

        JPanel ghiera = view.getCampo().getGhiera();

        MouseListener clickListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {

                appY = ghiera.getComponentAt(e.getX(), e.getY()).getY();
                appX = ghiera.getComponentAt(e.getX(), e.getY()).getX();

                clickedCell = interactiveMatch.getField().getCell(appY/50,appX/50);

            }
        };

        ghiera.addMouseListener(clickListener);

    }

    private void addInteractiveListener(){

        MouseListener clickListener = new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {

                //gioco e aggiornamento grafica 
            	int currentPlayer = 0;
                if(interactiveMatch.getReferee().checkDest(clickedCell, currentPlayer)){

                   	interactiveMatch.playInteractive(clickedCell);
                    view.getCampo().cambioturno(interactiveMatch.getCurrentPlayer());
                    view.getCampo().getGlass().draw(appY, appX);

                } else {
                	
                    System.out.println("invalid cell");
                    return;
                }
                //creazione dell' end panel
                if(interactiveMatch.getReferee().isEnd(interactiveMatch.getCurrentPlayer()))
                    new EndPanelController(view, interactiveMatch);
            }
        };

        //aggiunta di clickListener a ghiera
        view.getCampo().getGhiera().addMouseListener(clickListener);

    }
    
    
    
    
    public Cell getClickedCell() {
		return clickedCell;
	}

	public void setClickedCell(Cell clickedCell) {
		this.clickedCell = clickedCell;
	}

	public InteractiveMatch getInteractiveMatch() {
		return interactiveMatch;
	}

	public int getAppY() {
		return appY;
	}

	public int getAppX() {
		return appX;
	}


}
