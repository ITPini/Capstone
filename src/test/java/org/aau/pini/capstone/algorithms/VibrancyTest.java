package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class VibrancyTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new Vibrancy();
    private final Color color = new Color(51, 170, 189);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(0);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(51, imageAlgorithm.calculateRed(color));
        assertEquals(170, imageAlgorithm.calculateGreen(color));
        assertEquals(189, imageAlgorithm.calculateBlue(color));
    }
}