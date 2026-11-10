package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTgTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "tgData")
    public Object[][] tgData() {
        return new Object[][] {
                {Math.PI / 6, 1.0 / Math.sqrt(3.0)},
                {Math.PI / 4, 1.0},
                {Math.PI / 3, Math.sqrt(3.0)},
                {-Math.PI / 4, -1.0},
        };
    }

    @Test(dataProvider = "tgData", groups = {"trigonometry"})
    public void testTgDouble(double a, double expected) {
        assertEquals(calculator.tg(a), expected, 0.0001);
    }
}
