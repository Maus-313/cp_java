import java.util.ArrayDeque;
import java.util.Scanner;

public class LC402 {
    public static void main(String[] args) {
        
        // Scanner sc = new Scanner(System.in);

        // String num = sc.nextLine();
        // // sc.nextLine(); 
        // int k = sc.nextInt() ;
        // System.out.println(num + " - > " +  k);

        String num = "9";
        int k = 1;
        
        System.out.println(new LC402().removeKdigits(num, k));
        // sc.close();
    }

    public String removeKdigits(String num, int k) {
        int l = num.length();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i<l; i++){
            int n = num.charAt(i) - '0';
            if(st.isEmpty()){
                st.push(n);
            }else{
                while(st.size() != 0 && k > 0 && st.peek() > n){
                    st.pop();
                    k--;
                }
                st.push(n);
            }
        }
        
        while( st.size() != 0 && k > 0){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(st.size() != 0){
            
            if(sb.length() == 0 && st.getLast() == 0){
                st.removeLast();
                continue;
            }

            sb.append(st.getLast());
            st.removeLast();
        }

        if(sb.length() == 0) sb.append(0);

        return sb.toString();
    }
}