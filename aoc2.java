package com.adventOfCode;

import java.util.ArrayList;
import java.util.Scanner;

public class aoc2 {
    public static void main(String[] args) {
        int n = 1000;
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        while (n > 0) {
            l1.add(sc.nextInt());
            l2.add(sc.nextInt());
            n--;
        }

        System.out.println(findSimilarityScore(l1, l2));

    }

    public static int findSimilarityScore(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        int ans = 0;

        for (int i = 0; i < l1.size(); i++) {
            int num = l1.get(i);
            int count = 0;
            for (int j = 0; j < l2.size(); j++) {
                if (l2.get(j) == num) {
                    count++;
                }
            }

            ans += num * count;
        }

        return ans;
    }
}
