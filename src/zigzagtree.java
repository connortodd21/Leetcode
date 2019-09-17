import java.util.*;

public class zigzagtree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> next = new LinkedList<>();
        Queue<TreeNode> current = new LinkedList<>();
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> levelNodes = new ArrayList<>();
        current.add(root);
        int level = 1;
        while (!current.isEmpty()){
            TreeNode node;
            if (level % 2 != 0){
                // even, so right to left
                node = current.remove();
                if (node.right != null){
                    next.add(node.right);
                }
                if(node.left != null){
                    next.add(node.left);
                }
                levelNodes.add(node.val);
            }
            else{
                // odd, so left to right
                node = current.remove();
                if (node.left != null){
                    next.add(node.left);
                }
                if(node.right != null){
                    next.add(node.right);
                }
                levelNodes.add(node.val);
            }
            if (current.isEmpty()){
                current = next;
                next = new LinkedList<>();
                ret.add(levelNodes);
                levelNodes = new ArrayList<>();
                level++;
            }
        }
        return ret;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        System.out.println(zigzagLevelOrder(root));
    }

}
