public class Second_Largest {
    public static void main(String[] args) {
        System.out.println(new Second_Largest().getSecondLargest(new int[] {12, 35, 1, 10, 34, 1}));
        System.out.println(new Second_Largest().getSecondLargest(new int[] {10, 5, 10}));
        System.out.println(new Second_Largest().getSecondLargest(new int[] {10, 10, 10}));
    }

    public int getSecondLargest(int[] arr) {
        
    }

    public int sol2(int[] arr) {
        // humane approach
        int first = -1;
        int second = -1;

        for(int i : arr){
            if(first == -1) first = i;
            else if(second == -1){
                if(first > i){
                    second = i;
                }else if(first < i){
                    second = first;
                    first = i;
                }
            }else if(i > first){
                second = first;
                first = i;
            }else if(i > second && first != i){
                second = i;
            }
        }

        return second;
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
