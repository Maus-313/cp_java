public class LC283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new LC283().moveZeroes(nums);
        for(int i : nums){
            System.out.print(i+" ");
        }
    }

    public void moveZeroes(int[] nums) {
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

    public void sol1(int[] nums) {
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
}
