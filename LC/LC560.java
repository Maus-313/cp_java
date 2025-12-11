import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LC560 {
    public static void main(String[] args) {
        System.out.println(new LC560().subarraySum(new int[]{1,1,1}, 2));
        System.out.println(new LC560().subarraySum(new int[]{1,2,3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        
    }

    public int sol3(int[] nums, int k) {
        // 25ms sussy approach
        // ArrayList<Integer> temp = new ArrayList<>();
        HashMap<Integer, Integer> temp = new HashMap<>();
        int c = 0;
        if(nums[0] == k)c++;
        temp.put(nums[0], 1);

        for(int i = 1; i<nums.length; i++){
            nums[i] += nums[i-1];
            if(nums[i] == k) c++;
            
            if(temp.containsKey(nums[i] - k)){
                c += temp.get(nums[i] - k);
            }
            
            if(!temp.containsKey(nums[i])){
                temp.put(nums[i], 1);
            }else{
                temp.put(nums[i], temp.get(nums[i])+1);
            } 
        }
        return c;
    }

    public int sol1(int[] arr, int k) {
        // 1571ms brute force

        int max = 0;
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = i; j < l; j++) {
                sum += arr[j];
                if(sum == k) max++;
            }
        }
        return max;
    }

    public int sol2(int[] arr, int k) {
        // 22ms best solution
        int count = 0;

        // 
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0, 1);

        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            int diff = sum - k;
            if(map.containsKey(diff)){
                count += map.get(diff);
            }
            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum, 1);
            }
        }

        return count;
    }
}