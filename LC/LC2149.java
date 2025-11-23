public class LC2149 {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4};
        for(int i : new LC2149().rearrangeArray(nums)){
            System.out.print(i+" ");
        }
    }

    public int[] rearrangeArray(int[] arr) {
        
    }

    public int[] sol3(int[] arr) {
        // 3ms
        int l = arr.length;
        int pos = 0;
        int neg = 1;
        int[] ans = new int[l];

        for(int i : arr){
            if( i > 0){
                ans[pos] = i;
                pos += 2;
            }else{
                ans[neg] = i;
                neg += 2;
            }
        }

        return ans;
    }

    public int[] sol2(int[] arr) {
        // 5ms
        int l = arr.length;
        int[] pos = new int[l/2];
        int[] neg = new int[l/2];
        int p = 0;
        int n = 0;
        for(int i : arr){
            if(i<0){
                neg[n] = i;
                n++;
            }else{
                pos[p] = i;
                p++;
            }
        }
        n = 0;
        p = 0;

        for(int i = 0; i<l; i++){
            if(i%2 == 0){
                arr[i] = pos[p];
                p++;
            }else{
                arr[i] = neg[n];
                n++;
            }
        }

        return arr;
    }

    public int[] sol1(int[] arr) {
        // this breaks the sequence
        int l = arr.length;

        for(int i = 0; i<l; i++ ){
            if(i%2 == 0){
                // +ive
                if(arr[i] < 0){
                    for(int j = i+1; j<l; j++){
                        if(arr[j] > 0){
                            swap(arr, i, j);
                            break;
                        }
                    }
                }
            }else{
                // -ive
                if(arr[i] > 0){
                    for(int j = i+1; j<l; j++){
                        if(arr[j] < 0){
                            swap(arr, i, j);
                            break;
                        }
                    }
                }
            }
        }

        return arr;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}