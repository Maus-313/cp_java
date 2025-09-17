import java.util.ArrayDeque;
import java.util.Scanner;

public class Postfix_to_Infix_Conversion {
    public static void main(String[] args) {
        String exp = "ab*c+";
        System.out.println(postToInfix(exp));

        // System.out.println("AA" + "BB");
    }

    static String postToInfix(String exp) {
        // code here
        ArrayDeque<String> st = new ArrayDeque<>();
        for(int i = 0; i<exp.length(); i++){
            char c = exp.charAt(i);
            if(st.size() == 0){
                st.push(Character.toString(c));
            }else if(c == '^' || c == '+' || c == '/' || c == '*' || c == '-'){
                String second = st.pop();
                String first = st.pop();

                st.push("(" + first + Character.toString(c) + second + ")");
            }else{
                st.push(Character.toString(c));
            }
        }
        return st.pop();
    }
}