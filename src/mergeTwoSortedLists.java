public class mergeTwoSortedLists {
    public Solution.ListNode mergeTwoSortedLists(Solution.ListNode l1, Solution.ListNode l2) {
        Solution.ListNode head = new Solution.ListNode(0);
        Solution.ListNode ret = head;

        while (l1 != null || l2 != null){
            //check which is smaller and set value
            //check if both are valid
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    ret.next = l1;
                    l1 = l1.next;
                }
                else {
                    ret.next = l2;
                    l2 = l2.next;
                }
            }
            else if(l2 == null){
                //advance l1
                ret.next = l1;
                l1 = l1.next;
            }
            else {
                //advance l2
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "[";

        Solution.ListNode l1 = new Solution.ListNode(1);
        l1.next = new Solution.ListNode(2);
        l1.next.next = new Solution.ListNode(4);
        l1.next.next.next = new Solution.ListNode(6);

        Solution.ListNode l2 = new Solution.ListNode(1);
        l2.next = new Solution.ListNode(3);
        l2.next.next = new Solution.ListNode(4);

        Solution.ListNode n =  s.mergeTwoSortedLists(l1, l2);
        while (n != null){
            System.out.println(n.val);
            n = n.next;
        }
    }
}
