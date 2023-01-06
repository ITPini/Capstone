/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class RemoveRedGreenTest implements AlgorithmTest {

    @Override @Test
    public void testAlgorithmWithFixedValues() {
        ImageAlgorithm imageAlgorithm = new RemoveRedGreen();
        imageAlgorithm.setFactor(1);
        Color color = new Color(77, 169, 67);

        assertEquals(0, imageAlgorithm.calculateRed(color));
        assertEquals(0, imageAlgorithm.calculateGreen(color));
        assertEquals(67, imageAlgorithm.calculateBlue(color));
    }
}