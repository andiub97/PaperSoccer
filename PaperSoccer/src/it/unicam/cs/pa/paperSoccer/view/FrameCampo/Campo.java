package it.unicam.cs.pa.paperSoccer.view.FrameCampo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Campo {

    private JFrame finestra;
    private ghiera ghiera;
    private playersboxtext text;
    private tracciato glass;

    private BufferedImage frameIcon;

    private static boolean turno = true;


    public Campo(int row, int column){

        System.out.println("row: " + row);
        System.out.println("col: " + column);

        try{
            frameIcon = ImageIO.read(new File("src/it/unicam/cs/pa/paperSoccer/view/drawpanel/frameIcon.png"));
        } catch (Exception ex){
            ex.printStackTrace();
        }

        //FINESTRA DI GIOCO
        finestra = new JFrame("Pro Evolution Paper Soccer International 20");
        finestra.setIconImage(frameIcon);
        finestra.setDefaultCloseOperation(3);
        finestra.setLayout(new GridBagLayout());
        GridBagConstraints z = new GridBagConstraints();

        finestra.setResizable(false);
        finestra.setVisible(true);

        //PANNELLO SFONDO
        ghiera = new ghiera(row, column);

        z.fill = GridBagConstraints.HORIZONTAL;
        z.gridx = 0;
        z.gridy = 0;
        finestra.getContentPane().add(ghiera, z);

        //PANNELLO GIOCATORE
        text = new playersboxtext();
        z.fill = GridBagConstraints.HORIZONTAL;
        z.anchor = GridBagConstraints.PAGE_END;
        z.gridx = 0;
        z.gridy = 1;
        z.ipady = 16;
        finestra.getContentPane().add(text, z);

        //GLASSPANEL
        glass = new tracciato(row/2 *50, column/2 *50);

        //PACKING
        finestra.setGlassPane(glass);
        glass.setVisible(true);
        finestra.pack();
        finestra.setLocationRelativeTo(null);

    }


    public void cambioturno(int currentPlayer){

        if(currentPlayer == 0) turno = true;
        else turno = false;

        text.setttext();

    }

    static boolean isTurno() {
        return turno;
    }

    public static void setTurno(boolean turno) {
        Campo.turno = turno;
    }

    public JPanel getGhiera(){
        return this.ghiera;
    }

    public JFrame getFinestra() {
        return finestra;
    }

    public tracciato getGlass() {
        return glass;
    }

}
