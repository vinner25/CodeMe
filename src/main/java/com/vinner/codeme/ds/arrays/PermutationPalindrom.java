package com.vinner.codeme.ds.arrays;

public class PermutationPalindrom{

	/* This Method checks if each character in the String has a pair.
           Maximum of only one character is allowed to not have any pair.
      Time Complexity : O(n)
    */
	public boolean isPalindromPermutation(String s)
	{
		// Assuming the String is a ASCII string
		int[] wordCount = new int[128];

		for(int i=0; i< s.length() ; i++)
		{
			if(s.charAt(i) != ' ')
				wordCount[s.charAt(i)]++;

		}
		// only one character without pair is allowed in palindrome at maximum
		boolean isSingleCharacterFound  = false;
		for(int i=0;i<wordCount.length;i++)
		{

			if(wordCount[i] != 0)  //If character does not has a pair
			{
				if(wordCount[i] % 2 != 0)
				{
					if(isSingleCharacterFound)
						return false;
					isSingleCharacterFound = true;

				}

			}

		}
		return true;
	}
}
