public class BinarySearchTree <T extends Comparable<T>>{

    private TNode<T> root;

    public void insert(T val) throws Exception {
        TNode<T> newNode =new TNode<>(val);
        if(root==null){
            root=newNode;
        }else{
            TNode<T> iterator=root;
            while(iterator!=null){
                if(val.compareTo(iterator.value)==-1){
                    if(iterator.left==null) {
                        iterator.left = newNode;
                        return;
                    }
                    iterator=iterator.left;
                }else if(val.compareTo(iterator.value)==1){
                    if(iterator.right==null){
                        iterator.right=newNode;
                        return;
                    }
                    iterator=iterator.right;
                }else
                    throw new Exception("aynı değerden iki tane olamaz");
            }
        }
    }

    public void inorder(){
        inorder(root);
        System.out.println();
    }
    public void inorder(TNode<T> tempRoot){
        if(tempRoot!=null){
            inorder(tempRoot.left);
            System.out.print(tempRoot.value+" ");
            inorder(tempRoot.right);

        }
    }

    public boolean search(T val){
        TNode<T> iterator=root;
        while(iterator!=null){
            if(val.compareTo(iterator.value)==-1)
                iterator=iterator.left;
            else if (val.compareTo(iterator.value)==1)
                iterator=iterator.right;
            else
                return true;
        }
        return false;
    }
    public boolean recursiveSearch(T val){
        return recursiveSearch(root, val);
    }
    public boolean recursiveSearch(TNode<T> tempRoot, T val){
        if(tempRoot==null) {
            return false;
        }
        else if(val.compareTo(tempRoot.value)==-1){
            return recursiveSearch(tempRoot.left, val);
        }else if(val.compareTo(tempRoot.value)==1){
            return recursiveSearch(tempRoot.right, val);
        }else
            return true;

    }
    public TNode<T> findNode(T val){
        TNode<T> iterator=root;
        while(iterator!=null){
            if(val.compareTo(iterator.value)==-1)
                iterator=iterator.left;
            else if (val.compareTo(iterator.value)==1)
                iterator=iterator.right;
            else
                return iterator;
        }
        return null;
    }
    public boolean isLeaf(T val){
        TNode<T> current=findNode(val);
        if(current!=null && current.left==null && current.right==null)
            return true;
        return false;
    }
    public TNode<T> findParent(T val){
        if(!search(val))
            return null;
        else{
            TNode<T> iterator=root, parent=null;
            while(iterator.value.compareTo(val)!=0){
                parent=iterator;
                if(val.compareTo(iterator.value)==-1)
                    iterator=iterator.left;
                else if(val.compareTo(iterator.value)==1)
                    iterator=iterator.right;
            }
            return parent;
       }

    }
    public TNode<T> inorderSuccessor(T val){
        if(!search(val))
            return null;
        TNode<T> iterator=findNode(val).right;
        while(iterator.left!=null)
            iterator=iterator.left;
        return iterator;

    }

    public void delete(T val){
        if(search(val)) {
            if(val.compareTo(root.value)==0 && root.left==null &&
                    root.right==null) {
                root = null;
                return;
            }
            if(val.compareTo(root.value)==0  && root.right==null){
                root=root.left;
                return;
            }
            if(val.compareTo(root.value)==0  && root.left==null){
                root=root.right;
                return;
            }
            TNode<T> current = findNode(val);
            TNode<T> parent=findParent(val);
            if(isLeaf(val)){//yaprak ise
                if(parent.right!=null && parent.right.value.compareTo(val)==0)
                    parent.right=null;
                else
                    parent.left=null;
                return;
            }
            if(current.left!=null && current.right!=null){//çift çocuklu
                TNode<T> successor=inorderSuccessor(val);
                T successorValue=successor.value;
                delete(successorValue);
                current.value=successorValue;
                return;
            }
            //buraya geldiyse tek çocukludur
            if(val.compareTo(parent.right.value)==0){
                if(current.left!=null)
                    parent.right=current.left;
                else
                    parent.right=current.right;
            }else{ 
                if(current.left!=null)
                    parent.left=current.left;
                else
                    parent.left=current.right;
            }
        }
    }

    public int findHeight (){
        return findHeight(root);
    }

    private int findHeight(TNode<T> root){
        if (root == null){
            return 0;
        }else {
            return 1 + Math.max(findHeight(root.left), findHeight(root.right));
        }

    }

    public int balance(TNode<T> tempRoot){
        return (findHeight(tempRoot.right) - findHeight(tempRoot.left));
    }





}












