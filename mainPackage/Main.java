/*
- wczytanie z dysku plików csv z kartami egzaminacyjnymi i klucza odpowiedzi
- klasy kart, zestawów i statystyk (w jar)
- wczytać jar i użyć
- dokumentacja javadoc (mają być)
-

za tydzień aplikacja okienkowa (ikonki lewy górny róg)
techniki aplikacji wielojęzykowych (np c++) i lokalizacja


*/


import java.util.List;

import answer.AnswerCard;
import answer.AnswerCardLoader;
import answer.CardSet;
import answer.IStatistic;
import answer.ScoreHistogram;

public class Main {
    public static void main(String[] args) {
        AnswerCardLoader loader = new AnswerCardLoader();
        List<AnswerCard> cards = loader.loadAnswers("D:\\java\\odpowiedzi");
        AnswerCard answerKey = loader.loadAnswerKey("D:\\java\\klucz.csv");

        CardSet set = new CardSet();
        set.addAnswerCard(cards);
        set.setAnswerKey(answerKey);

        IStatistic stat = new ScoreHistogram();

        stat.apply(set);
        stat.printResult();
    }
}
