package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSubTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "subLongData")
    public Object[][] subLongData() {
        return new Object[][] {
                {5L, 2L, 3L},
                {10L, 30L, -20L},
                {-4L, -3L, -1L},
                {0L, 5L, -5L}
        };
    }

    @Test(dataProvider = "subLongData", groups = {"arithmetic"})
    public void testSubLong(long a, long b, long expected) {
        assertEquals(calculator.sub(a,b), expected);
    }

    @DataProvider(name = "subDoubleData")
    public Object[][] subDoubleData() {
        return new Object[][] {
                {5.1, 5.1, 0.0},
                {20.5, 40.5, -20.0},
                {-5.5, -3.5, -2.0},
                {10.0, -5.0, 15.0}
        };
    }

    @Test(dataProvider = "subDoubleData", groups = {"arithmetic"})
    public void testSubDouble(double a, double b, double expected) {
        assertEquals(calculator.sub(a,b), expected, 0.0001);
    }
}
