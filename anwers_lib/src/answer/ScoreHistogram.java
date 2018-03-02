package answer;
import java.util.*;

public class ScoreHistogram implements IStatistic {

    List<Integer> scores;

    public ScoreHistogram() {
        scores = new ArrayList<>();
    }

    public void apply(CardSet answers) {
        scores = answers.checkSet();
    }

    public void printResult() {
        Collections.sort(scores);
        Set<Integer> uniqueSet = new HashSet<>(scores);
        for (Integer temp : uniqueSet) {
            System.out.println(temp + ": " + Collections.frequency(scores, temp));
        }

    }
}
