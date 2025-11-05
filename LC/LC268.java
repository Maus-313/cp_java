public class LC268 {
    public static void main(String[] args) {
        System.out.println(new LC268().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }

    public int missingNumber(int[] nums) {

        // 0ms XOR
        int a = 0;
        int idx = 0;

        for(int i : nums){
            a = a^idx;
            a = a^i;
            idx++;
        }

        a = a^idx;

        return a;
    }

    public int sol1(int[] nums) {
        // 0ms 
        int total = 0;
        int temp = 0;
        int idx = 0;

        for(int i : nums){
            temp += i;
            total += idx;
            idx++;
        }

        total += idx;

        return total - temp;
        
    }

    public int sol1(int[] nums) {
        
        
    }
}
