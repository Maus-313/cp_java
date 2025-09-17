import java.util.ArrayList;

public class LC204 {
    public static void main(String[] args) {
        LC204 solution = new LC204();
        int res = solution.countPrimes(499979);
        System.out.println(res);
        System.out.println(res == 41537);
    }

    public int countPrimes(int n) {

            int count = 0;
            // boolean[] p = new boolean[n];

            int[] p = new int[n];
            int idx = 0;
            int pf = 0;

            for(int i = 2; i*i<=n; i++){
                if(p[i] == 0){
                    p[i] = pf + 1;
                    pf++;
                    for(int j = i*i; j<n; j+= i){
                        p[j] = -1;
                    }
                }
                idx = i;
            }

            while(idx < n){
                if(p[idx] != -1){
                    pf++;
                }
                p[idx] = pf;
                idx++;
            }
            return p[n-1];

            // for(int i = 2; i<n; i++){
            //     if(p[i] == 0) count++;
            // }
            // return count;
        }

    public int answer(int n) {
        int count = 0;
        boolean[] p = new boolean[n];

        for (int i = 2; i <= n / i; i++) {
            if (p[i] == false) {
                for (int j = i * i; j < n; j += i)
                    p[j] = true;
            }
        }

        for (int i = 2; i < n; i++) {
            if (!p[i]) {
                try (java.io.FileWriter fw = new java.io.FileWriter("included_primes_correct.txt", true)) {
                    fw.write("Included: " + i + System.lineSeparator());
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }
        return count;
    }
}
