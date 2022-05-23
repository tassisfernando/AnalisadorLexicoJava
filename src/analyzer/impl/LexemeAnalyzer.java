package analyzer.impl;

import analyzer.Analyzer;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LexemeAnalyzer implements Analyzer {

    private Map<String, String> vocabulary;

    public LexemeAnalyzer() throws FileNotFoundException {
        init();
    }

    private void init() throws FileNotFoundException {
        File f = new File("vocabulary_ptbr.txt");
        Scanner s = new Scanner(f);
        StringBuilder stopWordsString = new StringBuilder(" ");
        while (s.hasNext()) {
            stopWordsString.append(s.nextLine().toUpperCase()).append("\n");
        }
        this.vocabulary = Utils.getStringMap(stopWordsString.toString(), "\n");
    }

    @Override
    public List<String> analyze(List<String> words) {
        return words.stream().map(this::validLexeme).collect(Collectors.toList());
    }

    private String validLexeme(String word) {
        String parsedWord = word;
        return parsedWord;
    }
}
