package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

class InvertTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new Invert();
    private final Color color = new Color(136, 12, 70);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(0.3f);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(0, imageAlgorithm.calculateRed(color));
        assertEquals(64, imageAlgorithm.calculateGreen(color));
        assertEquals(6, imageAlgorithm.calculateBlue(color));
    }
}