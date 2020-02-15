package it.unicam.cs.pa.paperSoccer.model.match;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.core.Size;
import it.unicam.cs.pa.paperSoccer.model.core.Utils;
import it.unicam.cs.pa.paperSoccer.model.player.InteractivePlayer;

public class InteractiveMatch extends Match {

    private InteractivePlayer[] players = new InteractivePlayer[2];

    public InteractivePlayer[] getPlayers() {
		return players;
	}

	public InteractiveMatch(int row, int column){

        currentPlayer = PLAYER1;

        players[0] = new InteractivePlayer(PLAYER1, "Player 1", referee);
        players[1] = new InteractivePlayer(PLAYER2, "Player 2", referee);

        field = new MatrixSoccerField(new Size(row, column));
        ball = new Ball(row/2, column/2);

        referee.setBall(ball);
        referee.setField(field);

    }

    public void playInteractive(Cell dest){

        if(players[currentPlayer].getMoves() > 0){

            //aggiornamento direzioni celle
            Utils.updateCellsArrayLoc(dest,field,ball);
        	
            //spostamento palla
            players[currentPlayer].moveBall(ball, dest);

            //rimbalzo palla
            if(referee.checkEdge(dest))players[currentPlayer].increaseMoves();

            players[currentPlayer].decreaseMoves();
        	
            //cambio turni giocatori
            	if(players[currentPlayer].getMoves() == 0){

                players[currentPlayer].increaseMoves();
                currentPlayer = otherPlayer();
            
            	}
            
        	}
       

    }

}
