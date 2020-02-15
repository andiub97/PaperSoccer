package it.unicam.cs.pa.paperSoccer.model.core;

public class Utils {

	//confronto tra celle, da valutare lo spostamento
    public static Directions matchDirection(Cell start, Cell dest) {

        int startRow = start.getLoc().getRow();
        int startCol = start.getLoc().getColumn();

        int destRow = dest.getLoc().getRow();
        int destCol = dest.getLoc().getColumn();


        for (Directions d : Directions.values()) {
            if(d.getAdjacentIndex(0)== destRow-startRow && d.getAdjacentIndex(1)==destCol-startCol) {
                return d;
            }
        }
        return null;

    }
    
    
    
    
    public static void updateCellsArrayLoc(Cell dest, MatrixSoccerField field, Ball ball){

        Cell start = field.getCell(ball.getY(), ball.getX());

        try{

            start.getArrayLoc().add(Utils.matchDirection(start, dest));
            dest.getArrayLoc().add(Utils.matchDirection(start,dest).getOppositeDirection());

        }catch(Exception e){
            System.out.println("can't update dest -> " + dest.getLoc().toString() + " array list");
        }

    }
}
