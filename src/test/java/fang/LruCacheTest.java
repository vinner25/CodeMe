package fang;

import com.vinner.codeme.fang.LruCache;
import org.junit.Test;

public class LruCacheTest {

    @Test
    public void testLRUCache()
    {
        LruCache lruCache = new LruCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);

    }
}
