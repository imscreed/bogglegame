public class ScoreBoard {
    private static int score = 0;

    public void calculateScore(String word){
        switch (word.length()){
            case 1: score += 0; break;
            case 2: score += 0; break;
            case 3: score += 1; break;
            case 4: score += 1; break;
            case 5: score += 2; break;
            case 6: score += 3; break;
            case 7: score += 5; break;
            default:score += 11; break;
        }
//        System.out.println(score);
    }

    public static int getScore() {
        return score;
    }
}
