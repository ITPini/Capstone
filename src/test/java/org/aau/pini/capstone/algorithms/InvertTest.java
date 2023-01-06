/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class InvertTest implements AlgorithmTest {
    private final ImageAlgorithm imageAlgorithm = new Invert();

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        imageAlgorithm.setFactor(0.3f);
        Color color = new Color(136, 12, 70);

        assertEquals(0, imageAlgorithm.calculateRed(color));
        assertEquals(64, imageAlgorithm.calculateGreen(color));
        assertEquals(6, imageAlgorithm.calculateBlue(color));
    }
}