import java.util.ArrayDeque;

public class LC901 {
    public static void main(String[] args) {
        
    }
}

class StockSpanner {

    // value and index
    static ArrayDeque<int[]> st;
    static int idx;

    public StockSpanner() {
        st = new ArrayDeque<>();
        idx = 0;
    }
    
    public int next(int price) {

        if(idx == 0){
            st.push(new int[]{price, idx});
            idx++;
            return 1;
        }

        while(st.size() != 0 && st.peek()[0] < price) st.pop();

        if(st.size() == 0){
            st.push(new int[] {price, idx});
            int temp = idx+1;
            idx++;
            return temp;
        }else{
            int temp = idx - st.peek()[1];
            st.push(new int[] {price, idx});
            idx++;
            return temp;
        }
    }
}