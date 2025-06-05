package com.codingtest.baekjoon;

import java.util.Scanner;

public class Test9663GPT {
    /**
     * N-Queen - dfs(깊이 우선 탐색) + 백트래킹, 시간 O(n!), 공간 O(n^2)
     * N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
     * N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 N이 주어진다. (1 ≤ N < 15)
     * <p>
     * 출력
     * 첫째 줄에 퀸 N개를 서로 공격할 수 없게 놓는 경우의 수를 출력한다.
     */

    private static int n;
    private static int result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();

        dfs(0, new int[n]);

        System.out.println(result);
    }

    private static void dfs(int row, int[] cols) {
        if (row >= n) {
            result++;
            return;
        }

        for (int currentCol = 0; currentCol < n; currentCol++) {
            boolean isPossible = true;

            for (int i = 0; i < row; i++) {
                int prevCol = cols[i];

                if (currentCol == prevCol || Math.abs(row - i) == Math.abs(currentCol - prevCol)) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                cols[row] = currentCol;
                dfs(row + 1, cols);
            }
        }
    }
}
