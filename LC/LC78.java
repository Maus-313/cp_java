import java.util.*;

public class LC78{
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        List<List<Integer>> ans = new LC78().subsets(arr);

        // System.out.println(ans.size());
        for(List<Integer> ii: ans){
            for(int i : ii){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        // 0 0 0
        // 0 0 1
        // 0 1 0
        // for(int i = 0; i<10; i++){
        //     int n = i;
        //     int k = 0;
        //     while(n != 0){
        //         if((n >> k & 1) == 1){
        //             System.out.print(k + " ");
        //         }
        //         k++;
        //         n = n>>1;
        //     }
        //     System.out.println();
        // }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        help(ans, nums, 0, new ArrayList<>());

        return ans;
    }

    static void help(List<List<Integer>> ans, int[] arr, int idx, List<Integer> temp){

        if(idx >= arr.length) return;

        ans.add(new ArrayList<>(temp));
        temp.add(arr[idx]);
        help(ans, arr, idx+1, temp);
        temp.remove(temp.size()-1);
        
    }
}