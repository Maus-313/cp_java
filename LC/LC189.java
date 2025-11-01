public class LC189 {
    public static void main(String[] args) {

        int[] nums = {-1,-100,3,99};
        int k = 2;

        new LC189().rotate(nums, k);

        for(int i : nums){
            System.out.print(i+" ");
        }
    }

    public void rotate(int[] nums, int k) {
        
    }

    public void sol1(int[] nums, int k) {
        // 2ms but not space optimised!
        int l = nums.length;
        k = k%l;
        if(k == l || l == 1) return;
        int[] clone = nums.clone();

        for(int i = 0; i<l; i++){
            int idx = ((l-k)+i)%l;
            nums[i] = clone[idx];
        }
    }

    public void sol2(int[] nums, int k) {
        // accidentaly did 1ms with not best space optimization
        int l = nums.length;
        k = k%l;
        if(k == 0 || l == 1) return;
        int[] temp = new int[k];

        for(int i = 0; i<k; i++){
            temp[i] = nums[l-k+i];
        }

        // for(int i : temp){
        //     System.out.print(i + " ");
        // }
        
        for(int i = l-k-1; i>=0; i--){
            nums[i+k] = nums[i];
        }


        for(int i = 0; i<k; i++){
            nums[i] = temp[i];
        }
    }

    public void sol3(int[] nums, int k){

    }
}