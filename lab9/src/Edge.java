public class Edge <T extends Comparable<T>>{
    T vertexID;
    Edge<T> nextEdge;
    public Edge(T vertexID){
        this.vertexID = vertexID;
        nextEdge = null;
    }
    public String toString() {
        return String.valueOf(this.vertexID);
    }

}
