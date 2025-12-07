public class Toggle_bits_in_the_given_range {
    public static void main(String[] args) {
        System.out.println(toggleBits(50, 2, 5));
        System.out.println();
    }

    static int toggleBits(int n, int l, int r) {
        
    }

    static int sol1(int n, int l, int r) {

        l = l-1;
        r = r-1;

        for(int i = l; i<=r; i++){
            if((n>>i & 1) == 1){
                //clear ith bit
                n = n & (~(1<<i));
            }else{
                //set ith bit
                n = n | (1<<i);
            }
            // System.out.println(Integer.toBinaryString(n));
        }

        return (n);
        // return 2;
    }


}
