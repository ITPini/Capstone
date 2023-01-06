/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ContrastTest implements AlgorithmTest {
    private final ImageAlgorithm imageAlgorithm = new Contrast();

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        imageAlgorithm.setFactor(0.1f);
        Color color = new Color(0, 255, 44);

        assertEquals(0, imageAlgorithm.calculateRed(color));
        assertEquals(255, imageAlgorithm.calculateGreen(color));
        assertEquals(35, imageAlgorithm.calculateBlue(color));
    }

}