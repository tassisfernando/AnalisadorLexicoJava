package analyzer.impl;

import analyzer.Analyzer;

import java.util.List;

public class AlphabetAnalyzer implements Analyzer {

    @Override
    public List<String> analyze(List<String> source) {
        return source;
    }
}