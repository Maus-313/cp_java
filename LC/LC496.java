import java.util.ArrayDeque;
import java.util.HashMap;

public class LC496 {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        LC496 solution = new LC496();
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.println(java.util.Arrays.toString(result));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2){

        

    }

    public int[] sol1(int[] nums1, int[] nums2) {
            int l = nums2.length;
            int[] ans = new int[nums1.length];
            // int[] nge = new int[l];
            HashMap<Integer, Integer> nge = new HashMap<>();

            ArrayDeque<Integer> st = new ArrayDeque<>();

            for(int i = l-1; i>=0; i--){
                int n = nums2[i];
                if(st.size() == 0){
                    // nge[i] = -1;
                    nge.put(n, -1);
                    st.push(n);
                }else{
                    while(st.size() != 0 && st.peek() <= n){
                        st.pop();
                    }
                    if(st.size() != 0){
                        // nge[i] = st.peek();
                        nge.put(n, st.peek());
                        st.push(n);
                    }else{
                        st.push(n);
                        nge.put(n, -1);
                    }
                }
            }

            for(int i = 0; i<nums1.length; i++){
                ans[i] = nge.get(nums1[i]);
            }

            return ans;
    }
}