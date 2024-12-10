public class Main {
    public static void main(String[] args) throws Exception {
        Graph<Integer> MyGraph = new Graph();
        MyGraph.addVertex(1);
        MyGraph.addVertex(2);
        MyGraph.addVertex(3);
        MyGraph.addVertex(4);

        MyGraph.addEdge(1,2);
        MyGraph.addEdge(2,3);
        MyGraph.addEdge(2,4);
        MyGraph.addEdge(2,1);
        MyGraph.addEdge(3,1);
        MyGraph.addEdge(3,2);
        MyGraph.addEdge(3,4);

        /*MyGraph.displayGraph();

        System.out.println(MyGraph.outDegree(3));

        System.out.println(MyGraph.inDegree(2));*/

        int[][] myArray = MyGraph.adjacencyMatrix();

        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println(); // Yeni bir satıra geçmek için
        }
    }
}