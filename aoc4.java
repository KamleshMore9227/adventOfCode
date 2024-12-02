package com.adventOfCode;

import java.util.Scanner;

public class aoc4 {
    public static void main(String[] args) {
        int ans = 0;

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                break;
            }

            String[] parts = line.split(" ");
            int[] report = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                report[i] = Integer.parseInt(parts[i]);
            }

            boolean isSafe = isReportSafe(report);

            if (isSafe) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    //
    public static boolean isReportSafe(int[] report) {
        for (int i = 0; i < report.length; i++) {
            int[] temp = new int[report.length - 1];

            System.arraycopy(report, 0, temp, 0, i);
            System.arraycopy(report, i + 1, temp, i, report.length - i - 1);

            if (isSortedAscending(temp) || isSortedDescending(temp)) {
                return true;
            }
        }

        return isSortedAscending(report) || isSortedDescending(report);
    }

    private static boolean isSortedAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSortedDescending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff > -1 || diff < -3) {
                return false;
            }
        }
        return true;
    }
}















