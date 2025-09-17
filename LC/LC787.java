import java.util.*;

public class LC787{
    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {
            {0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}
        };
        int src = 0;
        int dst = 2;
        int k = 2;
        System.out.println(new LC787().findCheapestPrice(n, flights, src, dst, k));

    }

    
}