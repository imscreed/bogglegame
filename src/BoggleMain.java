public class BoggleMain {

    private static final String INPUT = "input.txt";

    public static void main(String[] args) {
        Utils utils = new Utils();
        BoggleFile boggleFile = utils.readFile(INPUT);
        if(boggleFile == null){
            System.out.println("Invalid File. (File is not equal to the given specification)");
        } else{
            System.out.println(boggleFile.toString());
        }

    }
}
