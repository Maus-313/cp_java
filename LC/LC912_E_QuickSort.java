public class LC912_E_QuickSort {
    public static void main(String[] args) {

        int[] nums = {5,1,1,2,0,0};

        for(int i : new LC912_E_QuickSort().sortArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] nums) {
        // Quick Sort
        quickSort(nums, 0, nums.length-1);
        return nums;
    }

    static void quickSort(int[] arr, int l, int r){
        if(l >=r ) return;

        int p = arr[l];
        int i = l;
        int j = r;

        while (i<j) {

            while(i<r){
                if(arr[i] > p){
                    break;
                }
                i++;
            }

            while(j>l){
                if(arr[j] < p){
                    break;
                }
                j--;
            }

            if(i<j) swap(arr, i, j);
        }

        swap(arr, l, j);

        quickSort(arr, l, j-1);
        quickSort(arr, j+1, r);
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}