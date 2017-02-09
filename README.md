# Palindrome #
Repo to store solution to the 'Palindrome' problem.
======

## Building ##
======

Ensure you have Gradle installed and on the classpath.
Run `gradle build` in the top level directory to compile the jar.
Now run `java -jar build/libs/palindrome-1.0.jar "Gimli" "Fili" "Ilif" "Ilmig" "Mark"` to get a list of palindromes.
To get the full list of combinations including those that aren't palindromes run `java -jar build/libs/palindrome-1.0.jar "Gimli" "Fili" "Ilif" "Ilmig" "Mark" --show-combinations`.

======

## Javadoc ##
======

To generate the Javadoc for this project run `gradle javadoc` at the top level directory.
Javadocs can then be found at `build/docs`.

