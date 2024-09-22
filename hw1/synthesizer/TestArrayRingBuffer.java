package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    private static ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);

    @Test
    public void testEnqueue() {
        for (int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        int[] expected = {0,1,2,3,4,5,6,7,8,9};
        int idx = 0;
        for (int x : arb) {
            assertEquals(expected[idx++], x);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
