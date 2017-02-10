# Palindrome 
Repo to store solution to the 'Palindrome' problem.

## Building 

1. Ensure you have Gradle installed and on the classpath.
2. Run `gradle build` in the top level directory to compile the jar.
3. Now run `java -jar build/libs/palindrome-1.0.jar "Gimli" "Fili" "Ilif" "Ilmig" "Mark"` to get a list of palindromes.
4. To get the full list of combinations including those that aren't palindromes run `java -jar build/libs/palindrome-1.0.jar "Gimli" "Fili" "Ilif" "Ilmig" "Mark" --show-combinations`.

## Javadoc 

To generate the Javadoc for this project run `gradle javadoc` at the top level directory.
Javadocs can then be found at `build/docs`.

