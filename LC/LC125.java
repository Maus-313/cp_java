public class LC125 {
    public static void main(String[] args) {
        // System.out.println('a' - 0);
        String s = "0P";
        // String s = " ";
        // System.out.println(s.toLowerCase());
        System.out.println(new LC125().isPalindrome(s.toLowerCase()));
    }

    public boolean isPalindrome(String s) {}

    public boolean sol1(String s) {
        // 2ms, but not optimised as 1ms
        s = s.toLowerCase();
        int l = 0;
        int r = s.length()-1;


        while(l < r){

            while( l < r && ((s.charAt(l) < 'a' || s.charAt(l) > 'z') && (s.charAt(l) < '0' || s.charAt(l) > '9'))) l++;
            while( l < r && ((s.charAt(r) < 'a' || s.charAt(r) > 'z') && (s.charAt(r) < '0' || s.charAt(r) > '9'))) r--;
            char c1 = s.charAt(l);
            char c2 = s.charAt(r);

            if(c1 != c2) return false;
            l++;
            r--;
        }

        return true;
    }
}
