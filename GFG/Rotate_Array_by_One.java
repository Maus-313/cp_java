public class Rotate_Array_by_One {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5};

        new Rotate_Array_by_One().rotate(arr);

        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    public void rotate(int[] arr) {
        // code here
        if(arr.length == 1) return;
        int l = arr.length;
        int last = arr[l-1];
        for(int i = l-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = last;
    }
}
