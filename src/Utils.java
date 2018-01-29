import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private List<String> lines;

    public BoggleFile readFile(String fileName){
        try {
            lines = Files.readAllLines(Paths.get(fileName));
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**Setup a Boggle file with Rows, Columns and the characters*/
        String rc = lines.get(0).trim();
        rc = rc.replace(" ", "");
        if(rc.length() < 2) return null;

        int rows = Integer.parseInt(String.valueOf(rc.charAt(0)));
        int columns = Integer.parseInt(String.valueOf(rc.charAt(1)));


        //If rows and columns are not equal then the inout file is invalid
        if(rows != columns) return null;

        List<String> result = lines.stream()
                .skip(1)
                .map(s -> {
                    s = s.replace(" ", "");
                    return s.toLowerCase();
                })
                .collect(Collectors.toList());

        return new BoggleFile(rows, columns, result);
    }
}
