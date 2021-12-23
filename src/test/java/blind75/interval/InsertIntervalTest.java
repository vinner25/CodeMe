package blind75.interval;

import com.vinner.codeme.blind75.interval.InsertInterval;
import org.junit.Assert;
import org.junit.Test;

public class InsertIntervalTest {

    InsertInterval insertInterval = new InsertInterval();

    @Test
    public void testInsertInterval()
    {
        int[][] intervals = new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] mergedIntervals = insertInterval.insert(intervals, new int[]{4,8});
        Assert.assertEquals(3, mergedIntervals.length);
    }


}
