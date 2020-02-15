package it.unicam.cs.pa.paperSoccer.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Startpanel extends JFrame{

    private JPanel pannello;
    private JLabel numerogiocatori;

    private JRadioButton pvp;
    private JRadioButton mvm;
    private ButtonGroup gruppo;

    private JLabel grandezzacampo;

    private SpinnerNumberModel columnModel = new SpinnerNumberModel(9,7,21,2);
    private JSpinner larghezza;

    private SpinnerNumberModel rowModel = new SpinnerNumberModel(13,7,21,2);
    private JSpinner altezza;

    private JButton playBtn;

    private BufferedImage frameIcon;

    Startpanel() {

        //=====================FINESTRA==============================================

        try{
            frameIcon = ImageIO.read(new File("src/it/unicam/cs/pa/paperSoccer/view/drawpanel/frameIcon.png"));
        } catch (Exception ex){
            ex.printStackTrace();
        }

        setIconImage(frameIcon);
        setTitle("ProEvolutionPaperSoccerInternational 20");
        setDefaultCloseOperation(3);
        setResizable(false);
        setVisible(true);

        pannello = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        //======================NUMERO GIOCATORI===============================================
        numerogiocatori = new JLabel("Specificare il tipo di partita:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        pannello.add(numerogiocatori, constraints);

        pvp = new JRadioButton("1 vs 1");
        pvp.setEnabled(true);
        constraints.gridx = 1;
        pannello.add(pvp, constraints);

        mvm = new JRadioButton("PC vs PC");
        mvm.setEnabled(true);
        constraints.gridx = 2;
        pannello.add(mvm, constraints);

        gruppo = new ButtonGroup();
        gruppo.add(pvp);
        gruppo.add(mvm);

        pvp.setSelected(true);

        //======================GRANDEZZA DEL CAMPO===========================================
        grandezzacampo = new JLabel("Specificare la grandezza del campo:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        pannello.add(grandezzacampo, constraints);

        larghezza = new JSpinner(columnModel);
        JFormattedTextField td = ((JSpinner.DefaultEditor) larghezza.getEditor()).getTextField();
        td.setEditable(false);
        larghezza.setFocusable(false);
        constraints.gridx = 1;
        pannello.add(larghezza, constraints);

        altezza = new JSpinner(rowModel);
        JFormattedTextField tb = ((JSpinner.DefaultEditor) altezza.getEditor()).getTextField();
        tb.setEditable(false);
        altezza.setFocusable(false);
        constraints.gridx = 2;
        pannello.add(altezza, constraints);


        //========================BOTTONI MENU================================================
        playBtn = new JButton("Start");
        constraints.gridx = 1;
        constraints.gridy = 2;
        pannello.add(playBtn, constraints);

        //===========================PACKING================================================
        pannello.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Opzioni"));

        add(pannello);
        pack();
        setLocationRelativeTo(null);
    }

    //===========================GETTERS PER CONTROLLER================================================

    public JRadioButton getPvp() {
        return pvp;
    }

    public JRadioButton getMvm() {
        return mvm;
    }

    public JSpinner getAltezza() {
        return altezza;
    }

    public JSpinner getLarghezza() {
        return larghezza;
    }

    public JButton getPlayBtn() {
        return playBtn;
    }

}
