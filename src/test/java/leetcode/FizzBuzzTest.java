package leetcode;

import com.vinner.codeme.leetcode.FizzBuzz;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void testFizzBuzz()
    {
        List<String> res = fizzBuzz.fizzBuzz(3);
        Assert.assertEquals( "Fizz", res.get(2));
    }
}
