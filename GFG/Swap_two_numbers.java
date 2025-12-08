import java.util.ArrayList;
import java.util.List;

public class Swap_two_numbers {
    public static void main(String[] args) {
        int a = 13, b = 9;
        // List<Integer> ans = get(a, b);

        // for(int i : ans){
        //     System.out.print(i+" ");
        // }

        a = a ^ b;
        b = a ^ b;
        a = b ^ a;

        System.out.println(a + " - " + b);
    }

    static List<Integer> get(int a, int b) {
        // code here
        List<Integer> ans = new ArrayList<>();

        ans.add(b);
        ans.add(a);

        return ans;
    }
}
