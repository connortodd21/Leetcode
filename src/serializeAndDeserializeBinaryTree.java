import java.util.*;

public class serializeAndDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        s.append(root.val + ",");
        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            if(node.right == null && node.left == null){
                continue;
            }
            else if(node.left == null){
                s.append("null,");
                s.append(node.right.val  + ",");
                queue.add(node.right);
            }
            else if(node.right == null){
                s.append("null,");
                s.append(node.left.val  + ",");
                queue.add(node.left);
            }
            else {
                s.append(node.left.val + ",");
                s.append(node.right.val  + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return s.toString().substring(0,s.length());
    }

    //decodes string into binary tree
    public TreeNode deserialize(String data) {
        Queue<TreeNode> queue = new LinkedList<>();
        while (data.length() > 0) {
            String currentData = data.substring(0, data.indexOf(','));
            TreeNode t;
            if(currentData.equals("null")){
                t = new TreeNode(Integer.MIN_VALUE);
            }
            else {
                t = new TreeNode(Integer.parseInt(currentData));
            }
            queue.add(t);
            data = data.substring(data.indexOf(',')+1);
        }
        TreeNode head = new TreeNode(queue.remove().val);
        buildTree(queue,head);
        return head;
    }

    //helper function for deserialize to build the binary tree
    public void buildTree(Queue<TreeNode> queue, TreeNode head){
        if(queue.isEmpty()){
            return;
        }
        TreeNode left = queue.remove();
        TreeNode right = queue.remove();
        if(left.val == Integer.MIN_VALUE && right.val == Integer.MIN_VALUE){
            head.left = null;
            head.right = null;
            return;
        }
        else if(left.val == Integer.MIN_VALUE){
            //dont build left
            head.right = right;
            head.left = null;
        }
        else if(right.val == Integer.MIN_VALUE){
            //dont build right
            head.left = left;
            head.right = null;
        }
        else {
            head.left = left;
            head.right = right;
            buildTree(queue, head.left);
            buildTree(queue, head.right);
        }
    }

    public static void main(String[] args) {
        serializeAndDeserializeBinaryTree s = new serializeAndDeserializeBinaryTree();
//        String input = " ";
//        int[] input = new int[]{1,3,-1,-3,5,3,6,7};
//        int[][] input = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
//        int[][] input = {{2,5}, {2,8}, {7,9}};
//        char[][] input = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 10;

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(15);

//        ListNode node = new ListNode(3);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
        System.out.println(s.serialize(node));
        String d = s.serialize(node);
        s.deserialize(d);
    }
}
