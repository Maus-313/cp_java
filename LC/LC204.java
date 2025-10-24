import java.util.ArrayList;

public class LC204 {

    public static void main(String[] args) {
        LC204 solution = new LC204();
        int res = solution.countPrimes(10);
        System.out.println(res);
        // System.out.println(res == 41537);
    }

    public int countPrimes(int n) {
        
    }

    public int sol1(int n) {
        // Not optimized 146ms

        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] prime = new boolean[n];

        for(int i = 2; i<n; i++){
            if(!prime[i]){
                // System.out.println(i);
                ans.add(i);
                for(int j = i+i; j<n; j+=i){
                    prime[j] = true;
                }
            }
        }

        // for(int i : ans){
        //     System.out.println(i);
        // }

        return ans.size();
    }


    public int sol2(int n) {
        // vey optimisede 30ms

        static int INF = 5000000;

    // false = prime and vice versa
        static boolean[] prime = new boolean[INF+1];

        static int[] prefixSum = new int[INF+1];
        static boolean init = false;

        public int countPrimes(int n) {

            if(!init){
                initialize();
                init = true;
            }

            // for(int i = 0; i<=INF; i++){
            //     System.out.println(i+ " = "+!prime[i]);
            // }

            // for(int i : prefixSum){
            //     System.out.print(i+" ");
            // }
            
            return prefixSum[n];

        }

        static void initialize(){

            for(int i = 2; i*i<=INF; i++ ){
                if(!prime[i]){
                    for(int j = i*i; j<=INF; j+=i){
                        prime[j] = true;
                    }
                }
            }

            for(int i = 3; i<=INF; i++){
                prefixSum[i] = prefixSum[i-1]+((!prime[i-1])? 1:0);
            }

        }
    }
}
