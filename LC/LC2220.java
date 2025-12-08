public class LC2220 {
    public static void main(String[] args) {
        int start = 10, goal = 7;
        System.out.println(new LC2220().minBitFlips(start, goal));
        // System.out.println(10>>3 & 1);
    }

    public int minBitFlips(int start, int goal) {
        
    }

    public int sol2(int start, int goal) {
        int c = 0;

        while(start != 0 && goal != 0){
            if((start & 1) != (goal & 1)) c++;
            start = start >> 1;
            goal >>= 1;
        }

        while(start != 0){
            if((start & 1) == 1) c++;
            start >>= 1;
        }

        while(goal != 0){
            if((goal & 1) == 1) c++;
            goal >>= 1;
        }

        return c;
    }

    public int sol1(int start, int goal) {
        // 1    -> 0001
        // 14   -> 1110
        int count = 0;
        while(start != goal){
            if(((start & 1)^(goal & 1)) != 0) count++;
            start = start>>1;
            goal = goal>>1;
        }

        return count;
    }
    
}
