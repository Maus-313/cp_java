public class Second_Largest {
    public static void main(String[] args) {
        int[] arr = {10, 10, 1};
        System.out.println(new Second_Largest().getSecondLargest(arr));
    }

    public int getSecondLargest(int[] arr) {
        
    }

    public int sol1(int[] arr) {
        int f = -1;
        int s = -1;

        for(int i : arr){

            if(f == -1){
                f = i;
            }else if(f < i){
                s = f;
                f = i;
            }else if(s < i && f > i){
                s = i;
            }
        }

        return s;
    }
}
