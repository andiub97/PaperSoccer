package it.unicam.cs.pa.paperSoccer.controller;

import it.unicam.cs.pa.paperSoccer.model.match.InteractiveMatch;
import it.unicam.cs.pa.paperSoccer.model.match.Match;
import it.unicam.cs.pa.paperSoccer.model.match.RandomMatch;
import it.unicam.cs.pa.paperSoccer.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndPanelController {

    private int row = StartPanelController.row;
	private int column = StartPanelController.column;

    private Match matchType;
    private View view;

    public EndPanelController(View view, Match matchType){

        this.view = view;
        this.matchType = matchType;

        view.initEndPanel(matchType.getReferee().getWinnerString());
        addRematchListener();
        addOptionListener();

    }

    private void addRematchListener(){

        ActionListener rematchBtn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(matchType.getClass() == InteractiveMatch.class) new InteractiveMatchController(new View(), row, column);
                else if(matchType.getClass() == RandomMatch.class) new RandomMatchController(new View(), row, column);

                resetGameStatus();

            }
        };

        view.getEndpanel().getNuovaBtn().addActionListener(rematchBtn);

    }

    private void addOptionListener(){

        ActionListener optionBtn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new StartPanelController(new View());
                resetGameStatus();

            }
        };

        view.getEndpanel().getOptzBtn().addActionListener(optionBtn);

    }

    private void resetGameStatus(){

        view.getCampo().getFinestra().dispose();
        view.getEndpanel().dispose();
        //view.getCampo().setTurno(true);

    }

    
    
    
    public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}
}
