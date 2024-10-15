public class Main {
    public static <T extends  Comparable> boolean search(CircularQueue<T> q , T val) throws Exception {
        boolean ans = false;
            for (int i = 0; i<= q.elemanSayisi(); i++){
                T gecici = q.deQueue();
                if (gecici.compareTo(val) == 0){
                    ans = true;
                }
                q.enQueue(gecici);
            }
        return ans;
    }

    public static boolean isPalindrome(String kelime) throws Exception {
        GenericStack<Character> stack = new GenericStack<>(Character.class, kelime.length());
        CircularQueue<Character> queue = new CircularQueue<>(Character.class, kelime.length() +1);

        for (int i = 0; i < kelime.length(); i++) {
            stack.push(kelime.charAt(i));
            queue.enQueue(kelime.charAt(i));
        }

        for (int i = 0; i < queue.size() / 2; i++) {
            if (stack.pop() != queue.deQueue()){
                return false;
            }

        }

        return true;
    }


    public static void main(String[] args) throws Exception {


        System.out.println(isPalindrome("a"));
    }
}