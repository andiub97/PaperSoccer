package it.unicam.cs.pa.paperSoccer.model.ruleSet;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.core.Utils;

//import it.unicam.cs.pa.paperSoccer.model.player.Player;

public class DefaultRuleSet implements checkEdge, checkMove, checkEnd {

    private MatrixSoccerField field;
    private Ball ball;
    private String winnerString;

    
    
    public boolean checkDest(Cell dest, int currentPlayer){

        //ignora i click dopo la creazione dell' end panel
        if(this.isEnd(currentPlayer)) return false;

        //check direzione non disponibile
        if( ! this.checkMove(dest)) return false;

        //non salta il turno se si clicca la palla
        if(dest.getLoc() == field.getCell(ball.getY(), ball.getX()).getLoc()) return false;

        return true;

    }

    
    //===========================================================================
    //checkEdge interface

    @Override
    public boolean checkEdge(Cell dest) {

        if( (dest.getArrayLoc().size() > 1) && ( ! dest.arrayLocIsFull()) ) return true;
        else return false;

    }

    @Override
    public boolean checkEdge(Directions dir) {

        Cell dest  = field.getCell(ball.getY(), ball.getX());

        if( (dest.getArrayLoc().size() > 1) && ( ! dest.arrayLocIsFull()) ) return true;
        else return false;

    }

    //===========================================================================
    //checkMove interface

    @Override
    public boolean checkMove(Cell dest){

        Cell start = field.getCell(ball.getY(), ball.getX());
        Directions destDir = Utils.matchDirection(start,dest);

        //check click su cella adiacente alla palla
        if(destDir == null) return false;

            //check della validità della mossa
        else if( ! start.getArrayLoc().contains(destDir) )return true;

        return false;

    }

    @Override
    public Directions checKMove(Directions... dir){

        //evita il suicidio se può per ogni direzione
        for (Directions x : dir){

            Cell dest = field.getCell(ball.getY() + x.getAdjacentIndex(0), ball.getX() + x.getAdjacentIndex(1));
            Cell start = field.getCell(ball.getY(), ball.getX());

            if (! start.getArrayLoc().contains(x) && dest.getArrayLoc().size() <= 6) {
                return x;
            }
        }

        //contempla il suicidio se app == 0

        for (Directions x :dir){

            Cell start = field.getCell(ball.getY(), ball.getX());

            if(! start.getArrayLoc().contains(x)) {
                return x;
            }

        }

        return checKMove();
    }

    
        //===========================================================================
    //checkEnd interface

    @Override
    public boolean score() {

        for(int i = 0; i < 3; i++){
            if(ball.getY() == field.getGoal1()[i].getLoc().getRow() && ball.getX() == field.getGoal1()[i].getLoc().getColumn()){
                winnerString = ("PLAYER 1 WINS!");
                return true;
            }
            else if(ball.getY() == field.getGoal2()[i].getLoc().getRow() && ball.getX() == field.getGoal2()[i].getLoc().getColumn()) {
                winnerString = ("PLAYER 2 WINS!");
                return true;
            }
        }

        return false;

    }

    @Override
    public boolean noMovesAvailable(int currentPlayer) {

        if(field.getCell(ball.getY(), ball.getX()).arrayLocIsFull()) {

            if(currentPlayer == 0){
                winnerString = ("PLAYER 1 WINS!");
                return true;
            }

            else if(currentPlayer == 1){
                winnerString = ("PLAYER 2 WINS!");
                return true;
            }

        }

        return false;

    }

    @Override
    public boolean isEnd(int currentPlayer){

        if(score()) return true;
        else return noMovesAvailable(currentPlayer);

    }

    //===========================================================================
    //getters e setters

    public String getWinnerString() {
        return winnerString;
    }

    public void setField(MatrixSoccerField field) {
        this.field = field;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

}
