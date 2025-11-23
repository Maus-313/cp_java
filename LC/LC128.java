import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class LC128 {
    public static void main(String[] args) {
        int[] arr = { 100, 4, 200, 1, 3, 2 };

        System.out.println(new LC128().longestConsecutive(arr));
    }

    public int longestConsecutive(int[] arr) {
        // 30ms
        if(arr.length == 0) return 0;
        
        int max = 1;

        HashSet<Integer> set = new HashSet<>();

        for(int i : arr){
            set.add(i);
        }

        for(int i : set){
            if(set.contains(i-1)) continue;
            int count = 1;
            while(set.size() != 0 && set.contains(i+1)){
                set.remove(i);
                count++;
                i++;
            }

            max = Math.max(count, max);
        }

        return max;
    }

    public int sol1(int[] arr) {
        // 25ms brute force
        Arrays.sort(arr);

        int max = 1;
        int temp = 1;
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] - arr[i+1] == -1){
                temp++;
            }else{
                max = Math.max(max, temp);
                temp = 1;
            }
        }

        return max;
    }

}