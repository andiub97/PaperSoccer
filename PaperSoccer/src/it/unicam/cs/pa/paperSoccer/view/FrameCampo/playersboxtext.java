package it.unicam.cs.pa.paperSoccer.view.FrameCampo;

import javax.swing.*;
import java.awt.*;

class playersboxtext extends JPanel{

    private JLabel player1;
    private JLabel freccia;
    private JLabel player2;

    playersboxtext(){

        setBackground(new Color(19, 161, 0));

        //SCRITTA PLAYER1
        player1 = new JLabel(" PLAYER 1 ");
        player1.setOpaque(true);
        player1.setBackground(new Color(0, 0, 255));
        player1.setFont(player1.getFont().deriveFont(20.0f));
        player1.setForeground(Color.white);
        add(player1);

        //FRECCIATURNO
        freccia = new JLabel();
        setttext();
        freccia.setFont(freccia.getFont().deriveFont(20.0f));
        freccia.setForeground(Color.white);
        add(freccia);


        //SCRITTA PLAYER2
        player2 = new JLabel(" PLAYER 2 ");
        player2.setOpaque(true);
        player2.setBackground(new Color(255, 0, 0));
        player2.setFont(player2.getFont().deriveFont(20.0f));
        player2.setForeground(Color.white);
        add(player2);
    }


    void setttext(){

        if (Campo.isTurno()) {
            freccia.setText("        \u2B9C        "); }
        else {
            freccia.setText("        \u2B9E        "); }
    }


}

