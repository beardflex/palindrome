package com.github.beardflex;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** Test class to perform functional unit tests on methods provided by {@link Palindrome} class.
 ** @author David Roche
 **/
public class TestPalindrome {
    // The member wide Palindrome instance used by all tests below.
    private Palindrome palindrome;
    
    /** Setup method for testing. Creates a {@link Palindrome} object for use by test methods.
     **/
    @Before
    public void setUp(){
        palindrome = new Palindrome();
    }
    
    /** Tear down method for testing. Assigns a null value to the {@link Palindrome} object created
     ** in the {@link TestPalindrome#setUp} method.
     **/
    @After
    public void tearDown(){
        palindrome = null;
    }
    /** Functional test for the {@link Palindrome#getCombinations} method. <br>
     ** Tests that the method output matches that of known sets and outputs.
     **/
    @Test
    public void testGenerateCombinations() {
        // Test generating all the combinations for a very simple array.
        String[] simpleArray = {"1", "2"};
        // Define an array of the known full list of combinations.
        String[] simpleArrayExpectedOutput = {"12", "21"};
        // Populate a List using this array for ease of access.
        List<String> simpleArrayOutputList = new ArrayList<String>(Arrays.asList(simpleArrayExpectedOutput));        
        // Now generate the list combinations.
        List<String> combinationsOfSimpleArray = palindrome.getCombinations(simpleArray);
        // Assert that the list was populated correctly, or else the assertion below is meaningless.
        assertTrue(combinationsOfSimpleArray.size() > 0);
        for(String simpleArrayCombo : simpleArrayOutputList) {
            // Remove the entry from the list to mark as seen.
            combinationsOfSimpleArray.remove(simpleArrayCombo);
        }
        // If the known list is empty, we've generated every known combination, therefore, we've passed the test.
        assertTrue(combinationsOfSimpleArray.size() == 0);
        
        // Now do the same as we did above but with one more order of complexity.
        String[] lessSimpleArray = {"1", "2", "3"};
        String[] lessSimpleArrayExpectedOutput = {"12", "13", "21", "23", "31", "32", "123", "132", "213", "231", "312", "321"};
        List<String> lessSimpleArrayOutputList = new ArrayList<String>(Arrays.asList(lessSimpleArrayExpectedOutput));       
        // Generate the list of combinations.
        List<String> combinationsOfLessSimpleArray = palindrome.getCombinations(lessSimpleArray);       
         // Like above, we need to test that this list has been populated correctly.
        assertTrue(combinationsOfLessSimpleArray.size() > 0);
        for(String lessSimpleArrayCombo : lessSimpleArrayOutputList) {
            combinationsOfLessSimpleArray.remove(lessSimpleArrayCombo);
        }
        // Again, as above if the list of known combinations is empty, we've generated all known combos.
        assertTrue(combinationsOfLessSimpleArray.size() == 0);
    }
    /** Functional test for the {@link Palindrome#isPalindrome} method. <br>
     ** Verifies that the method will return true for known even and odd length palindromes.
     **/
    @Test
    public void testIsPalindrome() {
        String validOddPalindrome = "Kayak";
        String validEvenPalindrome = "Abba";
        
        assertTrue(palindrome.isPalindrome(validOddPalindrome));
        assertTrue(palindrome.isPalindrome(validEvenPalindrome));
    }
    /** Functional test for the {@link Palindrome#isPalindrome} method. <br>
     ** Verifies that the method will return false for known even and odd length words that are not palindromes.
     **/
    @Test
    public void testIsNotPalindrome() {
        String invalidOddPalindrome = "Hello";
        String invalidEvenPalindrome = "Worlds";
        
        assertFalse(palindrome.isPalindrome(invalidOddPalindrome));
        assertFalse(palindrome.isPalindrome(invalidEvenPalindrome));
    }
}