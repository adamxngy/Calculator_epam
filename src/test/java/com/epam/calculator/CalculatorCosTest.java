package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorCosTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "CosData")
    public Object[][] CosData() {
        return new Object[][] {
                {0.0, 1.0},
                {Math.PI / 6, Math.sqrt(3.0) / 2},
                {Math.PI / 4, Math.sqrt(2.0) / 2},
                {Math.PI / 2, 0.0},
                {Math.PI, -1.0},
        };
    }

    @Test(dataProvider = "CosData", groups = {"trigonometry"})
    public void testCosDouble(double a, double expected) {
        assertEquals(calculator.cos(a), expected, 0.0001);
    }
}
