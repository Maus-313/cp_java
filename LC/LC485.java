public class LC485 {
    public static void main(String[] args) {
        System.out.println(new LC485().findMaxConsecutiveOnes(new int[] {0}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int i = 0;
        int sum = 0;
        int max = 0;
        int l = nums.length;

        while(i<l){

            if(nums[i] == 0){
                max = Math.max(max, sum);
                sum = 0;
            }else{
                sum += 1;
            }

            i++;
        }

        max = Math.max(max, sum);

        return max;
    }

    public int sol1(int[] nums) {
        // 2ms
        int i = 0;
        int sum = 0;
        int max = 0;
        int l = nums.length;

        while(i<l){

            if(nums[i] == 0){
                max = Math.max(max, sum);
                sum = 0;
            }else{
                sum += 1;
            }

            i++;
        }

        max = Math.max(max, sum);

        return max;

    }
}
