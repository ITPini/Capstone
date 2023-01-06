/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class VibrancyTest implements AlgorithmTest {

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        ImageAlgorithm imageAlgorithm = new Vibrancy();
        Color color = new Color(51, 170, 189);

        assertEquals(51, imageAlgorithm.calculateRed(color));
        assertEquals(170, imageAlgorithm.calculateGreen(color));
        assertEquals(189, imageAlgorithm.calculateBlue(color));
    }
}