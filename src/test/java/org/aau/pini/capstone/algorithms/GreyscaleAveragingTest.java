/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GreyscaleAveragingTest implements AlgorithmTest {
    private final ImageAlgorithm imageAlgorithm = new GreyscaleAveraging();

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        imageAlgorithm.setFactor(0.5f);
        Color color = new Color(102, 128, 141);

        assertEquals(61, imageAlgorithm.calculateRed(color));
        assertEquals(61, imageAlgorithm.calculateGreen(color));
        assertEquals(61, imageAlgorithm.calculateBlue(color));
    }
}