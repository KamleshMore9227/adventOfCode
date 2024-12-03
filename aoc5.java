package com.adventOfCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class aoc5 {
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

        String regex = "mul\\((\\d{1,3}),\\s*(\\d{1,3})\\)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inputString);

        int ans = 0;

        while (m.find()) {
            int num1 = Integer.parseInt(m.group(1));
            int num2 = Integer.parseInt(m.group(2));
            ans += num1 * num2;
        }

        System.out.println("Total Multiplication Result: " + ans);
    }
}
