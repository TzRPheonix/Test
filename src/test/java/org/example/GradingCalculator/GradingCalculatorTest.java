package org.example.GradingCalculator;

import org.example.model.Calculatrice;
import org.example.model.GradingCalculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GradingCalculatorTest {
    private static GradingCalculator gradingCalculator;

    @BeforeAll
    static void init(){
        gradingCalculator = new GradingCalculator();
    }


    @Test
    @DisplayName("Score: 95, Pres: 90 -> A")
    void testCalculetteA(){
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);
        assertEquals("A", gradingCalculator.getGrade(), "Score: 95, Pres: 90 -> A");
    }

    @Test
    @DisplayName("Score: 85, Pres: 90 -> B")
    void testCalculetteB(){
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);
        assertEquals("B", gradingCalculator.getGrade(), "Score: 85, Pres: 90 -> B");
    }

    @Test
    @DisplayName("Score: 65, Pres: 90 -> C")
    void testCalculetteC(){
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);
        assertEquals("C", gradingCalculator.getGrade(), "Score: 65, Pres: 90 -> C");
    }

    @Test
    @DisplayName("Score: 95, Pres: 65 -> B")
    void testCalculetteD(){
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);
        assertEquals("B", gradingCalculator.getGrade(), "Score: 95, Pres: 65 -> B");
    }

    @Test
    @DisplayName("Score: 95, Pres: 55 -> F")
    void testCalculetteE(){
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);
        assertEquals("F", gradingCalculator.getGrade(), "Score: 95, Pres: 55 -> F");
    }

    @Test
    @DisplayName("Score: 65, Pres: 55 -> F")
    void testCalculetteF(){
        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);
        assertEquals("F", gradingCalculator.getGrade(), "Score: 65, Pres: 55 -> F");
    }

    @Test
    @DisplayName("Score: 50, Pres: 90 -> F")
    void testCalculetteG(){
        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);
        assertEquals("F", gradingCalculator.getGrade(), "Score: 50, Pres: 90 -> F");
    }

}
