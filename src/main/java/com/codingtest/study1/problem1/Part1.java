package com.codingtest.study1.problem1;

import java.util.Scanner;

// 문자 찾기
public class Part1 {
    /**
     * [설명]
     * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.
     * 대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
     * <p>
     * [입력]
     * 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
     * 문자열은 영어 알파벳으로만 구성되어 있습니다.
     * <p>
     * [출력]
     * 첫 줄에 해당 문자의 개수를 출력한다.
     *
     * @param args
     */
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
