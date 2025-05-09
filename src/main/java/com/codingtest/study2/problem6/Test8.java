package com.codingtest.study2.problem6;

import java.util.Arrays;
import java.util.Scanner;

public class Test8 {
    /**
     * 8. 이분검색
     * 설명
     * 임의의 N개의 숫자가 입력으로 주어집니다. N개의 수를 오름차순으로 정렬한 다음 N개의 수 중 한 개의 수인 M이 주어지면
     * 이분검색으로 M이 정렬된 상태에서 몇 번째에 있는지 구하는 프로그램을 작성하세요. 단 중복값은 존재하지 않습니다.
     * <p>
     * 입력
     * 첫 줄에 한 줄에 자연수 N(3<=N<=1,000,000)과 M이 주어집니다.
     * 두 번째 줄에 N개의 수가 공백을 사이에 두고 주어집니다.
     * <p>
     * 출력
     * 첫 줄에 정렬 후 M의 값의 위치 번호를 출력한다.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        System.out.println(new Test8().solution(n, m, line));
    }

    private int solution(int n, int m, String line) {
        String[] strings = line.split(" ");
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(numbers);

        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + Math.floorDiv(end, 2);

            if (start == end) {
                mid = start;
            }

            if (numbers[mid] == m) {
                return mid + 1;
            } else if (numbers[mid] > m) {
                end = mid - 1;
            } else if (numbers[mid] < m) {
                start = mid + 1;
            }
        }

        return -1;
    }
}
