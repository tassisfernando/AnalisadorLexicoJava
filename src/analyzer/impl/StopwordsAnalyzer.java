package analyzer.impl;

import analyzer.Analyzer;

import java.util.List;

public class StopwordsAnalyzer implements Analyzer {

    @Override
    public List<String> analyze(List<String> source) {
        return source;
    }
}
