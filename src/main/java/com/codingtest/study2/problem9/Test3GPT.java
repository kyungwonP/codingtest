package com.codingtest.study2.problem9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test3GPT {
    /**
     * 3. 결혼식
     * 설명
     * 현수는 다음 달에 결혼을 합니다.
     * 현수는 결혼식 피로연을 장소를 빌려 3일간 쉬지 않고 하려고 합니다.
     * 피로연에 참석하는 친구들 N명의 참석하는 시간정보를 현수는 친구들에게 미리 요구했습니다.
     * 각 친구들은 자신이 몇 시에 도착해서 몇 시에 떠날 것인지 현수에게 알려주었습니다.
     * 현수는 이 정보를 바탕으로 피로연 장소에 동시에 존재하는 최대 인원수를 구하여 그 인원을 수용할 수 있는 장소를 빌리려고 합니다. 여러분이 현수를 도와주세요.
     * 만약 한 친구가 오는 시간 13, 가는시간 15라면 이 친구는 13시 정각에 피로연 장에 존재하는 것이고 15시 정각에는 존재하지 않는다고 가정합니다.
     * <p>
     * 입력
     * 첫째 줄에 피로연에 참석할 인원수 N(5<=N<=100,000)이 주어집니다.
     * 두 번째 줄부터 N줄에 걸쳐 각 인원의 오는 시간과 가는 시간이 주어집니다.
     * 시간은 첫날 0시를 0으로 해서 마지막날 밤 12시를 72로 하는 타임라인으로 오는 시간과 가는 시간이 음이 아닌 정수로 표현됩니다.
     * <p>
     * 출력
     * 첫째 줄에 피로연장에 동시에 존재하는 최대 인원을 출력하세요.
     */

    private static class Time implements Comparable<Time> {
        int time;
        char type;

        Time(int time, char type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Time time) {
            if (this.time == time.time) {
                return this.type - time.type; // e 먼저
            }

            return this.time - time.time;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Time> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();

            events.add(new Time(s, 's'));
            events.add(new Time(e, 'e'));
        }

        System.out.println(new Test3GPT().solution(events));
    }

    private int solution(List<Time> events) {
        int result = 0;

        Collections.sort(events);

        int remain = 0;
        for (Time event : events) {
            if (event.type == 's') {
                remain++;
            } else {
                remain--;
            }

            result = Math.max(result, remain);
        }

        return result;
    }
}
