package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorPowTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "powData")
    public Object[][] powData() {
        return new Object[][] {
                {5.0, 2.0, 25.0},
                {10.0, 0.0, 1.0},
                {2.0, 1.0, 2.0},
        };
    }

    @Test(dataProvider = "powData", groups = {"power"})
    public void testDivDouble(double a, double b, double expected) {
        assertEquals(calculator.pow(a,b), expected, 0.0001);
    }
}
