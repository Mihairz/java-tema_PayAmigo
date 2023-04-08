package com.db.PayAmigo;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @org.junit.jupiter.api.Test
    void testMultiplyWithOne() {
        assertEquals(5,calculator.multiply(5,1),"Multiple with one should be the number itself");
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handlig of zero")
    public void testMultiplyWithZero() {
        assertEquals(0,calculator.multiply(0,5),"Multiple with zero should be zero");
        assertEquals(0,calculator.multiply(5,0),"Multiple with zero should be zero");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Multiplication should work")
    public void testMultiply() {
        assertEquals(20,calculator.multiply(4,5),"Regular multiplication should work");
    }
}
