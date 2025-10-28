public class LC9 {
    public static void main(String[] args) {
        System.out.println(new LC9().isPalindrome(Integer.MAX_VALUE));
    }


    public boolean isPalindrome(int x) {

    }


    public boolean sol1(int x) {
        // Not optimised!
        String str = Integer.toString(x);
        int l = str.length();
        for(int i = 0; i<l; i++){
            if(str.charAt(i) != str.charAt(l-i-1)) return false;
        }

        return true;
    }
}
