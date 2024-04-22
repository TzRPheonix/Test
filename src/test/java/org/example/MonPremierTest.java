package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MonPremierTest {
    @Test
    @DisplayName("Test sur l'égalité")
    void testEgalite(){
        assertEquals(4,2+2, "2+2=4");
    }

    @Test
    @DisplayName("Test sur l'inégalité")
    void testInegalite(){
        assertNotEquals(4,2+3, "2+3=4");
    }

    @Test
    @DisplayName("Test sur vrai")
    void testVrai(){
        assertTrue(4+3==7, "4+3=7");
    }

    @Test
    @DisplayName("Test sur faux")
    void testFaux(){
        assertFalse(3+3==7, "3+3=7");
    }

    @Test
    @DisplayName("Test sur null")
    void testNull(){
        Object o = new Object();
        assertNull(o, "Object null");
    }

    @Test
    @DisplayName("Test sur non null")
    void testNotNull(){
        Object o = new Object();
        assertNotNull(o, "Object not null");
    }

    @Test
    @DisplayName("Test sur Exception")
    void testException(){
        assertThrows(IllegalAccessException.class, ()->{
            throw new IllegalArgumentException();
        }, "Une IllegalArgumentException doit être levée"
        );
    }

    @Test
    @DisplayName("Test sur multiple")
    void testMultiple(){
        assertAll("plusieurs test",
                () -> assertEquals(4,2+2, "2+2 doit être égal 4"),
                () -> assertTrue(3+3==6, "3 + 3 doit être égal à 6")
        );
    }
}
