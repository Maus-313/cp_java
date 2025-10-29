public class swap {
    public static void main(String[] args) {
        // System.out.println(123123);
        int a = 12;
        int b = 23;

        a = a^b;
        b = a^b;
        a = b^a;

        System.out.println(a);
        System.out.println(b);
    }
}