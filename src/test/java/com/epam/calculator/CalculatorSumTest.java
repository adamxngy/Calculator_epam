package com.epam.calculator;
import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CalculatorSumTest {
    private Calculator calculator;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        calculator = null;
    }

    @DataProvider(name = "sumLongData")
    public Object[][] sumLongData() {
        return new Object[][] {
                {5L, 2L, 7L},
                {10L, 30L, 40L},
                {-4L, -3L, -7L},
                {0L, 5L, 5L}
        };
    }

    @Test(dataProvider = "sumLongData", groups = {"arithmetic"})
    public void testSumLong(long a, long b, long expected) {
        assertEquals(calculator.sum(a,b), expected);
    }

    @DataProvider(name = "sumDoubleData")
    public Object[][] sumDoubleData() {
        return new Object[][] {
                {5.1, 5.1, 10.2},
                {20.5, 40.5, 61.0},
                {-5.5, -3.5, -9.0},
                {10.0, -5.0, 5.0}
        };
    }

    @Test(dataProvider = "sumDoubleData", groups = {"arithmetic"})
    public void testSumDouble(double a, double b, double expected) {
        assertEquals(calculator.sum(a,b), expected, 0.0001);
    }
}
