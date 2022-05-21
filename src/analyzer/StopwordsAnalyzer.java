package analyzer;

import java.util.ArrayList;
import java.util.List;

public class StopwordsAnalyzer implements Analyzer {

    @Override
    public List<String> analyze(List<String> source) {
        return source;
    }
}
