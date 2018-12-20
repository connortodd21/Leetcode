public class search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if(i == matrix.length-1 || matrix[0].length == 1){
                //on last row
                for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
            else if(matrix[i][0] <= target && target <= matrix[i][matrix[0].length-1]){
                for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean searchMatrixn2(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int i = matrix.length-1;
        int j = 0;
        while (i >= 0  && j < matrix[0].length){
            if(target < matrix[i][j]){
                i--;
            }
            else if(target > matrix[i][j]){
                j++;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        String input = " ";
//        int[] input = new int[]{7,1,5,3,6,4};
//        int[][] input = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        int[][] input = {{2,5}, {2,8}, {7,9}};
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
        System.out.println(s.searchMatrix(input, 5));
    }
}
