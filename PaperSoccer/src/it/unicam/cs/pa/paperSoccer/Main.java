package it.unicam.cs.pa.paperSoccer;

import it.unicam.cs.pa.paperSoccer.controller.StartPanelController;
import it.unicam.cs.pa.paperSoccer.view.View;
import javax.swing.*;

public class Main {

    public static void main(String[] argv){

        System.out.println(

                "CREDITS:"             + "\n" +
                        "Di Ubaldo Andrea"     + "\n" +
                        "Mendicino Riccardo"   + "\n" +
                        "Francalancia Simone"  + "\n" +
                        "L31 Informatica 2019"

        );

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new StartPanelController(new View());

            }
        });

    }

}
