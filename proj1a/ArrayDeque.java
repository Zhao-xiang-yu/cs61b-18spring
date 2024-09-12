public class ArrayDeque<T> {
    public T[] items;
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
        for(int i = 0; i < otherSize; i++) {
            items[i] = other.get(i);
        }
    }

    private void resize(int newLength, int beginIdx) {
        T[] newItems = (T[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            newItems[i] = items[(i + beginIdx) % maxLength];
        }
        maxLength = newLength;
        beginIdx = 0;
        items = newItems;
    }

    private boolean needsShrink() {
        if (size < MIN_SHRINK_LENGTH) {
            return false;
        }
        return size / maxLength < USAGE_RATIO;
    }

    private void expand() {
        resize(maxLength * EXPAND_RFACTOR, beginIdx);
    }

    private void shrink() {
        while (needsShrink()) {
            resize (maxLength / SHRINK_RFACTOR, beginIdx);
        }
    }

    public void addFirst(T item) {
        if (size == maxLength) {
            expand();
        }
        beginIdx = (beginIdx - 1 + maxLength) % maxLength;
        items[beginIdx] = item;
        size++;
    }

    public void addLast(T item) {
        if(size == maxLength) {
            expand();
        }
        items[(beginIdx + size) % maxLength] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = beginIdx; i < beginIdx + size; i++) {
            System.out.print(items[i % maxLength] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T item = items[beginIdx];
            beginIdx = (beginIdx + 1) % maxLength;
            size--;
            shrink();
            return item;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        } else {
            T item = items[(beginIdx + size - 1) % maxLength];
            size--;
            shrink();
            return item;
        }
    }

    public T get(int index) {
        if (size == 0 || index >= size || index < 0) {
            return null;
        }
        return items[(beginIdx + index) % maxLength];
    }
}
