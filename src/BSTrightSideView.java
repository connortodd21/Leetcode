import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BSTrightSideView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if(i == 0){
                    arrayList.add(node.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
        BSTrightSideView s = new BSTrightSideView();
//        String input = " ";
//        int[] input = new int[]{7,1,5,3,6,4};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 3;

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
//        node.right.left = new Solution.TreeNode(15);

//        ListNode node = new ListNode(3);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(0);
//        node.next.next.next = new ListNode(-4);
//        node.next.next.next.next = node.next;
        System.out.println(s.rightSideView(node));
    }
}
