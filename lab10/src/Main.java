public class Main {
    public static void main(String[] args) throws Exception {
        

        DoublyLinkedList<Integer> mylist = new DoublyLinkedList<>();

        mylist.addToFront(3);
        mylist.addToFront(5);
        mylist.addToFront(15);
        mylist.addToFront(66);
        mylist.addToFront(1);
        mylist.addToFront(80);
        mylist.addToFront(54);
        mylist.addToFront(99);

        mylist.addToFront(98);
        mylist.addToFront(97);
        mylist.insertionSort();
        mylist.display();



    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


}