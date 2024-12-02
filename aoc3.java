package com.adventOfCode;

import java.util.Scanner;

public class aoc3 {

    public static void main(String[] args) {
        int ans = 0;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;

            String[] parts = line.split(" ");
            int[] report = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                report[i] = Integer.parseInt(parts[i]);
            }

            boolean x = isReportSafeAscending(report);
            boolean y = isReportSafeDescending(report);
            if (isReportSafe(x, y)) {
                ans++;
            }

        }

        System.out.println(ans);
    }


    public static boolean isReportSafeAscending(int[] report) {
        for (int i = 0; i < report.length - 1; i++) {
            if (report[i] > report[i + 1]) {
                return false;
            } else {
                int diff = report[i + 1] - report[i];
                if (diff < 1 || diff > 3) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isReportSafeDescending(int[] report) {
        for (int i = 0; i < report.length - 1; i++) {
            if (report[i] < report[i + 1]) {
                return false;
            } else {
                int diff = report[i] - report[i + 1];
                if (diff < 1 || diff > 3) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isReportSafe(boolean x, boolean y) {
        return x || y;
    }
}
