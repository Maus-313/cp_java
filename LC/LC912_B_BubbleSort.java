public class LC912_B_BubbleSort {
    public static void main(String[] args) {

        int[] nums = {5,1,1,2,0,0};

        for(int i : new LC912_B_BubbleSort().sortArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] arr) {
        int l = arr.length;
        for(int j = 0; j<l; j++){
            for (int i = 0; i < l-1; i++) {
                if(arr[i] > arr[i+1]){
                    swap(arr, i+1, i);
                }
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
