import java.util.ArrayList;
import java.util.List;

public class BoggleFile {
    private int rows;
    private int columns;
    private List<String> jumbledCharacterList = new ArrayList<>();

    public BoggleFile(int rows, int columns, List<String> jumbledCharacterList) {
        this.rows = rows;
        this.columns = columns;
        this.jumbledCharacterList = jumbledCharacterList;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public char[][] getBoard() {
        char[] board1D;
        StringBuilder temp = new StringBuilder();
        for (String s: jumbledCharacterList){
            temp.append(s);
        }
        board1D = temp.toString().toCharArray();
        return get2DBoard(board1D);
    }

    private char[][] get2DBoard(char[] board1D) {
        char[][] board2D = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int k = i * columns + j;
                board2D[i][j] = board1D[k];
            }
        }
        return board2D;
    }

    public void setJumbledCharacterList(List<String> jumbledCharacterList) {
        this.jumbledCharacterList = jumbledCharacterList;
    }

    @Override
    public String toString() {
        return "BoggleFile{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", jumbledCharacterList=" + jumbledCharacterList +
                '}';
    }
}
