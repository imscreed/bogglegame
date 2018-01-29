import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solver {
    public List<String> solve(char[][] board, List<String> words) {
        System.out.println("Building trie from dictionary.....");
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        StringBuffer buff = new StringBuffer();
        Set<String> result = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                traverse(board, trie, i, j, buff, visited, result, board[0].length);
            }
        }
        return new ArrayList<>(result);
    }

    private void traverse(char[][] board, Trie trie , int i, int j, StringBuffer buff, Set<Integer> visited, Set<String> result, int col ) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
            return;
        }

        int val = i*col + j;

        if (visited.contains(val)) {
            return;
        }

        buff.append(board[i][j]);
        String str = buff.toString();
        if(!trie.startsWith(str)) {
            buff.deleteCharAt(buff.length() - 1);
            return;
        }
        visited.add(val);

        if(trie.contains(str)) {
            result.add(buff.toString());
        }

        //Up, Down, Left, Right
        traverse(board, trie, i + 1, j, buff, visited, result, col);
        traverse(board, trie, i, j + 1, buff, visited, result, col);
        traverse(board, trie, i, j - 1, buff, visited, result, col);
        traverse(board, trie, i - 1, j, buff, visited, result, col);


        //Diagonal
        traverse(board, trie, i + 1, j - 1, buff, visited, result, col);
        traverse(board, trie, i + 1, j + 1, buff, visited, result, col);
        traverse(board, trie, i - 1, j - 1, buff, visited, result, col);
        traverse(board, trie, i - 1, j + 1, buff, visited, result, col);

        buff.deleteCharAt(buff.length() - 1);
        visited.remove(val);
    }
}
