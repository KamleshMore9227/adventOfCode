package com.adventOfCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class aoc1 {
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

        System.out.println(findDifferenceBetweenLists(l1, l2));

    }

    public static int findDifferenceBetweenLists(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        Collections.sort(l1);
        Collections.sort(l2);
        int distance = 0;

        for (int i = 0; i < l1.size(); i++) {
            distance += Math.abs(l1.get(i) - l2.get(i));
        }

        return distance;
    }
}
