import java.util.ArrayList;
import java.util.Collections;

public class Prime_Factors {
    public static void main(String[] args) {
        ArrayList<Integer> ans = sol2(100);
        for (int i : ans) {
            System.out.print(i + " ");
        }
        // System.out.println((int)Math.sqrt(35));
    }

    public static ArrayList<Integer> primeFac(int n) {
        
    }

    public static ArrayList<Integer> sol1(int n) {
        // Best
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                ans.add(i);
                while (n % i == 0)
                    n = n / i;
            }
        }

        if(n > 1) ans.add(n);

        return ans;
    }

    public static ArrayList<Integer> sol2(int n) {
        // This is much optimized but buggy according to gemini

        // Example 35
        /*
         * For 35 ->
         * 
         * 5|35
         * 7|7
         * |1
         * 
         * For 75 ->
         * 
         * it will run only for (int)sqrt(37) == 6
         * 
         */
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 2;
        int orig = n;
        while (n != 1) {
            if (n % i == 0) {
                ans.add(i);
                while (n % i == 0) {
                    n = n / i;
                }
            }
            if (n == 1)
                break;
            if (i == Math.sqrt(n))
                break;
            i++;
        }

        if (ans.size() == 0)
            ans.add(orig);

        return ans;
    }

    public static ArrayList<Integer> optimalSol(int n) {
        ArrayList<Integer> ans = new ArrayList<>();

        // 1. Check for 2 separately (optimization to skip all even numbers later)
        if (n % 2 == 0) {
            ans.add(2);
            while (n % 2 == 0) {
                n /= 2;
            }
        }

        // 2. Iterate only up to sqrt(n), checking odd numbers only
        // Logic: i * i <= n is much safer/faster than Math.sqrt(n)
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                ans.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        // 3. If n > 1, the remaining n is a prime number
        if (n > 1) {
            ans.add(n);
        }

        return ans;
    }
}