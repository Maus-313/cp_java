import java.util.ArrayDeque;

public class LC85 {
    public static void main(String[] args) {
        LC85 solution = new LC85();
        char[][] matrix1 = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };
        System.out.println(solution.maximalRectangle(matrix1)); // Output: 6

        char[][] matrix2 = {
            {'0'}
        };
        System.out.println(solution.maximalRectangle(matrix2)); // Output: 0

        char[][] matrix3 = {
            {'1'}
        };
        System.out.println(solution.maximalRectangle(matrix3)); // Output: 1
    }

    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int l = matrix[0].length;
        // int[] heights = new int[l];

        // for(char[] r : matrix){
        //     for(int i = 0; i<l; i++){
        //         if(r[i] == '1'){
        //             heights[i]++;
        //         }else{
        //             heights[i] = 0;
        //         }
        //     }
        //     max = Math.max(max, helper(heights));
        // }

        int[][] mat = new int[matrix.length][l];
        for(int j = 0;j<l; j++){
            for(int i = 0; i<matrix.length; i++){
                if(matrix[i][j] == '1'){
                    if(i > 0){
                        mat[i][j] = mat[i-1][j]+1;
                    }else{
                        mat[i][j] = 1;
                    }
                }else{
                    mat[i][j] = 0;
                }
            }
        }

        for(int[] r : mat){
            max = Math.max(max, helper(r));
        }

        return max;
    }

    static int helper(int[] heights){
        int max = 0;
        int[] nsi = NSI(heights);
        int[] psi = PSI(heights);
        int l = heights.length;
        // 2, 1, 5, 6, 2, 3
        // 0, 1, 2, 3, 4, 5
        // 
        for(int i = 0; i<l; i++){
            int w = (nsi[i] - i) + (i - psi[i]) - 1;
            max = Math.max(max, (w*heights[i]));
        }


        return max;
    }

    static int[] NSI(int[] arr){
        int l = arr.length;
        int[] nsi = new int[l];

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for(int i = l-1; i>=0; i--){
            if(st.size() == 0){
                st.push(i);
                nsi[i] = l;
            }else{
                while(st.size() != 0 && arr[st.peek()] > arr[i]) st.pop();
                
                if(st.size() == 0){
                    st.push(i);
                    nsi[i] = l;
                }else{
                    nsi[i] = st.peek();
                    st.push(i);
                }
            }
        }

        return nsi;
    }

    static int[] PSI(int[] arr){
        int l = arr.length;
        int[] psi = new int[l];

        ArrayDeque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < l; i++){
            if(st.size() == 0){
                st.push(i);
                psi[i] = -1;
            }else{
                while(st.size() != 0 && arr[st.peek()] >= arr[i]) st.pop();
                
                if(st.size() == 0){
                    st.push(i);
                    psi[i] = -1;
                }else{
                    psi[i] = st.peek();
                    st.push(i);
                }
            }
        }

        return psi;
    }
}
