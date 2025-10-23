public class All_divisors_of_a_Number {
    public static void main(String[] args) {
        int n = 20;
        print_divisors(n);
    }

    public static void print_divisors(int n) {
        // code here
        for(int i = 1; i<=n; i++){
            if(n%i == 0) System.out.println(i+" ");
        }
    }
}
