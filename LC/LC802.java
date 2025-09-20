import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC802 {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        int[][] graph1 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};   
        int[][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        int[][] graph3 = {{0,1,8},{4,5,8},{3,5,6,8},{4,5,6,7,8,9},{5},{},{3,8},{8,9},{9},{8}};
        
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new LC802().eventualSafeNodes(graph));
        ans.add(new LC802().eventualSafeNodes(graph1));
        ans.add(new LC802().eventualSafeNodes(graph2));
        ans.add(new LC802().eventualSafeNodes(graph3));

        for(List<Integer> l : ans){
            for(int i : l){
                System.out.print(i + " ");
            }
            System.out.println();
        }
        

        System.out.println();
        // System.out.println("Hello");
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
    }
}