package com.codingtest.study2.problem4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test4GPT {
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
        String s = in.nextLine();
        String t = in.nextLine();
        System.out.println(new Test4GPT().solution(s, t));
    }

    private int solution(String s, String t) {
        int result = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        int tLength = t.length();

        for (char c : tArray) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < tLength - 1; i++) {
            sMap.put(sArray[i], sMap.getOrDefault(sArray[i], 0) + 1);
        }

        int left = 0;

        for (int right = tLength - 1; right < s.length(); right++) {
            sMap.put(sArray[right], sMap.getOrDefault(sArray[right], 0) + 1);

            if (sMap.equals(tMap)) {
                result++;
            }

            char leftOut = sArray[left++];
            sMap.put(leftOut, sMap.getOrDefault(leftOut, 0) - 1);

            if (sMap.get(leftOut) <= 0) {
                sMap.remove(leftOut);
            }
        }


        return result;
    }
}
