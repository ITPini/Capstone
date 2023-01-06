/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RemoveRedTest implements AlgorithmTest {

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        ImageAlgorithm imageAlgorithm = new RemoveRed();
        imageAlgorithm.setFactor(1);
        Color color = new Color(180, 51, 189);

        assertEquals(0, imageAlgorithm.calculateRed(color));
        assertEquals(51, imageAlgorithm.calculateGreen(color));
        assertEquals(189, imageAlgorithm.calculateBlue(color));

        imageAlgorithm.setFactor(0.2f);
        assertEquals(144, imageAlgorithm.calculateRed(color));
    }
}