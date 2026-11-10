package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorSinTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "sinData")
    public Object[][] sinData() {
        return new Object[][] {
                {Math.PI / 6, 0.5},
                {Math.PI / 4, Math.sqrt(2.0) / 2},
                {Math.PI / 2, 1.0},
                {Math.PI, 0.0},
        };
    }

    @Test(dataProvider = "sinData", groups = {"trigonometry"})
    public void testSinDouble(double a, double expected) {
        assertEquals(calculator.sin(a), expected, 0.0001);
    }
}
