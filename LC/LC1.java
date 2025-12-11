import java.util.HashMap;

public class LC1 {
    public static void main(String[] args) {

        for(int i : new LC1().twoSum(new int[]{2,7,11,15}, 9)){
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i : new LC1().twoSum(new int[]{3,2,4}, 6)){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i : new LC1().twoSum(new int[]{3,3}, 6)){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i : new LC1().twoSum(new int[]{-3,4,3,90}, 0)){
            System.out.print(i+" ");
        }
    }

    public int[] twoSum(int[] arr, int target) {
        
    }

    public int[] sol2(int[] arr, int target) {
        // clean approach
        int l = arr.length;
        for(int i = 1; i<l; i++){
            for(int j = 0; j<l-i; j++){
                if(arr[j] + arr[j+i] == target) return new int[]{j, j+i};
            }
        }

        return new int[]{};
    }

    public int[] sol1(int[] arr, int target) {
        int[] ans = new int[2];
        int l = arr.length;
        HashMap<Integer, Integer> mem = new HashMap<>();
        for(int i = 0; i<l; i++){
            int more = target - arr[i];
            if(mem.containsKey(more)){
                ans[0] = mem.get(more);
                ans[1] = i;
                break;
            }else{
                mem.put(arr[i], i);
            }
        }

        return ans;
    }

}