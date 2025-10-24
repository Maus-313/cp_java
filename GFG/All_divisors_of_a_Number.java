import java.util.ArrayList;
import java.util.Collections;

public class All_divisors_of_a_Number {
    public static void main(String[] args) {
        // 1, 2, 3
        int n = 34;
        print_divisors(n);
        System.out.println((int)Math.sqrt(34));
    }

    public static void print_divisors(int n){
        for(int i = 1; i<=n; i++){
            if(n%i == 0){
                System.out.print(i + " ");
            }
        }
    }

    public static void sol1(int n) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 1; i*i<=n; i++){
            if(n%i == 0){
                System.out.print(i+" ");
                if(n/i != i) temp.add(n/i);
            }
        }

        Collections.sort(temp);

        for(int i : temp){
            System.out.print(i+" ");
        }
    }
}
