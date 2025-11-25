import java.util.HashMap;
import java.util.HashSet;

public class LC560 {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 2;
        System.out.println(new LC560().subarraySum(arr, k));
    }

    public int subarraySum(int[] arr, int k) {
        
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