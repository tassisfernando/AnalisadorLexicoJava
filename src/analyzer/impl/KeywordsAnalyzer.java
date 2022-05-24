package analyzer.impl;

import analyzer.Analyzer;
import utils.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KeywordsAnalyzer implements Analyzer {

    private List<String> keywords;
    private LexemeAnalyzer lexemeAnalyzer;

    public KeywordsAnalyzer() throws FileNotFoundException {
        init();
    }

    private void init() throws FileNotFoundException {
        File f = new File("keywords_ptbr.txt");
        Scanner s = new Scanner(f);
        StringBuilder stopWordsString = new StringBuilder(" ");
        while (s.hasNext()) {
            stopWordsString.append(s.nextLine().toLowerCase()).append("\n");
        }
        this.keywords = Utils.getStringList(stopWordsString.toString(), "\n");
        lexemeAnalyzer = new LexemeAnalyzer();
        this.keywords = lexemeAnalyzer.analyze(keywords);
    }

    @Override
    public List<String> analyze(List<String> words) {
        List<String> symbolList = new ArrayList<>();
        words.forEach(word -> {
            if(!keywords.contains(word)) {
                symbolList.add(word);
            }
        });
        return symbolList;
    }
}
