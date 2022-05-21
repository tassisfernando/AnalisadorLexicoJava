package analyzer;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class LexicalAnalyzer  {

    private final String userMessage;
    private List<String> userMessageList;
    private final List<Analyzer> analyzers;

    public LexicalAnalyzer(String userMessage) {
        this.userMessage = userMessage;
        this.analyzers = asList(
                new AlphabetAnalyzer(),
                new StopwordsAnalyzer(),
                new LexemeAnalyzer()
        );
    }

    public void analyze() {
        this.userMessageList = getStringList(this.userMessage);
        analyzers.forEach(analyzer -> this.userMessageList = analyzer.analyze(userMessageList));
    }

    private List<String> getStringList(String text) {
        String[] strArray = text.split(" ");
        List<String> list = asList(strArray);
        List<String> returnList = new ArrayList<>(list);

        returnList.removeIf(String::isEmpty);

        return returnList;
    }

    public String printTokens() {
        return userMessageList.toString();
    }
}
