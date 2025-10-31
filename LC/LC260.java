import java.util.HashSet;

public class LC260 {
    
    public static void main(String[] args) {
        int[] nums = {-1, 2147483647};
        // int[] nums = {-1, 2147483647, -2, -2, -2, -2};
        // int[] nums = {-1, -1, -12, -2, -2, -23};
        // int[] ans = new LC260().singleNumber(nums);

        // for(int i : ans){
        //     System.out.print(i+" ");
        // }

        // System.out.println(Long.toBinaryString(-1));
        // System.out.println(Long.toBinaryString(Integer.MAX_VALUE));
        // System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }

    public int[] singleNumber(int[] nums) {

    }

    public int[] sol1(int[] nums) {
        // 4ms
        int[] ans = new int[2];
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums){
            if(set.contains(i)) set.remove(i);
            else set.add(i);
        }

        int idx = 0;
        for(int i : set){
            ans[idx] = i;
            idx++;
        }

        return ans;
    }


    public int[] sol2(int[] nums) {
        // 1ms
        long xor = 0;
        for(int i : nums){
            xor = xor^i;
        }

        long n = (xor & xor-1)^xor;

        System.out.println(n);
        long b1 = 0;
        long b2 = 0;

        for(int i : nums){
            if(((long) i & n) > 0){
                b1 = b1^i;
            }else{
                b2 = b2^i;
            }
        }

        int[] ans = new int[2];
        ans[0] = (int) b1;
        ans[1] = (int) b2;

        return ans;
    }


}