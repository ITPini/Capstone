/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GreyscaleTest implements AlgorithmTest {
    private final ImageAlgorithm imageAlgorithm = new Greyscale();

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        imageAlgorithm.setFactor(0.85f);
        Color color = new Color(201, 193, 99);

        assertEquals(166, imageAlgorithm.calculateRed(color));
        assertEquals(165, imageAlgorithm.calculateGreen(color));
        assertEquals(160, imageAlgorithm.calculateBlue(color));
    }
}