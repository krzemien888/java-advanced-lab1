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
        Set<Integer> uniqueSet = new HashSet<>(scores);
        Map<Integer, Integer> histMap = new TreeMap<>();
        for (Integer temp : uniqueSet) {
            histMap.put(temp,Collections.frequency(scores, temp));
        }
        
        for(Map.Entry<Integer, Integer> entry : histMap.entrySet()) {
        	System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
