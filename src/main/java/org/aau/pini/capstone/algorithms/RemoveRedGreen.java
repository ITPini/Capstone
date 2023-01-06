/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class RemoveRedGreen extends RemoveRed {
    RemoveRedGreen() {
        super();
        this.name = "Remove Red and Green Color Channel";
    }

    @Override
    public int calculateGreen(Color color) {
        return color.getGreen() - (int) (color.getGreen() * factor);
    }
}