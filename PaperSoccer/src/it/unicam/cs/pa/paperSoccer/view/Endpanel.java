package it.unicam.cs.pa.paperSoccer.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Endpanel extends JFrame{

    private JPanel pannello;
    private JLabel etichetta;
    private JButton nuovaBtn;
    private JButton optzBtn;

    private BufferedImage frameIcon;

    Endpanel(String winnerName){

        //=========================FINESTRA==================================

        try{
            frameIcon = ImageIO.read(new File("src/it/unicam/cs/pa/paperSoccer/view/drawpanel/frameIcon.png"));
        } catch (Exception ex){
            ex.printStackTrace();
        }

        setTitle("ProEvolutionPaperSoccerInternational 20");
        setIconImage(frameIcon);
        setDefaultCloseOperation(3);
        setSize(400,190);
        setResizable(false);
        setVisible(true);
        setAlwaysOnTop(true);

        pannello = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);

        //=========================CONTENUTO=======================================
        etichetta = new JLabel(winnerName);
        constraints.gridx = 2;
        constraints.gridy = 0;
        pannello.add(etichetta, constraints);

        nuovaBtn = new JButton("Rematch");
        nuovaBtn.setEnabled(true);
        constraints.gridy = 1;
        constraints.gridx = 0;
        pannello.add(nuovaBtn, constraints);

        optzBtn = new JButton("Option");
        optzBtn.setEnabled(true);
        constraints.gridy = 1;
        constraints.gridx = 3;
        pannello.add(optzBtn, constraints);
        //==========================PACKING============================================
        pannello.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Congratulazioni!"));

        add(pannello);
        setLocationRelativeTo(null);
    }


    //===========================GETTER PER CONTROLLER================================================

    public JButton getNuovaBtn() {
        return nuovaBtn;
    }

    public JButton getOptzBtn() {
        return optzBtn;
    }

}
