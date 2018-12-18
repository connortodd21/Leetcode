import java.util.HashSet;

public class hasCycle {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /*
       Simple method, just traverse straight through the linked list
    */
    public boolean hasCycleMethod(ListNode head) {
        if (head == null){
            return false;
        }
        if (head.next == null){
            return false;
        }
        HashSet<ListNode> arrayList = new HashSet<>();
        arrayList.add(head);
        head = head.next;
        while (head != null){
            if(arrayList.contains(head)){
                return true;
            }
            arrayList.add(head);
            head = head.next;
        }
        return false;
    }

    /*
        Optimal solution, Floyd's cycle finding algorithm
        Two pointers, increase one by one, and one by two.
        If they meet, then there is a cycle, otherwise not
        O(1) space
     */
    public boolean hasCycleOptimal(ListNode head){
        ListNode one = head;
        ListNode two = head;
        while (one != null && two != null && two.next != null){
            one = one.next;
            two = two.next.next;
            if(one == two){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        hasCycle c = new hasCycle();
//        int[] input = new int[]{7,1,5,3,6,4};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 3;

//        TreeNode node = new Solution.TreeNode(3);
//        node.left = new Solution.TreeNode(20);
//        node.right = new Solution.TreeNode(9);
//        node.right.right = new Solution.TreeNode(7);
//        node.right.left = new Solution.TreeNode(15);

        ListNode node = new ListNode(3);
        node.next = new ListNode(2);
        node.next.next = new ListNode(0);
        node.next.next.next = new ListNode(-4);
        node.next.next.next.next = node.next;
        System.out.println(c.hasCycleMethod(node));
    }
}
