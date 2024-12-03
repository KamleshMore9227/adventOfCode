package com.adventOfCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aoc6 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder inputString = new StringBuilder();
        try {
            String line;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                inputString.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
            return;
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.err.println("Error closing BufferedReader: " + e.getMessage());
            }
        }

        String regexMul = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
        String regexDo = "do\\(\\)";
        String regexDont = "don't\\(\\)";

        Pattern patternMul = Pattern.compile(regexMul);
        Matcher matcherMul = patternMul.matcher(inputString);

        Pattern patternDo = Pattern.compile(regexDo);
        Pattern patternDont = Pattern.compile(regexDont);

        int ans = 0;
        boolean multiplyEnabled = true;
        int currentIndex = 0;

        while (matcherMul.find()) {
            while (currentIndex <= matcherMul.start()) {
                Matcher matcherDo = patternDo.matcher(inputString.substring(currentIndex, matcherMul.start()));
                Matcher matcherDont = patternDont.matcher(inputString.substring(currentIndex, matcherMul.start()));

                if (matcherDo.find()) {
                    multiplyEnabled = true;
                }
                if (matcherDont.find()) {
                    multiplyEnabled = false;
                }
                currentIndex = matcherMul.start() + 1;
            }

            if (multiplyEnabled) {
                int num1 = Integer.parseInt(matcherMul.group(1));
                int num2 = Integer.parseInt(matcherMul.group(2));
                ans += num1 * num2;
            }
        }

        System.out.println("Total Multiplication Result: " + ans);  //89798695
    }
}
