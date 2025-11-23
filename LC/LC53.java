public class LC53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new LC53().maxSubArray(nums));
    }

    public int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i : arr){
            if(sum < 0){
                sum = i;
            }else{
                sum += i;
            }
            max = Math.max(max, sum);
        }

        return max;
    }

    public int sol1(int[] arr) {
        // TLE, brute force
        int l = arr.length;
        int max = Integer.MIN_VALUE;
        
        for(int i = 1; i<=l; i++){
            int temp = 0;
            for(int j = 0; j<l; j++){
                if(j<i){
                    temp += arr[j];
                }else{
                    temp += arr[j];
                    temp -= arr[j-i];
                }
                max = Math.max(max, temp);
            }
        }

        return max;
    }

    public int sol2(int[] arr) {
        // striver's brute force, TLE
        int l = arr.length;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i<l; i++){
            int temp = arr[i];
            for(int j = i+1; j<l; j++){
                temp += arr[j];
                max = Math.max(max, temp);
            }
            max = Math.max(max, temp);
        }

        return max;
    }
}
