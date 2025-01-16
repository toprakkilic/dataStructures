public class HashNode<T extends Comparable>{

    T value;
    int key;
    HashNode<T> next;

    public HashNode(int key,T val){
        this.value=val;
        this.key=key;
        this.next=null;
    }

    public String toString(){
        return this.key+ ":" +this.value;
    }
}
