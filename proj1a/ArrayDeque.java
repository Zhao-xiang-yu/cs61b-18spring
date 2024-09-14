public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int beginIdx;
    private int maxLength;

    private static int EXPAND_RFACTOR = 2;
    private static int SHRINK_RFACTOR = 2;
    private static double USAGE_RATIO = 0.25;
    private static int MIN_SHRINK_LENGTH = 16;

    public ArrayDeque() {
        maxLength = 8;
        size = 0;
        beginIdx = 0;
        items = (T[]) new Object[maxLength];
    }

    public ArrayDeque(ArrayDeque<T> other) {
        int otherSize = other.size();
        size = otherSize;
        maxLength = otherSize * 2;
        items = (T[]) new Object[maxLength];
        beginIdx = 0;
        for (int i = 0; i < otherSize; i++) {
            items[i] = other.get(i);
        }
    }

    private void resize(int newLength) {
        T[] newItems = (T[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(i + beginIdx) % maxLength];
        }
        maxLength = newLength;
        beginIdx = 0;
        items = newItems;
    }

    private boolean needsShrink() {
        if (maxLength <= MIN_SHRINK_LENGTH) {
            return false;
        }
        //System.out.println("size is " + size + ", Usage_Ratio * maxlength is " + USAGE_RATIO * maxLength);

        return size < USAGE_RATIO * maxLength;
    }

    private void expand() {
        resize(maxLength * EXPAND_RFACTOR);
    }

    private void shrink() {
        while (needsShrink()) {
            resize(maxLength / SHRINK_RFACTOR);
        }
    }

    @Override
    public void addFirst(T item) {
        if (size == maxLength) {
            expand();
        }
        beginIdx = (beginIdx - 1 + maxLength) % maxLength;
        items[beginIdx] = item;
        size++;
    }

    @Override
    public void addLast(T item) {
        if (size == maxLength) {
            expand();
        }
        items[(beginIdx + size) % maxLength] = item;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        for (int i = beginIdx; i < beginIdx + size; i++) {
            System.out.print(items[i % maxLength] + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T item = items[beginIdx];
            items[beginIdx] = null;
            beginIdx = (beginIdx + 1) % maxLength;
            size--;
            shrink();
            return item;
        }
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T item = items[(beginIdx + size - 1) % maxLength];
            items[(beginIdx + size - 1) % maxLength] = null;
            size--;
            shrink();
            return item;
        }
    }

    @Override
    public T get(int index) {
        if (size == 0 || index >= size || index < 0) {
            return null;
        }
        return items[(beginIdx + index) % maxLength];
    }
}
