package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class GreyscaleAveragingTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new GreyscaleAveraging();
    private final Color color = new Color(102, 128, 141);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(0.5f);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(61, imageAlgorithm.calculateRed(color));
        assertEquals(61, imageAlgorithm.calculateGreen(color));
        assertEquals(61, imageAlgorithm.calculateBlue(color));
    }
}