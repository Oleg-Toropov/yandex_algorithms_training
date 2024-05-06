package Yandex_internship_2024_1; // НЕ КОПИРОВАТЬ
//////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        sc.close();

        Pattern pattern = Pattern.compile("[a-z]+\\s*,?");
        Matcher matcher = pattern.matcher(data);

        List<String> parts = new ArrayList<>();
        while (matcher.find()) {
            String match = matcher.group();
            if (match.endsWith(",") && match.contains(" ")) {
                match = match.replace(" ", "");
            }
            parts.add(match.trim());
        }

        int maxLengthWord = 0;
        for (String part : parts) {
            if (part.contains(",")) {
                maxLengthWord = Math.max(maxLengthWord, part.length() - 1);
            } else {
                maxLengthWord = Math.max(maxLengthWord, part.length());
            }
        }

        int lengthLine = maxLengthWord * 3;

        StringBuilder line = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < parts.size(); i++) {
            String part = parts.get(i);

            if (line.length() + part.length() <= lengthLine) {
                line.append(part);

                if (i != parts.size() - 1) {
                    line.append(" ");
                }

            } else {
                line.setLength(line.length() - 1); // delete " "
                result.append(line.toString()).append("\n");

                line = new StringBuilder(part);

                if (i != parts.size() - 1) {
                    line.append(" ");
                }
            }
        }

        if (!line.isEmpty()) {
            result.append(line.toString());
        }

        System.out.println(result.toString());
    }
}
