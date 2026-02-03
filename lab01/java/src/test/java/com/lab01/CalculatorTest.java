package com.lab01;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    
    @Test
    public void testAddTwoPositiveNumbers() {
        Calculator calculator = new Calculator();

        int result = calculator.add(3, 4);
        assertEquals(7, result, "3+4 нь 7 той тэнцүү байх ёстой");
    }

    @Test
    public void testAddPositiveAndNegativeNumber() {
        Calculator calculator = new Calculator();
        int result = calculator.add(3, -4);
        assertEquals(-1, result, "3 + (-4) = -1 байх ёстой");
    }

    @Test
    public void testMultiplyTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(2, 5);
        assertEquals(10, result, "2 * 5 нь 10 той тэнцүү байх ёстой");
    }
}