public class LC912_C_InsertionSort {
    public static void main(String[] args) {

        int[] nums = {5,1,1,2,0,0};

        for(int i : new LC912_C_InsertionSort().sortArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] arr) {
        
    } 

    public int[] sol1(int[] nums) {
        int l = arr.length;
        for(int i = 1; i<l; i++){
            int j = i;
            while(j > 0 && arr[j] < arr[j-1]){
                swap(arr, j, j-1);
                j--;
            }
        }
        return arr;
    } 
    
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
