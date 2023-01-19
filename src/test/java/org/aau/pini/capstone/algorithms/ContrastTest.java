package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class ContrastTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new Contrast();
    private final Color color = new Color(0, 255, 44);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(0.1f);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(0, imageAlgorithm.calculateRed(color));
        assertEquals(255, imageAlgorithm.calculateGreen(color));
        assertEquals(35, imageAlgorithm.calculateBlue(color));
    }

}