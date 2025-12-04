import java.util.List;

class ListNode {
    ListNode next;
    int val;

    ListNode(int a) {
        val = a;
    }
}

public class LC92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int[] arr = { 1,2,3,4,5};
        int left = 2;
        int right = 3;

        for (int i : arr) {
            ListNode newNode = new ListNode(i);
            curr.next = newNode;
            curr = curr.next;
        }
        head = head.next;
        printLL(head);
        head = new LC92().sol1(head, left, right);
        printLL(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        
    }

    public ListNode sol1(ListNode head, int left, int right) {
        // 0ms
        ListNode D = new ListNode(0);
        D.next = head;
        ListNode a = D;
        
        for(int i = 1; i<left && a!= null; i++){
            a = a.next;
        }

        // System.out.println(a.val);

        ListNode b = a.next;

        for(int i = left; i<right; i++){
            ListNode c = b.next;
            b.next = c.next;
            c.next = a.next;
            a.next = c;
        }
        

        return D.next;
    }

    static void printLL(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
