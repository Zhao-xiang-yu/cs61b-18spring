public class LinkedListDeque<T> {
    private class LinkNode {
        private LinkNode prev, next;
        private T data;

        public LinkNode(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private LinkNode head;
    private int size;

    public LinkedListDeque() {
        head = new LinkNode(null);
        head.prev = head.next = head;
    }

    private LinkNode deepcopy(LinkNode target) {
        if (target == null) {
            return null;
        }

        LinkNode newhead = new LinkNode(target.data);
        LinkNode ptr1 = newhead, ptr2 = target.next;
        while (ptr2 != target) {
            ptr1.next = new LinkNode(ptr2.data);
            ptr1.next.prev = ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr1.next = newhead;
        newhead.prev = ptr1;

        return newhead;
    }

    public void addFirst(T data) {
        LinkNode originFirst = head.next;
        LinkNode newNode = new LinkNode(data);
        head.next = newNode;
        newNode.prev = head;
        newNode.next = originFirst;
        originFirst.prev = newNode;

        size += 1;
    }

    public void addLast(T data) {
        LinkNode originLast = head.prev;
        LinkNode newNode = new LinkNode(data);
        head.prev = newNode;
        newNode.next = head;
        newNode.prev = originLast;
        originLast.next = newNode;

        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        LinkNode current = head.next;
        while (current != head) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T data = head.next.data;
        LinkNode newFirst = head.next.next;
        newFirst.prev = head;
        head.next = newFirst;

        size -= 1;

        return data;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        T data = head.prev.data;
        LinkNode newLast = head.prev.prev;
        newLast.next = head;
        head.prev = newLast;

        size -= 1;

        return data;
    }

    public T get(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }

        LinkNode current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    private T getIndexRecursive(LinkNode current, int index) {
        if (index == 0) {
            return current.data;
        } else {
            return getIndexRecursive(current.next, index - 1);
        }
    }

    public T getRecursive(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return null;
        }

        return getIndexRecursive(head.next, index);
    }
}
