package com.epam.calculator;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorIsNegativeTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "isNegativeData")
    public Object[][] isNegativeData() {
        return new Object[][] {
                {-100L, true},
                {-1L, true},
                {0L, false},
                {1L, false},
                {100L, false}
        };
    }

    @Test(dataProvider = "isNegativeData", groups = {"comparison"})
    public void testIsNegative(long a, boolean expected) {
        assertEquals(calculator.isNegative(a), expected);
    }
}

