package fang;

import com.vinner.codeme.fang.LetterCombinationsOfPhoneNumber;
import org.junit.Assert;
import org.junit.Test;

public class LetterCombinationsOfPhoneNumberTest {


    LetterCombinationsOfPhoneNumber lcp = new LetterCombinationsOfPhoneNumber();

    @Test
    public void testPhoneNumberCombinations()
    {
        Assert.assertEquals(9,lcp.letterCombinations("23") );

    }

}
