package com.codingtest.livecoding.subject.play369;

public class DaejeonGameRule extends Game369 implements GameRule {

    // 3 6 9 포함이면 박수
    @Override
    public String getReplace(int number) {
        String replace = "박수";
        String str = String.valueOf(number);

        char[] chars = str.toCharArray();

        for (char ch : chars) {
            if (targets.contains(ch)) {
                return replace;
            }
        }

        return String.valueOf(number);
    }
}
