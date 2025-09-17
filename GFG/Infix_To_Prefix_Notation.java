import java.util.ArrayDeque;

public class Infix_To_Prefix_Notation {
    public static void main(String[] args) {
        Infix_To_Prefix_Notation obj = new Infix_To_Prefix_Notation();
        String infix = "a*b+c/d";
        String prefix = obj.infixToPrefix(infix);
        System.out.println("\nPrefix: " + prefix);
    }
    public String infixToPrefix(String s) {
        
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> st  = new ArrayDeque<>();
        int l = s.length();
        for(int i = l-1; i >= 0; i--){
            char c = s.charAt(i);
            if(c == ')'){
                st.push(c);
            }else if(c == '('){
                while(st.peek() != ')'){
                    sb.append(st.pop());
                }
                st.pop();
            }else if(c == '^' || c == '/' || c == '*' || c == '+' || c == '-'){
                if(c == '^'){
                    st.push(c);
                }else if(c == '/' || c == '*'){
                    while(st.size() != 0 && st.peek() == '^'){
                        sb.append(st.pop());
                    }
                    st.push(c);
                }else if(c == '+' || c == '-'){
                    while(st.size() != 0 && (st.peek() == '*' || st.peek() == '/' || st.peek() == '^')){
                        sb.append(st.pop());
                    }
                    st.push(c);
                }
            }else{
                sb.append(c);
            }
        }

        while(st.size() != 0) sb.append(st.pop());

        return sb.reverse().toString();
    }
}