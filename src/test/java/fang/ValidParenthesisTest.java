package fang;

import com.vinner.codeme.fang.ValidParenthesis;
import org.junit.Assert;
import org.junit.Test;

public class ValidParenthesisTest {

    ValidParenthesis vp = new ValidParenthesis();

    @Test
    public void testValidParenthesis()
    {
        Assert.assertFalse( vp.isValid("[[[]"));
    }

    //""
    @Test
    public void testValidParenthesis2()
    {
        Assert.assertTrue( vp.isValid("(([]){})"));
    }

}
