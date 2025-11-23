import java.util.HashMap;

public class LC169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new LC169().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        // 1ms M0oe Moe algo
        int n = nums.length;
        
        int ans = 0;

        int c = 0;

        for(int i : nums){
            if(c == 0){
                c = 1;
                ans = i;
            }else if(i == ans){
                c++;
            }else{
                c--;
            }
        }

        return ans;
    }

    public int sol1(int[] nums) {
        // 15ms
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else{
                map.put(i, 1);
            }
        }

        for(int i : map.keySet()){
            if(map.get(i) > n/2) return i;
        }

        return -1;
    }
}