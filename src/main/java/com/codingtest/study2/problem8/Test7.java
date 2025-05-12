package com.codingtest.study2.problem8;

import java.util.Scanner;

public class Test7 {
    /**
     * 7. 조합의 경우수(메모이제이션)
     * 설명
     * Image1.jpg로 계산합니다.
     * 하지만 여러분은 이 공식을 쓰지않고 다음 공식을 사용하여 재귀를 이용해 조합수를 구해주는 프로그램을 작성하세요.
     * Image1.jpg
     * <p>
     * 입력
     * 첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.
     * <p>
     * 출력
     * 첫째 줄에 조합수를 출력합니다.
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int r = in.nextInt();
        in.nextLine();

        System.out.println(new Test7().solution(n, r));
    }

    private int solution(int n, int r) {
        int[][] table = new int[n + 1][r + 1];

        int result = dfs(n, r, table);

        return result;
    }

    private int dfs(int n, int r, int[][] table) {
        if (table[n][r] > 0) {
            return table[n][r];
        }

        if (n == r || r == 0) {
            table[n][r] = 1;
            return table[n][r];
        }

        return table[n][r] = dfs(n - 1, r - 1, table) + dfs(n - 1, r, table);
    }
}
