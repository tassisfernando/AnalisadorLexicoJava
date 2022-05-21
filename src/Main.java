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
            System.out.println(analyzer.printTokens());
        } catch (FileNotFoundException | AnalyzerException e) {
            String aux = format("Exceção: %s", e.getMessage());
            printException(aux, -1, -1);
        }
    }

    public static void printException(String msg, int row, int pos) {
        if (pos > 0 && row > 0) {
            System.out.printf("%s na linha %d, posição %d\n", msg, row, pos);
        } else {
            System.out.println(msg);
        }
        System.exit(1);
    }
}
