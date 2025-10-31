import java.util.ArrayDeque;
import java.util.HashMap;

public class LC503 {
    public static void main(String[] args) {
        int[] arr = {100,1,11,1,120,111,123,1,-1,-100};
        for(int i : new LC503().nextGreaterElements(arr)){
            System.out.print(i+" ");
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int l = nums.length;
        // int[] ans = new int[nums.length];
            int[] nge = new int[l];
        // HashMap<Integer, Integer> nge = new HashMap<>();

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for(int j = 2*l-1; j>=0; j--){
            int i = j%l;
            int n = nums[i];
            if(st.size() == 0){
                nge[i] = -1;
                // nge.put(n, -1);
                st.push(n);
            }else{
                while(st.size() != 0 && st.peek() < n){
                    st.pop();
                }
                if(st.size() != 0){
                    nge[i] = st.peek();
                    // nge.put(n, st.peek());
                    st.push(n);
                }else{
                    st.push(n);
                    nge[i] = -1;
                    // nge.put(n, -1);
                }
            }
        }

        // for(int i = 0; i<nums.length; i++){
        //     ans[i] = nge.get(nums[i]);
        // }

        return nge;
    }
}
