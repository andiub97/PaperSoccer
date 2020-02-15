package it.unicam.cs.pa.paperSoccer.controller;

import it.unicam.cs.pa.paperSoccer.model.match.RandomMatch;
import it.unicam.cs.pa.paperSoccer.view.View;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static java.awt.event.KeyEvent.VK_SPACE;

/**
 * controller che gestisce il match pc vs pc
 */
public class RandomMatchController {

    private View view;
    private RandomMatch randomMatch;



	public RandomMatchController(View view, int row, int column){

        this.view = view;
        this.randomMatch = new RandomMatch(row, column);
        this.view.initCampo(row, column);

        addSpacebarListener();

    }

    private void addSpacebarListener(){

        KeyListener spacebarListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getKeyCode() == VK_SPACE){

                    if(randomMatch.getReferee().isEnd(randomMatch.getCurrentPlayer())) return;

                    randomMatch.playRandom();
                    view.getCampo().cambioturno(randomMatch.getCurrentPlayer());
                    view.getCampo().getGlass().draw(randomMatch.getBall().getY()*50, randomMatch.getBall().getX()*50);

                    if(randomMatch.getReferee().isEnd(randomMatch.getCurrentPlayer()))
                        new EndPanelController(view, randomMatch);

                }

            }
        };

        view.getCampo().getFinestra().addKeyListener(spacebarListener);

    }
    
    
    
    public RandomMatch getRandomMatch() {
		return randomMatch;
	}


}
