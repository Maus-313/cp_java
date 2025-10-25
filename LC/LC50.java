public class LC50 {
    public static void main(String[] args) {
        double x = -1.00000;
        // int n = -2;
        int n = Integer.MIN_VALUE;
        // System.out.println(Integer.MIN_VALUE);
        // System.out.println(-1*n);
        System.out.println(new LC50().myPow(x,n));
    }

    public double myPow(double x, int n) {}

    static double sol1(double x, int n){

        if(n == 1) return x;
        if(x == 1 || n == 0) return 1;
        if(x == 0) return 0;

        if(n < 0){
            if(n == Integer.MIN_VALUE) return (Math.abs(x) != 1)? 0:1;
            n = -1*n;
            x = 1/x;
            // 2^4 == 4^2 == 16^1
            return sol1(x, n);
        }else{
            if(x<0){
                x = -1*x;

                if(n%2 == 0){
                    return sol1(x, n);
                }else{
                    return -1*sol1(x, n);
                }
            }else{
                if(n%2 == 0){
                    return sol1(x*x, n/2);
                }else{
                    return x*sol1(x, n-1);
                }
            }
        }
    }
}