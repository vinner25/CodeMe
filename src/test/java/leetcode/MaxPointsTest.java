package leetcode;

import com.vinner.codeme.leetcode.MaxPoints;
import org.junit.Test;

public class MaxPointsTest {

    MaxPoints maxPoints = new MaxPoints();

    @Test
    public void testMaxPoints()
    {
        int[][] questions = new int[][]{{3,2},{4,3},{4,4},{2,5}};

        long points = maxPoints.mostPoints(questions);
    }

    @Test
    public void testMaxPoints2()
    {
        int[][] questions = new int[][]{{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};
        long points = maxPoints.mostPoints(questions);
    }

}
