package CN;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Alternate_Numbers {

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5, 6,-7,-8};
        for(int i : alternateNumbers(A)){
            System.out.print(i+" ");
        }
    }

    public static int[] alternateNumbers(int []a) {
        // Write your code here.
        int l = a.length;
        int[] pos = new int[l];
        Arrays.fill(pos, -1);
        
        int[] neg = new int[l];
        Arrays.fill(neg, 1);
        int p = 0;
        int n = 0;

        for(int i : a ){
            if(i > 0){
                pos[p] = i;
                p++;
            }else{
                neg[n] = i;
                n++;
            }
        }

        int[] ans = new int[l];
        
        p = 0;
        n = 0;

        for(int i = 0; i<l; i++){
            if(i%2 == 0){
                if(pos[p] == -1){
                    while(i<l & neg[n] != 1){
                        ans[i] = neg[n];
                        n++;
                        i++;
                    }
                    break;
                }
                ans[i] = pos[p];
                p++;
            }else{
                if(neg[n] == 1){
                    while(i<l && pos[p] != -1){
                        ans[i] = pos[p];
                        p++;
                        i++;
                    }
                    break;
                }
                ans[i] = neg[n];
                n++;
            }
        }
        return ans;
    }
}