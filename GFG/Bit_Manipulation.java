public class Bit_Manipulation {
    public static void main(String[] args) {
        bitManipulation(70, 3);
    }

    static void bitManipulation(int num, int k) {
    }

    static void sol1(int num, int k) {
        // code here
        k = k-1;
        System.out.print((num>>k) & 1);
        System.out.print(" ");
        System.out.print((num | 1<<k));
        System.out.print(" ");
        System.out.print((num & ~(1<<k)));
    }
}