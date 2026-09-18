package RetryLogicInTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MethodTwo {

    @Test
    public void testOne() {
        Assert.assertEquals(true, false);
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(true, true);
    }

}
