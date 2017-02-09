package com.github.beardflex;

import java.util.Set;

public class EntryPoint {
	
	public static void main(String[] args) {
		// If no arguments are supplied, print out the usage.
		if(args.length == 0) {
			usage();
		} else {
			// Create the Palindrome object.
			Palindrome palindrome = new Palindrome();
			// Generate the Set of combinations of the passed in words.
			Set<String> combinations = palindrome.getCombinations(args);
			// Print out the original passed in words along with their combinations.
			System.out.printf("Received %d words. Words: \n", args.length);
			for(String word : args) {
				System.out.printf("\t * %s\n", word);
			}
			System.out.printf("Computed combinations: \n");
			for(String combo : combinations) {
				System.out.printf("\t * %s\n", combo);
			}
			// Now print out which of these words are palindromes.
			System.out.printf("Among these words the palindromes are: \n");
			for(String combo : combinations) {
				if(palindrome.isPalindrome(combo))
					System.out.printf("\t * %s\n", combo);
			}
		}
	}
	
	public static void usage() {
		System.out.printf("Usage: \n");
		System.out.printf("palindrome \"first_word\" \"second_word\" ... \"nth_word\"\n");
	}
}