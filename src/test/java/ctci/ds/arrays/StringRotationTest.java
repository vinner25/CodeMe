package ctci.ds.arrays;

import com.vinner.codeme.ctci.ds.arrays_and_strings.StringRotation;
import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {


    @Test
    public void testStringRotation()
    {
        StringRotation sr = new StringRotation();

        Assert.assertTrue(sr.isRotation("waterbottle", "erbottlewat"));
        Assert.assertFalse(sr.isRotation("vinanu", "vinan"));
        Assert.assertTrue(sr.isRotation("iamthebest", "stiamthebe"));

    }
}
