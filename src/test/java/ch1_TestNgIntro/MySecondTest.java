package ch1_TestNgIntro;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MySecondTest {

    public int multiply(int a, int b) {
        return a*b;

    }

    public int add(int a, int b) {
        return a + b;
    }

    @Test
    public void checkMultiply() {
        Assert.assertEquals(multiply(2, 3), 6);
    }

    @Test
    public void checkAdd() {

        Assert.assertEquals(add(2, 3), 5);
    }
}
