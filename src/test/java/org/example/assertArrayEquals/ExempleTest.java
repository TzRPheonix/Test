package org.example.assertArrayEquals;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class ExempleTest {
    @Test
    void testEgaliteTabEntier(){
        double[] tab1 = {1,5,7,9};
        double[] tab2 = {1,5,7,9};
        assertArrayEquals(tab1,tab2, 0.1, "Les tableaux doivent être égaux");
    }
}
