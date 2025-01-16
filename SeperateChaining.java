public class SeperateChaining <T extends Comparable>{

    HashNode<T>[] indexes;

    public SeperateChaining(int size) {
        indexes = new HashNode[size];
    }

    public int hash(int key){
        return key % indexes.length;
    }

    public void insert(int key, T value)throws Exception{
        int index = hash(key);
        if(search(key)){
            throw new RuntimeException("Already Exists");
        }
        if(indexes[index] == null){
            indexes[index] = new HashNode(key,value);
        }else{
            HashNode<T> iterator = indexes[index];
            while (iterator.next!=null){
                if(iterator.key == key){
                    return;
                }
                iterator = iterator.next;
            }
            iterator.next = new HashNode(key,value);
        }
    }

    public void delete(int key){
        if(search(key)){
            HashNode<T> iterator = indexes[hash(key)];
            HashNode<T> previous = iterator;
            if(iterator.key == key){
                indexes[hash(key)]=iterator.next;
            }else {
                while (iterator != null) {
                    if (iterator.key == key) {
                        previous.next = iterator.next;
                    }
                    previous = iterator;
                    iterator = iterator.next;
                }
            }
        }else{
            return;
        }
    }

    public boolean search(int key){
        HashNode<T> iterator = indexes[hash(key)];
        while (iterator != null){
            if(iterator.key == key){
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

    public void display(){
        for(int i=0;i<indexes.length;i++){
            HashNode<T> iterator = indexes[i];
            if(iterator == null){
                System.out.print("NULL");
            }
            while(iterator!=null){
                System.out.print(iterator+" ");
                iterator = iterator.next;
            }
            System.out.println();
        }
    }
}
