import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC802 {
    public static void main(String[] args) {
        // int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        int[][] graph = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
        
        // TLE
        

        List<Integer> ans = new LC802().eventualSafeNodes(graph);

        for(int i : ans){
            System.out.print(i + " ");
        }

    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();

        int V = graph.length;

        boolean[] v = new boolean[V];
    
        for (int i = 0; i < V; i++) {
            if(!v[i]){
                v[i] = true;
                boolean[] loop = new boolean[V];
                loop[i] =true;
                if(isLoop(graph, i, v, loop, ans)){

                }else{
                    if(!ans.contains(i)) ans.add(i);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }

    static boolean isLoop(int[][] adj, int curr, boolean[] v, boolean[] loop, List<Integer> ans){
        for(int n : adj[curr]){
            if(loop[n]){
                return true;
            }else if(!loop[n]){
                if(ans.contains(n)) continue;
                // if(v[n]) continue;
                v[n] =true;
                loop[n] = true;
                if(isLoop(adj, n, v, loop, ans)){
                    return true;
                }else{
                    if(!ans.contains(n)) ans.add(n);
                }
                loop[n] = false;
            }
        }
        return false;
    }
}