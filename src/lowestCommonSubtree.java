public class lowestCommonSubtree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(p == root || q == root){
            return root;
        }
        //traverse tree to bottom
        //bottom up check to find ancestor
        TreeNode left =  lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }
        if(left == null){
            //inside right subtree
            return right;
        }
        //otherwise inside left subtree
        return left;
    }
}
