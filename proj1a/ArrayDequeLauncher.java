public class ArrayDequeLauncher {
    public static void main(String[] args) {
        /*
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        System.out.println(ArrayDeque.get(0));
        ArrayDeque.addLast(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addLast(4);
        ArrayDeque.removeFirst();
        ArrayDeque.addFirst(6);
        System.out.println(ArrayDeque.get(3));
        ArrayDeque.removeLast();
        System.out.println(ArrayDeque.get(0));
        ArrayDeque.addFirst(10);
        System.out.println(ArrayDeque.get(2));
        ArrayDeque.addLast(12);
        ArrayDeque.addFirst(13);
        System.out.println(ArrayDeque.get(1));
        ArrayDeque.addFirst(15);
        ArrayDeque.addFirst(16);
        ArrayDeque.addFirst(17);
        System.out.println(ArrayDeque.get(8));
        */

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for ( int i = 0; i < 20; ++i) {
            deque.addLast(i);
        }

        for( int i = 0; i < 20; ++i) {
            deque.removeFirst();
        }
    }
}
