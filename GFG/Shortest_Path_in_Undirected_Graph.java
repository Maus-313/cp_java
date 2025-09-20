import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Shortest_Path_in_Undirected_Graph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2)));
        adj.add(new ArrayList<>(Arrays.asList(1, 6)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(3, 5)));
        adj.add(new ArrayList<>(Arrays.asList(4, 6)));
        adj.add(new ArrayList<>(Arrays.asList(2, 5, 7, 8)));
        adj.add(new ArrayList<>(Arrays.asList(6, 8)));
        adj.add(new ArrayList<>(Arrays.asList(7, 6)));
        int src= 0;

        ArrayList<int[]> ans = new ArrayList<>();
        ans.add(new Shortest_Path_in_Undirected_Graph().shortestPath(adj, src));
        

        for(int[] a : ans){
            for(int i : a){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }


    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        

    }
}