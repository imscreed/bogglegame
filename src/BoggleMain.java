import java.util.Arrays;
import java.util.List;

public class BoggleMain {

    private static final String INPUT = "input.txt";

    public static void main(String[] args) {
        System.out.println("Reading input file and building Boogle board.....");
        Utils utils = new Utils();
        BoggleFile boggleFile = utils.readFile(INPUT);
        if(boggleFile == null){
            System.out.println("Invalid File. (File is not equal to the given specification)");
        } else{
            System.out.println(boggleFile.toString());
        }
        assert boggleFile != null;
        System.out.println(Arrays.deepToString(boggleFile.getBoard()));


        List<String> result = new Solver().solve(boggleFile.getBoard(), utils.importDictionary());
        ScoreBoard scoreBoard = new ScoreBoard();
        result.forEach(s -> {
            scoreBoard.calculateScore(s);
            System.out.println(s);
        });
        System.out.println("Total score on Board: "+ ScoreBoard.getScore());

    }
}
