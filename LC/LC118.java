import java.util.ArrayList;
import java.util.List;

public class LC118 {
    public static void main(String[] args) {
        int numRows = 1;
        List<List<Integer>> ans = new LC118().generate(numRows);

        for (List<Integer> l : ans) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> generate(int n) {
        
    }


    public List<List<Integer>> sol3(int n) {
        // different simple approach
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            if(ans.size() != 0){
                List<Integer> prev = ans.get(ans.size()-1);
                for(int j = 0; j<prev.size()-1; j++){
                    temp.add(prev.get(j)+prev.get(j+1));
                }
                temp.add(1);
            }
            ans.add(new ArrayList<>(temp));
        }

        return ans;
    }



    public List<List<Integer>> sol2(int n) {

        //
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            int val = 1;
            int num = i - 1;
            int den = 1;

            while (num != 0) {
                temp.add(val);
                val *= num;
                val /= den;
                num--;
                den++;
            }
            temp.add(val);

            ans.add(temp);
        }

        return ans;
    }

    public List<List<Integer>> sol1(int n) {
        // 1ms
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                temp.add((int) ncr2(i - 1, j - 1));
            }
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }

    static long ncr1(int n, int r) {
        // not optimisied as well as overflow prone!
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    static long ncr2(int n, int r) {
        // this is more optimised 1ms
        long val = 1;
        for (int i = 1; i <= r; i++) {
            val *= n;
            val /= i;
            n--;
        }

        return val;
    }

    static long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}