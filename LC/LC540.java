public class LC540 {
    public static void main(String[] args) {
        System.out.println(new LC540().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    public int singleNonDuplicate(int[] nums) {
        
    }

    public int sol2(int[] nums) {
        // 0ms
        int l = nums.length;
        if(l == 0) return -1;
        if(l == 1) return nums[0];

        if(nums[l-1] != nums[l-2]) return nums[l-1];

        for(int i = 0; i<l-1; i+= 2){
            if(nums[i] != nums[i+1]) return nums[i];
        }

        return -1;
    }

    public int sol1(int[] nums) {
        // 1ms
        int x = 0;
        for(int i : nums){
            x ^= i;
        }

        return x;
    }
}