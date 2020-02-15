package it.unicam.cs.pa.paperSoccer.view;

import it.unicam.cs.pa.paperSoccer.view.FrameCampo.Campo;

public class View {

    private Startpanel startpanel;
    private Campo campo;
    private Endpanel endpanel;

    //init per controller
    public void initStartPanel(){
        startpanel = new Startpanel();
    }

    public void initCampo(int column, int row){
        campo = new Campo(column, row);
    }

    public void initEndPanel(String winnerName){
        endpanel = new Endpanel(winnerName);
    }


    //getters per controller
    public Startpanel getStartpanel() {
        return startpanel;
    }

    public Campo getCampo() {
        return campo;
    }

    public Endpanel getEndpanel() {
        return endpanel;
    }

}