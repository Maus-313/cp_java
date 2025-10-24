import java.util.ArrayList;
import java.util.Collections;

public class All_divisors_of_a_Number {
    public static void main(String[] args) {
        // 1, 2, 3
        int n = 2;
        print_divisors(n);
        // System.out.println((int)Math.sqrt(n));
    }

    public static void print_divisors(int n){
        
    }

    public static void sol1(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i*i<=n; i++){
            if(n%i == 0){
                ans.add(i);
                if(n/i != i) ans.add(n/i);
            }
        }
        Collections.sort(ans);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}
