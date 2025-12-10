import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.ArrayBlockingQueue;

public class LC26 {
    public static void main(String[] args) {

        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(new LC26().removeDuplicates(arr));

        for(int i : arr){
            System.out.print(i + " ");
        }
    }

    public int removeDuplicates(int[] nums) {
        
    }

    public int sol1(int[] nums) {
        // 17ms
        ArrayList<Integer> tempArr = new ArrayList<>();

        for(int i : nums){
            if(!tempArr.contains(i)){
                tempArr.add(i);
            }
        }

        int k = tempArr.size();
        for(int i = 0; i<k; i++){
            nums[i] = tempArr.get(i);
        }

        // while(idx )
        
        return k;
    }

    public int sol2(int[] nums) {
        // 2ms
        HashSet<Integer> set = new HashSet<>();

        int idx = 0;
        for(int i : nums){
            if(!set.contains(i)){
                set.add(i);
                nums[idx] = i;
                idx++;
            }
        }
        
        return idx;
    }

    public int sol3(int[] nums) {
        // 1ms
        int last = -101;

        int idx = 0;
        for(int i : nums){
            if(last != i){
                last = i;
                nums[idx] = i;
                idx++;
            }
        }
        
        return idx;
    }

    public int sol4(int[] nums) {
        // 0ms
        int idx = 0;
        int l = nums.length;

        for(int i = 1; i<l; i++){
            if(nums[idx] != nums[i]){
                idx++;
                nums[idx] = nums[i];
            }
        }

        return idx+1;
    }
}