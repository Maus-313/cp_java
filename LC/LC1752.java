public class LC1752 {
    public static void main(String[] args) {
        System.out.println(new LC1752().check(new int[]{3,4,5,1,2}));
        System.out.println(new LC1752().check(new int[]{2,1,3,4}));
        System.out.println(new LC1752().check(new int[]{1,2,3}));
    }

    public boolean check(int[] nums) {
        
    }

    public boolean check(int[] nums) {
        // 0ms
        int l = nums.length;
        for(int i = 0; i<l-1; i++){
            if(nums[i] > nums[i+1]){
                for(int j = 0; j<l-1; j++){
                    if(nums[(j+i+1)%l] > nums[(j+i+2)%l]) return false;
                }
                return true;
            }
        }
        return true;
    }
}
