package Algorithm.solved;

import java.util.*;

public class 개인정보_수집_유효기간 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(today, ".");

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        Map<String, Integer> termMap = new HashMap<>();

        for (int i = 0; i < terms.length; i++) {
            StringTokenizer term = new StringTokenizer(terms[i], " ");

            termMap.put(term.nextToken(), Integer.parseInt(term.nextToken()));
        }

        for (int i = 0; i < privacies.length; i++) {
            StringTokenizer privacy = new StringTokenizer(privacies[i], " ");

            String date = privacy.nextToken();
            String term = privacy.nextToken();

            StringTokenizer eachDate = new StringTokenizer(date, ".");

            int termMonth = termMap.get(term);

            int tempYear = Integer.parseInt(eachDate.nextToken());
            int tempMonth = Integer.parseInt(eachDate.nextToken());
            int tempDay = Integer.parseInt(eachDate.nextToken());

            tempYear += (tempMonth + termMonth - 1) / 12 == 0 ?
                    0 : (tempMonth + termMonth - 1) / 12;
            tempMonth = (tempMonth + termMonth - 1) / 12 == 0 ?
                    tempMonth + termMonth :
                    (tempMonth + termMonth) - 12 * ((tempMonth + termMonth - 1) / 12);

            if (tempYear < year) {
                list.add(i + 1);
            } else if (tempYear == year) {
                if (tempMonth < month) {
                    list.add(i + 1);
                } else if (tempMonth == month) {
                    if (tempDay <= day) {
                        list.add(i + 1);
                    }
                }
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
