public class LC1486{
    public static void main(String[] args) {
        int n = 5, start = 0;
        System.out.println(new LC1486().xorOperation(n, start));
    }

    public int xorOperation(int n, int start) {
        
    }

    public int s_0ms(int n, int start) {

        int[] arr = new int[n];
        int ans = 0;
        
        for(int i = 0; i<n; i++){
            arr[i] = start + 2 * i;
            ans = ans^arr[i];
        }

        return ans;
    }
}