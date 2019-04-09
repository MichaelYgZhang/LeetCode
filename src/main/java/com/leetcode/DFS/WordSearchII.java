package com.leetcode.DFS;

import java.util.*;

/**
 * https://leetcode.com/problems/word-search-ii/
 * Given words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 */
public class WordSearchII {
    public static List<String> findWords(char[][] boards, String[] words) {
        Set<String> result = new HashSet<>();
        if (boards.length == 0 || words.length == 0) {
            return Collections.EMPTY_LIST;
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (WordSearch.exist(boards, word)){
                result.add(word);
            }
        }
        return new ArrayList<>(result);
    }


    //上，左，下，右
    static Point[] points = {new Point(-1, 0, 1), new Point(0, -1, 1), new Point(1, 0, 1), new Point(0, 1, 1)};

    public static List<String> findWords2(char[][] boards, String[] words) {
        Set<String> result = new HashSet<>();
        if (boards.length == 0 || words.length == 0) {
            return Collections.EMPTY_LIST;
        }
        int m = boards.length, n = boards[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
//            if (WordSearch.exist(boards, word)) {
//                result.add(word);
//            }
            if (exist(boards, word)){
                result.add(word);
            }
//            List<Point> points = getPoint(word.toCharArray(), boards);
//            for (Point p : points) {
//                if (dfs(boards, visited, p, 0, word)) {
//                    result.add(word);
//                }
//                if (dfsSearch(p, word.toCharArray(), boards)) {
//                    result.add(word);
//                }

//            }
        }
        return new ArrayList<>(result);
    }

    public static boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, new Point(i, j, 0), 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Point> getPoint(char[] c, char[][] boards) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[0].length; j++) {
                if (c[0] == boards[i][j]) {
                    Point cur = new Point(i, j, 0);
                    points.add(cur);
                }
            }
        }
        return points;
    }

    private static boolean dfs(char[][] board, boolean[][] visited, Point p, int len, String word) {
        int x = p.i;
        int y = p.j;
        if (len == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        if (visited[x][y]) return false;
        if (board[x][y] != word.charAt(len)) return false;
        visited[x][y] = true;
        for (Point point : points) {
            Point next = p.add(point);
            if (dfs(board, visited, next, len + 1, word)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }


    public static boolean dfsSearch(Point cur, char[] source, char[][] boards) {
        Stack stack = new Stack();
        stack.push(cur);
        int[][] tempRecord = new int[boards.length][boards[0].length];
        for (int i = 0; i < tempRecord.length; i++) {
            for (int j = 0; j < tempRecord[i].length; j++) {
                tempRecord[i][j] = -1;
            }
        }
        while (!stack.isEmpty()) {
            Point curTemp = (Point) stack.pop();
            System.out.println("point:" + curTemp.i + "-" + curTemp.j + ", len:" + curTemp.len);
            char currChar = boards[curTemp.i][curTemp.j];
            if (curTemp.len < source.length && source[curTemp.len] == currChar && tempRecord[curTemp.i][curTemp.j] == -1) {
                boolean flag = false;
                for (int k = 0; k < points.length; k++) {
                    Point next = curTemp.add(points[k]);
                    if (next.at(boards) == null || tempRecord[next.i][next.j] == 1) {
                        continue;
                    }
                    if (next.len < source.length && source[next.len] == boards[next.i][next.j]) {
                        stack.push(next);
                        flag = true;
                    }
                }
                if (flag) {
                    tempRecord[curTemp.i][curTemp.j] = 1;
                }
            }
            if (curTemp.len + 1 == source.length) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] boards1 = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words1 = {"oath", "pea", "eat", "rain"};
//        char[][] boards = {{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}};
//        ["abcdefg","befa","eaabcdgfa","gfedcbaaa"]
//        String[] words = {"eaabcdgfa"};
//        char[][] boards = {{'a'}, {'a'}};
//        String[] words = {"aaa"};
        char[][] boards = {
                {'b', 'a', 'a', 'b', 'a', 'b'},
                {'a', 'b', 'a', 'a', 'a', 'a'},
                {'a', 'b', 'a', 'a', 'a', 'b'},
                {'a', 'b', 'a', 'b', 'b', 'a'},
                {'a', 'a', 'b', 'b', 'a', 'b'},
                {'a', 'a', 'b', 'b', 'b', 'a'},
                {'a', 'a', 'b', 'a', 'a', 'b'}
        };
//["bbaabaabaaaaabaababaaaaababb","aabbaaabaaabaabaaaaaabbaaaba","babaababbbbbbbaabaababaabaaa","bbbaaabaabbaaababababbbbbaaa","babbabbbbaabbabaaaaaabbbaaab","bbbababbbbbbbababbabbbbbabaa","babababbababaabbbbabbbbabbba","abbbbbbaabaaabaaababaabbabba","aabaabababbbbbbababbbababbaa","aabbbbabbaababaaaabababbaaba","ababaababaaabbabbaabbaabbaba","abaabbbaaaaababbbaaaaabbbaab","aabbabaabaabbabababaaabbbaab","baaabaaaabbabaaabaabababaaaa","aaabbabaaaababbabbaabbaabbaa","aaabaaaaabaabbabaabbbbaabaaa","abbaabbaaaabbaababababbaabbb","baabaababbbbaaaabaaabbababbb","aabaababbaababbaaabaabababab","abbaaabbaabaabaabbbbaabbbbbb","aaababaabbaaabbbaaabbabbabab","bbababbbabbbbabbbbabbbbbabaa","abbbaabbbaaababbbababbababba","bbbbbbbabbbababbabaabababaab","aaaababaabbbbabaaaaabaaaaabb","bbaaabbbbabbaaabbaabbabbaaba","aabaabbbbaabaabbabaabababaaa","abbababbbaababaabbababababbb","aabbbabbaaaababbbbabbababbbb","babbbaabababbbbbbbbbaabbabaa"]
//["aabbbbabbaababaaaabababbaaba","abaabbbaaaaababbbaaaaabbbaab","ababaababaaabbabbaabbaabbaba"]
        String[] words = {"aabbbbabbaababaaaabababbaaba"};
        final List<String> search = findWords(boards, words);
//        List<String> search = findWords(boards, words);
        for (String s : search) {
            System.out.println(s);
        }

        final List<String> search1 = findWords(boards1, words1);
        for (String s : search1) {
            System.out.println(s);
        }
    }


    public static List<String> findWords1(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        System.out.println("i, j;" + i + "," + j);
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) {
                    p.next[i] = new TrieNode();
                }
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }
}

class Point {
    int i, j, len;

    Point(int i, int j) {
        this.i = i;
        this.j = j;
    }

    Point(int i, int j, int len) {
        this.i = i;
        this.j = j;
        this.len = len;
    }

    Point add(Point point) {
        return new Point(this.i + point.i, this.j + point.j, this.len + point.len);
    }

    Point at(char[][] grid) {
        if (this.i < 0 || this.i > grid.length - 1) {
            return null;
        }
        if (this.j < 0 || this.j > grid[0].length - 1) {
            return null;
        }
        return this;
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    String word;
}
