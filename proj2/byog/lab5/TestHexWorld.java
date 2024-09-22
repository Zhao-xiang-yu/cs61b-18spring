package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestHexWorld {
    public static HexWorld hw = new HexWorld();

    @Test
    public void testNeedsFilling1() {
        boolean[] actual = new boolean[4];
        boolean[] expected = {false, true, true, false};
        for (int x = 0; x < 4; x += 1) {
            actual[x] = hw.needsFilling(x, 0, 2);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNeedsFilling2() {
        boolean[] actual = new boolean[7];
        boolean[] expected = {false, true, true, true, true, true, false};
        for (int x = 0; x < 7; x += 1) {
            actual[x] = hw.needsFilling(x, 4, 3);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNeedsFilling3() {
        boolean[] actual = new boolean[10];
        boolean[] expected = {false, false, false, true, true, true, true, false, false, false};
        for (int x = 0; x < 10; x += 1) {
            actual[x] = hw.needsFilling(x, 7, 4);
        }
        assertArrayEquals(expected, actual);
    }
}
