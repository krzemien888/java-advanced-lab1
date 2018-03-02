package answer;
import java.util.List;

public class AnswerCard {
    private List<Answer> answers;

    public AnswerCard(List<Answer> answers) {
        this.answers = answers;
    }

    public String getAnswer(int question_number) {
        return String.join(", ", answers.get(question_number).getAnswer());
    }

    public String getAnswers() {
        StringBuilder bulider = new StringBuilder();

        for(Answer answer : answers) {
            bulider.append(String.join(", ", answer.getAnswer()));
            bulider.append('\n');
        }

        return bulider.toString();
    }

    public int getSize() {
        return answers.size();
    }

    public float checkAnswers(AnswerCard answerKey) {
        int correctAnswers = 0;
        for(int i = 0; i < answerKey.getSize(); i++) {
            if (getAnswer(i).equals(answerKey.getAnswer(i))) {
                correctAnswers++;
            }
        }

        return ((float)correctAnswers/(float)getSize());
    }
}