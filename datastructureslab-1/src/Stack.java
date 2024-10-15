public class Stack{
    private int [] values;
    private int top;
    public Stack(int size){
        this.values=new int[size];
        this.top=-1;
    }

    public void push(int val){
        if(!isFull()){
            this.top++;
            this.values[this.top]=val;
        }else{
            System.out.println("stack dolu");
        }

    }

    public int peek() throws Exception {
        if (!isEmpty()){
            return this.values[this.top];
        }
        else {
            throw new Exception("stack bos");
        }
    }

    public int size(){
        return this.values.length;
    }
    public int pop() throws Exception {
        if(!isEmpty()){
            this.top--;
            return this.values[this.top+1];
        }else{
            throw  new Exception("stack bos");
//            System.out.println("stack boş");
//            return -1;//güzel bir çözüm değil
        }

    }
    public boolean isEmpty(){
        return this.top==-1;
//        if(this.top==-1)
//            return true;
//        else
//            return false;
    }
    public boolean isFull(){
        return this.top==this.values.length-1;
    }
    public void display(){
//        for (int i = this.top; i >-1 ; i--) {
//            System.out.println(this.values[i]);
//        }
        int temp=this.top;
        while(temp!=-1){
            System.out.println(this.values[temp]);
            temp--;
        }

    }

    public boolean search (int val){
        for (int i = 0; i <=this.top ; i++) {
            if (val==this.values[i])
                return true;
        }
        return false;
    }


}