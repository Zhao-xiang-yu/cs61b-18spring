import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    /*// You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset. */
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();


    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    /** test method: boolean isPalindrome(String word) */
    @Test
    public void testIsPalindrome() {
        String[] s = new String[]{"racecar", "noon", "horse", "aaaaaab", "a", ""};
        Boolean[] expected = new Boolean[]{true, true, false, false, true, true};
        Boolean[] actual = new Boolean[s.length];
        for (int i = 0; i < s.length; i++) {
            actual[i] = palindrome.isPalindrome(s[i]);
        }
        assertArrayEquals(expected, actual);
    }

    /** the method: boolean isPalindrome(String word, CharacterComparator cc) */
    @Test
    public void testIsPalindrome2() {
        String[] s = new String[]{"nopm", "flake", "aaaaaab", "a", ""};
        Boolean[] expected = new Boolean[]{true, true, false, true, true};
        Boolean[] actual = new Boolean[s.length];
        for (int i = 0; i < s.length; i++) {
            actual[i] = palindrome.isPalindrome(s[i], cc);
        }
        assertArrayEquals(expected, actual);
    }
}
