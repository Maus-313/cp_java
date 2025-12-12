public class LC912_D_MergeSort {
    public static void main(String[] args) {

        int[] nums = { 5, 1, 1, 2, 0, 0 };
        int[] ans = new LC912_D_MergeSort().sortArray(nums);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }

    public int[] sortArray(int[] nums) {
        
    }

    public int[] sol1(int[] nums) {
        divide(nums, 0, nums.length-1);
        return nums;
    }

    static void divide(int[] arr, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;
        divide(arr, l, m);
        divide(arr, m + 1, r);

        merge(arr, l, m, r);

    }

    static void merge(int[] arr, int l, int m, int r) {

        int[] temp = new int[r - l + 1];

        int a = l;
        int b = m + 1;
        int idx = 0;
        while (a <= m && b <= r) {
            if (arr[a] < arr[b]) {
                temp[idx] = arr[a];
                a++;
            } else {
                temp[idx] = arr[b];
                b++;
            }
            idx++;
        }

        while(a <= m){
            temp[idx] = arr[a];
            a++;
            idx++;
        }


        while(b <= r){
            temp[idx] = arr[b];
            b++;
            idx++;
        }

        idx = 0;
        for(int i = l; i<= r; i++){
            arr[i] =  temp[idx];
            idx++;
        }
    }
}