import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;

public class LC146 {
    public static void main(String[] args) {
        LinkedList<Integer> ddq = new LinkedList<>();
        ddq.add(12);
        ddq.add(23);
        ddq.add(34);
        System.out.println(ddq);
    }
}

class LRUCache {

    // key and position
    static HashMap<Integer, Integer> table;
    
    // key, value
    static LinkedList<int[]> st;
    int SIZE;

    public LRUCache(int capacity) {
        table = new HashMap<>();
        st = new LinkedList<>();
        SIZE = capacity;
    }
    
    public int get(int key) {

        if(table.containsKey(key)){
            int[] temp = st.get(key);
            
            st.remove(key);

            st.push(temp);

            return temp[1];
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(st.size() < SIZE){
            st.push(new int[]{key, value});
            table.put(key, 0);
            SIZE++;
        }else{

        }
    }
}
