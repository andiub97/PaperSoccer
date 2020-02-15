package it.unicam.cs.pa.paperSoccer.model.core;

public class CellLocation {

    private final int row;
    private final int column;

    public CellLocation(int row, int column) {

        this.row = row;
        this.column = column;

    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public String toString () {
        return "[row: " + row + ", column: " + column + "]";
    }



}