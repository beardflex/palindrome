package com.github.beardflex;

import static org.junit.Assert.*;

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
     ** 
     **/
    @Test
    public void testGenerateCombinations() {
        assertTrue(true);
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