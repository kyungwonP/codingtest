package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Test1931_2 {
    /**
     * 회의실 배정 성공 - 그리디 알고리즘 + 정렬, 시간 O(n log n),공간 O(n)
     * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다.
     * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
     * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
     * 회의의 시작시간과 끝나는 시간이 같을 수도 있다.
     * 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
     * <p>
     * 입력
     * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다.
     * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다.
     * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
     * <p>
     * 출력
     * 첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
     */

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting meeting) {
            if (this.end == meeting.end) {
                return this.start - meeting.start;
            }
            return this.end - meeting.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }

        solution(n, meetings);
    }

    private static void solution(int n, List<Meeting> meetings) {
        int result = 0;
        int prev = 0;

        Collections.sort(meetings);

        for (int i = 0; i < n; i++) {
            Meeting currentMeeting = meetings.get(i);
            if (currentMeeting.start >= prev) {
                result++;
                prev = currentMeeting.end;
            }
        }

        System.out.println(result);
    }
}
