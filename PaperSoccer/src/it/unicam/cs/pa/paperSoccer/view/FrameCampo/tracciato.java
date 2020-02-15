package it.unicam.cs.pa.paperSoccer.view.FrameCampo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * tracciato deve:
 *
 * 1 - essere settato come glasspane di campo
 * 2 - prendere i click del mouse e metterli dentro arrayclick
 * 3 - connettere i punti dentro arrayclick e disegnarli su se stesso
 *
 */

public class tracciato extends JPanel {

    private ArrayList<Point> arrayClick = new ArrayList<>();
    private BufferedImage ball;

    tracciato(int y, int x){

        arrayClick.add(new Point(y,x));
        setOpaque(false);

        try{
            ball = ImageIO.read(new File("src/it/unicam/cs/pa/paperSoccer/view/drawpanel/ball.png"));
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public void draw(int y, int x){

        arrayClick.add(new Point(y,x));
        repaint();

    }

    protected void paintComponent(Graphics g){

        //SCIA PALLA ===============================================
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.white);
        for (int i = 1; i < arrayClick.size(); i++) {
            g2.drawLine(
                    (int)arrayClick.get(i).getY()+25,
                    (int)arrayClick.get(i).getX()+25,
                    (int)arrayClick.get(i-1).getY()+25,
                    (int)arrayClick.get(i-1).getX()+25
            );
        }

        //CONTORNO PALLA ===============================================
        if (Campo.isTurno())g.setColor(Color.BLUE);
        else g.setColor(Color.RED);

        g.fillOval(
                (int) arrayClick.get(arrayClick.size()-1).getY()+15,
                (int) arrayClick.get(arrayClick.size()-1).getX()+15,
                19,19);

        //DISEGNO PALLA ===============================================
        g.drawImage(ball,
                (int) arrayClick.get(arrayClick.size()-1).getY(),
                (int) arrayClick.get(arrayClick.size()-1).getX(),
                null);

    }


}