import java.util.HashSet;

public class LC234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        int[] arr = { 1,2,3,4,5};

        for (int i : arr) {
            ListNode newNode = new ListNode(i);
            curr.next = newNode;
            curr = curr.next;
        }
        head = head.next;
        System.out.println(new LC234().isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        

        return set.isEmpty();
    }
}


class ListNode {
    ListNode next;
    int val;

    ListNode(int a) {
        val = a;
    }
}