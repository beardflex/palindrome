package com.github.beardflex;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Collections;

public class Palindrome {
	
	public List<String> getCombinations(String[] words) {
		// Use a Set internally so we don't have any duplicate entries.
        Set<String> distinctCombinations = new HashSet<String>();
        // For each word, assign that word as a prefix and use the remaining words to generate combinations.
        for(String word : words) {
            String prefix = word;
            List<String> remaining = new ArrayList<String>(Arrays.asList(words));
            remaining.remove(word);
            recurse(prefix, remaining, distinctCombinations);
        }
        // Sort the combinations using length, and then alphabetical.
		List<String> sortedCombinations = new ArrayList<String>(distinctCombinations);
		Collections.sort(sortedCombinations, (String x1, String x2) -> {
				if(x1.length() < x2.length())
					return -1;
				else if (x1.length() == x2.length())
					return x1.compareTo(x2);
				else 
					return 1;
			});
        return sortedCombinations;
    }
	public void recurse (String prefix, List<String> remaining, Set<String> combinations) {
		// For each remaining word, append it to the passed in prefix, add it to the Set, remove that word
		// from the pool of words and recurse the function.
        for(String word : remaining) {
            String tempPrefix = String.join("", prefix, word);
            combinations.add(tempPrefix);
            List<String> tempRemaining = new ArrayList<String>(remaining);
            tempRemaining.remove(word);
            recurse(tempPrefix, tempRemaining, combinations);
        }
    }
	
	public boolean isPalindrome(String word) {
		 // Make sure all chars in the String are in the same case.
        String normalisedWord = word.toLowerCase();
        // Check if the word has an even numbered length.
        boolean wordIsEvenLength = normalisedWord.length() % 2 == 0;
        // Get the pivot of the word, so we can do a binary search.
        int pivot = normalisedWord.length() / 2;
        // If the word's length is odd, we don't need to check the pivoting character.
        for(int i = wordIsEvenLength ? 0 : 1; i < pivot; i++){
            char leftChar = normalisedWord.charAt(pivot - i);
            char rightChar = normalisedWord.charAt(pivot + (wordIsEvenLength ? (i - 1) : i));
            if(leftChar != rightChar)
                return false;
        }
        return true;
	}
}