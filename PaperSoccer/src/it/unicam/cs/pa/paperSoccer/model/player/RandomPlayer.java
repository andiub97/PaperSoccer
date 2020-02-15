package it.unicam.cs.pa.paperSoccer.model.player;

import it.unicam.cs.pa.paperSoccer.model.core.Ball;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;
import it.unicam.cs.pa.paperSoccer.model.core.MatrixSoccerField;
import it.unicam.cs.pa.paperSoccer.model.ruleSet.DefaultRuleSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RandomPlayer extends Player {

    public RandomPlayer(int id, String name, DefaultRuleSet ruleSet){
        super(id, name, ruleSet);
    }

    public Directions chooseDir1(Ball ball, MatrixSoccerField field){

        //if F=W/2
        if (ball.getX() == field.getSize().getColumn()/2){

            ArrayList<Directions> x = randomdir(Directions.NORTH_WEST, Directions.NORTH_EAST);
            ArrayList<Directions> y = randomdir(Directions.EAST, Directions.WEST);
            ArrayList<Directions> z = randomdir(Directions.SOUTH, Directions.SOUTH_EAST, Directions.SOUTH_WEST);

            return ruleSet.checKMove(
                    Directions.NORTH,
                    x.get(0),
                    x.get(1),
                    y.get(0),
                    y.get(1),
                    z.get(0),
                    z.get(1),
                    z.get(2)
            );
        }

        //if F<W/2
        else if (ball.getX() < field.getSize().getColumn()/2){

            ArrayList<Directions> x = randomdir(Directions.NORTH_WEST, Directions.EAST);
            ArrayList<Directions> y = randomdir(Directions.WEST, Directions.SOUTH_EAST, Directions.SOUTH, Directions.SOUTH_WEST);

            return ruleSet.checKMove(
                    Directions.NORTH_EAST,
                    Directions.NORTH,
                    x.get(0),
                    x.get(1),
                    y.get(0),
                    y.get(1),
                    y.get(2),
                    y.get(3)
            );
        }

        //if F>W/2
        else{

            ArrayList<Directions> x = randomdir(Directions.NORTH_EAST, Directions.WEST);
            ArrayList<Directions> y = randomdir(Directions.EAST, Directions.SOUTH_WEST, Directions.SOUTH_EAST, Directions.SOUTH);

            return ruleSet.checKMove(
                    Directions.NORTH_WEST,
                    Directions.NORTH,
                    x.get(0),
                    x.get(1),
                    y.get(0),
                    y.get(1),
                    y.get(2),
                    y.get(3)
            );
        }
    }

    public Directions chooseDir2(Ball ball, MatrixSoccerField field){

        //if F=W/2
        if (ball.getX() == field.getSize().getColumn()/2){

            ArrayList<Directions> x = randomdir(Directions.SOUTH_WEST, Directions.SOUTH_EAST);
            ArrayList<Directions> y = randomdir(Directions.EAST, Directions.WEST);
            ArrayList<Directions> z = randomdir(Directions.NORTH, Directions.NORTH_EAST, Directions.NORTH_WEST);

            return ruleSet.checKMove(
                    Directions.SOUTH,
                    x.get(0),
                    x.get(1),
                    y.get(0),
                    y.get(1),
                    z.get(0),
                    z.get(1),
                    z.get(2)
            );
        }

        //if F<W/2
        else if (ball.getX() < field.getSize().getColumn()/2){

            ArrayList<Directions> x = randomdir(Directions.SOUTH_WEST, Directions.EAST);
            ArrayList<Directions> y = randomdir(Directions.WEST, Directions.NORTH_EAST, Directions.NORTH, Directions.NORTH_WEST);

            return ruleSet.checKMove(
                    Directions.SOUTH_EAST,
                    Directions.SOUTH,
                    x.get(0),
                    x.get(1),
                    y.get(0),
                    y.get(1),
                    y.get(2),
                    y.get(3)
            );
        }

        //if F>W/2
        else{

            ArrayList<Directions> x = randomdir(Directions.SOUTH_EAST, Directions.WEST);
            ArrayList<Directions> y = randomdir(Directions.EAST, Directions.NORTH_WEST, Directions.NORTH_EAST, Directions.NORTH);

            return ruleSet.checKMove(
                    Directions.SOUTH_WEST,
                    Directions.SOUTH,
                    x.get(0),
                    x.get(1),
                    y.get(0),
                    y.get(1),
                    y.get(2),
                    y.get(3)
            );
        }
    }

    public void moveBall(Ball ball, Directions dir){

        ball.setY(ball.getY() + dir.getAdjacentIndex(0));
        ball.setX(ball.getX() + dir.getAdjacentIndex(1));

    }

    private ArrayList<Directions> randomdir(Directions... args){

        ArrayList<Directions> arr = new ArrayList<>(Arrays.asList(args));
        Collections.shuffle(arr);
        return arr;

    }


}
