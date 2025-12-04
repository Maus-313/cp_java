import java.util.List;

class ListNode {
    ListNode next;
    int val;

    ListNode(int a) {
        val = a;
    }
}

public class LC24 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int[] arr = { 1};

        for (int i : arr) {
            ListNode newNode = new ListNode(i);
            curr.next = newNode;
            curr = curr.next;
        }

        head = head.next;
        printLL(head);
        head = new LC24().swapPairs(head);
        printLL(head);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode D = new ListNode(0);
        D.next = head;

        ListNode tempD = D;
        ListNode a = D.next;
        if(a == null) return head;
        ListNode b = a.next;
        if(b == null) return head;

        while(true){
            a.next = b.next;
            b.next = tempD.next;
            tempD.next = b;
            tempD = a;
            a = a.next;
            if(a == null) break;
            b = a.next;
            if(b == null) break;
        }

        return D.next;
    }

    public ListNode sol1(ListNode head, int left, int right) {
        
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
