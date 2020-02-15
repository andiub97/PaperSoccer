package it.unicam.cs.pa.paperSoccer.model.ruleSet;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;

public interface checkEdge {

    boolean checkEdge(Cell dest);
    boolean checkEdge(Directions dir);

}
