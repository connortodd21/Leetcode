import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraverse {
    public List<List<Integer>> levelOrder(Solution.TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> levelNodes = new ArrayList<>();
        Queue<Solution.TreeNode> current =new LinkedList<>();
        Queue<Solution.TreeNode> next = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()){
            Solution.TreeNode node = current.remove();
            if(node.right != null){
                next.add(node.right);
            }
            if(node.left != null){
                next.add(node.left);
            }
            levelNodes.add(node.val);
            if(current.isEmpty()){
                //move to next
                //reset all temp objects
                current = next;
                next = new LinkedList<>();
                ret.add(levelNodes);
                levelNodes = new ArrayList<>();
            }
        }
        return ret;
    }




    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] input = new int[]{1,2,3,4};
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 3;
        Solution.TreeNode node = new Solution.TreeNode(3);
        node.left = new Solution.TreeNode(20);
        node.right = new Solution.TreeNode(9);
        node.right.right = new Solution.TreeNode(7);
        node.right.left = new Solution.TreeNode(15);
        System.out.println(s.levelOrder(node));
    }
}
