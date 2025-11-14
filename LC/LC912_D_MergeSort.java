public class LC912_D_MergeSort {
    public static void main(String[] args) {

        int[] nums = {5,1,1,2,0,0};

        for(int i : new LC912_A_SelectionSort().sortArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length-1);
        return nums;
    }

    static void divide2(int[] arr, int l, int r){
        if(l >= r) return;

        int m = (l+r)/2;

        divide(arr, l, m);
        divide(arr, m+1, r);

        merge(arr, l, m, r);
    }

    static void merge(int[] arr, int l, int m, int r){
        int[] temp = new int[r-l+1];
        int i = l;
        int j = m+1;
        int idx = 0;

        while(i <= m && j<= r){
            if(arr[i] < arr[j]){
                temp[idx] = arr[i];
                i++;
            }else{
                temp[idx] = arr[j];
                j++;
            }
            idx++;
        }


        while(i <= m){
            temp[idx] = arr[i];
            i++;
            idx++;
        }

        while(j <= r){
            temp[idx] = arr[j];
            j++;
            idx++;
        }

        for(int k = 0; k<temp.length; k++){
            arr[l+k] = temp[k];
        }
    }

    
    static void divide1(int[] arr , int a, int b){
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
}