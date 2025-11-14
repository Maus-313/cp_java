public class LC912_C_InsertionSort {
    public static void main(String[] args) {

        int[] nums = {5,1,1,2,0,0};

        for(int i : new LC912_C_InsertionSort().sortArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] arr) {
        int l = arr.length; 
        for(int i = 0; i<l; i++){
            int j = i;
            while(j>0 && arr[j-1]>arr[j]){
                swap(arr, j, j-1);
                j--;
            }
        }
        return arr;
    } 

    public int[] sol1(int[] nums) {

        int l = nums.length;
        for(int i = 0; i<l; i++){
            int j = i;
            while(j>0 && nums[j-1]>nums[j]){
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    } 
    
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
