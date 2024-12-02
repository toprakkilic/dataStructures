public class LinkedList <T extends Comparable<T>> {
    private Node<T> head;
    public LinkedList() {
        head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        Node<T> iterator = head;
        int count = 0;
        while (iterator != null) {
            count++;
            iterator = iterator.next;
        }
        return count;
    }
    public void addToFront(T val) {
        Node<T> newNode = new Node<>(val);
        newNode.next = head;
        head = newNode;

    }
    public void addToEnd(T val) {
        Node<T> newNode = new Node<>(val);
        if (head == null) {
            head = newNode;
        }
        else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = newNode;
        }
    }
    public Node<T> findMinNode() {
        Node<T> minNode = head;
        if (head == null) {
            return null;
        } else {
            Node<T> iterator = head;
            while (iterator != null) {
                if (iterator.value.compareTo(minNode.value) < 0) {
                    minNode = iterator;
                }
                iterator = iterator.next;
            }
        }
        return minNode;
    }

    public Node<T> findMaxNode() throws Exception {
        Node<T> maxNode = head;
        if (head == null) {
            throw new Exception("Liste bos");
        } else {
            Node<T> iterator = head;
            while (iterator != null) {
                if (iterator.value.compareTo(maxNode.value) > 0) {
                    maxNode = iterator;
                }
                iterator = iterator.next;
            }
        }
        return maxNode;
    }

    public Node<T> findMiddleNode() {
        Node<T> middleNode;
        if (head == null) {
            return null;
        } else {
            middleNode = head;
            Node<T> iterator = head;
            while (iterator.next != null) {
                middleNode = middleNode.next;
                iterator = iterator.next.next;
            }
            return middleNode;
        }
    }

    public boolean search(T val) {
        if (head == null) {
            return false;
        }else {
            Node<T> iterator = head;
            while (iterator.next != null) {
                if (iterator.value.compareTo(val) == 0) {
                    return true;
                }
                iterator = iterator.next;
            }
        }
        return false;
    }
    public void delete(T val) throws Exception {
        if(!search(val)){
            throw new Exception("Liste bos");
        }else if (head.value.compareTo(val) == 0) {
            head = head.next;
        }
        else {
            Node<T> iterator = head;
            Node<T> prev = head;
            while (iterator.value.compareTo(val) != 0) {
                prev = iterator;
                iterator = iterator.next;
            }
            prev.next = iterator.next;
        }
    }

    public void deleteAll(T val) throws Exception {
        if (head == null) {
            throw new Exception("Liste bos");
        }else {
            while (search(val)) {
                delete(val);
            }
        }
    }

    public void sortedInsert(T val) {
        Node<T> newNode = new Node<>(val);
        if (head == null) {
            head = newNode;
        } else if (head.value.compareTo(val) == 1) {
            newNode.next = head;
            head = newNode;
        }else{
            Node<T> iterator = head;
            Node<T> prev = head;
            while (iterator !=null && iterator.value.compareTo(val) != 1) {
                prev = iterator;
                iterator = iterator.next;
            }
            prev.next = newNode;
            newNode.next = iterator;
        }
    }
    public void display() {
        if(head!=null) {
            Node<T> iterator = head;
            while (iterator.next != null) {
                System.out.print(iterator + "-->");
                iterator = iterator.next;
            }
            System.out.println(iterator);
        }
    }


    public int searchWithMemoryAcsess(T val) throws Exception {
        int bellekErisimi = 1;
        if (head == null) {
            throw new Exception("Liste bos");
        }else {
            Node<T> iterator = head;
            while (iterator != null) {
                if (iterator.value.compareTo(val) == 0) {
                    return bellekErisimi ;
                }
                iterator = iterator.next;
                bellekErisimi++;
            }
        }
        throw new Exception("Girilen değer listede bulunmamaktadır");
    }

    public int searchWithMemoryAcsessAddesToHead(T val) throws Exception {
        // aranan değeri bulduğunda head'e ekleyip eski halibi siliyor.
        int bellekErisimi = 1;
        if (head == null) {
            throw new Exception("Liste bos");
        }
        Node<T> iterator = head;
        while (iterator.next != null) {
            if (iterator.value.compareTo(val) == 0) {
                delete(val);
                addToFront(val);
                return bellekErisimi;
            }
            iterator = iterator.next;
            bellekErisimi++;
        }
        throw new Exception("Girdiğiniz değer listede yok");
    }

    public int searchWithMemoryAcsessWithTransposition(T val) throws Exception {
        //aranan değeri bulduğunda ondan önceki değerle yer değiştiriyor.
        int bellekErisimi = 1;
        if (head == null) {
            throw new Exception("Liste bos");
        }
        Node<T> iterator = head;
        Node<T> prev = head;
        while (iterator.next != null) {
            if (iterator.value.compareTo(val) == 0) {
                T tempVal = iterator.value;
                iterator.value = prev.value;
                prev.value = tempVal;
                return bellekErisimi;
            }
            prev = iterator;
            iterator = iterator.next;
            bellekErisimi++;
        }
        throw new Exception("Girdiginiz deger listede yok");
    }

}
