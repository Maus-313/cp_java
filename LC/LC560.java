import java.util.HashMap;

public class LC560 {
    public static void main(String[] args) {
        int[] arr = {1,1,1};
        int k = 2;
        System.out.println(new LC560().subarraySum(arr, k));
    }

    public int subarraySum(int[] arr, int k) {

        int count = 0;

        return count;
    }

    public int sol2(int[] arr, int k) {
        // optimised 
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            if(sum == k){
                count++;
            }else if(map.containsKey(sum - k)){
                count++;
            }
        }

        return count;
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
}
