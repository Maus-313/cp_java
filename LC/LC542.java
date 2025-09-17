public class LC542 {
    public static void main(String[] args) {

        int[][] mat = {{0,0,0},{0,1,0},{0,0,0}};
        int[][] mat2 = {{0,0,0},{0,1,0},{1,1,1}};

        // int[][] ans = mat;
        int[][] ans = new LC542().updateMatrix(mat2);

        for(int i = 0; i<ans.length; i++){
            for(int j = 0; j<ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }


    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];

        

        return ans;
    }


}