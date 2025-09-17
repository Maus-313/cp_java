import java.util.PriorityQueue;

public class Minimum_Multiplications_to_reach_End {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            }
            int start = sc.nextInt();
            int end = sc.nextInt();
            int result = minimumMultiplications(arr, start, end);
            System.out.println("Result -> " +result);
        }
    }

    static int MOD = 100000;
    
    static int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int l = arr.length;
        
        // count, value
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        boolean[] v = new boolean[MOD];

        q.add(new int[]{0, start});
        v[start] = true;
        
        while(q.size() != 0){

            int[] temp = q.poll();
            int curr = temp[1];
            
            if(curr == end) return temp[0];
            
            for(int n : arr){
                int nc = (curr*n)%MOD;
                if(!v[nc]){
                    v[nc] = true;
                    q.add(new int[] {temp[0] + 1, nc});
                }
            }
        }
        
        
        return -1;
        
    }
}
