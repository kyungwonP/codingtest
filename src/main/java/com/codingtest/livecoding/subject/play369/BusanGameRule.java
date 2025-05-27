package com.codingtest.livecoding.subject.play369;

public class BusanGameRule extends Game369 implements GameRule {

    // 3 6 9 포함이면 출력 x
    @Override
    public String getReplace(int number) {
        String str = String.valueOf(number);

        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (targets.contains(ch)) {
                return "";
            }
        }

        return String.valueOf(number);
    }
}
