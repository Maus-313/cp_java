
public class Longest_Subarray_with_Sum_K {
    public static void main(String[] args) {

        System.out.println(new Longest_Subarray_with_Sum_K().longestSubarray(new int[]{10, 5, 2, 7, 1, -10}, 15));
        System.out.println(new Longest_Subarray_with_Sum_K().longestSubarray(new int[]{-5, 8, -14, 2, 4, 12}, -5));
        System.out.println(new Longest_Subarray_with_Sum_K().longestSubarray(new int[]{10, -10, 20, 30}, 5));
    }

    public int longestSubarray(int[] arr, int k) {
        // code here
        int max = 0;
        int l = arr.length;
        
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = i; j < l; j++) {
                sum += arr[j];
                if(sum == k) max = Math.max(max, j-i+1);
            }
        }

        return max;
    }

    public int sol1(int[] arr, int k) {
        // code here
        int max = 0;
        int l = arr.length;
        
        for (int i = 0; i < l; i++) {
            int sum = 0;
            for (int j = i; j < l; j++) {
                sum += arr[j];
                if(sum == k) max = Math.max(max, j-i+1);
            }
        }

        return max;
    }
}