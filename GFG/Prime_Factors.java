import java.util.ArrayList;

public class Prime_Factors {
    public static void main(String[] args) {
        ArrayList<Integer> ans = primeFac(35);
        for(int i  : ans){
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> primeFac(int n) {
        // code here
        // Take out the factors, then check for the prime
        ArrayList<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(-1);
            return ans;
        }else if(n == 2){
            ans.add(2);
            return ans;
        }else if(n == 3){
            ans.add(3);
            return ans;
        }
        
        for(int i = 1; i<)

        return ans;
    }
}