package answer;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnswerCardLoader {

    public ArrayList<AnswerCard> loadAnswers(String dirPath){
        final File folder = new File(dirPath);
        ArrayList<AnswerCard> loaded_answers = new ArrayList<>();

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                List<Answer> inputList = new ArrayList<>();
                try{
                    InputStream inputFS = new FileInputStream(fileEntry);
                    BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
                    // skip the header of the csv
                    inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
                    br.close();
                } catch (IOException e) {
                    System.out.println("Something went wrong while reading files");
                }

                loaded_answers.add(new AnswerCard(inputList));
            }
        }

        return loaded_answers;
    }

    public AnswerCard loadAnswerKey(String filepath) {
        final File fileEntry = new File(filepath);
        AnswerCard correctAnswers = null;
        try{
            InputStream inputFS = new FileInputStream(fileEntry);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
            correctAnswers = new AnswerCard(br.lines().skip(1).map(mapToItem).collect(Collectors.toList()));
            br.close();
        } catch (IOException e) {
            System.out.println("Something went wrong while reading files");
        }

        return correctAnswers;
    }

    private Function<String, Answer> mapToItem = (line) -> new Answer(line.split(";"));
}
