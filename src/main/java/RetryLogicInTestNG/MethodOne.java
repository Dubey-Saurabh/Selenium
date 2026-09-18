package RetryLogicInTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodOne {

    @Test (retryAnalyzer = RetryLogicInTestNG.RetryAnalyzer.class)
    public void testOne() {
        Assert.assertEquals(true, false);
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(false, true);
    }

}
