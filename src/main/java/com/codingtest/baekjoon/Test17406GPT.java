package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Test17406GPT {

    /**
     * 배열 돌리기 4 - 순열 + 구현, 시간 O(K!), 공간 O(n * m)
     * 크기가 N×M 크기인 배열 A가 있을때, 배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값을 의미한다.
     * 배열 A가 아래와 같은 경우 1행의 합은 6, 2행의 합은 4, 3행의 합은 15이다. 따라서, 배열 A의 값은 4이다.
     * 1 2 3
     * 2 1 1
     * 4 5 6
     * 배열은 회전 연산을 수행할 수 있다.
     * 회전 연산은 세 정수 (r, c, s)로 이루어져 있고, 가장 왼쪽 윗 칸이 (r-s, c-s), 가장 오른쪽 아랫 칸이 (r+s, c+s)인 정사각형을 시계 방향으로 한 칸씩 돌린다는 의미이다.
     * 배열의 칸 (r, c)는 r행 c열을 의미한다.
     * 예를 들어, 배열 A의 크기가 6×6이고, 회전 연산이 (3, 4, 2)인 경우에는 아래 그림과 같이 회전하게 된다.
     * 회전 연산이 두 개 이상이면, 연산을 수행한 순서에 따라 최종 배열이 다르다.
     * 배열 A에 (3, 4, 2), (4, 2, 1) 순서로 연산을 수행하면 배열 A의 값은 12, (4, 2, 1), (3, 4, 2) 순서로 연산을 수행하면 15 이다.
     * 배열 A와 사용 가능한 회전 연산이 주어졌을 때, 배열 A의 값의 최솟값을 구해보자. 회전 연산은 모두 한 번씩 사용해야 하며, 순서는 임의로 정해도 된다.
     * <p>
     * 입력
     * 첫째 줄에 배열 A의 크기 N, M, 회전 연산의 개수 K가 주어진다.
     * 둘째 줄부터 N개의 줄에 배열 A에 들어있는 수 A[i][j]가 주어지고, 다음 K개의 줄에 회전 연산의 정보 r, c, s가 주어진다.
     * <p>
     * 출력
     * 배열 A의 값의 최솟값을 출력한다.
     */

    private static class Turn {
        int r;
        int c;
        int s;

        Turn(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    private static int N;
    private static int M;
    private static int K;
    private static int[][] board;
    private static Turn[] turns;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        turns = new Turn[K];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            turns[i] = new Turn(r, c, s);
        }

        permute(0, new ArrayList<>(), new boolean[K]);

        System.out.println(result);
    }

    private static void permute(int level, List<Turn> mixTurns, boolean[] used) {
        if (level == K) {
            turn(copyBoard(), mixTurns);
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!used[i]) {
                used[i] = true;
                mixTurns.add(turns[i]);
                permute(level + 1, mixTurns, used);
                used[i] = false;
                mixTurns.remove(mixTurns.size() - 1);
            }
        }
    }

    private static void turn(int[][] copyBoard, List<Turn> mixTurns) {
        for (Turn mixTurn : mixTurns) {
            int r = mixTurn.r;
            int c = mixTurn.c;
            int s = mixTurn.s;

            for (int i = 1; i <= s; i++) {
                int top = r - i;
                int bottom = r + i;
                int left = c - i;
                int right = c + i;

                int temp = copyBoard[top][left];

                // 좌측 : 아래 -> 위 (위에서 당기기)
                for (int row = top; row < bottom; row++) {
                    copyBoard[row][left] = copyBoard[row + 1][left];
                }

                // 아래 : 우측 -> 좌측 ( 좌측에서 당기기)
                for (int col = left; col < right; col++) {
                    copyBoard[bottom][col] = copyBoard[bottom][col + 1];
                }

                // 우측 : 위 -> 아래 (아래에서 당기기)
                for (int row = bottom; row > top; row--) {
                    copyBoard[row][right] = copyBoard[row - 1][right];
                }

                // 위 : 좌측 -> 우측 (우측에서 당기기)
                for (int col = right; col > left; col--) {
                    copyBoard[top][col] = copyBoard[top][col - 1];
                }

                copyBoard[top][left + 1] = temp;
            }
        }

        findResult(copyBoard);
    }

    private static void findResult(int[][] copyBoard) {
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= M; j++) {
                sum += copyBoard[i][j];
            }

            result = Math.min(result, sum);
        }
    }

    private static int[][] copyBoard() {
        int[][] copyBoard = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            copyBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }

        return copyBoard;
    }

}
