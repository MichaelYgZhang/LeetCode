package com.leetcode.DFS;

/**
 * https://leetcode.com/problems/word-search-ii/
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    /**
     *         (0,-1)
     *  (-1,0) (0,0)  (1,0)
     *         (0,1)
     */
    static Point[] points = {new Point(1, 0), new Point(-1, 0), new Point(0, -1), new Point(0, 1)};

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, new Point(i, j), 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, Point p, int len, String word) {
        int m = board.length, n = board[0].length;
        if (len == word.length()) {
            return true;
        }
        if (p.i < 0 || p.i >= m || p.j < 0 || p.j >= n) {
            return false;
        }
        if (visited[p.i][p.j]) {
            return false;
        }
        if (board[p.i][p.j] != word.charAt(len)) {
            return false;
        }
        visited[p.i][p.j] = true;
        for (Point point : points) {
            Point next = p.add(point);
            if (dfs(board, visited, next, len + 1, word)) {
                return true;
            }
        }
        visited[p.i][p.j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] boards = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
//        Given word = "ABCCED", return true.
//                * Given word = "SEE", return true.
//                * Given word = "ABCB", return false.
        System.out.println(exist(boards, "ABCCED"));
    }

}