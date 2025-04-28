package com.codingtest.study1.session1;


import java.util.Scanner;

// 문장 속 단어
public class Part3 {
    /**
     * [설명]
     * 한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
     * 문장속의 각 단어는 공백으로 구분됩니다.
     * <p>
     * [입력]
     * 첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
     * <p>
     * [출력]
     * 첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
     * 단어를 답으로 합니다.
     *
     * @param args
     */
    public static void main(String[] args) {
        Part3 main = new Part3();
        Scanner in = new Scanner(System.in);
        String input1 = in.nextLine();

        System.out.println(main.solution(input1));
    }

    public String solution(String input1) {
        String[] strings = input1.split(" ");
        String result = "";

        for (String word : strings) {
            if (result.length() < word.length()) {
                result = word;
            }
        }

        return result;
    }
}
