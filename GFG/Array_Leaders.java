import java.util.ArrayDeque;
import java.util.ArrayList;

public class Array_Leaders {
    public static void main(String[] args) {
        // int[] arr = {16, 17, 4, 3, 5, 2};
        int[] arr = {10, 4, 2, 4, 1};
        
        for(int i : leaders(arr)){
            System.out.print(i+" ");
        }
    }

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayDeque<Integer> st = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int j = arr.length-1; j>=0; j--){
            int i = arr[j];
            if(st.size() == 0){
                st.add(i);
                ans.addFirst(i);
            }else{
                while(st.size() != 0 && st.peek() <= i) st.pop();

                if(st.size() == 0){
                    st.add(i);
                    ans.addFirst(i);
                }
            }
        }

        return ans;
    }
}
