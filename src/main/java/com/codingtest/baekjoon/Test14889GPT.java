package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test14889GPT {
    /**
     * 스타트와 링크
     * 오늘은 스타트링크에 다니는 사람들이 모여서 축구를 해보려고 한다. 축구는 평일 오후에 하고 의무 참석도 아니다. 축구를 하기 위해 모인 사람은 총 N명이고 신기하게도 N은 짝수이다. 이제 N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
     * BOJ를 운영하는 회사 답게 사람에게 번호를 1부터 N까지로 배정했고, 아래와 같은 능력치를 조사했다. 능력치 Sij는 i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치이다. 팀의 능력치는 팀에 속한 모든 쌍의 능력치 Sij의 합이다. Sij는 Sji와 다를 수도 있으며, i번 사람과 j번 사람이 같은 팀에 속했을 때, 팀에 더해지는 능력치는 Sij와 Sji이다.
     * N=4이고, S가 아래와 같은 경우를 살펴보자.
     * i\j	1	2	3	4
     * 1	 	1	2	3
     * 2	4	 	5	6
     * 3	7	1	 	2
     * 4	3	4	5
     * 예를 들어, 1, 2번이 스타트 팀, 3, 4번이 링크 팀에 속한 경우에 두 팀의 능력치는 아래와 같다.
     * 스타트 팀: S12 + S21 = 1 + 4 = 5
     * 링크 팀: S34 + S43 = 2 + 5 = 7
     * 1, 3번이 스타트 팀, 2, 4번이 링크 팀에 속하면, 두 팀의 능력치는 아래와 같다.
     * 스타트 팀: S13 + S31 = 2 + 7 = 9
     * 링크 팀: S24 + S42 = 6 + 4 = 10
     * 축구를 재미있게 하기 위해서 스타트 팀의 능력치와 링크 팀의 능력치의 차이를 최소로 하려고 한다. 위의 예제와 같은 경우에는 1, 4번이 스타트 팀, 2, 3번 팀이 링크 팀에 속하면 스타트 팀의 능력치는 6, 링크 팀의 능력치는 6이 되어서 차이가 0이 되고 이 값이 최소이다.
     * <p>
     * 입력
     * 첫째 줄에 N(4 ≤ N ≤ 20, N은 짝수)이 주어진다. 둘째 줄부터 N개의 줄에 S가 주어진다. 각 줄은 N개의 수로 이루어져 있고, i번 줄의 j번째 수는 Sij 이다. Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.
     * <p>
     * 출력
     * 첫째 줄에 스타트 팀과 링크 팀의 능력치의 차이의 최솟값을 출력한다.
     */

    private static int n;
    private static int[][] s;
    private static boolean[] visited;
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited[0] = true; // 0번 사람을 스타트팀에 고정
        dfs(1, 1);

        System.out.println(result);
    }

    private static void dfs(int level, int start) {
        if (level == n / 2) {
            calculation();
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            dfs(level + 1, i + 1);
            visited[i] = false;
        }
    }

    private static void calculation() {
        int team1 = 0;
        int team2 = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    team1 += s[i][j] + s[j][i];
                } else if (!visited[i] && !visited[j]) {
                    team2 += s[i][j] + s[j][i];
                }
            }
        }

        result = Math.min(result, Math.abs(team1 - team2));
    }
}
