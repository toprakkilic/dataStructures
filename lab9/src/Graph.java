public class Graph<T extends Comparable> {
    private Vertex<T> graphHead;

    public void addVertex(T id) {
        Vertex<T> newVertex = new Vertex<>(id);
        if (graphHead == null) {
            graphHead = newVertex;
        }
        else {
            Vertex<T> iterator = graphHead;
            while (iterator.nextVertex != null) {
                iterator = iterator.nextVertex;
            }
            iterator.nextVertex = newVertex;
        }
    }
    public Vertex<T> findVertex(T id) {
        Vertex<T> iterator = graphHead;
        while (iterator != null) {
            if(iterator.vertexID.compareTo(id) == 0)
                return iterator;
            iterator = iterator.nextVertex;
        }
        return iterator;
    }
    public void addEdge(T startingVertexID, T endingVertexID) throws Exception {
        Vertex<T> startVertex = findVertex(startingVertexID);
        if(startVertex == null)
            throw new Exception("vertex bulunamadı");
        Edge<T> newEdge=new Edge(endingVertexID);
        if(startVertex.edgeLink == null)
            startVertex.edgeLink = newEdge;
        else{
            Edge<T> iterator = startVertex.edgeLink;
            while(iterator.nextEdge != null) {
                iterator = iterator.nextEdge;
            }
            iterator.nextEdge = newEdge;
        }

    }

    public void displayGraph() {
        Vertex<T> iterator = graphHead;
        while (iterator != null) {
            Edge<T> TempEdge = iterator.edgeLink;
            System.out.println(" \n"+iterator.vertexID + "Vertex");
            while (TempEdge != null) {
                System.out.print("-->" +TempEdge.vertexID + "edge");
                TempEdge = TempEdge.nextEdge;
            }
            iterator = iterator.nextVertex;
        }
    }


    public int outDegree (T VertexID) {
        Vertex<T> tempVertex = findVertex(VertexID);
        Edge<T> tempEdge = tempVertex.edgeLink;
        int iterator = 0;
        if (tempEdge == null) {
            return iterator;
        }else {
            while (tempEdge != null) {
                iterator++;
                tempEdge = tempEdge.nextEdge;
            }
            return iterator;
        }
    }


    public int inDegree (T VertexID) {
        int count = 0;
        Vertex<T> iterator = graphHead;
        while (iterator != null) {
            Edge<T> TempEdge = iterator.edgeLink;
            while (TempEdge != null) {
                if (TempEdge.vertexID.compareTo(VertexID) == 0) {
                    count++;
                }
                TempEdge = TempEdge.nextEdge;
            }
            iterator = iterator.nextVertex;
        }
        return count;
    }

        public int[][] adjacencyMatrix() {
            int i = 0; int j;
            int[][] array = new int[4][4] ;
            Vertex<T> iterator = graphHead;
            while(iterator != null) {
                Edge<T> TempEdge = iterator.edgeLink;
                j = 0;
                while (TempEdge != null) {
                    if (iterator.vertexID.compareTo(TempEdge.vertexID) == 0) {
                        array[i][j] = 1;
                        System.out.println("calisiyo");
                    }else {
                        array[i][j] = 0;
                        System.out.println("calismito");
                    }
                    TempEdge = TempEdge.nextEdge;
                    j++;
                }
                iterator = iterator.nextVertex;
                i++;
            }
            return array;
        }

}
