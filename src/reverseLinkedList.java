public class reverseLinkedList {
    public Solution.ListNode reverseList(Solution.ListNode head) {
        if(head == null){
            return null;
        }
        Solution.ListNode prev = null;
        Solution.ListNode curr = head;
        Solution.ListNode next = null;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = " ";
//        int[] input = new int[]{7,1,5,3,6,4};
//        char[][] input = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 10;

//        TreeNode node = new Solution.TreeNode(1);
//        node.left = new Solution.TreeNode(2);
//        node.right = new Solution.TreeNode(3);
//        node.left.right = new Solution.TreeNode(5);
//        node.right.left = new Solution.TreeNode(15);

        Solution.ListNode node = new Solution.ListNode(3);
        node.next = new Solution.ListNode(2);
        node.next.next = new Solution.ListNode(0);
        node.next.next.next = new Solution.ListNode(-4);
        node.next.next.next.next = node.next;
        Solution.ListNode ret = s.reverseList(node);
    }
}
