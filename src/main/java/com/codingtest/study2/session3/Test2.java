package com.codingtest.study2.session3;

import java.util.Scanner;

public class Test2 {
    /**
     * 2. 보이는 학생
     * 설명
     * 선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
     * 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
     * <p>
     * 입력
     * 첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
     * <p>
     * 출력
     * 선생님이 볼 수 있는 최대학생수를 출력한다.
     */
    public static void main(String[] args) {
        Test2 t = new Test2();
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        System.out.println(t.solution(count, line));
    }

    private int solution(int count, String line) {
        String[] heights = line.split(" ");
        int prev = Integer.parseInt(heights[0]);
        int result = 1;

        for (int i = 0; i < count; i++) {
            int current = Integer.parseInt(heights[i]);
            if (prev < current) {
                result++;
            }
            prev = Math.max(prev, current);
        }

        return result;
    }
}
