package com.github.beardflex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Palindrome {
	
	public Set<String> getCombinations(String[] names) {
		// Create a Set to store the combinations. By using a set, we won't get any duplicate entries.
		Set<String> combinations = new HashSet<String>();
		// Iterate through all the combinations of names, excluding where both the first and second names are the same.
		for (String firstName : names) {
			for(String secondName : names) {
				if(!firstName.equals(secondName)) {
					combinations.add(String.join("", firstName, secondName));
				}
			}
		}
		return combinations;
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