import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    static ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
    static StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();


    @Test
    public void testRandomMethod() {
        int N = 10000;
        String msg = "\n";

        for (int i = 0; i < N; i++) {
            int methodIndex = StdRandom.uniform(0, 4);
            switch (methodIndex) {
                case 0:
                    msg += "addFirst(" + i + ")\n";
                    solution.addFirst(i);
                    sad1.addFirst(i);
                    //assertEquals(solution.size(), sad1.size());
                    assertEquals(msg, solution.get(0), sad1.get(0));
                    break;
                case 1:
                    msg += "addLast(" + i + ")\n";
                    solution.addLast(i);
                    sad1.addLast(i);
                    //assertEquals(solution.size(), sad1.size());
                    assertEquals(msg, solution.get(solution.size() - 1), sad1.get(sad1.size() - 1));
                    break;
                case 2:
                    if (solution.size() == 0 || sad1.size() == 0) {
                        break;
                    } else {
                        msg += "removeFirst()\n";
                        Integer expected = solution.removeFirst();
                        Integer actual = sad1.removeFirst();
                        //assertEquals(solution.size(), sad1.size());
                        assertEquals(msg, expected, actual);
                        break;
                    }
                case 3:
                    if (solution.size() == 0 || sad1.size() == 0) {
                        break;
                    } else {
                        msg += "removeLast()\n";
                        Integer expected = solution.removeLast();
                        Integer actual = sad1.removeLast();
                        //assertEquals(solution.size(), sad1.size());
                        assertEquals(msg, expected, actual);
                        break;
                    }
            }
        }

    }

    /**
    @Test
    public void randomizedTest() {
        ArrayDequeSolution<Integer> solution = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> student = new StudentArrayDeque<>();
        String msg = "";

        int N = 5000;
        for (int i = 0; i < N; i++) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                solution.addFirst(randVal);
                student.addFirst(randVal);

                msg += "addFirst(" + randVal + ")\n";

                assertEquals(msg, solution.get(0), student.get(0));
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                solution.addLast(randVal);
                student.addLast(randVal);

                msg += "addLast(" + randVal + ")\n";

                assertEquals(msg, solution.get(solution.size() - 1), student.get(student.size() - 1));
            } else if (operationNumber == 2 && solution.size() > 0 && student.size() > 0) {
                // removeFirst
                Integer expected = solution.removeFirst();
                Integer actual = student.removeFirst();

                msg += "removeFirst()\n";

                assertEquals(msg, expected, actual);
            } else if (operationNumber == 3 && solution.size() > 0 && student.size() > 0) {
                // removeLast
                Integer expected = solution.removeLast();
                Integer actual = student.removeLast();

                msg += "removeLast()\n";

                assertEquals(msg, expected, actual);
            }
        }

    }
    */
}
