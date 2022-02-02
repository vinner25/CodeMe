package com.vinner.codeme.leetcode;

import java.util.PriorityQueue;

public class UglyNumberII {

    public int nthUglyNumber(int n) {
        if(n== 1)
            return 1;

        int count = 1;
        PriorityQueue<int[]> queue = new PriorityQueue<>( (i1, i2) ->  i1[0] - i2[0]);
        queue.add(new int[]{2,2});
        queue.add(new int[]{3,3});
        queue.add(new int[]{5,5});

        int num = 1;
        while(count != n)
        {

            int[]  arr = queue.poll();
            num = arr[0];
            queue.add(new int[]{num*arr[1], arr[1]});
            count++;

        }

        return num;
    }


}
