package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorCtgTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "ctgData")
    public Object[][] ctgData() {
        return new Object[][] {
                {Math.PI / 6, Math.sqrt(3.0)},
                {Math.PI / 4, 1.0},
                {Math.PI / 3, 1.0 / Math.sqrt(3.0)},
                {Math.PI / 2, 0.0},
        };
    }

    @Test(dataProvider = "ctgData", groups = {"trigonometry"})
    public void testCtgDouble(double a, double expected) {
        assertEquals(calculator.ctg(a), expected, 0.0001);
    }
}
