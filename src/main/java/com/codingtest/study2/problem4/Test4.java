package com.codingtest.study2.problem4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test4 {
    /**
     * 4. 모든 아나그램 찾기
     * 설명
     * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
     * 아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
     * <p>
     * 입력
     * 첫 줄에 첫 번째 S문자열이 입력되고, 두 번째 줄에 T문자열이 입력됩니다.
     * S문자열의 길이는 10,000을 넘지 않으며, T문자열은 S문자열보다 길이가 작거나 같습니다.
     * <p>
     * 출력
     * S단어에 T문자열과 아나그램이 되는 부분문자열의 개수를 출력합니다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();
        String secondLine = in.nextLine();
        System.out.println(new Test4().solution(firstLine, secondLine));
    }

    private int solution(String firstLine, String secondLine) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();

        char[] firstChars = firstLine.toCharArray();

        int left = 0;

        for (int i = 0; i < secondLine.length() - 1; i++) {
            char current = firstChars[i];
            if (secondLine.contains(String.valueOf(current))) {
                map.put(current, map.getOrDefault(current, 0) + 1);
            }
        }

        for (int right = secondLine.length() - 1; right < firstLine.length(); right++) {
            char current = firstChars[right];
            if (secondLine.contains(String.valueOf(current))) {
                map.put(current, map.getOrDefault(current, 0) + 1);
            }

            if (map.size() == secondLine.length()) {
                result++;
            }

            char leftOut = firstChars[left++];
            if (secondLine.contains(String.valueOf(leftOut))) {
                map.put(leftOut, map.getOrDefault(leftOut, 0) - 1);

                if (map.get(leftOut) <= 0) {
                    map.remove(leftOut);
                }
            }
        }

        return result;
    }
}
