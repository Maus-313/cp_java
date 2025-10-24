import java.util.ArrayList;

public class Sieve_of_Eratosthenes {
    public static void main(String[] args) {
        int[] arr = new Sieve_of_Eratosthenes().sieve(3);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    public int[] sieve(int n) {
        // code here
    }

    public int[] sol1(int n) {
        // code here

        // true = not prime, false = prime
        boolean[] p = new boolean[n+1];
        // int count = n+1;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 2; i*i<=n; i++){
            if(!p[i]){
                temp.add(i);
                for(int j = i; j<=n; j+=i){
                    p[j] = true;
                }
            }
        }

        for(int i = (int) Math.sqrt(n); i<=n; i++){
            if(!p[i] && i>=2) temp.add(i);
        }

        int[] ans = new int[temp.size()];

        for(int i = 0; i<temp.size(); i++){
            ans[i] = temp.get(i);
        }

        return ans;
    }
}
