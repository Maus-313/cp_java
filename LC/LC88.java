public class LC88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        new LC88().merge(nums1, m, nums2, n);

        for(int i : nums1){
            System.out.print(i+" ");
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        int l = nums1.length;
        int idx = 0;
        for(int i = m; i<l; i++){
            nums1[i] = nums2[idx];
            idx++;
        }
    }
}
