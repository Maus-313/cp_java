public class LC75 {
    public static void main(String[] args) {

        int[] nums = {2,0,2,1,1,0};
        new LC75().sortColors(nums);

        for(int i : nums){
            System.out.print(i+" ");
        }
    }

    public void sortColors(int[] nums) {
        divide1(nums, 0, nums.length-1);
    }

    public int[] sortArray(int[] arr) {
        int l = arr.length;
        for(int i = 0; i<l; i++){
            for(int j = i+1; j<l; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
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

    static void divide1(int[] arr , int a, int b){
        if(a >= b) return;
        int m = (a+b)/2;
        divide1(arr, a, m);
        divide1(arr, m+1, b);

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

}