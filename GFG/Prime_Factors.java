import java.util.ArrayList;
import java.util.Collections;

public class Prime_Factors {
    public static void main(String[] args) {
        ArrayList<Integer> ans = primeFac(71);
        for(int i  : ans){
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> primeFac(int n) {}

    public static ArrayList<Integer> sol1(int n) {
        // This is not optimized for Large Prime numbers
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 2;
        while(n != 1){
            if(n%i == 0){
                ans.add(i);
                while(n%i == 0){
                    n = n/i;
                }
            }
            if(n == 1) break;
            i++;
        }

        return ans;
    }

    public static ArrayList<Integer> sol2(int n) {
        // This is much optimized
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 2;
        int orig = n;
        while(n != 1){
            if(n%i == 0){
                ans.add(i);
                while(n%i == 0){
                    n = n/i;
                }
            }
            if(n == 1) break;
            if(i == Math.sqrt(n)) break;
            i++;
        }

        if(ans.size() == 0) ans.add(orig);

        return ans;
    }
}