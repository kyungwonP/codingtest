package com.codingtest.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Test2304GPT {
    /**
     * 창고 다각형 - 구현 + 스위핑
     * N 개의 막대 기둥이 일렬로 세워져 있다. 기둥들의 폭은 모두 1 m이며 높이는 다를 수 있다. 이 기둥들을 이용하여 양철로 된 창고를 제작하려고 한다. 창고에는 모든 기둥이 들어간다. 이 창고의 지붕을 다음과 같이 만든다.
     * 지붕은 수평 부분과 수직 부분으로 구성되며, 모두 연결되어야 한다.
     * 지붕의 수평 부분은 반드시 어떤 기둥의 윗면과 닿아야 한다.
     * 지붕의 수직 부분은 반드시 어떤 기둥의 옆면과 닿아야 한다.
     * 지붕의 가장자리는 땅에 닿아야 한다.
     * 비가 올 때 물이 고이지 않도록 지붕의 어떤 부분도 오목하게 들어간 부분이 없어야 한다.
     * 그림 1은 창고를 옆에서 본 모습을 그린 것이다. 이 그림에서 굵은 선으로 표시된 부분이 지붕에 해당되고, 지붕과 땅으로 둘러싸인 다각형이 창고를 옆에서 본 모습이다. 이 다각형을 창고 다각형이라고 하자.
     * 그림1 . 기둥과 지붕(굵은 선)의 예
     * 창고 주인은 창고 다각형의 면적이 가장 작은 창고를 만들기를 원한다. 그림 1에서 창고 다각형의 면적은 98 ㎡이고, 이 경우가 가장 작은 창고 다각형이다.
     * 기둥들의 위치와 높이가 주어질 때, 가장 작은 창고 다각형의 면적을 구하는 프로그램을 작성하시오.
     * <p>
     * 입력
     * 첫 줄에는 기둥의 개수를 나타내는 정수 N이 주어진다. N은 1 이상 1,000 이하이다. 그 다음 N 개의 줄에는 각 줄에 각 기둥의 왼쪽 면의 위치를 나타내는 정수 L과 높이를 나타내는 정수 H가 한 개의 빈 칸을 사이에 두고 주어진다. L과 H는 둘 다 1 이상 1,000 이하이다.
     * <p>
     * 출력
     * 첫 줄에 창고 다각형의 면적을 나타내는 정수를 출력한다.
     */

    private static class Bar implements Comparable<Bar> {
        int l;
        int h;

        Bar(int l, int h) {
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Bar bar) {
            return this.l - bar.l;
        }
    }

    private static int n;
    private static List<Bar> bars = new ArrayList<>();
    private static int maxHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            bars.add(new Bar(l, h));
            maxHeight = Math.max(maxHeight, h);
        }

        System.out.println(solution());
    }

    private static int solution() {
        Collections.sort(bars);

        int area = 0;
        int left = 0;
        int right = n - 1;
        int leftMaxHeight = bars.get(left).h;
        int rightMaxHeight = bars.get(right).h;

        int leftL = bars.get(left).l;
        // 왼쪽 -> 최대높이(왼쪽)
        while (bars.get(left).h != maxHeight) {
            left++;

            if (leftMaxHeight < bars.get(left).h) {
                area += (bars.get(left).l - leftL) * leftMaxHeight;
                leftMaxHeight = bars.get(left).h;
                leftL = bars.get(left).l;
            }
        }

        int rightL = bars.get(right).l;
        // 최대높이(오른쪽) <- 오른쪽
        while (bars.get(right).h != maxHeight) {
            right--;

            if (rightMaxHeight < bars.get(right).h) {
                area += (rightL - bars.get(right).l) * rightMaxHeight;
                rightMaxHeight = bars.get(right).h;
                rightL = bars.get(right).l;
            }
        }

        area += (rightL - leftL + 1) * maxHeight;

        return area;
    }
}
