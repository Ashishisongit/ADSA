public class PrimsAlgo {
    public static int minKey(int[] key, boolean[] mstSet) {
        // helping to sort the min weight's key
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < key.length; i++) {

            if (mstSet[i] == false && key[i] < min) {
                min = key[i];
                index = i;
            }
        }

        return index;
    }

    public static void primMST(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V];
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        for (int i = 0; i < graph.length; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int i = 0; i < V; i++) {
                if (graph[u][i] != 0 && mstSet[i] == false && graph[u][i] < key[i]) {
                    parent[i] = u;
                    key[i] = graph[u][i];
                }
            }
        }
        System.out.println("Edge Weigt : ");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i]+" -- "+i+"\t"+graph[i][parent[i]]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 2, 6, 0 },
                { 2, 0, 3, 5 },
                { 6, 3, 0, 1 },
                { 0, 5, 1, 0 }
        };
        primMST(graph);
    }
}
