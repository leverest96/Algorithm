package Algorithm.again;

import java.util.List;

public class 아날로그_시계 {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;

        for (int i = start; i < end; i++) {
            List<Double> cnt = List.of(((i/3600) % 12) * 30d + ((i % 3600) / 60) * 0.5d + ((i % 3600) % 60) * (1/120d),
                    ((i % 3600) / 60) * 6d + ((i % 3600) % 60) * (0.1d), ((i % 3600) % 60) * 6d);

            List<Double> next = List.of((((i + 1) / 3600) % 12) * 30d + (((i + 1) % 3600) / 60) * 0.5d + (((i + 1) % 3600) % 60) * (1/120d),
                    (((i + 1) % 3600) / 60) * 6d + (((i + 1) % 3600) % 60) * (0.1d), (((i + 1) % 3600) % 60) * 6d);

            boolean hourMatch = hourMatch(cnt, next);
            boolean minuteMatch = minuteMatch(cnt, next);

            if (hourMatch && minuteMatch) {
                if (Double.compare(next.get(0), next.get(1)) == 0) {
                    answer++;
                } else {
                    answer += 2;
                }
            } else if (hourMatch || minuteMatch) {
                answer++;
            }
        }

        if (start == 0 || start == 43200) answer++;

        return answer;
    }

    boolean hourMatch(List<Double> cnt, List<Double> next){
        if (Double.compare(cnt.get(0),cnt.get(2)) > 0
                && Double.compare(next.get(0),next.get(2)) <= 0) {
            return true;
        }

        if (Double.compare(cnt.get(2),354d) == 0
                && Double.compare(cnt.get(0),354d) > 0) {
            return true;
        }

        return false;
    }

    boolean minuteMatch(List<Double> cnt, List<Double> next){
        if (Double.compare(cnt.get(1),cnt.get(2)) > 0
                && Double.compare(next.get(1),next.get(2)) <= 0) {
            return true;
        }

        if (Double.compare(cnt.get(2),354d) == 0
                && Double.compare(cnt.get(1),354d) > 0) {
            return true;
        }

        return false;
    }
}
