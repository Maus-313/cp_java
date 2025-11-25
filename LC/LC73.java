import java.util.HashSet;

public class LC73 {
    public static void main(String[] args) {
        int[][]matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };

        new LC73().setZeroes(matrix);
        for(int[] r : matrix){
            for(int i : r){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    public void setZeroes(int[][] matrix) {
        // 1ms, but space taking
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){

                    if(!rows.contains(i)){
                        rows.add(i);
                        for(int r = 0; r<n; r++){
                            matrix[i][r] = 0;
                        }
                    }

                    if(!cols.contains(j)){
                        cols.add(j);
                        for(int r = 0; r<m; r++){
                            matrix[r][j] = 0;
                        }
                    }
                }
            }
        }
    }

    public void sol1(int[][] matrix) {
        // 1ms
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int r : rows){
            for(int i = 0; i<n; i++){
                matrix[r][i] = 0;
            }
        }

        for(int r : cols){
            for(int i = 0; i<m; i++){
                matrix[i][r] = 0;
            }
        }
    }

}