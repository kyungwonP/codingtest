package com.codingtest.study2.problem9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test4 {
    /**
     * 4. 최대 수입 스케쥴(PriorityQueue 응용문제)
     * 설명
     * 현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.
     * 각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.
     * 단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.
     * <p>
     * 입력
     * 첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.
     * <p>
     * 출력
     * 첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.
     */
    private static class Company implements Comparable<Company> {
        int m;
        int d;

        Company(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Company company) {
            if (this.m == company.m) {
                return company.d - this.d;
            }

            return company.m - this.m;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        List<Company> companies = new ArrayList<>();
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            int m = in.nextInt();
            int d = in.nextInt();
            companies.add(new Company(m, d));
            maxDay = Math.max(maxDay, d);
        }

        System.out.println(new Test4().solution(maxDay, companies));
    }

    private int solution(int maxDay, List<Company> companies) {
        int result = 0;
        int day = 0;
        boolean[] used = new boolean[maxDay + 1];

        Collections.sort(companies);

        for (int i = 0; i < companies.size(); i++) {
            Company company = companies.get(i);
            int index = 0;
            if (!used[company.d]) {
                index = company.d;
            } else {
                for (int j = company.d; j > 0; j--) {
                    if (!used[j]) {
                        index = j;
                        break;
                    }
                }
            }

            if (index != 0) {
                used[index] = true;
                result += company.m;
                day++;
            }

            if (day >= maxDay) {
                break;
            }
        }

        return result;
    }
}
