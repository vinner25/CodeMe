package dsa;

import com.vinner.codeme.dsa.MajorityElementII;
import org.junit.Test;

import java.util.List;

public class MajorityElementIITest {

    MajorityElementII majorityElementII = new MajorityElementII();

    @Test
    public void testMajorityElementII()
    {
        List<Integer> res = majorityElementII.majorityElement(new int[]{3,3,1,1,1,1,2,4,4,3,3,3,4,4});
    }
}
