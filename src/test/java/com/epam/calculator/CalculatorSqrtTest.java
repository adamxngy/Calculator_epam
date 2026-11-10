package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CalculatorSqrtTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "sqrtData")
    public Object[][] sqrtData() {
        return new Object[][] {
                {9.0, 3.0},
                {16.0, 4.0},
                {0.0, 0.0},
                {25.0, 5.0},
        };
    }

    @Test(dataProvider = "sqrtData", groups = {"power"})
    public void testSqrtDouble(double a, double expected) {
        assertEquals(calculator.sqrt(a), expected, 0.0001);
    }
}
