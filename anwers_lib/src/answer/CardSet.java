package answer;
import java.util.ArrayList;
import java.util.List;

public class CardSet {
    private AnswerCard answer_key;
    private ArrayList<AnswerCard> answers;

    public CardSet() {
        answers = new ArrayList<>();
    }

    public void setAnswerKey(AnswerCard key){
        answer_key = key;
    }

    public void addAnswerCard(AnswerCard answer){
        answers.add(answer);
    }

    public void addAnswerCard(List<AnswerCard> answers) {
        this.answers.addAll(answers);
    }

    public List<Integer> checkSet() {
        List<Integer> scores = new ArrayList<>();
        for(AnswerCard answer : answers) {
            float tmp  = answer.checkAnswers(answer_key);
            scores.add((int)(tmp*100));
        }

        return scores;
    }
}
