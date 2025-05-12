package com.codingtest.study2.problem8;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    /**
     * 1. 합이 같은 부분집합(DFS : 아마존 인터뷰)
     * 설명
     * N개의 원소로 구성된 자연수 집합이 주어지면, 이 집합을 두 개의 부분집합으로 나누었을 때
     * 두 부분집합의 원소의 합이 서로 같은 경우가 존재하면 “YES"를 출력하고, 그렇지 않으면 ”NO"를 출력하는 프로그램을 작성하세요.
     * 둘로 나뉘는 두 부분집합은 서로소 집합이며, 두 부분집합을 합하면 입력으로 주어진 원래의 집합이 되어 합니다.
     * 예를 들어 {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이 16으로 같은 경우가 존재하는 것을 알 수 있다.
     * <p>
     * 입력
     * 첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.
     * 두 번째 줄에 집합의 원소 N개가 주어진다. 각 원소는 중복되지 않는다.
     * <p>
     * 출력
     * 첫 번째 줄에 “YES" 또는 ”NO"를 출력한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        in.nextLine();

        System.out.println(new Test1().solution(n, numbers));
    }

    private String solution(int n, int[] numbers) {
        String result = "NO";
        int sum = Arrays.stream(numbers).sum();

        if (sum % 2 > 0) {
            return result;
        }

        int mid = sum / 2;
        int forSum = 0;
        for (int i = 0; i < n; i++) {
            forSum = numbers[i];
            for (int j = i; j < n; j++) {
                if (forSum + numbers[j] == mid) {
                    return "YES";
                } else if (forSum + numbers[j] < mid) {
                    forSum += numbers[j];
                } else {
                    break;
                }
            }
        }

        return result;
    }
}
