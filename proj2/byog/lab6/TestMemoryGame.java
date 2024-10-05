package byog.lab6;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestMemoryGame {
    static int seed = 0;
    static int weight = 10;
    static int height = 10;
    static MemoryGame game = new MemoryGame(weight, height, seed);

    @Test
    public void testGenerateRandomString() {
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] actual = new int[expected.length];
        for (int i = 0; i < expected.length; i++) {
            String targetStr = game.generateRandomString(expected[i]);
            actual[i] = targetStr.length();
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testDrawFrame() {
        String targetStr = "you did this!";
        game.drawFrame(targetStr);
    }
}
