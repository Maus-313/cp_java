public class LC191 {
    public static void main(String[] args) {
        System.out.println(new LC191().hammingWeight(Integer.MAX_VALUE));
    }

    public int hammingWeight(int n) {
        
    }

    public int sol1(int n) {
        // 0ms
        int count = 0;

        while(n != 0){
            if((n & 1)== 1) count++;
            n = n>>1 ;
        }

        return count;
    }

    public int sol2(int n) {
        // best solution 0ms
        if(n == 1) return 1;
        int count = 0;

        while(n!= 0){
            if(n-1 > 0) count++;
            n = n&(n-1);
        }

        return count;
    }
    
    public int sol3(int n) {
        int c = 0;
        while(n != 0){
            if(n - 1 > 0) c++;
            n = n & (n-1);
        }
        return c;
    }
}
