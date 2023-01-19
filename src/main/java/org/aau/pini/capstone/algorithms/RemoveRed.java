package org.aau.pini.capstone.algorithms;

import java.awt.Color;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class RemoveRed extends ImageAlgorithm {
    RemoveRed() {
        super.name = "Remove Red Color Channel";
        super.minimumFactor = 0;
        super.maximumFactor = 1;
    }

    @Override
    public int calculateRed(Color color) {
        return color.getRed() - (int) (color.getRed() * factor);
    }
}
