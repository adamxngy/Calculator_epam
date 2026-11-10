package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorIsPositiveTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "isPositiveData")
    public Object[][] isPositiveData() {
        return new Object[][] {
                {5L, true},
                {10L, true},
                {-4L, false},
                {0L, false}
        };
    }

    @Test(dataProvider = "isPositiveData", groups = {"comparison"})
    public void testIsPositive(long a, boolean expected) {
        assertEquals(calculator.isPositive(a), expected);
    }
}
