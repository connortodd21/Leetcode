public class uniquePath {

    public static int uniquePaths(int m, int n) {
        int grid[][] = new int[m][n];
        System.out.println(grid.length);
        if(m == 1 || n == 1){
            return 1;
        }
        grid[0][0] = 0;
        for (int i = 1; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            grid[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }

    public static int uniquePaths2(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int grid[][] = new int[m][n];
        if(obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        if(m == 1 || n == 1){
            if(obstacleGrid[0][0] == 1){
                return 0;
            }
            return 1;
        }
        grid[0][0] = 0;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 1){
                break;
            }
            grid[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            if (obstacleGrid[0][i] == 1){
                break;
            }
            grid[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1){
                    grid[i][j] = 0;
                }
                else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(new int[][]{{0}, {1}}));
    }
}

/*

0 0 0 1 0
0 0 0 0 0
1 0 1 0 0
0 0 0 0 0

0 1 1 0 0
1 2 3 3 3
0 2 0 3 6
0

 */