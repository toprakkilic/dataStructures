public class MyArray {
    int[] array;

    public MyArray(int[] arr){
        array = new int[arr.length];
        System.arraycopy(arr, 0, array, 0, arr.length);
    }

    public void display(){
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    public int min (){
        int min = array[0];

        for (int sayi : array){
            if (sayi < min){
                min = sayi;
            }
        }
        return min;
    }

    public int lineerSearch(int num){
        int index = 0;
        boolean bulundu = false;
        for (int sayi : array){
            if (sayi == num){
                bulundu = true;
                break;
            }
            index++;
        }
        if (bulundu){
            return index;
        }
        else
            return -1;
    }

    public void bubbleSort(){
        boolean swapped;

        for (int i = 0; i < array.length; i++) {
            swapped = false;
            for (int j = 0; j < array.length -1 -i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public int binarySearch(int num){
        int low = 0;
        int high = array.length -1;
        while (low <= high){
            int mid = low + (high - low) / 2;

            if (array[mid] == num){
                return mid;
            }
            if (array[mid] < num){
                low = mid + 1;
            }
            else
                high = mid -1 ;
        }
        return -1;
    }


}
