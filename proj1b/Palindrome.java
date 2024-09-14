public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        int l = 0, r = word.length() - 1;
        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int l = 0, r = word.length() - 1;
        while (l < r) {
            if (!cc.equalChars(word.charAt(l), word.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
