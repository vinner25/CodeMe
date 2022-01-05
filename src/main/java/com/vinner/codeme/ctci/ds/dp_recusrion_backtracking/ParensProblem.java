package com.vinner.codeme.ctci.ds.dp_recusrion_backtracking;

import com.vinner.codeme.ProblemStatement;

import java.util.ArrayList;
import java.util.List;

public class ParensProblem implements ProblemStatement {

	public List<String> possibleParenthesis(int n)
	{
		int left = n ;
		int right = n;
		List<String> res = new ArrayList<>();
		generateParentheses(res,left,right,new StringBuilder(), left+right);
		return res;
	}

	private void generateParentheses(List<String> res, int left , int right, StringBuilder s, int finalLength)
	{
		if(s.length() == finalLength)
		{
			res.add(s.toString());
			//return;
		}
		else {
			if (left < right) //Means we have room to close
			{
				StringBuilder sNew = new StringBuilder();
				sNew.append(s);
				sNew.append(')');
				generateParentheses(res, left, right - 1, sNew, finalLength);
			}
			if (left > 0 ) //Means we have room to open
			{
				StringBuilder sNew = new StringBuilder();
				sNew.append(s);
				sNew.append('(');
				generateParentheses(res, left - 1, right, sNew, finalLength);
			}
		}
	}


	@Override
	public String getDescription() {
		return "Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.\n" +
				"\n" +
				"Example 1:\n" +
				"\n" +
				"Input: n = 3\n" +
				"Output: [\"((()))\",\"(()())\",\"(())()\",\"()(())\",\"()()()\"]\n" +
				"Example 2:\n" +
				"\n" +
				"Input: n = 1\n" +
				"Output: [\"()\"]";
	}

	@Override
	public String getSolutionNotes() {
		return "We Will use Backtracking Solution for this. We know that we can either start a parenthesis or close it if it is already started. " +
				"Based on this decision we have a count of left means parenthesis to start and right means parenthesis to close. Each time we recurse we " +
				"make a decision and it to our recursive stack. The decision is based on the previous left and right value, hence backtracking" +
				"For More : https://www.youtube.com/watch?v=sz1qaKt0KGQ ";
	}

	@Override
	public String getTimeComplexity() {
		return "Since the Decision Tree is not balanced in this problem the time complexity is hard to find. Worst case can be O(b^n) where B is decision we make at each recusrive" +
				" stack and N is the depth of the recursion stack";
	}

	@Override
	public String getSpaceComplexity() {
		return "O(2n)  =? O(n) for storing the sequence created. ";
	}
}
