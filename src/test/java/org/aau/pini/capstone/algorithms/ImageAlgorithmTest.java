/**
 * @author Marcelino Patrick Pini - mpini21@student.aau.dk
 */

package org.aau.pini.capstone.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageAlgorithmTest {

    final ImageAlgorithm imageAlgorithm = new Invert();

    @Test
    void testCheckFactorRange() {
        imageAlgorithm.setFactor(5);
        assertEquals(1, imageAlgorithm.getFactor());

        imageAlgorithm.setFactor(-3);
        assertEquals(0, imageAlgorithm.getFactor());

        imageAlgorithm.setFactor(0.5f);
        assertEquals(0.5, imageAlgorithm.getFactor());
    }

    @Test
    void testCheckColorValueRange() {
        int rgbValue = 125;
        assertEquals(125, imageAlgorithm.checkColorValueRange(rgbValue));

        rgbValue = 300;
        assertEquals(255, imageAlgorithm.checkColorValueRange(rgbValue));

        rgbValue = -10;
        assertEquals(0, imageAlgorithm.checkColorValueRange(rgbValue));
    }

    @Test
    void testName() {
        imageAlgorithm.setName("Test");
        assertEquals("Test", imageAlgorithm.getName());
    }

    @Test
    void testSetNewMinimumMaximumFactor() {
        imageAlgorithm.setMinimumFactor(1);
        imageAlgorithm.setMaximumFactor(5);
        assertEquals(1, imageAlgorithm.getMinimumFactor());
        assertEquals(5, imageAlgorithm.getMaximumFactor());
    }
}