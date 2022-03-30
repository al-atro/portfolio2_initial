import java.util.ArrayList;

public class AdjacencyGraph {
    ArrayList<Vertex> Vertices;
    public AdjacencyGraph(){
        Vertices=new ArrayList<Vertex>();
    }
    public void addVertex(Vertex v){
        Vertices.add(v);
    }

    // here we add a way to create the path between two cities. IMPORTANT: the path is undirected
    public void addEdge(Vertex from, Vertex to, Integer distance){
        if(!(Vertices.contains(from) && Vertices.contains(to)))
        {
            System.out.println("Vertices missing from graph");
            return;
        }
        Edge newE=new Edge(from, to, distance);
        Edge newE2=new Edge( to, from, distance);
    }
    // here we create a way for out graph to be displayed
    public void PrintGraph(){
        for(int i=0;i<Vertices.size();i++){
            System.out.println("City "+Vertices.get(i).name+" is connected to: ");
            Vertex current=Vertices.get(i);
            for (Edge e: current.OutEdge) {
                System.out.println(e.to.name +", the distance is "+e.weight);
            }
        }
    }

}
// here we add the class for the cities
class Vertex {
    String name;
    ArrayList<Edge> OutEdge;
    public Vertex(String name){
        this.name=name;
        OutEdge=new ArrayList<Edge>();
    }

}
// here we add the class for the paths between the cities
class Edge{
    Vertex from;
    Vertex to;
    Integer weight;
    public Edge(Vertex from,Vertex to, Integer weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
        from.OutEdge.add(this);
    }
}
