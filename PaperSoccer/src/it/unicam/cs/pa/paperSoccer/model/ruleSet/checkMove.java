package it.unicam.cs.pa.paperSoccer.model.ruleSet;

import it.unicam.cs.pa.paperSoccer.model.core.Cell;
import it.unicam.cs.pa.paperSoccer.model.core.Directions;

public interface checkMove {

    boolean checkMove(Cell dest);
    Directions checKMove(Directions... dir);

}
