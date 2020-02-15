package it.unicam.cs.pa.paperSoccer.model.core;

import java.util.EnumSet;

public class MatrixSoccerField {

    private Size size;
    private Cell[][] matrix;

    private Cell[] goal1 = new Cell[3];
    private Cell[] goal2 = new Cell[3];


    public MatrixSoccerField (Size size) {

        this.size = size;
        this.matrix = new Cell[size.getRow()][size.getColumn()];

        for (int i = 0; i < size.getRow(); i++) {
            for (int j = 0; j < size.getColumn(); j++) {

                this.matrix[i][j] = new Cell(new CellLocation(i,j));

            }
        }

        this.goal1 = setGoal1();
        this.goal2 = setGoal2();

        init();
    }


    private Cell[] setGoal1() {

        //vedi con diubi

        goal1[0] = getCell(0, Math.floorDiv(getSize().getColumn(), 2)-1);  //sinistra
        goal1[1] = getCell(0, Math.floorDiv(getSize().getColumn(), 2));	   //centro
        goal1[2] = getCell(0, Math.floorDiv(getSize().getColumn(), 2)+1);  //destra

        return goal1;

    }

    private Cell[] setGoal2() {

        //vedi con diubi

        goal2[0] = getCell(getSize().getRow()-1, Math.floorDiv(getSize().getColumn(), 2)-1);
        goal2[1] = getCell(getSize().getRow()-1, Math.floorDiv(getSize().getColumn(), 2));
        goal2[2] = getCell(getSize().getRow()-1, Math.floorDiv(getSize().getColumn(), 2)+1);

        return goal2;

    }


    public void init() {

        setEdge(1,				0,                  Directions.SOUTH_EAST); //spigoloNW
        setEdge(size.getRow()-2,0,                  Directions.NORTH_EAST); //spigoloSW
        setEdge(1,				size.getColumn()-1, Directions.SOUTH_WEST); //spigoloNE
        setEdge(size.getRow()-2,size.getColumn()-1, Directions.NORTH_WEST); //spigoloSE

        setColumn(0,                  Directions.EAST, Directions.NORTH_EAST, Directions.SOUTH_EAST); //colonna sx
        setColumn(size.getColumn()-1, Directions.WEST, Directions.NORTH_WEST, Directions.SOUTH_WEST); //colonna dx

        setRow(1,					Directions.SOUTH, Directions.SOUTH_EAST, Directions.SOUTH_WEST); //rigaN esclusi pali della porta
        setRow(size.getRow()-2,		Directions.NORTH, Directions.NORTH_EAST, Directions.NORTH_WEST); //rigaS esclusi pali della porta
        setGoalLines();

    }



    public void setEdge(int row, int column, Directions freeDir){

        EnumSet.complementOf(EnumSet.of(freeDir))
                .forEach(Directions -> {
                    getCell(row, column).addListDirections(Directions);

                });

    }



    public void setColumn(int colToSet, Directions ...freeDir){

        EnumSet.complementOf(EnumSet.of(freeDir[0], freeDir[1], freeDir[2]))
                .forEach(Directions -> {
                    for(int i = 2; i < size.getRow()-2; i++) {
                        getCell(i, colToSet).addListDirections(Directions);
                    }
                });

    }



    public void setRow(int rowToSet, Directions ...freeDir) {

        EnumSet.complementOf(EnumSet.of(freeDir[0], freeDir[1], freeDir[2]))
                .forEach(Directions -> {
                    for(int i = 1; i < size.getColumn()-1; i++) {
                        if (i == this.getGoal1()[0].getLoc().getColumn()
                                || i == this.getGoal1()[1].getLoc().getColumn() || i == this.getGoal1()[2].getLoc().getColumn()
                                || i == this.getGoal2()[0].getLoc().getColumn() || i == this.getGoal2()[1].getLoc().getColumn()
                                || i == this.getGoal2()[2].getLoc().getColumn()) {}
                        else getCell(rowToSet, i).addListDirections(Directions);
                    }
                });

    }


    private void setGoalLines() {

        this.getCell(1, getGoal1()[0].getLoc().getColumn())
                .addListDirections(Directions.WEST, Directions.NORTH_WEST, Directions.NORTH);

        this.getCell(1, getGoal1()[2].getLoc().getColumn())
                .addListDirections(Directions.EAST, Directions.NORTH_EAST, Directions.NORTH);

        this.getCell(size.getRow()-2, getGoal2()[0].getLoc().getColumn())
                .addListDirections(Directions.WEST, Directions.SOUTH_WEST, Directions.SOUTH);

        this.getCell(size.getRow()-2, getGoal2()[2].getLoc().getColumn())
                .addListDirections(Directions.EAST, Directions.SOUTH_EAST, Directions.SOUTH);

    }



    //============================================================================//

    public Cell getCell(int row, int column){

        try{
            return this.matrix[row][column];
        }catch(Exception e){
            System.out.println("[getCell error] unable to return cell [" + row + "][" + column + "]");
        }

        return null;

    }

    public Size getSize() {
        return size;
    }

    public Cell[] getGoal1() {
        return goal1;
    }

    public Cell[] getGoal2() {
        return goal2;
    }

    //============================================================================//

}

