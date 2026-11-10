package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorDivTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "divLongData")
    public Object[][] divLongData() {
        return new Object[][] {
                {20L, 2L, 10L},
                {10L, 5L, 2L},
                {-20L, 4L, -5L},
                {200L, 5L, 40L}
        };
    }

    @Test(dataProvider = "divLongData", groups = {"arithmetic"})
    public void testDivLong(long a, long b, long expected) {
        assertEquals(calculator.div(a,b), expected);
    }

    @DataProvider(name = "divDoubleData")
    public Object[][] divDoubleData() {
        return new Object[][] {
                {6.6, 2.2, 3.0},
                {24.8, 4.0, 6.2},
                {-9.2, 4.0, -2.3},
                {10.0, -5.0, -2.0}
        };
    }

    @Test(dataProvider = "divDoubleData", groups = {"arithmetic"})
    public void testDivDouble(double a, double b, double expected) {
        assertEquals(calculator.div(a,b), expected, 0.0001);
    }

    @Test(expectedExceptions = NumberFormatException.class, groups = {"arithmetic"})
    public void testDivisionByZero() {
        calculator.div(10L, 0L);
    }
}
