package ua.lviv.iot;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {

    private HashMap<Integer, String> mapNumbersLetters = new HashMap<Integer, String>();

    public static String readInputText() {
        String text;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text:");
            text = scanner.nextLine();
        }
        return text;
    }

    public StringProcessor() {
        mapNumbersLetters.put(1, " A ");
        mapNumbersLetters.put(2, " B ");
        mapNumbersLetters.put(3, " C ");
        mapNumbersLetters.put(4, " D ");
        mapNumbersLetters.put(5, " E ");
        mapNumbersLetters.put(6, " F ");
        mapNumbersLetters.put(7, " G ");
        mapNumbersLetters.put(8, " H ");
        mapNumbersLetters.put(9, " I ");
    }

    public String processString() throws NullPointerException {

        String text = readInputText();
        for (int number : mapNumbersLetters.keySet()) {
            Pattern pattern = Pattern.compile("((\\s)" + number + "(\\s))|((\\s)" + number + "(\\p{Punct" + "}))|" + number + "(\\s)");
            Matcher matcher = pattern.matcher(text);
            text = matcher.replaceAll(mapNumbersLetters.get(number));
        }
        return text;
    }

    public void showResult(final String result) throws NullPointerException {
        if (null == result) System.err.println("Something went wrong!");
        else {
            System.out.println(result);
        }
    }
}