package com.codingtest.study2.problem1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test4GPT {
    /**
     * 4. 단어 뒤집기
     * 설명
     * N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
     * <p>
     * 입력
     * 첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
     * 두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
     * <p>
     * 출력
     * N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
     */
    public static void main(String[] args) {
        Test4GPT t = new Test4GPT();
        Scanner in = new Scanner(System.in);
        List<String> words = new ArrayList<>();

        int count = in.nextInt();

        for (int i = 0; i < count; i++) {
            words.add(in.next());
        }

        for (String word : words) {
            System.out.println(t.solution(word));
        }

    }

    private String solution(String word) {
        return new StringBuilder(word).reverse().toString();
    }
}
