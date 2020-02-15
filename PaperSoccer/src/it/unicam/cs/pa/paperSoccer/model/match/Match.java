package it.unicam.cs.pa.paperSoccer.model.match;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.core.Utils;
import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;

/**
 * Questa classe definisce il modello di match generico, con i due giocatori, il campo, la palla e l'arbitro
 * 
 * 
 * 
 * 
 *     
    un tipo di match usa questo metodo, il random quello sotto, valutare di spostare i metodi nella classe cella
 */

public abstract class Match {

    //id per alternare i turni
    static final int PLAYER1 = 0;
    static final int PLAYER2 = 1;
    int currentPlayer;

    MatrixSoccerField field;
    protected  Ball ball;

    DefaultRuleSet referee = new DefaultRuleSet();

    //============================================================================

    int otherPlayer() {
        return (currentPlayer + 1) % 2;
    }

    //============================================================================
    //getters e setters

    public Ball getBall() {
        return ball;
    }

    public MatrixSoccerField getField() {
        return field;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public DefaultRuleSet getReferee() {
        return referee;
    }

    //============================================================================

}
