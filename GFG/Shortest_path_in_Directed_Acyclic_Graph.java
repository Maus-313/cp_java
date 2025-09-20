import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Shortest_path_in_Directed_Acyclic_Graph {
    public static void main(String[] args) {
        Shortest_path_in_Directed_Acyclic_Graph solver = new Shortest_path_in_Directed_Acyclic_Graph();

        int V1 = 4, E1 = 2;
        int[][] edges1 = { {0,1,2}, {0,2,1} };
        System.out.println(Arrays.toString(solver.shortestPath(V1, E1, edges1)));

        int V2 = 6, E2 = 7;
        int[][] edges2 = { {0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1} };
        System.out.println(Arrays.toString(solver.shortestPath(V2, E2, edges2)));
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        int[] dist = new int[V];

        int INF = Integer.MAX_VALUE;
        boolean v[] = new boolean[V];

        Arrays.fill(dist, INF);

        // distance, node
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 

        
    }

}
