// import java.util.Scanner;

import java.util.Scanner;

public class Fwarshall {
    static final int inf = 99999;

    public static void floyd(int[][] graph, int n) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j]=graph[i][j];
            }

        }
        for(int k=0;k<n;k++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k]!=inf && 
                        dist[k][j]!=inf && 
                        dist[i][k] + dist[k][j] < dist[i][j] ){
                            dist[i][j]=dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        //display
        System.out.println("Shortest Distance Matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.print("Enter the no of Vertices : ");
        int n = s.nextInt();
        int[][] graph = new int[n][n];
        System.out.println("Enter the Graph ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Distance " + i + " -> " + j + " (Enter 99999 for infinite distance): ");
                int path = s.nextInt();
                graph[i][j] = path;
            }
        }
        floyd(graph, n);
        s.close();
    }
}
