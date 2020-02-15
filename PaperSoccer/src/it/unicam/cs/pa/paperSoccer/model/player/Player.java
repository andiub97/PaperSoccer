package it.unicam.cs.pa.paperSoccer.model.player;

import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;
/*
 * 
 * 
 * 
 * valutare la possibilità di definire interfacce per i moveBall 
 */
public abstract class Player {

    int id;
    String name;
    private int moves = 1;

    DefaultRuleSet ruleSet;

    Player(int id, String name, DefaultRuleSet ruleSet){

        this.id = id;
        this.name = name;
        this.ruleSet = ruleSet;

    }

    public void increaseMoves(){
        this.moves++;
    }

    public void decreaseMoves(){
        this.moves--;
    }

    //============================================================================//
    //getters

    public int getMoves() {
        return moves;
    }


}