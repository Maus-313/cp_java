
public class LC231 {
    public static void main(String[] args) {
        // System.out.println(new LC231().isPowerOfTwo(Integer.MIN_VALUE));
        System.out.println((1 << 31));
        System.out.println((1 << 31) - 1);
    }

    public boolean sol1(int n) {
        // 1ms
        int count = 0;

        // if(n == 0 || n == 1) return true;

        while(n != 0){
            if((n & 1) == 1) count++;
            if(count > 1) return false;
            n = n>>1;
        }
        if(count == 1) return true;
        return false;
    }

    public boolean isPowerOfTwo(int n) {
        // 0 ms
        if(n <= 0) return false;
        return (((n)&(n-1)) == 0);
    }
}