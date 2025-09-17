import java.util.*;

public class City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }
        int distanceThreshold = sc.nextInt();
        System.out.println(findCity(n, m, edges, distanceThreshold));
    }

    // static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
    //     // code here
        
    //     int INF = Integer.MAX_VALUE;
    //     int dist[][] = new int[n][n];
        
    //     for(int[] r : dist){
    //         Arrays.fill(r, INF);
    //     }

    //     for(int i = 0; i<n; i++){
    //         for(int j = 0; j<n; j++){
    //             if( i != j ) 
    //         }
    //     }

    //     return 1;
    // }

    static int count;

    static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        // code here
        
        int INF = Integer.MAX_VALUE;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for(int i = 0; i<n; i++) adj.add(new ArrayList<>());

        for(int[] e : edges){
            adj.get(e[0]).add(new int[]{e[1], e[2]});
            adj.get(e[1]).add(new int[]{e[0], e[2]});
        }

        // counting, city
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });

        for(int i = 0; i<n; i++){
            count = 0;
            boolean[] v = new boolean[n];
            v[i] = true;
            dfs(adj, i, v, distanceThreshold);
            if(count == 0) continue;
            q.add(new int[]{count, i});
        }

        return q.poll()[1];
    }

    static void dfs(ArrayList<ArrayList<int[]>> adj, int curr, boolean[] v, int dt){

        if(dt <= 0) return;

        for(int[] n : adj.get(curr)){
            if(!v[n[0]]){
                if(dt-n[1] >= 0){
                    v[n[0]] = true;
                    count++;
                    dfs(adj, n[0], v, dt-n[1]);
                }
            }
        }
    }
}