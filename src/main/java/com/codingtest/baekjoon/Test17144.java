package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test17144 {
    /**
     * 미세먼지 안녕! - 구현 알고리즘, 시간/공간 O(n^2)
     * 미세먼지를 제거하기 위해 구사과는 공기청정기를 설치하려고 한다.
     * 공기청정기의 성능을 테스트하기 위해 구사과는 집을 크기가 R×C인 격자판으로 나타냈고, 1×1 크기의 칸으로 나눴다.
     * 구사과는 뛰어난 코딩 실력을 이용해 각 칸 (r, c)에 있는 미세먼지의 양을 실시간으로 모니터링하는 시스템을 개발했다.
     * (r, c)는 r행 c열을 의미한다.
     * 공기청정기는 항상 1번 열에 설치되어 있고, 크기는 두 행을 차지한다.
     * 공기청정기가 설치되어 있지 않은 칸에는 미세먼지가 있고, (r, c)에 있는 미세먼지의 양은 Ar,c이다.
     * 1초 동안 아래 적힌 일이 순서대로 일어난다.
     * 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
     * (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
     * 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
     * 확산되는 양은 Ar,c/5이고 소수점은 버린다. 즉, ⌊Ar,c/5⌋이다.
     * (r, c)에 남은 미세먼지의 양은 Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수) 이다.
     * 공기청정기가 작동한다.
     * 공기청정기에서는 바람이 나온다.
     * 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
     * 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
     * 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
     * 다음은 확산의 예시이다.
     * 왼쪽과 위쪽에 칸이 없기 때문에, 두 방향으로만 확산이 일어났다.
     * 인접한 네 방향으로 모두 확산이 일어난다.
     * 공기청정기가 있는 칸으로는 확산이 일어나지 않는다.
     * 공기청정기의 바람은 다음과 같은 방향으로 순환한다.
     * 방의 정보가 주어졌을 때, T초가 지난 후 구사과의 방에 남아있는 미세먼지의 양을 구해보자.
     * <p>
     * 입력
     * 첫째 줄에 R, C, T (6 ≤ R, C ≤ 50, 1 ≤ T ≤ 1,000) 가 주어진다.
     * 둘째 줄부터 R개의 줄에 Ar,c (-1 ≤ Ar,c ≤ 1,000)가 주어진다.
     * 공기청정기가 설치된 곳은 Ar,c가 -1이고, 나머지 값은 미세먼지의 양이다.
     * -1은 2번 위아래로 붙어져 있고, 가장 윗 행, 아랫 행과 두 칸이상 떨어져 있다.
     * <p>
     * 출력
     * 첫째 줄에 T초가 지난 후 구사과 방에 남아있는 미세먼지의 양을 출력한다.
     */

    private static int r;
    private static int c;
    private static int t;
    private static int[][] map;
    private static int[] cleaner = new int[2];
    private static int[] moveRow = {-1, 1, 0, 0};
    private static int[] moveCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        int cleanerIndex = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    cleaner[cleanerIndex++] = i;
                }
            }
        }

        System.out.println(solution());
    }

    private static int solution() {
        int result = 0;
        for (int i = 0; i < t; i++) {
            diffusion();
            cleaning();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] > 0) {
                    result += map[i][j];
                }
            }
        }

        return result;
    }

    private static void diffusion() {
        int[][] room = new int[r][c];

        room[cleaner[0]][0] = -1;
        room[cleaner[1]][0] = -1;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int current = map[i][j];

                if (current <= 0) {
                    continue;
                }

                int count = 0;
                int currentDiffusion = current / 5;

                for (int k = 0; k < 4; k++) {
                    int nextRow = i + moveRow[k];
                    int nextCol = j + moveCol[k];

                    if (nextRow >= 0 && nextRow < r
                            && nextCol >= 0 && nextCol < c
                            && map[nextRow][nextCol] >= 0
                    ) {
                        room[nextRow][nextCol] += currentDiffusion;
                        count++;
                    }
                }

                int remain = current - (currentDiffusion * count);
                room[i][j] += remain;
            }
        }

        map = room;
    }

    private static void cleaning() {
        cleaningUp();
        cleaningDown();
    }

    private static void cleaningUp() {
        int top = 0;
        int bottom = cleaner[0];
        int left = 0;
        int right = c - 1;

        // 왼쪽 : 위 -> 아래(아래 -> 위)
        for (int i = bottom - 1; i > top; i--) {
            map[i][left] = map[i - 1][left];
        }

        // 위 : 오른쪽 -> 왼쪽(왼쪽 -> 오른쪽)
        for (int i = left; i < right; i++) {
            map[top][i] = map[top][i + 1];
        }

        // 오른쪽 : 아래 -> 위(위 -> 아래)
        for (int i = top; i < bottom; i++) {
            map[i][right] = map[i + 1][right];
        }

        // 아래 : 왼쪽 -> 오른쪽(오른쪽 -> 왼쪽)
        for (int i = right; i > left; i--) {
            map[bottom][i] = map[bottom][i - 1];
        }

        map[bottom][left + 1] = 0;
    }

    private static void cleaningDown() {
        int top = cleaner[1];
        int bottom = r - 1;
        int left = 0;
        int right = c - 1;

        // 왼쪽 : 아래 -> 위
        for (int i = top + 1; i < bottom; i++) {
            map[i][left] = map[i + 1][left];
        }

        // 아래 : 오른쪽 -> 왼쪽
        for (int i = left; i < right; i++) {
            map[bottom][i] = map[bottom][i + 1];
        }

        // 오른쪽 : 위 -> 아래 -------------
        for (int i = bottom; i > top; i--) {
            map[i][right] = map[i - 1][right];
        }

        // 위 : 왼쪽 -> 오른쪽
        for (int i = right; i > left + 1; i--) {
            map[top][i] = map[top][i - 1];
        }

        map[top][left + 1] = 0;
    }
}
