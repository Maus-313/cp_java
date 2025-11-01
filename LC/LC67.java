import java.util.Arrays;

public class LC67 {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(new LC67().addBinary(a, b));

        // char[] c = new char[4];
        // Arrays.fill(c, '0');
        // c[2] = '1';
        // System.out.println(c[0]);
        // System.out.println(Integer.parseInt(new String(c), 2));
        // System.out.println(a.substring(3));
    }

    public String addBinary(String a, String b) {
        
    }


    public String sol1(String a, String b) {
        // 1ms, but still 0ms exists; programming this took a lot of time, There exists more less time taking but 5ms solutions
        int al = a.length();
        int bl = b.length();
        int l = Math.max(al, bl);
        l++;
        char[] c = new char[l];

        Arrays.fill(c, '0');

        int ai = al-1;
        int bi = bl-1;
        int idx = l-1;
        char carry = '0';
        
        while(ai >= 0 && bi >= 0){
            // System.out.println("Touched");
            char ac = a.charAt(ai);
            char bc = b.charAt(bi);
            if(ac == '1' && bc == '1'){
                if(carry == '1'){
                    c[idx] = '1';
                }else{
                    c[idx] = '0';
                    carry = '1';
                }
            }else if(ac == '1'){
                // System.out.println("Touched");
                if(carry == '1'){
                    // System.out.println("Touched");
                    c[idx] = '0';
                }else{
                    // System.out.println("Touched");
                    c[idx] = '1';
                }
            }else if(bc == '1'){
                if(carry == '1'){
                    c[idx] = '0';
                }else{
                    c[idx] = '1';
                }
            }else if(ac == '0' && bc == '0'){
                if(carry == '1'){
                    c[idx] = '1';
                    carry = '0';
                }else{
                    c[idx] = '0';
                }
            }
            ai--;
            bi--;
            idx--;
        }

        while(ai >= 0){
            // System.out.println("Touched");
            char ac = a.charAt(ai);
            if(ac == '1'){
                if(carry == '1'){
                    c[idx] = '0';
                }else{
                    c[idx] = '1';
                }
            }else if(ac == '0'){
                if(carry == '1'){
                    c[idx] = '1';
                    carry = '0';
                }else{
                    c[idx] = '0';
                }
            }
            ai--;
            idx--;
        }

        while(bi >= 0){
            // System.out.println("Touched");
            char bc = b.charAt(bi);
            if(bc == '1'){
                if(carry == '1'){
                    c[idx] = '0';
                }else{
                    c[idx] = '1';
                }
            }else if(bc == '0'){
                if(carry == '1'){
                    c[idx] = '1';
                    carry = '0';
                }else{
                    c[idx] = '0';
                }
            }
            bi--;
            idx--;
        }

        // for(char i : c){
        //     System.out.print(i + " ");
        // }

        if(carry == '1'){
            // System.out.println("Touched");
            c[0] = '1';
        }
        if(c[0] == '0'){
            // System.out.println("Touched");
            return new String(c).substring(1);
        }
        // System.out.println("Touched");
        return new String(c);
    }

    public String sol2(String a, String b){

    }

}