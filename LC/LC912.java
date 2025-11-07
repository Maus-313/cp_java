public class LC912 {
    public static void main(String[] args) {

        int[] nums = {5,2,3,1};

        for(int i : new LC912().sortArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] nums) {
        // Quick Sort
        
    }

    public int[] sol2(int[] nums){
        // Merge Sort
        divide(nums, 0, nums.length-1);
        return nums;
    }
    
    static void divide(int[] arr , int a, int b){
        if(a >= b) return;
        int m = (a+b)/2;
        divide(arr, a, m);
        divide(arr, m+1, b);

        conq(arr, a, m, b);

    }

    static void conq(int[] arr, int a, int m, int b){
        int[] temp = new int[(b-a)+1];

        int aa = a;
        int mm = m+1;
        int idx = 0;
        while(aa <= m && mm <= b){
            if(arr[aa] < arr[mm]){
                temp[idx] = arr[aa];
                aa++;
            }else{
                temp[idx] = arr[mm];
                mm++;
            }
            idx++;
        }


        while(aa <= m){
            temp[idx] = arr[aa];
            aa++;
            idx++;
        }

        while(mm <= b){
            temp[idx] = arr[mm];
            mm++;
            idx++;
        }

        for(int i = 0; i<temp.length; i++){
            arr[i+a] = temp[i];
        }
    }

    public int[] sol1(int[] nums) {
        // Insertion Sort, Gave TLE
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
}
