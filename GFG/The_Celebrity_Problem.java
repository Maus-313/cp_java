public class The_Celebrity_Problem {
    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},{0, 1, 0},{0, 1, 1}};
        // int[][] mat = {{1, 1},{1, 1}};
        System.out.println(new The_Celebrity_Problem().celebrity(mat));
    }

    public int celebrity(int mat[][]) {
        int l = mat.length;

        boolean[] cel = new boolean[l];
        
        int[] fol = new int[l];

        for(int i = 0; i<l; i++){
            for(int j = 0; j<l; j++){
                if( i!= j && mat[i][j] == 1){
                    cel[i] = true;
                    fol[j]++;
                }
            }
        }

        for(int i = 0; i<l; i++){
            // System.out.println(cel[i]);
            if(!cel[i] && fol[i] == l-1) return i;
        }

        return -1;
    }
}
