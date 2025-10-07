public class Floyd_Warshall {
    public static void main(String[] args) {
        int dist[][] = {{0, 4, (int) Math.pow(10, 8), 5, (int) Math.pow(10, 8)}, {(int) Math.pow(10, 8), 0, 1, (int) Math.pow(10, 8), 6}, {2, (int) Math.pow(10, 8), 0, 3, (int) Math.pow(10, 8)}, {(int) Math.pow(10, 8), (int) Math.pow(10, 8), 1, 0, 2}, {1, (int) Math.pow(10, 8), (int) Math.pow(10, 8), 4, 0}};

        new Floyd_Warshall().floydWarshall(dist);
        // int[] ans2 = new Floyd_Warshall().floydWarshall(dist);   

        for(int[] arr: dist){
            for(int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println();

        // for(int i: ans2){
        //     System.out.print(i+" ");
        // }
        // System.out.println();
    }

    public void floydWarshall(int[][] dist) {
        // Code here
        int V = dist.length;
        int INF = (int) Math.pow(10, 8);

        for(int w = 0; w<V; w++){
            for(int i = 0; i<V; i++){
                for(int j = 0; j<V; j++){
                    int a = dist[i][w];
                    int b = dist[w][j];

                    if(a == INF || b == INF) continue;
                    if(dist[i][j] > a+b){
                        dist[i][j] = a+b;
                    }
                }
            }
        }
    }
}
