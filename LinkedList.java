public class LinkedList <T extends Comparable<T>> {
    private Node<T> head;

    //constructor yazmasak da olur.
    public LinkedList(){
        this.head=null;
    }

    public void addToFront(T val){
        Node<T> newNode=new Node<>(val);
        newNode.next= getHead();
        head=newNode;
    }
    public void addToEnd(T val){
        Node<T> newNode=new Node<>(val);
        if(getHead() ==null)
            head=newNode;
        else {
            Node<T> iterator = getHead();
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }

    public boolean search(T val){
        Node<T> iterator= getHead();
        while(iterator!=null){
            if(iterator.value.compareTo(val)==0){
                return true;
            }
            iterator=iterator.next;
        }
        return false;
    }

    public void display(){
        if(getHead() !=null) {
            Node<T> iterator = getHead();
            while (iterator.next != null) {
                System.out.print(iterator + "-->");
                iterator = iterator.next;
            }
            System.out.println(iterator);
        }
    }
    public void sortedInsert(T val){
        Node<T> newNode=new Node<>(val);
        if (getHead() ==null){
            head=newNode;
        }else if(getHead().value.compareTo(val)==1){
            newNode.next= getHead();
            head=newNode;
        }else{
            Node<T> prev, iterator;
            prev=iterator= getHead();
            while(iterator!=null && iterator.value.compareTo(val)!=1 ){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=newNode;
            newNode.next=iterator;

        }
    }
    public void delete(T val){
        if(!search(val)){
            return;
        }else if(getHead().value.compareTo(val)==0){
            head= getHead().next;
        }else{
            Node<T> prev, iterator;
            prev=iterator= getHead();
            while(iterator.value.compareTo(val)!=0){
                prev=iterator;
                iterator=iterator.next;
            }
            prev.next=iterator.next;
        }
    }
    public boolean isEmpty(){
        return this.getHead() ==null;
    }
    public T findMin() throws Exception {
        if(getHead() ==null)
            throw  new Exception("Liste boş");
        else{
            T min= getHead().value;
            Node<T> iterator= getHead();
            while(iterator!=null){
                if(iterator.value.compareTo(min)==-1)
                    min=iterator.value;
                iterator=iterator.next;
            }
            return min;
        }
    }


    public Node<T> getHead() {
        return head;
    }

    public int size(){
        int size=0;
        Node<T> iterator= this.head;
        while(iterator!=null){
            size++;
            iterator=iterator.next;
        }
        return size;
    }
}
