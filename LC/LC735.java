import java.util.ArrayDeque;
import java.util.ArrayList;

public class LC735 {
    public static void main(String[] args) {
        LC735 solution = new LC735();
        int[] result1 = solution.asteroidCollision(new int[]{11, 23, 1});
        System.out.println(java.util.Arrays.toString(result1)); // Output: [5, 10]
    }

    public int[] asteroidCollision(int[] asteroids) {
        
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayDeque<Integer> st = new ArrayDeque<>();
        
        for(int i : asteroids){
            if(i<0 && (st.size() == 0)){
                arr.add(i);
            }else if(i > 0 || (i < 0 &&  st.peek() < 0)){
                st.push(i);
            }else if(i < 0 && st.size() != 0){
                i *= -1;
                while(st.size() != 0 && st.peek() < i) st.pop();

                if(st.size() == 0){
                    arr.add(i);
                }else{
                    if(st.peek() < 0){
                        st.push(-1*i);
                    }else if(st.peek() == i){
                        st.pop();
                    }else if(st.peek() > i){
                        
                    }
                }
            }
        }

        while(st.size() != 0){
            arr.add(st.getLast());
            st.removeLast();
        }

        int[] ans = new int[arr.size()];

        for(int i = 0; i<arr.size(); i++){
            ans[i] = arr.get(i);
        }

        return ans;
    }
}
