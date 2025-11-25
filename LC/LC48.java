import java.util.Collection;
import java.util.Collections;

public class LC48 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        new LC48().rotate(matrix);
        
        for(int[] r : matrix){
            for(int i : r){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        

    }

    public void sol1(int[][] matrix) {
        // 0ms but n2 space 
        int m = matrix.length;

        int[][] clone = new int[m][];

        for(int i = 0; i<m; i++){
            clone[i] = matrix[i].clone();
        }


        for(int i = 0; i<m; i++){
            for(int j = m-1; j>=0; j--){
                matrix[i][m-j-1] = clone[j][i];
                // System.out.print(clone[j][i]+" ");
                // System.out.print(matrix[i][m-j-1]+" ");
            }
            // System.out.println();
        }

        // for(int[] r : clone){
        //     for(int i : r){
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
    }

    public void sol2(int[][] matrix) {
        // space optimised
        int n = matrix.length;

        for(int i = 0; i<n; i++){
            for(int j = i; j<n; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        
        for(int[] r : matrix){
            for(int i = 0; i<n/2; i++){
                int temp = r[i];
                r[i] = r[n-i-1];
                r[n-i-1] = temp;
            }
        }

    }

}