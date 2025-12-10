import java.util.Arrays;

public class LC283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new LC283().moveZeroes(nums);
        for(int i : nums){
            System.out.print(i+" ");
        }
    }

    public void moveZeroes(int[] nums) {

    }

    public void sol4(int[] nums) {
        // 1ms
        int idx = 0;
        int l = nums.length;
        while(idx < l && nums[idx] != 0){
            idx++;
        }

        for(int i = idx+1; i<l; i++){
            if(nums[i] != 0){
                nums[idx] = nums[i];
                idx++;
            }
        }

        while(idx < l){
            nums[idx] = 0;
            idx++;
        }
    }

    public void sol1(int[] nums) {
        int zeros = 0;
        int non = 0;
        int l = nums.length;

        while(non < l && zeros < l){
            if(nums[zeros] == 0){
                while(non < l && nums[non] == 0){
                    non++;
                }
                if(non >= l) return;
                nums[zeros] = nums[non];
                nums[non] = 0;
                zeros++;
            }else{
                while(zeros < l && nums[zeros] != 0) zeros++;
                non = zeros+1;
            }
        }
    }

    public void sol2ms(int[] nums) {
        // 2ms
        int[] clone = nums.clone();
        int l = nums.length;
        int idx = 0;
        int count = 0;

        for(int i = 0; i<l; i++){
            if(clone[i] != 0){
                nums[idx] = clone[i];
                idx++;
            }else{
                count++;
            }
        }

        idx = l - 1;

        while(count != 0){
            nums[idx] = 0;
            idx--;
            count--;
        }
    }

    public void sol3ms(int[] nums){
        int[] clone = nums.clone();
        Arrays.fill(nums, 0);
        int l = nums.length;
        int idx = 0;
        int count = 0;

        for(int i = 0; i<l; i++){
            if(clone[i] != 0){
                nums[idx] = clone[i];
                idx++;
            }else{
                count++;
            }
        }
    }
}