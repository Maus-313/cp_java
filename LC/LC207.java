import java.util.ArrayDeque;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Result -> " + new Main().canFinish(numCourses1, prerequisites1));

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}, {0, 1}};
        System.out.println("Result -> " + new Main().canFinish(numCourses2, prerequisites2));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] id = new int[numCourses];

        for (int[] e : prerequisites) {
            adj.get(e[1]).add(e[0]);
            id[e[0]]++;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] done = new boolean[numCourses];
        int count = 0;

        for (int i = 0; i < numCourses; i++) {
            if (id[i] == 0) {
                q.add(i);
                count++;
            }
        }

        

        while (q.size() != 0) {
            int curr = q.poll();
            for (int n : adj.get(curr)) {
                id[n]--;
                if (id[n] == 0){
                    q.add(n);
                    count++;
                }
            }
        }
        
        if(count != numCourses) return false;

        return true;
    }
}