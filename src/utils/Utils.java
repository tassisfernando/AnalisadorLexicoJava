package utils;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Utils {

    public static List<String> getStringList(String text, String regex) {
        String[] strArray = text.split(regex);
        List<String> list = asList(strArray);
        List<String> returnList = new ArrayList<>(list);

        returnList.removeIf(String::isEmpty);

        return returnList;
    }
}
