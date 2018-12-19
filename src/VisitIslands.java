public class VisitIslands {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int l1 = grid.length;
        int l2 = grid[0].length;
        boolean[][] marked = new boolean[l1][l2];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1' && !marked[i][j]){
                    markIsland(marked, grid, i ,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void markIsland(boolean[][] marked, char[][] grid, int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || marked[i][j] || grid[i][j] == '0'){
            return;
        }
        marked[i][j] = true;
        markIsland(marked, grid, i+1,j);
        markIsland(marked, grid, i-1,j);
        markIsland(marked, grid, i,j+1);
        markIsland(marked, grid, i,j-1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = " ";
//        int[] input = new int[]{7,1,5,3,6,4};
        char[][] input = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
//        boolean[] b = new boolean[5];
//        String[] input = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        int input = 3;

//        TreeNode node = new Solution.TreeNode(1);
//        node.left = new Solution.TreeNode(2);
//        node.right = new Solution.TreeNode(3);
//        node.left.right = new Solution.TreeNode(5);
//        node.right.left = new Solution.TreeNode(15);

//        ListNode node = new ListNode(3);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(0);
//        node.next.next.next = new ListNode(-4);
//        node.next.next.next.next = node.next;
        System.out.println(s.numIslands(input));
    }
}
