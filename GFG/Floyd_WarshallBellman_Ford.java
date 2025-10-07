import java.util.Arrays;

public class Bellman_Ford {

    public static void main(String[] args) {
        int V = 5;
        int edges[][] = {{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        int src = 0;

        int V1 = 4;
        int edges1[][] = {{0, 1, 4}, {1, 2, -6}, {2, 3, 5}, {3, 1, -2}};
        int src1 = 0;

        int[] ans1 = new Bellman_Ford().bellmanFord(V, edges, src);
        int[] ans2 = new Bellman_Ford().bellmanFord(V1, edges1, src1);   

        for(int i: ans1){
            System.out.print(i+" ");
        }

        System.out.println();

        for(int i: ans2){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        

    }
}