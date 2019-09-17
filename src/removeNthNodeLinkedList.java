public class removeNthNodeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        if (temp.next == null){
            return head;
        }
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        temp = tempHead;
        int i =0;
        while (i < count-n){
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        return tempHead.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode temp = ret;
        for (int i = 0; i <= n && temp != null; i++) {
            temp = temp.next;
        }
        ListNode behind = ret;
        while (temp != null){
            temp = temp.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return ret.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode temp = removeNthFromEnd2(head, 2);
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
