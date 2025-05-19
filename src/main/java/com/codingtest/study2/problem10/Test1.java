package com.codingtest.study2.problem10;

import java.util.Scanner;

public class Test1 {
    /**
     * 1. 계단오르기
     * 설명
     * 철수는 계단을 오를 때 한 번에 한 계단 또는 두 계단씩 올라간다. 만약 총 4계단을 오른다면 그 방법의 수는
     * 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2 로 5가지이다.
     * 그렇다면 총 N계단일 때 철수가 올라갈 수 있는 방법의 수는 몇 가지인가?
     * <p>
     * 입력
     * 첫째 줄은 계단의 개수인 자연수 N(3≤N≤35)이 주어집니다.
     * <p>
     * 출력
     * 첫 번째 줄에 올라가는 방법의 수를 출력합니다.
     */

    private int result = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(new Test1().solution(n));
    }

    private int solution(int n) {
        dfs(n, 0, 1);
        dfs(n, 0, 2);
        return result;
    }

    private void dfs(int n, int stair, int add) {
        System.out.println(n + ", " + stair + ", " + add);

        int addStair = stair + add;

        if (n == addStair) {
            result++;
            return;
        }

        if (n < addStair) {
            return;
        }

        dfs(n, addStair, 1);
        dfs(n, addStair, 2);
    }
}
