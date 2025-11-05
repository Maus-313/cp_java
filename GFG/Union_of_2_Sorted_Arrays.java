import java.util.ArrayList;
import java.util.Collections;

public class Union_of_2_Sorted_Arrays {
    public static void main(String[] args) {
        int[] a = {2, 2, 3, 4, 5}; 
        int b[] = {1, 1, 2, 3, 4};

        ArrayList<Integer> ans = findUnion(a, b);

        for(int i : ans){
            System.out.print(i+" ");
        }
    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // TLE, 
        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i<a.length && j<b.length){
            int aa = a[i];
            int bb = b[j];

            if(aa < bb){
                if(!ans.contains(aa)){
                    ans.add(aa);
                }
                i++;
            }else{
                if(!ans.contains(bb)){
                    ans.add(bb);
                }
                j++;
            }
        }

        while(i<a.length){
            if(!ans.contains(a[i])){
                ans.add(a[i]);
            }
            i++;
        }

        while(j<b.length){
            if((!ans.contains(b[j]))) ans.add(b[j]);
            j++;
        }

        return ans;
    }
}
