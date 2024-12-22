import java.util.*;
public class BellmanFord {
    public static final int MAX_VAL=999;
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total number of vertices:");
        int V=sc.nextInt();
        int graph[][]=new int[V][V];
        System.out.println("Enter the edge weight(use "+MAX_VAL+" for no edge:");
        for(int i=0;i<V;i++)
        {
            for(int j=0;j<V;j++)
            {
             System.out.println("The Weights from vertex "+i+" to vertex "+j);
             graph[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the source vertex:");
        int src=sc.nextInt();
        bellmanford(graph,V,src);
        sc.close();
    }
    public static void bellmanford(int graph[][],int V,int src)
    {
        int dist[]=new int[V];
        Arrays.fill(dist,MAX_VAL);
        dist[src]=0;
        for(int i=0;i<V-1;i++)
        {
            for(int u=0;u<V;u++)
            {
                for(int v=0;v<V;v++)
                {
                    if(dist[u]!=MAX_VAL && dist[u]+graph[u][v]<dist[v])
                    {
                        dist[v]=dist[u]+graph[u][v];
                    }
                }
            }
        }
        for(int u=0;u<V;u++)
        {
            for(int v=0;v<V;v++)
            {
                if(dist[u]!=MAX_VAL && dist[u]+graph[u][v]<dist[v])
                {
                    System.out.println("Graph contains negetive cycle!!!");
                    return;
                }
            }
        }
        System.out.println("Vertex \t Distance from source vertex");
        for(int i=0;i<V;i++)
        {
            System.out.println(i+"\t\t"+dist[i]);
        }
    }
}
