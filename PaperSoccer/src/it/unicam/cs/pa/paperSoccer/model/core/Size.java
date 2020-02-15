package it.unicam.cs.pa.paperSoccer.model.core;

import java.util.List;

public class Size {

    private List<Integer> sizes;


    public Size(Integer[] sizes)throws IllegalArgumentException {

        if(sizes.length != 2) throw new IllegalArgumentException ("The array must contain a two integer values!");
        else this.sizes = List.of(sizes[0], sizes[1]);

    }

    public Size(Integer row, Integer column)throws IllegalArgumentException {
        this(new Integer[] {row, column});
    }


    public Integer getRow() {
        return this.sizes.get(0);
    }

    public Integer getColumn() {
        return this.sizes.get(1);
    }


}
