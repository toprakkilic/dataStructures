public class DNode<T extends Comparable<T>> {
    T value;
    public DNode<T> next;
    public DNode<T> prev;

    public DNode(T val) {
        this.value = val;
        this.next = null;
        this.prev = null;

    }

    public String toString() {
        return String.valueOf(this.value);
    }

}
