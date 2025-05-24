package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Test3015GPT {
    /**
     * 오아시스 재결합 다국어 - 스택 알고리즘 O(n)
     * 오아시스의 재결합 공연에 N명이 한 줄로 서서 기다리고 있다.
     * 이 역사적인 순간을 맞이하기 위해 줄에서 기다리고 있던 백준이는 갑자기 자기가 볼 수 있는 사람의 수가 궁금해졌다.
     * 두 사람 A와 B가 서로 볼 수 있으려면, 두 사람 사이에 A 또는 B보다 키가 큰 사람이 없어야 한다.
     * 줄에 서 있는 사람의 키가 주어졌을 때, 서로 볼 수 있는 쌍의 수를 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫째 줄에 줄에서 기다리고 있는 사람의 수 N이 주어진다. (1 ≤ N ≤ 500,000)
     * 둘째 줄부터 N개의 줄에는 각 사람의 키가 나노미터 단위로 주어진다. 모든 사람의 키는 231 나노미터 보다 작다.
     * 사람들이 서 있는 순서대로 입력이 주어진다.
     * <p>
     * 출력
     * 서로 볼 수 있는 쌍의 수를 출력한다.
     */

    private static class Person {
        int height;
        int count;

        Person(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n, heights));
    }

    /**
     * 2 4 1 2 2 5 1
     * 2 4, 4 1, 1 2, 2 2, 2 5, 5 1 -> 6
     * 4 2, 4 2, 4 5 -> 3
     * 2 5 -> 1
     * 10
     */
    private static long solution(int n, int[] heights) {
        long result = 0;
        Stack<Person> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];
            int count = 1;

            // 스택에 있는 사람들 중 현재 키보다 작거나 같은 사람은 pop -> 어처피 이후에서 가려지기때문에 없어야됨
            while (!stack.isEmpty() && stack.peek().height <= currentHeight) {
                Person pop = stack.pop();
                result += pop.count;

                // 같은 키일 경우 count를 누적하여 넘길 예정
                if (pop.height == currentHeight) {
                    count += pop.count;
                }
            }

            // 스택이 비어있지 않다면 키가 더 큰 사람이 존재하는것, 이 경우 그 사람과 마주볼 수 있어서 + 1
            if (!stack.isEmpty()) {
                result++;
            }

            stack.push(new Person(currentHeight, count));
        }

        return result;
    }
}
