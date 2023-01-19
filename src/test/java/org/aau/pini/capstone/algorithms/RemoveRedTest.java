package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */
class RemoveRedTest implements AlgorithmTest {
    private static final ImageAlgorithm imageAlgorithm = new RemoveRed();
    private final Color color = new Color(180, 51, 189);

    @BeforeAll
    static void beforeAll() {
        imageAlgorithm.setFactor(1);
    }

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        assertEquals(0, imageAlgorithm.calculateRed(color));
        assertEquals(51, imageAlgorithm.calculateGreen(color));
        assertEquals(189, imageAlgorithm.calculateBlue(color));

        imageAlgorithm.setFactor(0.2f);
        assertEquals(144, imageAlgorithm.calculateRed(color));
    }
}