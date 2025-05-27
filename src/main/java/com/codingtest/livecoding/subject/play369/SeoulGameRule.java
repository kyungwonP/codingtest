package com.codingtest.livecoding.subject.play369;

public class SeoulGameRule extends Game369 implements GameRule {

    // 3 6 9 포함이면 포함된 만큼 짝
    @Override
    public String getReplace(int number) {
        String replace = "짝";
        String str = String.valueOf(number);

        char[] chars = str.toCharArray();
        int count = 0;

        for (char ch : chars) {
            if (targets.contains(ch)) {
                count++;
            }
        }

        return count == 0 ? String.valueOf(number) : replace.repeat(count);
    }
}
