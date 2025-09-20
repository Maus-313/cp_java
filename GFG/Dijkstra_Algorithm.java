import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra_Algorithm {
    public static void main(String[] args) {
        int V = 3;
        int edges[][] = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};
        int src = 2;

        int[] ans = new Dijkstra_Algorithm().dijkstra(V, edges, src);

        for(int i : ans){
            System.out.print(i+" ");
        }

        System.out.println();

    }

    public int[] dijkstra(int V, int[][] edges, int src) {

        
    }
}