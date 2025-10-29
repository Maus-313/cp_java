import java.util.Arrays;
import java.util.HashSet;

public class LC137 {
    public static void main(String[] args) {        
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(new LC137().singleNumber(nums));
        // System.out.println(1 << 31);
    }

    public int singleNumber(int[] nums) {
        
    }

    public int sol1(int[] nums) {
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

    public int sol2(int[] nums) {
        // 4ms, still some possiblities are there!
        Arrays.sort(nums);
        // 0 0 0 1 1 1 99
        for(int i = 0; i<nums.length-1; i+= 3){
            if(nums[i] != nums[i+1]) return nums[i];
        }

        return nums[nums.length-1];
    }

    public int sol3(int[] nums) {
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