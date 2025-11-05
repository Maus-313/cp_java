public class LC540 {
    public static void main(String[] args) {
        System.out.println(new LC540().singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
    }

    public int singleNonDuplicate(int[] nums) {
        int x = 0;
        
        for(int i : nums){
            x ^= i;
        }

        return x;
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