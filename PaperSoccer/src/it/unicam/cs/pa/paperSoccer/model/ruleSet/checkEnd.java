package it.unicam.cs.pa.paperSoccer.model.ruleSet;

public interface checkEnd {

    boolean score();
    boolean noMovesAvailable(int currentPlayer);
    boolean isEnd(int currentPlayer);

}
