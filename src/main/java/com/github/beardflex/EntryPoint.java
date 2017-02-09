package com.github.beardflex;

import java.util.List;
import java.util.ArrayList;

/** Entry point of the program.
 ** @author David Roche
 **/
public class EntryPoint {
    /** Flag to determine whether or not to display the full list of generated combinations. **/
    private static boolean showCombinations = false;
    /** Static definition of the show combinations cmd line flag. **/
    private static final String STR_Show_Combinations_Switch = "--show-combinations";
    
    public static void main(String[] args) {
        // If no arguments are supplied, print out the usage.
        if(args.length == 0) {
            usage();
        } else {
            // Check to see if the 'showCombinations' switch was set and return the rest of the args.
            String[] programArgs = getArgs(args);
            
            // Create the Palindrome object.
            Palindrome palindrome = new Palindrome();
            // Generate the List of combinations of the passed in words.
            List<String> combos = palindrome.getCombinations(programArgs);
            
            // Print out the original passed in words along with their combinations.
            System.out.printf("Received %d words. Words: \n", programArgs.length);
            for(String word : programArgs) {
                System.out.printf("\t * %s\n", word);
            }
            System.out.printf("Computed %d combinations.\n", combos.size());
            if(showCombinations) {
                System.out.printf("Combinations: \n");
                for(String combo : combos) {
                    System.out.printf("\t * %s\n", combo);
                }
            }
            // Now print out which of these words are palindromes.
            System.out.printf("Among these words the palindromes are: \n");
            for(String combo : combos) {
                if(palindrome.isPalindrome(combo))
                    System.out.printf("\t * %s\n", combo);
            }
        }
    }
    
    /** Checks the cmd line supplied args for option switches, set's their flag if found
     ** and returns the list of String arguments without the option switches.
     ** @param args {@link String} - The cmd line supplied String array of arguments.
     **/
    public static String[] getArgs(String[] args) {
        List<String> argList = new ArrayList<String>();
        for(String arg : args) {
            if(arg.equals(STR_Show_Combinations_Switch)) {
                showCombinations = true;
            } else {
                argList.add(arg);
            }
        }
        return argList.toArray(new String[argList.size()]);
    }
    
    /** Prints out a usage message to instruct the user how to use this program.
     **/
    public static void usage() {
        System.out.printf("Usage: \n");
        System.out.printf("palindrome \"first_word\" \"second_word\" ... \"nth_word\" [--show-combinations]\n");
    }
}