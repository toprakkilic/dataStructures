public class LinkedList<T> {
    private Node Head = null;


    public LinkedList() {
        this.Head = null;
    }

    public void addToFront(T val) {

        Node<T> newNode = new Node(val);
        newNode.next = Head;
        Head = newNode;

    }

    public void addToEnd(T val) {
        Node<T> newNode = new Node<>(val);
        if (Head == null) {
            Head = newNode;
        } else {
            Node iterator = Head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }

    public void display() {
        Node iterator = Head;
        while (iterator != null) {
            System.out.println(iterator);
            iterator = iterator.next;
        }
    }

    public boolean search(T val) {
        Node iterator = Head;
        while (iterator != null) {
            if (iterator.value.compareTo(val) == 0) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

    public void headdenBirSonra(T val) {
        Node<T> newNode = new Node<>(val);
        if (Head == null) {
            Head = newNode;
        } else {
            Node tempNode = Head.next;
            Head.next = newNode;
            newNode.next = tempNode;
        }
    }
}


    }

    public void siraliEkle(T val){
        Node<T> newNode = new Node<>(val);
        Node previous = Head;
        if (previous == null){
            addToEnd(val);
        }
        else {
            if (previous.next == null){
                if (previous.value.compareTo(val) == 1){
                    addToFront(val);
                }
                else{
                    addToEnd(val);
                }

            }
            else {
                Node iterator = previous.next;
                while (iterator != null) {
                    if (iterator.value.compareTo(val) == 1) {
                        previous.next = newNode;
                        newNode.next = iterator;
                        System.out.println("aaaaaaa");
                    } else if (iterator.value.compareTo(val) < 0) {
                        previous.next = newNode;
                        newNode.next = iterator;
                        System.out.println("b");
                    } else if (iterator.value.compareTo(val) == 0) {
                        previous.next = newNode;
                        newNode.next = iterator;
                        System.out.println("acccccc");
                    }
                    iterator = iterator.next;
                }
            }
        }
    }


}
