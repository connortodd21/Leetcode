public class multiplyAllExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        for (int i = nums.length -2; i >= 0 ; i--) {
            right[i] = right[i+1] * nums[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            products[i] = right[i] * left[i];
        }
        return products;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = " ";
        int[] input = new int[]{7,1,5,3,6,4};
//        char[][] input = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 10;

//        TreeNode node = new Solution.TreeNode(1);
//        node.left = new Solution.TreeNode(2);
//        node.right = new Solution.TreeNode(3);
//        node.left.right = new Solution.TreeNode(5);
//        node.right.left = new Solution.TreeNode(15);

//        ListNode node = new ListNode(3);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(2);
//        node.next.next.next = new ListNode(3);
        System.out.println(s.productExceptSelf(input));
    }
}
