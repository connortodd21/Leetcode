public class rotate {
    /*
        Rotate an array k times
     */
    public void rotateK(int[] nums, int k) {
        for (int i = 0; i < k; i++) {

            int temp = nums[nums.length - 1];
            int j;
            for (j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;

        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void rotate(int [][] matrix){
        for (int i = 0; i < matrix[0].length / 2; i++) {
            for (int j = i; j < matrix.length-i-1; j++) {
                //1 -> temp
                int temp = matrix[i][j];
                //bottom to left
                matrix[i][j] = matrix[matrix[0].length - j -1][i];
                //right to bottom
                matrix[matrix[0].length - j -1][i] = matrix[matrix[0].length - i -1][matrix[0].length - j -1];
                //top to right
                matrix[matrix[0].length - i -1][matrix.length - j -1] = matrix[j][matrix[0].length - i -1];
                //left to top
                matrix[j][matrix[0].length - i -1] = temp;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        rotate r = new rotate();
        int[][] input = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        r.rotate(input);
    }
}
