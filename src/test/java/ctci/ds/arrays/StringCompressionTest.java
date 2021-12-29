package ctci.ds.arrays;

import com.vinner.codeme.ctci.ds.arrays_and_strings.StringCompression;
import org.junit.Assert;
import org.junit.Test;

public class StringCompressionTest {

    private StringCompression sc = new StringCompression();

    @Test
    public void shouldCompressStringCorrectly()
    {
        Assert.assertEquals("a4b2c2a2d1", sc.compressString("aaaabbccaad"));
        Assert.assertEquals("aabb", sc.compressString("aabb"));
    }
}
