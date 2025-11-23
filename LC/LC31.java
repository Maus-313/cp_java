import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class LC31 {
    public static void main(String[] args) {
        // int[] arr = { 2,1,5,4,3,0,0 };
        int[] arr = { 3,2,1};
        // int[] arr = { 1,2,3};
        // 2 3 0 0 1 4 5
        new LC31().nextPermutation(arr);

        for(int i : arr){
            System.out.print(i+" ");
        }

        // ArrayList<ArrayList<Integer>> per = new ArrayList<>();
        // boolean[] used = new boolean[arr.length];
        // helper(arr, per, new ArrayList<>(), used);

        // for(ArrayList<Integer> al : per){
        //     for(int i : al){
        //         System.out.print(i+" ");S
        //     }
        //     System.out.println();
        // }

    }

    public void nextPermutation(int[] arr) {
        // 0ms
        int l = arr.length;

        // break point
        int b = -1;

        // for(int i = 0; i<l-1; i++){
        //     if(arr[i] < arr[i+1]){
        //         b = i;
        //         break;
        //     }
        // }

        for(int i = l-1; i>0; i--){
            if(arr[i-1] < arr[i]){
                b = i-1;
                break;
            }
        }

        if(b == -1){
            for(int i = 0; i<l/2; i++){
                int tt = arr[l-i-1];
                arr[l-i-1] = arr[i];
                arr[i] = tt;
            }
            return;
        }

        int smallidx = -1;
        int max = -1;
        for(int i = l-1; i>b ; i--){
            if(arr[i] > arr[b] && (max == -1 || arr[i] < max)){
                smallidx = i;
                max = arr[i];
            } 
        }

        swap(arr, smallidx, b);

        int start = b + 1;
        int end = l - 1;
        
        while (start < end) {
            swap(arr, start, end); // Assuming you have a helper swap function
            start++;
            end--;
        }
    }

    public void sol2(int[] arr) {

        // 2ms
        int l = arr.length;

        // break point
        int b = -1;

        // for(int i = 0; i<l-1; i++){
        //     if(arr[i] < arr[i+1]){
        //         b = i;
        //         break;
        //     }
        // }

        for(int i = l-1; i>0; i--){
            if(arr[i-1] < arr[i]){
                b = i-1;
                break;
            }
        }

        if(b == -1){
            for(int i = 0; i<l/2; i++){
                int tt = arr[l-i-1];
                arr[l-i-1] = arr[i];
                arr[i] = tt;
            }
            return;
        }

        int smallidx = -1;
        int max = -1;
        for(int i = l-1; i>b ; i--){
            if(arr[i] > arr[b] && (max == -1 || arr[i] < max)){
                smallidx = i;
                max = arr[i];
            } 
        }

        swap(arr, smallidx, b);

        int[] tempArr = Arrays.copyOfRange(arr, b+1, l);

        Arrays.sort(tempArr);

        // for(int i : tempArr){
        //     System.out.print(i+" ");
        // }

        for(int i = 0; i<tempArr.length; i++){
            arr[i+b+1] = tempArr[i];
        }

    }

    // static void sort(int a, int[] arr, int l){

    //     for(int i = a; i<l; i++){
    //         for(int )
    //     }
    // }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sol1(int[] arr) {
        // this is brute force but not done yet!
        ArrayList<ArrayList<Integer>> per = new ArrayList<>();
        boolean[] used = new boolean[arr.length];
        helper(arr, per, new ArrayList<>(), used);
        
        boolean found = false;
        for(ArrayList<Integer> al : per){
            int idx = 0;
            System.out.println("asdfS");
            if(found){
                for(int i : al){
                    arr[idx] = i;
                    idx++;
                }
                
                return;
            }
            for(int i : al){
                
                if(i != arr[idx]){
                    found = false;
                    break;
                }

                found = true;
                idx++;
            }
        }
    }

    static void helper(int[] arr, ArrayList<ArrayList<Integer>> per, ArrayList<Integer> temp, boolean[] used) {

        if (temp.size() == arr.length) {
            per.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.add(arr[i]);
            helper(arr, per, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    static void helper1(int[] arr,
            ArrayList<ArrayList<Integer>> per,
            ArrayList<Integer> temp,
            boolean[] used) { // New parameter: boolean array to track used elements

        // Base Case: A complete permutation is formed
        if (temp.size() == arr.length) {
            per.add(new ArrayList<>(temp));
            return;
        }

        // Loop through ALL elements in the array
        for (int i = 0; i < arr.length; i++) {

            // Skip this element if it has already been used in the current permutation
            if (used[i]) {
                continue;
            }

            // 1. Choose: Mark as used and add to the temporary list
            used[i] = true;
            temp.add(arr[i]);

            // 2. Explore: Recurse without changing the starting index (always start at 0)
            helper1(arr, per, temp, used);

            // 3. Un-Choose (Backtrack): Remove from temp and mark as unused
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}