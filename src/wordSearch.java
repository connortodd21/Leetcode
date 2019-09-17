public class wordSearch {

    public boolean[][] deepCopy(boolean[][] visited) {
        boolean[][] result = new boolean[visited.length][];
        for (int r = 0; r < visited.length; r++) {
            result[r] = visited[r].clone();
        }
        return result;
    }

    public boolean dfs (char[][] board, String word, boolean[][] visited, int i, int j){
        if (word.length() == 0){
            return true;
        }
        if (j < 0 || i < 0 || j >= board[0].length || i >= board.length || visited[i][j] || board[i][j] != word.charAt(0)){
            return false;
        }
        visited[i][j] = true;
        word = word.substring(1);
        return (
                dfs(board, word, deepCopy(visited), i+1, j)
                || dfs(board,word,deepCopy(visited), i-1, j)
                || dfs(board, word, deepCopy(visited), i, j+1)
                || dfs(board, word,deepCopy(visited),i, j-1)
        );
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, new boolean[board.length][board[0].length], i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        wordSearch w = new wordSearch();
        System.out.println(w.exist(new char[][]{{'A', 'B', 'C', 'E'},{'S', 'F', 'E', 'S'},{'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
        /*
            A B C E
            S F E S
            A D E E
         */
    }

}
