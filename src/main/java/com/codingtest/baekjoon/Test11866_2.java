package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Test11866_2 {
    /**
     * 요세푸스 문제 0 - 큐 자료구조, 시간/공간 O(n)
     * 요세푸스 문제는 다음과 같다.
     * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
     * 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
     * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
     * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
     * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)
     * <p>
     * 출력
     * 예제와 같이 요세푸스 순열을 출력한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        System.out.println(solution(n, k, queue));
    }

    private static String solution(int n, int k, Queue<Integer> queue) {
        StringBuilder result = new StringBuilder();
        result.append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    result.append(queue.poll());
                    if (!queue.isEmpty()) {
                        result.append(", ");
                    }
                } else {
                    queue.offer(queue.poll());
                }
            }
        }
        result.append(">");

        return result.toString();
    }
}
