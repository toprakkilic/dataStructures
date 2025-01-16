public class TNode <T extends Comparable<T>>{
    T value;
    public TNode<T> left;
    public TNode<T> right;

    public TNode(T val) {
        this.value = val;
        this.left = null;
        this.right = null;

    }

    public String toString() {
        return String.valueOf(this.value);
    }


}
