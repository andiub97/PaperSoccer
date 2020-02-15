package it.unicam.cs.pa.paperSoccer.model.player;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;

public class InteractivePlayer extends Player {

    public InteractivePlayer(int id, String name, DefaultRuleSet ruleSet){
        super(id, name, ruleSet);
    }

    public void moveBall(Ball ball, Cell dest){

        ball.setY(dest.getLoc().getRow());
        ball.setX(dest.getLoc().getColumn());

    }

}