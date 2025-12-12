public class LC912_A_SelectionSort {
    public static void main(String[] args) {

        int[] nums = {5,1,1,2,0,0};

        for(int i : new LC912_A_SelectionSort().sortArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] arr) {
        
    }

    public int[] sol1(int[] arr) {
        int l = arr.length;
        for(int i = 0; i<l; i++){
            int minIdx = i;
            for(int j = i+1; j<l; j++){
                if(arr[minIdx] > arr[j]){
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}