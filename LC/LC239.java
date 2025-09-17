import java.util.ArrayDeque;

public class LC239 {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int  k = 3;
        int[] ans = new LC239().maxSlidingWindow(nums, k);
        for(int i : ans){
            System.out.print(i +" ");
        }
        System.out.println();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        // index, value
        ArrayDeque<int[]> st = new ArrayDeque<>();
        int temp = k;
        for(int i = 0; i<nums.length; i++){
            if(temp != 0){

                if(st.size() == 0){
                    st.push(new int[]{i, nums[i]});
                }else{
                    while(st.size() != 0 && st.peek()[1] < nums[i]) st.pop();
                    st.push(new int[]{i, nums[i]});
                }
                temp--;
                // System.out.println("called");
            }else{
                
                ans[idx] = st.getLast()[1];
                idx++;

                // removing last if it is out of the window
                if(st.getLast()[0] == i-k) st.removeLast();


                while(st.size() != 0 && st.peek()[1] < nums[i]) st.pop();

                st.push(new int[]{i, nums[i]});
            }
        }

        ans[idx] = st.getLast()[1];

        return ans;
    }
}
