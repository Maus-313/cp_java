import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC229 {
    public static void main(String[] args) {
        int[] nums = {2,2};

        for(int i : new LC229().majorityElement(nums)){
            System.out.print(i+" ");
        }
    }

    public List<Integer> majorityElement(int[] nums) {
        
    }

    public List<Integer> sol3(int[] nums) {
        // 2ms
        int c1 = 0, c2 = 0, e1 = 0, e2 = 0;

        for(int i : nums){
            if(c1 == 0 && e2 != i){
                e1 = i;
                c1 = 1;
            }else if(c2 == 0 && e1 != i){
                e2 = i;
                c2 = 1;
            }else if(e1 == i) c1++;
            else if(e2 == i) c2++;
            else{
                c1--;
                c2--;
            }
        }
        
        List<Integer> ans = new ArrayList<>();

        c1 = 0;
        c2 = 0;

        for(int i : nums){
            if(e1 == i) c1++;
            if(e2 == i) c2++;
        }

        int n = nums.length/3 + 1;

        if(c1 >= n) ans.add(e1);
        if(c2 >= n && e2 != e1) ans.add(e2);

        return ans;

    }

    public List<Integer> sol2(int[] nums) {
        // 19 ms
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        if(n == 1){
            ans.add(nums[0]);
            return ans;
        }else if(n == 2){
            ans.add(nums[0]);
            if(!ans.contains(nums[1])) ans.add(nums[1]);
            return ans;
        }

        for(int i : nums){
            if(ans.contains(i)) continue;
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
                if(map.get(i) > n/3) ans.add(i);
            }else{
                map.put(i, 1);
            }
        }

        return ans;
    }

    public List<Integer> sol1(int[] nums) {
        // 16ms
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int i : map.keySet()){
            if(map.get(i) > n/3) ans.add(i);
        }

        return ans;
    }
}
