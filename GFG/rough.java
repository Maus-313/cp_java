import java.util.ArrayList;

public class rough {
    public static void main(String[] args) {
        int n = 1;
        int INF = Integer.MAX_VALUE;
        ArrayList<Integer> arr = new ArrayList();
        ArrayList<Integer> arr1 = new ArrayList();
        ArrayList<Integer> arr2 = new ArrayList();
        ArrayList<Integer> arr3 = new ArrayList();
        ArrayList<Integer> arr4 = new ArrayList();
        while(n < 99){
            n = (n*3)%100;
            arr.add(INF);
            arr1.add(INF);
            arr2.add(INF);
            arr3.add(INF);
            arr4.add(INF);
            // System.out.println(n);
            System.out.println(arr.size());
        }
    }
}
