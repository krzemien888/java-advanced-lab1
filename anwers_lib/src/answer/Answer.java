package answer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Answer {
    public List<String> answers;

    public Answer(String[] answers){
        this.answers = new ArrayList<>(Arrays.asList(answers));
    }

    public List<String> getAnswer() {
        return answers;
    }

    public int getSize() {
        return answers.size();
    }
}
