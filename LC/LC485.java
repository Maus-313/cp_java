public class LC485 {
    public static void main(String[] args) {
        System.out.println(new LC485().findMaxConsecutiveOnes(new int[] {1,1,0,1,1,1}));
        System.out.println(new LC485().findMaxConsecutiveOnes(new int[] {1,0,1,1,0,1}));
    }

    public int findMaxConsecutiveOnes(int[] nums) {

    }

    public int sol2(int[] nums) {
        // 1ms
        int c = 0;
        int max = 0;
        int l = nums.length;
        for(int i = 0; i<l; i++){
            if(nums[i] == 0){
                max = Math.max(max, c);
                c = 0;
            }else{
                c++;
            }
        }

        max = Math.max(max, c);

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