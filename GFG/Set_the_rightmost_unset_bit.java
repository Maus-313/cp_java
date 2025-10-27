public class Set_the_rightmost_unset_bit {
    public static void main(String[] args) {
        System.out.println(setBit(15));
    }

    static int setBit(int n) {}

    static int sol1(int n) {
        // code here
        for(int i = 0; i<=n; i++){
            if((n>>i & 1) == 0){
                n = n | 1<<i;
                return n;
            }
        }

        return n;
    }
}
