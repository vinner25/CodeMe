package leetcode;

import com.vinner.codeme.leetcode.UniqueEmails;
import org.junit.Assert;
import org.junit.Test;

public class UniqueEmailsTest {

    UniqueEmails uniqueEmails = new UniqueEmails();
    @Test
    public void shoudlTestValidEmails()
    {
        int count = uniqueEmails.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"});
        Assert.assertEquals(2,count);
    }
}
