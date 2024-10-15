public class Main {

    public static boolean search ( Stack obj, int val) throws Exception {
        boolean ans = false;
        Stack temp = new Stack(obj.size());

        while(!obj.isEmpty()){
                int a = obj.pop();
                temp.push(a);
                if (a == val){
                    ans = true;
                    break;
                }
        }
        while (!temp.isEmpty()){
            obj.push(temp.pop());
        }
        return ans;
    }

    public static Stack butunle (Stack obj1, Stack obj2) throws Exception {
        Stack birlesmis = new Stack(obj1.size() + obj2.size());

        while(!obj1.isEmpty() || !obj2.isEmpty()){
            int a = 0;
            int b = 0;
            if (!obj1.isEmpty() || !obj2.isEmpty()) {
                if (!obj1.isEmpty()){
                    a = minimum(obj1);
                    remove(obj1, a);
                    System.out.println(a + "       toprak        ");
                }

                if (!obj2.isEmpty()){
                    b = minimum(obj2);
                    remove(obj2, b);
                    System.out.println(b + "       toprak        ");
                }
            }

            if (a <= b){

                if (!(a == 0 && obj1.isEmpty())) {
                    birlesmis.push(a);

                }
                if (!(b == 0 && obj2.isEmpty())){
                    birlesmis.push(b);

                }
            }

            if (a > b){
                if (!(b == 0 && obj2.isEmpty())) {
                    birlesmis.push(b);
                }
                if (!(a == 0 && obj1.isEmpty())){
                    birlesmis.push(a);
                }
            }

        }

        return birlesmis;
    }

    public static int minimum(Stack obj) throws Exception {
        Stack temp = new Stack(obj.size());
        int b = obj.peek();

        while(!obj.isEmpty()){
            int a = obj.pop();
            temp.push(a);
            if (a < b ){
                b=a;
                break;
            }
        }
        while (!temp.isEmpty()){
            obj.push(temp.pop());
        }
        return b;
    }

    public static void remove(Stack obj, int val) throws Exception {
        Stack temp = new Stack(obj.size());

        while(!obj.isEmpty()){
            int a = obj.pop();
            if (a == val ){
                break;
            }
            temp.push(a);
        }
        while (!temp.isEmpty()){
            obj.push(temp.pop());
        }


    }

    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        Stack stack2 = new Stack(6);
        stack.push(5);
        stack.push(7);
        stack.push(2);

        System.out.println("-------------------------------------------------------");

        stack.display();

        System.out.println("-------------------------------------------------------");
        stack2.push(9);
        stack2.push(7);
        stack2.push(6);
        stack2.push(12);

        stack.display();
        System.out.println("-------------------------------------------------------");

        Stack stack3 = butunle(stack2 , stack);

        stack3.display();


    }

}