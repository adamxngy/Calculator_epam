package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorMultTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "multLongData")
    public Object[][] multLongData() {
        return new Object[][] {
                {5L, 2L, 10L},
                {10L, 30L, 300L},
                {-4L, -3L, 12L},
                {0L, 5L, 0L}
        };
    }

    @Test(dataProvider = "multLongData", groups = {"arithmetic"})
    public void testMultLong(long a, long b, long expected) {
        assertEquals(calculator.mult(a,b), expected);
    }

    @DataProvider(name = "multDoubleData")
    public Object[][] multDoubleData() {
        return new Object[][] {
                {5.1, 5.1, 26.0},
                {20.5, 40.5, 830},
                {-5.5, -3.5, 19.0},
                {10.0, -5.0, -50.0}
        };
    }

    @Test(dataProvider = "multDoubleData", groups = {"arithmetic"})
    public void testMultDouble(double a, double b, double expected) {
        assertEquals(calculator.mult(a,b), expected, 0.0001);
    }
}
