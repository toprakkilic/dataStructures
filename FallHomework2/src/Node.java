public class Node <T extends Comparable<T>> {
    T value;
    Node <T> next;
    public Node(T data) {
        this.value = data;
        this.next = null;
    }
    public String toString() {
        return value.toString();
    }
}
