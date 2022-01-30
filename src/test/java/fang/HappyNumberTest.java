package fang;

import com.vinner.codeme.fang.HappyNumber;
import org.junit.Assert;
import org.junit.Test;

public class HappyNumberTest {

    HappyNumber happyNumber = new HappyNumber();

    @Test
    public void testHappyNumber()
    {
        Assert.assertFalse(happyNumber.isHappy(3));
    }


}
