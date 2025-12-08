import java.util.HashSet;

public class LC136 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new LC136().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        
    }

    public int sol1(int[] nums) {

        // works but not the best! 12ms;

        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            if(!set.contains(i)) set.add(i);
            else set.remove(i);
        }

        int ans = 0;
        for(int i : set){
            ans = i;
        }

        return ans;
    }

    public int sol2(int[] nums) {
        // 1ms
        int temp = 0;

        for(int i : nums){
            temp = temp^i;
        }

        return temp;
    }
}