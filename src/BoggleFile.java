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

    public List<String> getJumbledCharacterList() {
        return jumbledCharacterList;
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
