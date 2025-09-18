public class Directed_Graph_Cycle {
    public static void main(String[] args) {
        int V = 4;
        int edges[][] = {{0, 1}, {1, 2}, {2, 3}, {3, 3}};

        System.out.println(new Directed_Graph_Cycle().isCyclic(V, edges));
    }

    public boolean isCyclic(int V, int[][] edges) {
        // code here
        
    }
}
