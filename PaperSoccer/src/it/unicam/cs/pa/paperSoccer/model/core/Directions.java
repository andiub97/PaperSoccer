package it.unicam.cs.pa.paperSoccer.model.core;

public enum Directions {

    /**
     * ad ogni direzione corrisponde la sua opposta
     * e gli indici da sommare alla posizione della palla
     * per ottenere la cella verso la quale sarà effettuato lo spostamento (per random player)
     *
     * N.B. nord e sud sono specchiati per il semplice fatto che
     * il punto di coordinate (0,0) del frame si trova in alto a sinistra.
     * (serve per evitare di spostare la palla a sud quando in realtà
     * la si sposta verso l'alto, cioè a nord)
     */

    NORTH("SOUTH", -1,0),
    SOUTH("NORTH", 1, 0),
    EAST("WEST",   0, 1),
    WEST("EAST",   0,-1),

    NORTH_EAST("SOUTH_WEST",-1 ,1 ),
    NORTH_WEST("SOUTH_EAST", -1,-1),
    SOUTH_EAST("NORTH_WEST",1  ,1 ),
    SOUTH_WEST("NORTH_EAST", 1 ,-1);

    private String opposite;
    private int adjacentY;
    private int adjacentX;

    //costruttore
    Directions(String opposite, int adjacentY, int adjacentX){

        this.opposite = opposite;
        this.adjacentY = adjacentY;
        this.adjacentX = adjacentX;

    }


    //ritorna la stringa opposite dell'enum
    public String getOpposite() {
        return opposite;
    }

    //ritorna l'enum dalla stringa
    public Directions getOppositeDirection(){
        return valueOf(getOpposite());
    }

    //ritorna gli indici da sommare alla palla
    public int getAdjacentIndex(int index){

        int[] appArr = new int[2];

        appArr[0] = adjacentY;
        appArr[1] = adjacentX;

        return appArr[index];

    }


}
