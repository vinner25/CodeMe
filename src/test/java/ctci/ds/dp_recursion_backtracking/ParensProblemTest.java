package ctci.ds.dp_recursion_backtracking;

import com.vinner.codeme.ctci.ds.dp_recusrion_backtracking.ParensProblem;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ParensProblemTest {

    ParensProblem parensProblem = new ParensProblem();

    @Test
    public void testParensProblem()
    {
        List<String> list = parensProblem.possibleParenthesis(3);
        Assert.assertNotNull(list);
    }
}
