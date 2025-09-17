import java.util.ArrayDeque;

public class Smaller_on_Left {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2};
        int[] res = new Smaller_on_Left().leftSmaller(arr);
        for (int x : res) {
            System.out.print(x + " ");
        }
        System.out.println();

        int[] arr2 = {1, 5, 0, 3, 4, 5};
        int[] res2 = new Smaller_on_Left().leftSmaller(arr2);
        for (int x : res2) {
            System.out.print(x + " ");

        }
        System.out.println();
    }

    public int[] leftSmaller(int[] arr) {
        // code here
        ArrayDeque<Integer> st = new ArrayDeque<>();
        int[] pse = new int[arr.length];

        for(int i = 0; i<arr.length; i++){
            int n = arr[i];
            if(st.size() == 0){
                pse[i] = -1;
                st.push(n);
            }else{
                while(st.size() != 0 && st.peek() >= n) st.pop();
                if(st.size() != 0){
                    pse[i] = st.peek();
                    st.push(n);
                }else{
                    st.push(n);
                    pse[i] = -1;
                }
            }
        }

        return pse;
    }
}