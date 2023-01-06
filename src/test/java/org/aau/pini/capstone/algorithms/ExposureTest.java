/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ExposureTest implements AlgorithmTest {
    private final ImageAlgorithm imageAlgorithm = new Exposure();

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        imageAlgorithm.setFactor(1);
        Color color = new Color(54, 68, 56);

        assertEquals(108, imageAlgorithm.calculateRed(color));
        assertEquals(136, imageAlgorithm.calculateGreen(color));
        assertEquals(112, imageAlgorithm.calculateBlue(color));
    }
}