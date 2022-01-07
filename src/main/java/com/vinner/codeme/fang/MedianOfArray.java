package com.vinner.codeme.fang;

import com.sun.tracing.Probe;
import com.vinner.codeme.ProblemStatement;

public class MedianOfArray implements ProblemStatement {

	public double median(int[] num1, int[] num2)
	{
		int totalLength = num1.length + num2.length;
		int medianIndex =  (totalLength ) /2;

		int i=-1; int j=-1;
		double median = 0f;
		int last=0, secondLast = 0;
		while( (i+j+1)  != medianIndex)
		{
			secondLast = last;
			if(i+1 < num1.length) {
				if(j+1<num2.length) {
					if (num1[i + 1] <= num2[j + 1])
					{
						i++;
					}
					else
						j++;
				}
				else
					i++;
			}
			else
				j++;

			if(i > -1 && j > -1)
				last = Math.max(num1[i], num2[j]);
			else if (j == -1)
				last = num1[i];
			else
				last = num2[j];


		}

		if(totalLength % 2 == 0) {

			return (last+secondLast)/ 2d;
		}
		else {
			return last*1d;

		}
	}

	@Override
	public String getDescription() {
		return "Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.\n" +
				"\n" +
				"The overall run time complexity should be O(log (m+n)).\n" +
				"\n" +
				" \n" +
				"\n" +
				"Example 1:\n" +
				"\n" +
				"Input: nums1 = [1,3], nums2 = [2]\n" +
				"Output: 2.00000\n" +
				"Explanation: merged array = [1,2,3] and median is 2.\n" +
				"Example 2:\n" +
				"\n" +
				"Input: nums1 = [1,2], nums2 = [3,4]\n" +
				"Output: 2.50000\n" +
				"Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.";
	}

	@Override
	public String getSolutionNotes() {
		return "We traverse both the arrays using pointers and keep track of last element and second last element if the arrays were merged and iterated till the half way mark. Since the median for odd numbered array is middle element" +
				"and for even number it is middle and middle +1";
	}

	@Override
	public String getTimeComplexity() {
		return "O(log(m+n))";
	}

	@Override
	public String getSpaceComplexity() {
		return "O(1)";
	}
}
