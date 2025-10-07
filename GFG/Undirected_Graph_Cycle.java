import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Undirected_Graph_Cycle {
    public static void main(String[] args) {
        int edges[][] = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int edges2[][] = {{0, 1}, {1, 2}, {2, 3}};

        System.out.println(new Undirected_Graph_Cycle().isCycle(4, edges));
        System.out.println(new Undirected_Graph_Cycle().isCycle(4, edges2));
    }

    public boolean isCycle(int V, int[][] edges) {
        
    }
}