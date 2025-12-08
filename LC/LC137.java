import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC137 {
    public static void main(String[] args) {        
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(new LC137().singleNumber(nums));
        // System.out.println(1 << 31);
    }

    public int singleNumber(int[] nums) {
        
    }


    public int s_1ms(int[] nums) {
        
        int ans = 0;
        int temp = 0;

        for(int i: nums){
            ans = (ans ^ i) & ~temp;
            temp = (temp ^ i) & ~ans;
        }
        
        return ans;
    }

    public int s_6ms(int[] nums) {
        // 6ms
        HashSet<Integer> not = new HashSet<>();
        HashSet<Integer> ans = new HashSet<>();

        for(int i : nums){
            if(not.contains(i)) continue;
            if(ans.contains(i)){
                ans.remove(i);
                not.add(i);
            }else{
                ans.add(i);
            }
        }

        for(int i : ans) return i;

        return -1;
    }

    public int s_7ms(int[] nums) {
        // 7ms
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        for(int i : map.keySet()){
            if(map.get(i) == 1) return i;
        }

        return -1;
    }

    public int s_5ms(int[] nums) {
        // 5ms
        HashSet<Integer> mem = new HashSet<>();
        HashSet<Integer> temp = new HashSet<>();

        for(int i : nums){
            if(!temp.contains(i)){
                if(!mem.contains(i)){
                    temp.add(i);
                    mem.add(i);
                }
            }else{
                temp.remove(i);
            }
        }

        int ans = 0;
        for(int i : temp){
            ans = i;
        }

        return ans;
        
    }

    public int s_4ms(int[] nums) {
        // 4ms, still some possiblities are there!
        Arrays.sort(nums);
        // 0 0 0 1 1 1 99
        for(int i = 0; i<nums.length-1; i+= 3){
            if(nums[i] != nums[i+1]) return nums[i];
        }

        return nums[nums.length-1];
    }

    public int s_0ms(int[] nums) {
        // 0ms
        int o = 0;
        int t = 0;

        for(int i =0; i<nums.length; i++){
            o = (o^nums[i]) & ~t;
            t = (t^nums[i]) & ~o;
        }

        return o;
    }
}