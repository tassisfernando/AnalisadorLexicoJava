import analyzer.LexicalAnalyzer;
import exception.AnalyzerException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {
        try {
            File f = new File("input.txt");
            Scanner s = new Scanner(f);
            StringBuilder message = new StringBuilder(" ");
            while (s.hasNext()) {
                message.append(s.nextLine()).append("\n");
            }

            LexicalAnalyzer analyzer = new LexicalAnalyzer(message.toString());
            analyzer.analyze();
            System.out.println("Lista de tokens: " + analyzer.printTokens());
            System.out.println("Tabela de símbolos inicial: " + analyzer.printSymbolList());
        } catch (FileNotFoundException e) {
            String msg = format("Exceção: %s", e.getMessage());
            printException(msg);
        } catch (AnalyzerException e) {
            String msg = format(e.getMessage(), e.getWords());
            printException(msg);
        }
    }

    public static void printException(String msg) {
        System.out.println(msg);
        System.exit(1);
    }
}
