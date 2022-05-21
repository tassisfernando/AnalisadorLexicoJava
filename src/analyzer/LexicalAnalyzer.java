package analyzer;

import analyzer.impl.AlphabetAnalyzer;
import analyzer.impl.LexemeAnalyzer;
import analyzer.impl.StopWordsAnalyzer;
import utils.Utils;

import java.io.FileNotFoundException;
import java.util.List;

import static java.util.Arrays.asList;

public class LexicalAnalyzer  {

    private final String userMessage;
    private List<String> userMessageList;
    private final List<Analyzer> analyzers;

    public LexicalAnalyzer(String userMessage) throws FileNotFoundException {
        this.userMessage = userMessage;
        this.analyzers = asList(
                new AlphabetAnalyzer(),
                new StopWordsAnalyzer(),
                new LexemeAnalyzer()
        );
    }

    public void analyze() {
        this.userMessageList = Utils.getStringList(this.userMessage, " ");
        analyzers.forEach(analyzer -> this.userMessageList = analyzer.analyze(userMessageList));
    }

    public String printTokens() {
        return userMessageList.toString();
    }
}
