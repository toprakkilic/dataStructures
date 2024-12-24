public class DoublyLinkedList<T extends Comparable<T>> {
    private DNode<T> head;
    private DNode<T> current;

    public boolean hasNext(){
        return current!=null;
    }
    public T next(){
        T temp=current.value;
        current=current.next;
        return temp;

    }
    public void addToFront(T val) {
        DNode<T> newNode = new DNode<>(val);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        current=head;
    }

    public void addToEnd(T val) {
        DNode<T> newNode = new DNode<>(val);
        if (head == null) {
            head = newNode;
            current=head;
        } else {
            DNode<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
            newNode.prev = iterator;
        }
    }


    public boolean search(T val) {
        DNode<T> iterator = head;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == 0) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

    public void delete(T val) {
        if (!search(val))
            return;
        if (head.value.compareTo(val) == 0) {
            if(current==head)
                current=head.next;
            head = head.next;

            //head.prev.next=null; olmasa da olur
            if (head != null)
                head.prev = null;
        } else {
            DNode<T> iterator = head;
            while (iterator.value.compareTo(val) != 0)
                iterator = iterator.next;
            iterator.prev.next = iterator.next;
            if (iterator.next != null)
                iterator.next.prev = iterator.prev;

        }
    }


    public boolean isEmpty(){
        return this.head==null;
    }
    public T findMin() throws Exception {
        if(head==null)
            throw  new Exception("Liste boş");
        else{
            T min=head.value;
            DNode<T> iterator=head;
            while(iterator!=null){
                if(iterator.value.compareTo(min)==-1)
                    min=iterator.value;
                iterator=iterator.next;
            }
            return min;
        }
    }

    public DNode<T> findMinNode(DNode<T> start) throws Exception {
        if(head==null)
            throw  new Exception("Liste boş");
        else{
            DNode<T> min=start;
            DNode<T> iterator=start;
            while(iterator!=null){
                if(iterator.value.compareTo(min.value)==-1)
                    min=iterator;
                iterator=iterator.next;
            }
            return min;
        }
    }
    public void selectionSort() throws Exception {
        if(head==null)
            return;
        DNode<T> iterator=head;
        while(iterator!=null){
            DNode<T> minNode=findMinNode(iterator);
            //swap ilk ve min
            T temp=iterator.value;
            iterator.value=minNode.value;
            minNode.value=temp;

            iterator=iterator.next;


        }




    }
    public void deleteAll(T val) {
        while (search(val)) {
            if (head.value.compareTo(val) == 0) {
                head = head.next;
                //head.prev.next=null; olmasa da olur
                if (head != null)
                    head.prev = null;
            } else {
                DNode<T> iterator = head;
                while (iterator.value.compareTo(val) != 0)
                    iterator = iterator.next;
                iterator.prev.next = iterator.next;
                if (iterator.next != null)
                    iterator.next.prev = iterator.prev;

            }
        }
    }


    public void display() {
        if (head != null) {
            DNode<T> iterator = head;
            while (iterator.next != null) {
                System.out.print(iterator + "-->");
                iterator = iterator.next;
            }
            System.out.println(iterator);
        }
    }

    public void insertionSort() throws Exception {
        if(head==null && head.next == null ){
            return;
        }
        DNode<T> iterator = head.next;

        while (iterator != null) {
            DNode<T> iterator2 = iterator.prev;
            T key=iterator.value;
            while ((iterator2 != null) && (iterator2.value.compareTo(key) > 0) ) {
                iterator2.next.value = iterator2.value;
                iterator2 = iterator2.prev;
            }
            if (iterator2 == null){
                head.value = key;
            }else {
                iterator2.next.value = key  ;
            }
            iterator = iterator.next;
        }


    }
}
