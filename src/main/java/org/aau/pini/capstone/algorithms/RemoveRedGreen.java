package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class RemoveRedGreen extends RemoveRed {
    RemoveRedGreen() {
        super();
        super.name = "Remove Red and Green Color Channel";
    }

    @Override
    public int calculateGreen(Color color) {
        return color.getGreen() - (int) (color.getGreen() * factor);
    }
}