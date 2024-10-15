public class CircularQueue <T extends Comparable> {
    private T [] values;
    private int head, tail;

    public CircularQueue(Class<T> dataType, int size){
        this.values= (T[])java.lang.reflect.Array.newInstance(dataType, size);
        head=tail=0;
    }
    public int size(){
        return this.values.length;
    }
    public boolean isEmpty(){
        return this.head==this.tail;
    }
    public boolean isFull(){
        return this.head==(this.tail+1)%size();
    }
    public void clear(){
        this.head=this.tail=0;
    }
    public void enQueue(T val){
        if(!isFull()){
            this.tail=(this.tail+1)%size();
            this.values[this.tail]=val;
        }else
            System.out.println("queue is full");
    }
    public T deQueue() throws Exception {
        if(!isEmpty()){
            this.head=(this.head+1)%size();
            return this.values[this.head];
        }else
            throw  new Exception("queue is empty");
    }
    public void display(){
        int tempHead=this.head;
        while(tempHead!=this.tail){
            tempHead=(tempHead+1)%size();
            System.out.println(this.values[tempHead]);

        }
    }
    public boolean search(T val){
        int tempHead=this.head;
        while(tempHead!=this.tail){
            tempHead=(tempHead+1)%size();
            if(this.values[tempHead].compareTo(val)==0)
                return true;
        }
        return false;
    }

    public int elemanSayisi(){
        int temp = this.head;
        int sayac = 0;
        while (temp != tail){
            temp = (temp +1) % size();
            sayac++;
        }
        return sayac;
    }

}
