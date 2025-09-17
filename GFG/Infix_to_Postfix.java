import java.util.ArrayDeque;

public class Infix_to_Postfix {
    public static void main(String[] args) {
        String input = "a+b*(c^d-e)^(f+g*h)-i";
        // String input = "a+b*c+d";
        // String correct = "abcd^e-fgh*+^*+i-";
        // String correct = "abcd^e-fgh*+^*+i-";
        // System.out.println(infixToPostfix(input));
        System.out.println(highP('+', '-'));
    }

    public static String infixToPostfix(String s) {
        // code here
        ArrayDeque<Character> st = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                while(st.peek() != '(' ){
                    ans.append(st.pop());
                }
                st.pop();
            }else if(c == '('){
                st.push(c);
            }else if(c == '*' || c == '/' || c == '+' || c == '-' || c == '^'){
                if(st.size() == 0){
                    st.push(c);
                }else{
                    while(st.size() != 0 && st.peek() != '(' && !highP(c, st.peek())){
                        ans.append(st.pop());
                    }
                    st.push(c);
                }
            }else{
                ans.append(c);
            }
        }
        
        while(st.size() != 0) ans.append(st.pop());
        
        return ans.toString();
    }

    static boolean highP(char a, char b){
        
        if(a == '^' && b != '^') return true;
        else if(a == '/'){
            if(b == '+' || b == '-' || b =='*') return true;
        }else if(a == '*'){
            if(b == '+' || b == '-') return true;
        }else if(a == '+'){
            if(b == '-') return true;
        }
        
        return false;
    }
}
