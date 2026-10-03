import java.util.Scanner;

public class Dijktras {

    public static int[] dijkstras(int[][] graph, int s) {

        int n = graph.length;

        int[] d = new int[n];          // distance array
        Boolean[] v = new Boolean[n]; // visited array

        // Initialize visited status as false and distance of all nodes as infinity
        for (int i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE;
            v[i] = false;
        }
    //initializing source node as at 0 distance 
        d[s] = 0;

        // Main loop
        for (int i = 0; i < n; i++) {
            int u = -1;
            int mindistance = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {

                if (!v[j] && d[j] < mindistance) {
                    mindistance = d[j];
                    u = j;
                }
            }
            if (u == -1) {
                break;
            }
            v[u] = true;

            // Check all neighbours of u
            for (int j = 0; j < n; j++) {

                if (!v[j]
                        && graph[u][j] != 0
                        && d[u] + graph[u][j] < d[j]) {

                    d[j] = d[u] + graph[u][j];
                }
            }
        }

        return d;
    }


    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the Size of graph (m x n) : ");
        System.out.print("m : ");
        int m=s.nextInt();
        System.out.print("n : ");
        int n=s.nextInt();

        int [][] graph = new int [m][n];
        System.out.println("Enter the Graph in Matrix Form : ");
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print("Enter Distance of "+j+" from "+i+" : ");
                int dist=s.nextInt();
                graph[i][j]=dist;
            }
        }

        int source = 0;

        int[] dist = dijkstras(graph, source);

        System.out.println("Shortest Distance From Vertex " + source + " : ");

        for (int i = 0; i < dist.length; i++) {
            System.out.println(source + " -> " + i + " = " + dist[i]);
        }
    }
}