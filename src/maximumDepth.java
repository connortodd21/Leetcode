public class maximumDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int max = 0;

    public static void maxDepthHelper(TreeNode root, int depth){
        if (root.left == null && root.right == null){
            if (depth > max){
                max = depth;
            }
        }
        else if (root.right == null){
            maxDepthHelper(root.left, depth+1);
        }
        else if(root.left == null){
            maxDepthHelper(root.right, depth+1);
        }
        else {
            maxDepthHelper(root.left, depth + 1);
            maxDepthHelper(root.right, depth + 1);
        }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        maxDepthHelper(root, 0);
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        System.out.println(maxDepth(root));
    }
}
