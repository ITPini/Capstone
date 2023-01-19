package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class GreyscaleTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new Greyscale();
    private final Color color = new Color(201, 193, 99);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(0.85f);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(166, imageAlgorithm.calculateRed(color));
        assertEquals(165, imageAlgorithm.calculateGreen(color));
        assertEquals(160, imageAlgorithm.calculateBlue(color));
    }
}