class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            int target = sc.nextInt();
            int maxDoubles = sc.nextInt();
            System.out.println("Result -> "+new Main().minMoves(target, maxDoubles));
        }
    }

    public int minMoves(int target, int maxDoubles) {
        
        return dfs(1, target, maxDoubles, 0);

    }

    static int dfs(int start, int target, int mD, int c) {

        if (start == target)
            return c;
        if (start > target)
            return -1;

        int a = dfs(start + 1, target, mD, c + 1);
        int b = -1;
        if (mD > 0)
            b = dfs(start * 2, target, mD - 1, c + 1);

        if (a != -1 && b != -1)
            return Math.min(a, b);
        return Math.max(a, b);
    }
}