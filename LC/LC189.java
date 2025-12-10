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

    public void sol3(int[] nums, int k) {3,0,1]
        // best possible sol
        int n = nums.length;
        k %= n; 
        
        // 1. Reverse the whole array
        reverse(nums, 0, n - 1);
        // 2. Reverse the first k elements
        reverse(nums, 0, k - 1);
        // 3. Reverse the rest
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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
}