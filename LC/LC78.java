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
    }

    public List<List<Integer>> subsets(int[] nums) {

    }

    public List<List<Integer>> sol1(int[] nums) {
        // PowerSet best solution possible, but recursion is also good, so take a look below
        List<List<Integer>> ans = new ArrayList<>();

        int s = nums.length;
        int l = 1 << nums.length;

        for(int i = 0; i<l; i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j<s; j++){
                if(( i>>j & 1) == 1) temp.add(nums[j]);
            }
            ans.add(temp);
        }

        return ans;
    }


    public List<List<Integer>> sol2(int[] nums) {

        // Rec solution
        List<List<Integer>> ans = new ArrayList<>();
        
        help(ans, nums, 0, new ArrayList<>());

        return ans;
    }


    static void help(List<List<Integer>> ans, int[] arr, int idx, List<Integer> temp){

        ans.add(new ArrayList<>(temp));

        for(int i = idx; i<arr.length; i++){
            temp.add(arr[i]);
            help(ans, arr, i+1, temp);
            temp.remove(temp.size()-1);
        }
        
    }
}