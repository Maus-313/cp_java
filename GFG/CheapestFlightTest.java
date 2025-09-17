import java.util.*;

// ---- Your solution (unchanged) ----
class Solution {
    public int findCheapestPrice(int V, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] e : flights) {
            adj.get(e[0]).add(new int[]{e[1], e[2]});
        }

        // cost, stopsUsed, node
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        q.add(new int[]{0, 0, src});

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int curr = temp[2];
            int cost = temp[0];
            int tempK = temp[1];

            if (curr == dst) return cost;

            for (int[] n : adj.get(curr)) {
                int newK = tempK + 1;
                if (newK > k + 1) continue; // at most k stops => at most k+1 edges
                int newDest = n[0];
                int newCost = cost + n[1];
                q.add(new int[]{newCost, newK, newDest});
            }
        }

        return -2;
    }
}

// ---- Reference implementation for cross-check (Bellman-Ford with up to k stops) ----
class Reference {
    // O(k * |E|) DP: dp[steps][v] = min cost to reach v in exactly 'steps' edges
    // We want up to k+1 edges (because k stops = k+1 edges).
    static int cheapestWithKStops(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1_000_000_000;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax edges up to k+1 times (edges count)
        for (int i = 0; i < k + 1; i++) {
            int[] next = dist.clone();
            for (int[] e : flights) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] == INF) continue;
                if (dist[u] + w < next[v]) {
                    next[v] = dist[u] + w;
                }
            }
            dist = next;
        }
        return dist[dst] >= INF ? -1 : dist[dst];
    }
}

// ---- Test harness ----
public class CheapestFlightTest {
    public static void main(String[] args) {
        int n = 13;
        int[][] flights = new int[][]{
            {11,12,74},{1,8,91},{4,6,13},{7,6,39},{5,12,8},{0,12,54},{8,4,32},{0,11,4},
            {4,0,91},{11,7,64},{6,3,88},{8,5,80},{11,10,91},{10,0,60},{8,7,92},{12,6,78},
            {6,2,8},{4,3,54},{3,11,76},{3,12,23},{11,6,79},{6,12,36},{2,11,100},{2,5,49},
            {7,0,17},{5,8,95},{3,9,98},{8,10,61},{2,12,38},{5,7,58},{9,4,37},{8,6,79},
            {9,0,1},{2,3,12},{7,10,7},{12,10,52},{7,2,68},{12,2,100},{6,9,53},{7,4,90},
            {0,5,43},{11,2,52},{11,8,50},{12,4,38},{7,9,94},{2,7,38},{3,7,88},{9,12,20},
            {12,0,26},{10,5,38},{12,8,50},{0,2,77},{11,0,13},{9,10,76},{2,6,67},{5,6,34},
            {9,7,62},{5,3,67}
        };
        int src = 10, dst = 1, k = 10;

        Solution sol = new Solution();
        int ans = sol.findCheapestPrice(n, flights, src, dst, k);

        int ref = Reference.cheapestWithKStops(n, flights, src, dst, k);

        System.out.println("Your Solution Output : " + ans);
        System.out.println("Reference Output     : " + ref);

        if (ans != ref) {
            System.err.println("❌ MISMATCH between your solution and reference result!");
            System.exit(1);
        } else {
            System.out.println("✅ Match! Test passed.");
        }

        // Extra quick sanity tests
        smallSanityTests();
    }

    private static void smallSanityTests() {
        // 1) Simple line: 0->1 (100), 0->2 (50), 2->1 (40). With k=1, answer should be 90 via 0->2->1.
        int n = 3;
        int[][] flights = {{0,1,100},{0,2,50},{2,1,40}};
        int src = 0, dst = 1, k = 1;

        Solution sol = new Solution();
        int ans = sol.findCheapestPrice(n, flights, src, dst, k);
        int ref = Reference.cheapestWithKStops(n, flights, src, dst, k);
        assert ans == ref && ans == 90 : "Sanity test 1 failed: got " + ans + ", expected 90";

        // 2) No route within k stops
        int[][] flights2 = {{0,2,100},{2,1,100}}; // needs 2 edges
        int ans2 = sol.findCheapestPrice(3, flights2, 0, 1, 0); // k=0 => at most 1 edge
        int ref2 = Reference.cheapestWithKStops(3, flights2, 0, 1, 0);
        assert ans2 == ref2 && ans2 == -1 : "Sanity test 2 failed";

        // 3) Direct is cheaper than via
        int[][] flights3 = {{0,1,50},{0,2,10},{2,1,50}};
        int ans3 = sol.findCheapestPrice(3, flights3, 0, 1, 1);
        int ref3 = Reference.cheapestWithKStops(3, flights3, 0, 1, 1);
        assert ans3 == ref3 && ans3 == 50 : "Sanity test 3 failed";

        System.out.println("Additional sanity tests passed.");
    }
}