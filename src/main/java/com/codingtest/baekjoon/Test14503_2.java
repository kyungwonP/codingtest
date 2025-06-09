package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14503_2 {
    /**
     * 로봇 청소기 - 구현, 시간/공간 O(n^2)
     * 로봇 청소기와 방의 상태가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.
     * 로봇 청소기가 있는 방은
     * N X M 크기의 직사각형으로 나타낼 수 있으며,
     * 1 X 1 크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북 중 하나이다.
     * 방의 각 칸은 좌표 (r, c) 로 나타낼 수 있고, 가장 북쪽 줄의 가장 서쪽 칸의 좌표가
     * (0, 0)  가장 남쪽 줄의 가장 동쪽 칸의 좌표가 (N-1, M-1) 이다.
     * 즉, 좌표 (r, c) 는 북쪽에서 (r+1) 번째에 있는 줄의 서쪽에서 (c+1) 번째 칸을 가리킨다.
     * 처음에 빈 칸은 전부 청소되지 않은 상태이다.
     * 로봇 청소기는 다음과 같이 작동한다.
     * 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
     * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
     * 1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
     * 2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
     * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
     * 1. 반시계 방향으로 90도 회전한다.
     * 2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
     * 3. 1번으로 돌아간다.
     * <p>
     * 입력
     * 첫째 줄에 방의 크기 N 과  M 이 입력된다.
     * (3 <= N, M <= 50) 둘째 줄에 처음에 로봇 청소기가 있는 칸의 좌표 (r, c) 와 처음에 로봇 청소기가 바라보는 방향 d 가 입력된다.
     * d 가 0 인 경우 북쪽, 1 인 경우 동쪽, 2 인 경우 남쪽, 3 인 경우 서쪽을 바라보고 있는 것이다.
     * 셋째 줄부터 N 개의 줄에 각 장소의 상태를 나타내는 N X M 개의 값이 한 줄에 M 개씩 입력된다.
     * i 번째 줄의 j 번째 값은 칸 (i, j) 의 상태를 나타내며,
     * 이 값이 0 인 경우 (i, j) 가 청소되지 않은 빈 칸이고, 1 인 경우 (i, j) 에 벽이 있는 것이다.
     * 방의 가장 북쪽, 가장 남쪽, 가장 서쪽, 가장 동쪽 줄 중 하나 이상에 위치한 모든 칸에는 벽이 있다.
     * 로봇 청소기가 있는 칸은 항상 빈 칸이다.
     * <p>
     * 출력
     * 로봇 청소기가 작동을 시작한 후 작동을 멈출 때까지 청소하는 칸의 개수를 출력한다.
     */

    private static class Point {
        int r;
        int c;
        int d;

        Point(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    private static int result;
    private static int n;
    private static int m;
    private static int[][] map;
    private static int[] moveRow = {-1, 1, 0, 0};
    private static int[] moveCol = {0, 0, -1, 1};
    private static Point point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        point = new Point(r, c, d);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    private static void solution() {
        while (true) {
            if (map[point.r][point.c] == 0) {
                clean();
            }

            if (isCleanRoom()) {
                for (int i = 0; i < 4; i++) {
                    turn();
                    if (go()) {
                        break;
                    }
                }
            } else {
                if (!back()) {
                    System.out.println(result);
                    break;
                }
            }
        }
    }

    private static boolean isCleanRoom() {
        for (int i = 0; i < 4; i++) {
            int nextR = point.r + moveRow[i];
            int nextC = point.c + moveCol[i];

            if (nextR >= 0 && nextR < n
                    && nextC >= 0 && nextC < m
                    && map[nextR][nextC] == 0) {
                return true;
            }
        }

        return false;
    }

    private static void clean() {
        map[point.r][point.c] = 2;
        result++;
    }

    private static boolean go() {
        int nextR = point.r;
        int nextC = point.c;

        switch (point.d) {
            case 0:
                nextR--;
                break;
            case 1:
                nextC++;
                break;
            case 2:
                nextR++;
                break;
            case 3:
                nextC--;
                break;
        }

        if (nextR >= 0 && nextR < n
                && nextC >= 0 && nextC < m
                && map[nextR][nextC] == 0) {
            point.r = nextR;
            point.c = nextC;
            return true;
        }

        return false;
    }

    private static boolean back() {
        int nextR = point.r;
        int nextC = point.c;

        switch (point.d) {
            case 0:
                nextR++;
                break;
            case 1:
                nextC--;
                break;
            case 2:
                nextR--;
                break;
            case 3:
                nextC++;
                break;
        }

        if (nextR >= 0 && nextR < n
                && nextC >= 0 && nextC < m
                && map[nextR][nextC] != 1) {
            point.r = nextR;
            point.c = nextC;
            return true;
        }

        return false;
    }

    private static void turn() {
        switch (point.d) {
            case 0:
                point.d = 3;
                break;
            case 1:
                point.d = 0;
                break;
            case 2:
                point.d = 1;
                break;
            case 3:
                point.d = 2;
                break;
        }
    }
}
