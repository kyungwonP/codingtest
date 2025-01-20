package com.codingtest.session1;

import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        Part1 part1 = new Part1();
        Scanner in = new Scanner(System.in);
        String input1 = in.next().toUpperCase();
        String input2 = in.next().toUpperCase();
        char ch = input2.charAt(0);

        long count = part1.getMatchCount(input1, ch);

        System.out.println(count);
    }

    public long getMatchCount(String input1, char ch) {
        return input1.chars().filter(x -> x == ch).count();
    }
}
