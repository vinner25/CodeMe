package leetcode;

import com.vinner.codeme.leetcode.ExamRoom;
import org.junit.Test;

public class ExamRoomTest {


    @Test
    public void testExamRoom()
    {
        ExamRoom examRoom = new ExamRoom(10);
        examRoom.seat();
        examRoom.seat();
        examRoom.seat();
        examRoom.leave(0);
        examRoom.leave(4) ;
        examRoom.seat();
        examRoom.seat();
    }
}
