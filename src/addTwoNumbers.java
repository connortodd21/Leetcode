public class addTwoNumbers {

    /*
    Add two numbers using linked lists
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = null;
        ListNode prev = null;
        ListNode curr = null;
        int value = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
            //calculate value or next digit
            if (l1 == null) {
                value = l2.val;
            } else if (l2 == null) {
                value = l1.val;
            } else {
                value = l1.val + l2.val + carry;
            }
            //check if you need to carry a 1
            if (value >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            value = value % 10;
            //allocate new node to be the new value
            curr = new ListNode(value);
            //check if this is the head of the LL
            if (sum == null) {
                sum = curr;
            }
            //add new digit to LL
            else {
                prev.next = curr;
            }
            prev = curr;
            //advance LL pointers
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //check final digit
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return sum;
    }
}

