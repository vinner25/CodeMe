package leetcode;

import com.vinner.codeme.leetcode.HashCodeString;
import org.junit.Test;

public class HashCodeStringTest {

    HashCodeString hashCodeString = new HashCodeString();

    @Test
    public void testHashCodeString()
    {
       String s =  hashCodeString.subStrHash("leetcode", 7 , 20, 2, 0);
    }

    @Test
    public void testHashCodeString2()
    {
        String s =  hashCodeString.subStrHash("xmmhdakfursinye", 96 , 45, 15, 21);
    }
}
