package fang;

import com.vinner.codeme.fang.CourseSchedule;
import org.junit.Assert;
import org.junit.Test;

public class CourseScheduleTest {

    private CourseSchedule courseSchedule = new CourseSchedule();

    @Test
    public void testCourseScheduleValid1()
    {
        int[] order =  courseSchedule.findOrder(2,new int[][]{{0,1}});
        Assert.assertEquals(1, order[0]);
        Assert.assertEquals(0, order[1]);
    }



    @Test
    public void testCourseScheduleValid2()
    {
        int[] order =  courseSchedule.findOrder(2,new int[][]{{1,0}});
        Assert.assertEquals(0, order[0]);
        Assert.assertEquals(1, order[1]);
    }


    @Test
    public void testCourseScheduleValid3()
    {
        int[] order =  courseSchedule.findOrder(2,new int[][]{{0,1},{0,2}, {1,2}});
        Assert.assertEquals(2, order[0]);
        Assert.assertEquals(1, order[1]);
        Assert.assertEquals(0, order[2]);
    }

    @Test
    public void testCyclicCourseSchedule()
    {
        int[] order =  courseSchedule.findOrder(2,new int[][]{{0,1}, {1,0}});
        Assert.assertEquals(0, order.length);
    }


    @Test
    public void testTransientCyclicCourseSchedule()
    {
        int[] order =  courseSchedule.findOrder(3,new int[][]{{1,2}, {0,2}, {2,1}});
        Assert.assertEquals(0, order.length);
    }
}
