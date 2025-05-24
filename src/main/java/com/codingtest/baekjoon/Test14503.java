package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14503 {
    /**
     * 로봇 청소기
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

    private static int N;
    private static int M;
    private static int[] GO_ROWS = {-1, 0, 1, 0}; // 북, 동, 남, 서
    private static int[] GO_COLS = {0, 1, 0, -1}; // 북, 동, 남, 서
    private static int[] BACK_ROWS = {1, 0, -1, 0}; // 북, 동, 남, 서
    private static int[] BACK_COLS = {0, -1, 0, 1}; // 북, 동, 남, 서
    private static int[][] map;

    private static class Robot {
        int r;
        int c;
        int d;

        Robot(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Robot robot = new Robot(r, c, d);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(robot));

    }

    private static int solution(Robot robot) {
        int result = 0;

        while (true) {
            int spot = map[robot.r][robot.c];
            System.out.println(robot.r + " " + robot.c + " " + robot.d + " : " + spot);

            // 현재 칸이 청소되지 않은 경우는 청소한다.
            if (spot == 0) {
                map[robot.r][robot.c] = 2;
                result++;
            }

            // 현재 주변 4칸 중 청소되지 않은 빈 칸 없는 경우
            if (!checkNotCleanSpot(robot)) {
                // 후진 안 되는 경우 break
                if (!isBack(robot)) {
                    break;
                }

                // 후진
                back(robot);
            } else {
                for (int i = 0; i < 4; i++) {
                    robot.d = turn(robot.d);

                    Robot goRobot = go(new Robot(robot.r, robot.c, robot.d));

                    if (checkNotCleanOneSpot(goRobot.r, goRobot.c)) {
                        robot.r = goRobot.r;
                        robot.c = goRobot.c;
                        break;
                    }

                }
            }

        }

        return result;
    }

    // 주변 4칸 청소 체크
    private static boolean checkNotCleanSpot(Robot robot) {
        boolean result = false;

        for (int i = 0; i < 4; i++) {
            if (checkNotCleanOneSpot(robot.r + GO_ROWS[i], robot.c + GO_COLS[i])) {
                return true;
            }
        }

        return result;
    }

    // 벽 체크
    private static boolean isWall(int row, int col) {
        return map[row][col] == 1 ? true : false;
    }

    // 1칸 청소 체크
    private static boolean checkNotCleanOneSpot(int row, int col) {
        // 벽 체크
        if (isWall(row, col)) {
            return false;
        }
        return map[row][col] == 0 ? true : false;
    }

    // 후진 가능 여부 체크
    private static boolean isBack(Robot robot) {
        boolean result = true;

        Robot backRobot = back(new Robot(robot.r, robot.c, robot.d));

        // 벽 체크
        if (isWall(backRobot.r, backRobot.c)) {
            return false;
        }

        return result;
    }

    // 방향 변경
    private static int turn(int d) {
        if (d == 0) {
            return 3;
        } else {
            return d - 1;
        }
    }

    // 전진
    private static Robot go(Robot robot) {
        return move(robot, "GO");
    }

    // 후진
    private static Robot back(Robot robot) {
        return move(robot, "BACK");
    }

    // 이동
    private static Robot move(Robot robot, String flag) {
        if ("GO".equals(flag)) {
            robot.r = robot.r + GO_ROWS[robot.d];
            robot.c = robot.c + GO_COLS[robot.d];
        } else {
            robot.r = robot.r + BACK_ROWS[robot.d];
            robot.c = robot.c + BACK_COLS[robot.d];
        }

        return robot;
    }
}
