package it.unicam.cs.pa.paperSoccer.model.match;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.core.Size;
import it.unicam.cs.pa.paperSoccer.model.core.Utils;
import it.unicam.cs.pa.paperSoccer.model.player.RandomPlayer;

public class RandomMatch extends Match {

    private RandomPlayer[] players = new RandomPlayer[2];

    public RandomPlayer[] getPlayers() {
		return players;
	}

	public RandomMatch(int row, int column){

        currentPlayer = PLAYER1;

        players[0] = new RandomPlayer(PLAYER1, "Bot 1", referee);
        players[1] = new RandomPlayer(PLAYER2, "Bot 2", referee);

        field = new MatrixSoccerField(new Size(row, column));
        ball = new Ball(row/2, column/2);

        referee.setBall(ball);
        referee.setField(field);

    }

    public void playRandom(){

        if(players[currentPlayer].getMoves() > 0){

            Directions dir;
            
            //scelta direzione in base al player
            if(currentPlayer == PLAYER1) dir = players[currentPlayer].chooseDir1(ball, field);
            else dir = players[currentPlayer].chooseDir2(ball, field);
            
            Cell dest  = field.getCell(ball.getY() + dir.getAdjacentIndex(0), ball.getX() + dir.getAdjacentIndex(1));
            
            Utils.updateCellsArrayLoc(dest,field,ball);
            players[currentPlayer].moveBall(ball, dir);

            if(referee.checkEdge(dir)) players[currentPlayer].increaseMoves();

            players[currentPlayer].decreaseMoves();

            if(players[currentPlayer].getMoves() == 0){

                players[currentPlayer].increaseMoves();
                currentPlayer = otherPlayer();

            }
        }
    }


}
