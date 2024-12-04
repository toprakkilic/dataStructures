public class Main {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer> myTree = new BinarySearchTree<>();

        myTree.insert(15);
        myTree.insert(24);
        myTree.insert(44);
        myTree.insert(25);

        myTree.inorder();

        System.out.println(myTree.findHeight());


    }
}
