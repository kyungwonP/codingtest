package com.codingtest.study2.problem8;

import java.util.Scanner;

public class Test10 {
    /**
     * 10. 미로탐색(DFS)
     * 설명
     * 7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요.
     * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다.
     * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
     * S 0 0 0 0 0 0
     * 0 1 1 1 1 1 0
     * 0 0 0 1 0 0 0
     * 1 1 0 1 0 1 1
     * 1 1 0 0 0 0 1
     * 1 1 0 1 1 0 0
     * 1 0 0 0 0 0 D
     * 위의 지도에서 출발점에서 도착점까지 갈 수 있는 방법의 수는 8가지이다.
     * <p>
     * 입력
     * 7*7 격자판의 정보가 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 경로의 가지수를 출력한다.
     */
    private static int n = 7;
    private static int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = in.nextInt();
            }
            in.nextLine();
        }

        System.out.println(new Test10().solution(board));
    }

    private int solution(int[][] board) {
        boolean[][] visits = new boolean[n][n];
        visits[0][0] = true;
        move(board, 0, 0, visits);
        return result;
    }

    private void move(int[][] board, int x, int y, boolean[][] visits) {
        if (x == n - 1 && y == n - 1) {
            result++;
        }

        if (board[x][y] == 1) {
            return;
        }

        // 상
        if (y > 0 && !visits[x][y - 1]) {
            visits[x][y - 1] = true;
            move(board, x, y - 1, visits);
            visits[x][y - 1] = false;
        }

        // 하
        if (y < n - 1 && !visits[x][y + 1]) {
            visits[x][y + 1] = true;
            move(board, x, y + 1, visits);
            visits[x][y + 1] = false;
        }

        // 좌
        if (x > 0 && !visits[x - 1][y]) {
            visits[x - 1][y] = true;
            move(board, x - 1, y, visits);
            visits[x - 1][y] = false;
        }

        // 우
        if (x < n - 1 && !visits[x + 1][y]) {
            visits[x + 1][y] = true;
            move(board, x + 1, y, visits);
            visits[x + 1][y] = false;
        }
    }
}
