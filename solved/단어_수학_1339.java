package Algorithm.solved;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 단어_수학_1339 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];

        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            arr[i] = line;

            for (int j = 0; j < line.length(); j++) {
                char now = line.charAt(j);

                int depth = 1;

                for (int k = j; k < line.length(); k++) {
                    depth *= 10;
                }

                if (map.containsKey(line.charAt(j))) {
                    map.replace(now, map.get(now) + depth);
                } else {
                    map.put(now, depth);
                    list.add(now);
                }
            }
        }

        // 정렬
        int order = 9;

        for (int i = 0; i < map.size(); i++) {
            int max = 0;
            char temp = 0;

            for (int j = 0; j < map.size(); j++) {
                if (map.get(list.get(j)) > max) {
                    max = map.get(list.get(j));
                    temp = list.get(j);
                }
            }

            map.replace(temp, order--);
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            String check = arr[i];

            for (int j = 0; j < check.length(); j++) {
                int depth = 1;

                for (int k = j; k < check.length() - 1; k++) {
                    depth *= 10;
                }

                result += depth * map.get(check.charAt(j));
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
    }
}
