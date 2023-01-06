/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import java.awt.*;

public class RemoveRed extends ImageAlgorithm {
    RemoveRed() {
        this.name = "Remove Red Color Channel";
        this.minimumFactor = 0;
        this.maximumFactor = 1;
    }

    @Override
    public int calculateRed(Color color) {
        return color.getRed() - (int) (color.getRed() * factor);
    }
}
