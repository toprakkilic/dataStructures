public class Main {
    public static void main(String[] args) {
        int [] array = {8,4,5,9,15,26,12,44,14};

        MyArray arr = new MyArray(array);

        arr.display();
        System.out.println(" \n" +arr.min());
        arr.bubbleSort();
        arr.display();
        System.out.println(" \n" +arr.lineerSearch(5));
        System.out.println(" \n" +arr.lineerSearch(44));
        System.out.println(" \n" +arr.lineerSearch(2));
        System.out.println(" \n" + arr.binarySearch(2));
        System.out.println(" \n" + arr.binarySearch(44));

    }
}