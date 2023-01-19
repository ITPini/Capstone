package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class BrightnessTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new Brightness();
    private final Color color = new Color(54, 68, 56);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(1);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(108, imageAlgorithm.calculateRed(color));
        assertEquals(136, imageAlgorithm.calculateGreen(color));
        assertEquals(112, imageAlgorithm.calculateBlue(color));
    }
}