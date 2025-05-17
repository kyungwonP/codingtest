package com.codingtest.study2.problem9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test2 {
    /**
     * 2. 회의실 배정
     * 설명
     * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
     * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
     * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
     * <p>
     * 입력
     * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
     * 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
     * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
     * <p>
     * 출력
     * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            meetings.add(new Meeting(start, end));
        }

        System.out.println(new Test2().solution(meetings));
    }

    private int solution(List<Meeting> meetings) {
        int result = 0;
        int nextStart = 0;

        Collections.sort(meetings);

        for (Meeting meeting : meetings) {
            if (meeting.start >= nextStart) {
                nextStart = meeting.end;
                result++;
            }
        }

        return result;
    }
}
