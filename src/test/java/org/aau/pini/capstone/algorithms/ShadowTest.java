package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class ShadowTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new Shadow();
    private final Color color = new Color(5, 31, 45);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(1);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(9, imageAlgorithm.calculateRed(color));
        assertEquals(58, imageAlgorithm.calculateGreen(color));
        assertEquals(82, imageAlgorithm.calculateBlue(color));
    }
}