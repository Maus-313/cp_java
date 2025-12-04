import java.util.Arrays;

public class Least_Prime_Factor {
    public static void main(String[] args) {
        int N = 12;
        int[] ans = new Least_Prime_Factor().leastPrimeFactor(N);
        for(int i :ans){
            System.out.print(i+" ");
        }
    }

    public int[] leastPrimeFactor(int n) {
        
    }

    public int[] sol2(int n) {
        // simple easy
        int[] arr = new int[n+1];

        for(int i = 0; i<=n; i++){
            arr[i] = i;
        }

        for(int i = 2; i*i<=n; i++){
            if(arr[i] == i){
                for(int j = i*i; j<=n; j+=i){
                    if(i< arr[j]) arr[j] = i;
                }
            }
        }

        return arr;
    }

    public int[] sol1(int n) {
        static int MAX = 100000;
    static boolean init = false;
    static int spf[] = new int[MAX+1];
        // code here
        if(!init) initialize();
        return Arrays.copyOf(spf, n+1);

    }

    static void initialize(){
        for(int i = 0; i<=MAX; i++){
            spf[i] = i;
        }

        for(int i = 2; i*i<=MAX; i++){
            if(spf[i] == i){
                for(int j = i*i; j<=MAX; j+=i){
                    if(spf[j] == j) spf[j] = i;
                }
            }
        }
        init = true;
    }
}
