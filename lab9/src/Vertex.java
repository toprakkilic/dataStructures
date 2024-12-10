public class Vertex <T extends Comparable> {
    T vertexID;
    Vertex<T> nextVertex;
    Edge<T> edgeLink;
    public Vertex(T vertexID) {
        this.vertexID = vertexID;
        nextVertex = null;
        edgeLink = null;
    }
    public String toString() {
        return String.valueOf(this.vertexID);
    }


}
