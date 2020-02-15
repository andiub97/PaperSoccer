package it.unicam.cs.pa.paperSoccer.view.FrameCampo;

import javax.swing.*;
import java.awt.*;

class ghiera extends JPanel{

    private final String defaultPath = "src/it/unicam/cs/pa/paperSoccer/view/drawpanel/";

    private JLabel label;

    ghiera(int row, int column){

        setLayout(new GridLayout(row, column));

        for(int r = 0; r < row; r++)
        {
            for(int c = 0; c < column; c++)
            {
                if ((r==1 && c==0) || (r==0 && c==column/2-1) || (r==row-2 && c==column/2+1)){
                    setLabel("cornerNW.png");
                }
                else if ((r==row-2 && c==0)||(r==row-1 && c==column/2-1) || (r==1 && c==column/2+1)){
                    setLabel("cornerSW.png");
                }
                else if ((r==1 && c==column-1)|| (r==0 && c==column/2+1) || (r==row-2 && c==column/2-1)){
                    setLabel("cornerNE.png");
                }
                else if ((r==row-2 && c==column-1)|| (r==row-1 && c==column/2+1) || (r==1 && c==column/2-1)){
                    setLabel("cornerSE.png");
                }
                else if ((r<row-2 && r>1 && (c==0 || c==column-1))){
                    setLabel("vertical.png");
                }
                else if ((r==1 || r==row-2) && (c!=column/2 && c!=column/2-1 && c!=column/2+1)){
                    setLabel("horizzontal.png");
                }
                else if (r==0 && c==column/2){
                    setLabel("redgoal.png");
                }
                else if (r==row-1 &&  c==column/2){
                    setLabel("bluegoal.png");
                }

                else setLabel("cell.png");

                add(label);

            }
        }

    }

    private void setLabel(String path){

        label = new JLabel(new ImageIcon(defaultPath + path));

    }

}
