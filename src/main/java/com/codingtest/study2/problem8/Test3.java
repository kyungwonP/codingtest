package com.codingtest.study2.problem8;

import java.util.Scanner;

public class Test3 {
    /**
     * 3. 최대점수 구하기(DFS)
     * 설명
     * 이번 정보올림피아드대회에서 좋은 성적을 내기 위하여 현수는 선생님이 주신 N개의 문제를 풀려고 합니다.
     * 각 문제는 그것을 풀었을 때 얻는 점수와 푸는데 걸리는 시간이 주어지게 됩니다.
     * 제한시간 M안에 N개의 문제 중 최대점수를 얻을 수 있도록 해야 합니다.
     * (해당문제는 해당시간이 걸리면 푸는 걸로 간주한다, 한 유형당 한개만 풀 수 있습니다.)
     * <p>
     * 입력
     * 첫 번째 줄에 문제의 개수N(1<=N<=20)과 제한 시간 M(10<=M<=300)이 주어집니다.
     * 두 번째 줄부터 N줄에 걸쳐 문제를 풀었을 때의 점수와 푸는데 걸리는 시간이 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 제한 시간안에 얻을 수 있는 최대 점수를 출력합니다.
     */

    int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        int[][] numbers = new int[n][2];

        for (int i = 0; i < n; i++) {
            numbers[i][0] = in.nextInt();
            numbers[i][1] = in.nextInt();
            in.nextLine();
        }

        System.out.println(new Test3().solution(n, m, numbers));
    }

    private int solution(int n, int m, int[][] numbers) {
        dfs(n, m, numbers, 0, 0, 0);

        return result;
    }

    private void dfs(int n, int m, int[][] numbers, int level, int sumScore, int sumTime) {
        if (sumTime > m) {
            return;
        }
        if (level == n) {
            result = Math.max(result, sumScore);
            return;
        }

        dfs(n, m, numbers, level + 1, sumScore + numbers[level][0], sumTime + numbers[level][1]);
        dfs(n, m, numbers, level + 1, sumScore, sumTime);
    }
}
