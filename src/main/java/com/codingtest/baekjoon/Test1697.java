package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test1697 {
    /**
     * 숨바꼭질 다국어
     * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
     * 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
     * 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
     * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
     * <p>
     * 출력
     * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(new Test1697().solution(n, k));
    }

    private int solution(int n, int k) {
        int second = 0;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];

        queue.offer(n);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int currentNumber = queue.poll();
                if (currentNumber == k) {
                    return second;
                }

                if (currentNumber < 0 || currentNumber > 100000) {
                    continue;
                }

                if (!visited[currentNumber]) {
                    visited[currentNumber] = true;
                    queue.offer(currentNumber - 1);
                    queue.offer(currentNumber + 1);
                    queue.offer(currentNumber * 2);
                }
            }

            second++;
        }

        return second;
    }
}
