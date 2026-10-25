
import java.util.Scanner;

public class Hamiltonian {

    static int n;
    static int graph[][];
    static int path[];

    static boolean isSafe(int v, int pos) {

        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++) {
            if (path[i] == v)
                return false;
        }

        return true;
    }

    static boolean solve(int pos) {

        if (pos == n) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < n; v++) {

            if (isSafe(v, pos)) {

                path[pos] = v;

                if (solve(pos + 1))
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        n = sc.nextInt();

        graph = new int[n][n];
        path = new int[n];

        System.out.println("Enter adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            path[i] = -1;
        }

        path[0] = 0;

        if (solve(1)) {
            System.out.println("Hamiltonian Cycle:");

            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " -> ");
            }

            System.out.println(path[0]);
        } else {
            System.out.println("No Hamiltonian Cycle exists.");
        }

        sc.close();
    }
}

